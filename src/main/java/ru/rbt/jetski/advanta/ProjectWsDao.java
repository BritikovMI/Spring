package ru.rbt.jetski.advanta;

import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.AdvantaProjectTSh;
import ru.rbt.jetski.advanta.ws.apiprojects.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProjectWsDao {

    private static final AdvantaConfiguration cfg = AdvantaConfiguration.getInstance();

    /**
     *
     */
    public ProjectWrapper get(String sessionId, String uid) {
        ProjectIdDataContract contract = makeContract(sessionId, uid);
        APIProjects service = new APIProjects();
        APIProjectsSoap apiProjectsSoap = service.getAPIProjectsSoap();
        ProjectWrapper project = apiProjectsSoap.getProject(contract);
        return project;
    }

    public static void main(String[] args) {
        AdvantaAccess access = new AdvantaAccess();
        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();
        ProjectWsDao projectDao = new ProjectWsDao();
        String sessionId = null;
        try {
             sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        ProjectWsDao pw = new ProjectWsDao();
        System.out.println(pw.get(sessionId, "4826bdc1-41c1-4f94-b15b-096236618adc").getName());
    }
    public Set<String> getSetOfProjects(String sessionId) throws ConfigurationException {
        Set<String> projects = new HashSet<>();

        // TODO хардкод потом надо выпилить
        /*projects.add("214baa59-e8b4-40a2-bd12-fc6854caa9fb");
        projects.add("0eccc23d-3479-4bca-a820-122c57f6fb97");
		projects.add("d4352053-7f48-4561-8a54-347360553a4b");
		projects.add("4826bdc1-41c1-4f94-b15b-096236618adc");
		projects.add("09cace2f-ac42-4cb6-97f0-f17456bb786e");
		projects.add("099704f5-6178-4b5a-9bf4-68e1902887c1");
		projects.add("b517fb73-9918-4c6a-b2f2-aab49dc622f0");
		projects.add("c00497cc-9676-4337-9d63-bc750388c11b");
		projects.add("c9460cf8-f090-45a0-96e2-0c3c668ba954");
		projects.add("1b1946cb-16bb-4198-852e-f1ea172e040c");
		projects.add("40bee055-6a91-4b62-b092-9a707a8add57");
		projects.add("3dd6ea4c-f115-4e48-9009-90c663625b7a");
		projects.add("ae8f4119-0700-46e4-885d-0361e30f2b0d");
		projects.add("bc8982c4-d810-4933-8f23-d9665c7f338b");
		projects.add("cd192d71-0ec4-49e5-9d4a-67a4e50923a3");
		projects.add("e4ec7e38-b448-4b34-ad3a-a74cda25bcc3");
		projects.add("96a2ec8d-d635-4289-9a9c-d9237578c422");
		projects.add("6bf86b02-490a-478d-a867-291b66d5f7cf");
		projects.add("1e08e573-c62f-45f4-8c38-443a0e54b820");
		projects.add("8e643e19-5195-4dac-9e64-f49ad4a467ed");
		projects.add("d8e246d1-4456-4e41-b5cc-b17d2b57805b");
		projects.add("3df0b31a-1c48-4c73-9361-58224936f13e");
		projects.add("e7734e14-6f41-465d-9c82-913f3d4319f5");
		projects.add("8115f768-9dd0-41ab-9dec-5bf7401e57bc");*/
        // Dummy end

        APIProjects apiProjects = new APIProjects();
//        Set<String> resPlans = getProjectTasks(sessionId, cfg.getResourcePlanProjectId());  //Респлана больше нет в Advanta
        CalendarDao calendar = new CalendarDao();
        Set<String> prCalendarTasks = calendar.getCalendarPrjTasks(sessionId, cfg.getCalendarProjectId());

        Set<String> closedTasksParents = new HashSet<>();
        closedTasksParents.add(cfg.getClosedPayedProjectId()); //Закытые задачи оплачиваемых проектов
        closedTasksParents.add(cfg.getClosedInvestProjectId()); //Закрытые задачи инвестиционных проектов
        closedTasksParents.add(cfg.getClosedIntAdmProjectId()); //Закрытые задачи административных проектов
        closedTasksParents.add(cfg.getClosedIntAdmProjectId()); //Закрытые задачи presale проектов

        Set<String> closedTasks = new LinkedHashSet<>();
        for (String parentTask :
                closedTasks) {
            closedTasks.addAll(getProjectTasks(sessionId, parentTask)); // Добавляем сразу все закрытые задачи
        }


        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
        ArrayOfFilterWrapper arrayOfFilterWrapper = new ArrayOfFilterWrapper();
        ArrayOfSortWrapper arrayOfSortWrapper = new ArrayOfSortWrapper();
        ArrayOfProjectWrapper arrayOfProjectWrapper = apiProjectsSoap.getProjects(sessionId, arrayOfFilterWrapper,
                arrayOfSortWrapper, true);
        arrayOfProjectWrapper.getProjectWrapper().stream().forEach(pw -> {
            projects.add(pw.getUID());
        });

      /*  for (String remResPlan : resPlans) {
            projects.remove(remResPlan); // Удаляем задачи ресПлана
        }*/
        for (String remPrCalendTask : prCalendarTasks) {
            projects.remove(remPrCalendTask); // Удаляем задачи
            // производственного календаря
        }
        for (String remClosedTasks : closedTasks) {
            projects.remove(remClosedTasks); // Удаляем закрытые задачи
        }
        return projects;
    }

    public Set<String> getProjectTasks(String sessionId, String projectId) {
        Set<String> projectTasks = new LinkedHashSet<>(); //Необходимо использование упорядоченной по порядку добавления коллекции, чтобы сохранить иерархию вложений Адванты
        APIProjects apiProjects = new APIProjects();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
        ArrayOfProjectWrapper arrayOfProjectWrapper = apiProjectsSoap.getSubprojectsDates(sessionId, projectId);

        arrayOfProjectWrapper.getProjectWrapper().stream().forEach(pw -> {
            projectTasks.add(pw.getUID());
        });
        return projectTasks;
    }


    public String updateProject(UpdateProjectDataContract contract){
        APIProjects apiProjects = new APIProjects();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
        String result = apiProjectsSoap.updateProject(contract);

        return result;
    }
    public UpdateProjectDataContract makeUpdateProjectDataContract(String sessionId, ProjectWrapper pw){
        UpdateProjectDataContract contract = new UpdateProjectDataContract();
        contract.setASPNETSessionId(sessionId);
        contract.setProject(pw);
        return contract;
    }

    public String createProject(CreateProjectDataContract contract) {
        APIProjects apiProjects = new APIProjects();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
        String result = apiProjectsSoap.createProject(contract);

        return result;
    }

    public ProjectIdDataContract makeProjectIdDataContract(String sessionId, String projectUID){
        ProjectIdDataContract contract = new ProjectIdDataContract();
        contract.setASPNETSessionId(sessionId);
        contract.setProjectId(projectUID);
        return contract;
    }
    public void deleteProject(ProjectIdDataContract contract) {
        APIProjects apiProjects = new APIProjects();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();

        apiProjectsSoap.deleteProject(contract);
    }

    public CreateProjectDataContract makeDataContract(String sessionId, String parentUId, String name, String projectTypeId, String ownerID, String responsibleId, LocalDate startDate, LocalDate endDate) {
        CreateProjectDataContract contract = new CreateProjectDataContract();
        contract.setASPNETSessionId(sessionId);
        contract.setParentProjectId(parentUId);
        contract.setProjectTypeId(projectTypeId);
        contract.setProjectName(name);
//        contract.setOrder(2);
//        contract.setProjectOwnerId(ownerID);
//        contract.setProjectResponsibleId(responsibleId);
//        contract.setPlannedStartDateSerialized(startDate.toString());
//        contract.setPlannedStartDate(localDateToXMLGregorianCalendar(startDate));
//        contract.setPlannedEndDateSerialized(endDate.toString());
//        contract.setPlannedEndDate(localDateToXMLGregorianCalendar(endDate));
//        contract.setFields(new ArrayOfFieldWrapper());
//        contract.setFields(makeArrayOfField("Тест поле", "2"));
        return contract;
    }
    /////////////////////////////////////////////////////////////TODO: For Create project
    private ArrayOfFieldWrapper makeArrayOfField(String fieldName, String fieldVal) {
        ArrayOfFieldWrapper aow = new ArrayOfFieldWrapper();
        FieldWrapper fw = new FieldWrapper();
        fw.setFieldName(fieldName);
        fw.setFieldVal(fieldVal);
        List<FieldWrapper> fieldWrapper = aow.getFieldWrapper();
        fieldWrapper.add(fw);

        return aow;
    }

    /////////////////////////////////////////////////////////////TODO: For Create project

    public Map<String, Date> getFiredDates(String sessionId) throws ConfigurationException {
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        DateFormat month = new SimpleDateFormat("MM");
        DateFormat year = new SimpleDateFormat("yyyy");
        Date date = new Date();
        try {
            date = df.parse(cal.get(Calendar.YEAR) + "-" + ((cal.get(Calendar.MONTH) + 1 < 10)
                    ? "0" + (cal.get(Calendar.MONTH) + 1) : cal.get(Calendar.MONTH) + 1) + "-01T00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDate = date;
        Map<String, Date> firedDates = new HashMap<>();
        // String sessionId = initSession();
        APIProjects apiProjects = new APIProjects();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
        ArrayOfProjectWrapper arrayOfProjectWrapper = apiProjectsSoap.getSubprojectsDates(sessionId,
                cfg.getCalendarProjectId());
        arrayOfProjectWrapper.getProjectWrapper().stream().forEach(pw -> {
            try {
                if ((month.format(df.parse(pw.getPlannedEndDate().toString())).equals(month.format(finalDate)))
                        && (year.format(df.parse(pw.getPlannedEndDate().toString())).equals(year.format(finalDate)))) {
                    firedDates.put(pw.getName(), df.parse(pw.getPlannedEndDate().toString()));
                } else
                    firedDates
                            .put(pw.getName(),
                                    df.parse("1900-" + ((cal.get(Calendar.MONTH) + 1 < 10)
                                            ? "0" + (cal.get(Calendar.MONTH) + 1) : cal.get(Calendar.MONTH) + 1)
                                            + "-01T00:00:00"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        return firedDates;
    }

    public ProjectWrapper taskWrapper(String sessionId, String projectUID){
        APIProjects apiProjects = new APIProjects();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
        ProjectIdDataContract contract = new ProjectIdDataContract();
        contract.setASPNETSessionId(sessionId);
        contract.setProjectId(projectUID);
        ProjectWrapper projectWrapper = apiProjectsSoap.getProject(contract);

        return projectWrapper;
    }

    @Deprecated // It is recommended to use the method ProjectWsDao.getProjectTasks()
    public Set<String> getClosedTasks(String sessionId, String projectId) throws ConfigurationException {
        // String projectUid = "0e062f70-ae59-4e72-aed6-8bb5f6097263";
        // //Закрытые задачи оплачиваемых проектов
        // String sessionId = initSession();
        APIProjects apiProjects = new APIProjects();
        Set<String> closedTasks = new HashSet<>();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
        ArrayOfProjectWrapper arrayOfProjectWrapper = apiProjectsSoap.getSubprojectsDates(sessionId, projectId);

        arrayOfProjectWrapper.getProjectWrapper().stream().forEach(pw -> {
            closedTasks.add(pw.getUID());
        });

        // sessionId = initSession();
        // projectUid = "be92c243-4aed-4fa0-b381-23af0f6d7da7"; //Закрытые
        // задачи инвестиционных проектов
        ArrayOfProjectWrapper arrayOfProjectWrapper1 = apiProjectsSoap.getSubprojectsDates(sessionId,
                cfg.getClosedInvestProjectId());

        arrayOfProjectWrapper1.getProjectWrapper().stream().forEach(pw -> {
            closedTasks.add(pw.getUID());
        });

        // sessionId = initSession();
        // projectUid = "ee5f809a-7c36-4ba5-984d-d7104364a40b"; //Закрытые
        // задачи административных проектов
        ArrayOfProjectWrapper arrayOfProjectWrapper2 = apiProjectsSoap.getSubprojectsDates(sessionId,
                cfg.getClosedIntAdmProjectId());

        arrayOfProjectWrapper2.getProjectWrapper().stream().forEach(pw -> {
            closedTasks.add(pw.getUID());
        });

        // sessionId = initSession();
        // projectUid = "5b2cdbfb-a150-4493-9509-cf13287d1d08"; //Закрытые
        // задачи presale проектов
        ArrayOfProjectWrapper arrayOfProjectWrapper3 = apiProjectsSoap.getSubprojectsDates(sessionId,
                cfg.getClosedPresaleProjectId());

        arrayOfProjectWrapper3.getProjectWrapper().stream().forEach(pw -> {
            closedTasks.add(pw.getUID());
        });
        return closedTasks;
    }

    public double getResourceAssignments(String sessionId, String uid) {
        // String sessionId = initSession();
        StringBuilder sb = new StringBuilder();
        // PersonsWsDao pwd = new PersonsWsDao();
        APIProjects service = new APIProjects();
        APIProjectsSoap apiProjectsSoap = service.getAPIProjectsSoap();
        ArrayOfResourceAssignmentWrapper arrayOfResourceAssignmentWrapper = apiProjectsSoap
                .getProjectResourceAssignments(sessionId, uid);
        arrayOfResourceAssignmentWrapper.getResourceAssignmentWrapper().stream().forEach(ra -> {
            sb.append(/* ra.getPersonId() + ":" + */ra.getValue());
        });
        String finRate = sb.toString();
        return Double.parseDouble(
                ((finRate.length() - finRate.replaceAll(".", "").length()) > 1) ? finRate.split("\\.")[0] : finRate);
    }

    private ProjectIdDataContract makeContract(String sessionId, String uid) {
        ProjectIdDataContract contract = new ProjectIdDataContract();
        contract.setASPNETSessionId(sessionId);
        contract.setProjectId(uid);
        return contract;
    }

    public List<Map<String, Double>> advantaProjectTSh(String sessionId, String projectId,
                                                       Map<String, String> mapOfProdCalendars, String period) throws ConfigurationException {
        Map<String, Double> planHours = new HashMap<>();
        Date anyFutureDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.now(); // first period initiallization
        LocalDate endDate = LocalDate.now();
        YearMonth month = YearMonth.from(LocalDate.now());
        Calendar cal = Calendar.getInstance();
        String finalSurnameFormat = null;

        if (period.equalsIgnoreCase("month") || period == "month") {
            startDate = month.atDay(1);
        } else if (period.contains("-")) {
            startDate = LocalDate.parse(period.split("-")[0], formatter);
            endDate = LocalDate.parse(period.split("-")[1], formatter);
        } else {
            startDate = startDate.minusWeeks(1).with(DayOfWeek.MONDAY);
            endDate = endDate.minusWeeks(1).with(DayOfWeek.SUNDAY);
        }
        String regexFullTemplate = "([A-zА-Яа-яёЁ]+) ([A-zА-Яа-яёЁ]+) ([A-zА-Яа-яёЁ]+)"; // Шаблон
        // для
        // подстановки
        // ФИО
        // целиком
        String regexIOTemplate = "([A-zА-Яа-яёЁ]+) ([A-ZА-Я])[a-zа-яёЁ]+ ([A-ZА-Я])[a-zа-яёЁ]+"; // Шаблон
        // для
        // сокращения
        // И.О.

        ProjectWsDao projectDao = new ProjectWsDao();
        try {
            anyFutureDate = df.parse("1900-" + ((cal.get(Calendar.MONTH) + 1 < 10) ? "0" + (cal.get(Calendar.MONTH) + 1) : cal.get(Calendar.MONTH) + 1) + "-01T00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Получаем информацию о полях таймшита текущей задачи ( Количество
        // списанных часов, имя ресурса...)
        FieldWsDao fieldDao = new FieldWsDao();
        Map<String, Double> mapOfUsersHours = fieldDao.get(sessionId, projectId, cfg.getDirectoryId()); // получаем
        // map(ФИО,
        // часы)
        // ФИО
        // формат
        // Имя
        // Фамилия
        // Отчество
        Map<String, Date> getFiredDate = getFiredDates(sessionId);// Собираем
        // информацию,
        // уволился
        // ли кто в
        // этом
        // месяце

        for (String row : mapOfUsersHours.keySet()) {
            if (mapOfProdCalendars.containsKey(row.replaceAll(regexIOTemplate, "$1 $2.$3.")))
                finalSurnameFormat = row.replaceAll(regexIOTemplate, "$1 $2.$3.");
            else if (mapOfProdCalendars.containsKey(row))
                finalSurnameFormat = row;
            else if (mapOfProdCalendars.containsKey(row.replaceAll(regexFullTemplate, "$1 $2")))
                finalSurnameFormat = row.replaceAll(regexFullTemplate, "$1 $2");
            else if (mapOfProdCalendars.containsKey(row.replaceAll(regexFullTemplate, "$1")))
                finalSurnameFormat = row.replaceAll(regexFullTemplate, "$1");

            Date firedDate;
            firedDate = getFiredDate.get(finalSurnameFormat);
            String prodCalendar = mapOfProdCalendars.get(finalSurnameFormat);
            double hours = prodCalendar == null ? 0 : projectDao.getResourceAssignments(sessionId, prodCalendar);
            double workingHours = getWorkingHoursBetweenTwoDates(
                    startDate,
                    firedDate.equals(anyFutureDate) ? endDate : firedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    (hours < 10.0) ? 100.0 / 100 : hours / 100);
            planHours.put(row, workingHours);
        }
        return Arrays.asList(planHours, mapOfUsersHours);
    }

    // Вычисление количества плановых часов для сотрудника с учетом его
    // коэффициента загрузки
    public Double getWorkingHoursBetweenTwoDates(LocalDate localDate1, LocalDate localDate2, Double coeff) {
        int hoursCorrection = 0, workDays = 0, workHours = 0;

        for (LocalDate date = localDate1; !date.isAfter(localDate2); date = date.plusDays(1)) {
            if (date.getDayOfWeek().getValue() > 5) continue;
            ++workDays;
        }

        workHours = (int) (workDays * 8);

        //exception hours counting zone
        hoursCorrection = hoursCorrection(localDate1, localDate2);

        workHours += hoursCorrection;
        System.out.println("Получили " + (int) (workHours * coeff) + " рабочих часов\n");
        return Double.valueOf((int) (workHours * coeff));
    }

    public int hoursCorrection(LocalDate localDate1, LocalDate localDate2) { // Рассчитываем корректировки из
        // за исключений (праздников)
        Date d1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date d2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar cal = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        cal.setTime(d1);
        end.setTime(d2);
        int ruSaturday = Calendar.SATURDAY, ruSunday = Calendar.SUNDAY, dom, dow, mon, workHours = 0;
        AdvantaProjectTSh ats = new AdvantaProjectTSh();
        Map<String, Integer> exceptionsMap = ats.coutingExceptions();
        for (int i = cal.getActualMinimum(Calendar.DAY_OF_MONTH); i <= end.get(Calendar.DAY_OF_MONTH); i++) {
            cal.set(Calendar.DAY_OF_MONTH, i);
            dom = cal.get(Calendar.DAY_OF_MONTH);
            dow = cal.get(Calendar.DAY_OF_WEEK);
            mon = cal.get(Calendar.MONTH);
            // System.out.println("Чекдень: " +((mon + 1 < 10) ? "0" + (mon + 1)
            // : (mon + 1)) + "." + ((dom < 10) ? "0" + dom : dom + ":" +
            // dow)+":"+dow); // Выведем ее на экран
            if (exceptionsMap.containsKey(
                    ((mon + 1 < 10) ? "0" + (mon + 1) : (mon + 1)) + "." + ((dom < 10) ? "0" + dom : dom))) { // Если
                // текущая
                // дата
                // содержится
                // в
                // карте
                // исключений
                if (exceptionsMap
                        .get(((mon + 1 < 10) ? "0" + (mon + 1) : (mon + 1)) + "." + ((dom < 10) ? "0" + dom : dom)) == 1
                        && (dow != ruSaturday) && (dow != ruSunday)) { // Если
                    // ключ
                    // 1
                    // (выходной
                    // день)
                    // и это
                    // не
                    // суббота
                    // и не
                    // воскресенье
                    System.out.println("Выходной будний день(-8ч): " + ((mon + 1 < 10) ? "0" + (mon + 1) : (mon + 1))
                            + "." + ((dom < 10) ? "0" + dom : dom) + ":" + getWeekDayNameForInt(dow)); // Выведем
                    // ее
                    // на
                    // экран
                    workHours -= 8; // Вычитаем 8 часов
                } else if (exceptionsMap
                        .get(((mon + 1 < 10) ? "0" + (mon + 1) : (mon + 1)) + "." + ((dom < 10) ? "0" + dom : dom)) == 2
                        && (dow != ruSaturday) && (dow != ruSunday)) { // Если
                    // ключ
                    // 2
                    // (рабочий
                    // и
                    // сокращенный
                    // (может
                    // быть
                    // использован
                    // для
                    // любого
                    // дня
                    // недели)
                    // и это
                    // не
                    // суббота
                    // и не
                    // воскресенье
                    System.out.println("Сокращенный будний день(-1ч): " + ((mon + 1 < 10) ? "0" + (mon + 1) : (mon + 1))
                            + "." + ((dom < 10) ? "0" + dom : dom) + ":" + getWeekDayNameForInt(dow)); // Выведем
                    // ее
                    // на
                    // экран
                    workHours--;
                } else if (exceptionsMap
                        .get(((mon + 1 < 10) ? "0" + (mon + 1) : (mon + 1)) + "." + ((dom < 10) ? "0" + dom : dom)) == 2
                        && ((dow == ruSaturday) || (dow == ruSunday))) { // Если
                    // ключ
                    // 2
                    // (рабочий
                    // и
                    // сокращенный
                    // (может
                    // быть
                    // использован
                    // для
                    // любого
                    // дня
                    // недели)
                    // и
                    // это
                    // суббота
                    // или
                    // воскресенье
                    System.out.println("Сокращенный выходной(+7ч): " + ((mon + 1 < 10) ? "0" + (mon + 1) : (mon + 1))
                            + "." + ((dom < 10) ? "0" + dom : dom) + ":" + getWeekDayNameForInt(dow)); // Выведем
                    // ее
                    // на
                    // экран
                    workHours += 7;
                } else if (exceptionsMap.get(
                        ((mon + 1 < 10) ? "0" + (mon + 1) : (mon + 1)) + "." + ((dom < 10) ? "0" + dom : dom)) == 3) { // Если
                    // ключ
                    // 3
                    // Рабочий
                    // выходной
                    // день
                    System.out.println("рабочий выходной день(+8ч): " + ((mon + 1 < 10) ? "0" + (mon + 1) : (mon + 1))
                            + "." + ((dom < 10) ? "0" + dom : dom) + ":" + getWeekDayNameForInt(dow)); // Выведем
                    // ее
                    // на
                    // экран
                    workHours += 8;
                }
            }
        }

        return workHours;
    }

    public String getWeekDayNameForInt(int num) {
        String wr = "wrong";
        Map<Integer, String> dayNames = new HashMap<>();
        dayNames.put(2, "Понедельник");
        dayNames.put(3, "Вторник");
        dayNames.put(4, "Среда");
        dayNames.put(5, "Четверг");
        dayNames.put(6, "Пятница");
        dayNames.put(7, "Суббота");
        dayNames.put(8, "Воскресенье");

        return (dayNames.containsKey(num) == true) ? dayNames.get(num) : wr;
    }

    public ProjectWrapper makeProjectWrapper(String projectId, int status, int percentComplete){
        ProjectWrapper pw = new ProjectWrapper();
        pw.setUID(projectId);
        pw.setStatus(status);
        pw.setPercentComplete(percentComplete);

        /*LocalDate ld = LocalDate.now().plusDays(12); //Попытки установить таймшиты
        DateUtils du = new DateUtils();
        pw.setActualEndDate(du.localDateToXMLGregorianCalendar(ld));*/
    /*ArrayOfResourceAssignmentWrapper sss  =;
        pw.setResourceAssignments(sss);

        sss.*/

        return pw;
    }

    public ProjectWrapper getPW(){

        ProjectWrapper pw = new ProjectWrapper();

        System.out.println(pw.getProjectType());

        return new ProjectWrapper();
    }
}
