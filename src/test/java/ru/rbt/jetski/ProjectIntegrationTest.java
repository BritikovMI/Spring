package ru.rbt.jetski;

import com.atlassian.jira.rest.client.domain.*;
import com.atlassian.jira.rest.client.domain.input.IssueInput;
//import org.json.JSONObject;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.advanta.*;
import ru.rbt.jetski.advanta.model.Project;
import ru.rbt.jetski.advanta.ws.apiprojects.ProjectWrapper;
import ru.rbt.jetski.advanta.ws.apiprojects.UpdateProjectDataContract;
import ru.rbt.jetski.jira.JiraConfiguration;
import ru.rbt.jetski.jira.JsonTemplates;
import ru.rbt.jetski.jira.dao.*;
import ru.rbt.jetski.jira.model.BasicWorklog;
import ru.rbt.jetski.jira.model.Epic;
import ru.rbt.jetski.jira.model.Subtask;
import ru.rbt.jetski.newmodel.Component;
import ru.rbt.jetski.newmodel.Worklog;
import ru.rbt.jetski.utils.ComponentUtil;
import ru.rbt.jetski.utils.EpicUtil;
import ru.rbt.jetski.utils.ProjectUtil;
import ru.rbt.jetski.utils.SubtaskUtil;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ProjectIntegrationTest {
    @Test
    public void integration() throws ConfigurationException {
        //BasicConfigurator.configure(); //TODO: включить Log4j по необходимости

        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();
        JiraConfiguration jiraCfg = JiraConfiguration.getInstance();

        AdvantaAccess access = new AdvantaAccess();

        ProjectWsDao projectDao = new ProjectWsDao();
        String sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());

        //TODO: Create A2nta project from application
            /*String parentUId = "09cace2f-ac42-4cb6-97f0-f17456bb786e";
            String name = "Testing project";
            String ownerID = "eac9da1f-0abe-4175-a07e-1dd23ec5ab47";
            String projectTypeId = "eac9da1f-0abe-4175-a07e-1dd23ec5ab47";
            String responsibleId = "eac9da1f-0abe-4175-a07e-1dd23ec5ab47";
            LocalDate date = LocalDate.now();
            LocalDate startDate = date, endDate = date.plusDays(1);
            String taskCreateResult = projectDao.createProject(sessionId, parentUId, name, projectTypeId, ownerID, responsibleId, startDate, endDate);

            System.out.println(taskCreateResult);*/

        //Получаем множество иерархию проектов из адванты
        String parentProject = "4826bdc1-41c1-4f94-b15b-096236618adc"; //Родительский проект
        Project project = new Project();

        List<Project> advantaProjectsList = project.buildAdvantaProjectHierarchy(parentProject);
        assertFalse(advantaProjectsList.isEmpty());
        Set<Project> advantaProjects = new LinkedHashSet<>();
        Set<Project> advantaContracts = new LinkedHashSet<>();
        Set<Project> advantaTasks = new LinkedHashSet<>();

        for (Project projectRow :                       //TODO: Раскрыть комментарии, если загрузка будет по открытым проектам, а не по тестовому
                advantaProjectsList) {
            if (projectRow.getLevel() == /*4*/0)
                advantaProjects.add(projectRow);
            else if (projectRow.getLevel() == /*5*/1)
                advantaContracts.add(projectRow);
            else if (projectRow.getLevel() >= /*6*/2)
                advantaTasks.add(projectRow);
        }

        Map<String, Project> advantaTaskMap
                = advantaTasks.stream()
                .collect(Collectors.toMap(Project::getUID, advantaProject -> advantaProject));

        Assert.assertFalse(advantaProjects.isEmpty());
        Assert.assertFalse(advantaContracts.isEmpty());
        Assert.assertFalse(advantaTasks.isEmpty());

//        advantaTasks.forEach(task -> System.out.println(task.getName()));


        /*Получаем иерархию проектов JIRA*/
        List<ru.rbt.jetski.newmodel.Project> jiraProjectList = ProjectUtil.initilizeProject();
        Map<String, ru.rbt.jetski.newmodel.Project> jiraProjectsMap
                = jiraProjectList.stream()
                .collect(Collectors.toMap(ru.rbt.jetski.newmodel.Project::getName, jiraProject -> jiraProject));

        /*Subtask subtask = new Subtask();
        List<Subtask> subtaskList = subtask.initilizeSubtask();

        Map<String, Subtask> subtaskMap = new LinkedHashMap<>();

        Map<String, Epic> epicMap = new LinkedHashMap<>();
        for (Subtask s :
                subtaskList) {
            subtaskMap.put(s.getSubtaskKey(), s);
            epicMap.put(s.getParentEpicKey(), s.getParentEpic());
        }*/

//        ProjectWrapper project = projectDao.get(sessionId, parentProject);

//        Assert.assertNotNull(project);

       /* String name = project.getName();
        System.out.println("name = " + name);

        Assert.assertNotNull(name);*/

        //Получаем множество задач из Адванта

/*
        Set<String> taskSet = projectDao.getProjectTasks(sessionId, parentProject);

        Assert.assertNotNull(taskSet);*/

        /*Получаем пользователя Advanta*/
        UserJiraDao userJiraDao = new UserJiraDao();
        User user = userJiraDao.get("BritikovMI");

        System.out.println("Username: " + user.getName());

        Assert.assertEquals("BritikovMI", user.getName());

        System.out.println("Задач в адванте: " + advantaTasks.size());
        for (Project currentTask :
                advantaTasks) {
            IssueJiraDao issueJiraDao = new IssueJiraDao();
            IssueInput ii = null;
            BasicIssue bi;

            Double complexity = 0D;

            WorklogJiraDao worklogJiraDao = new WorklogJiraDao();
            String deletionResult = null;

            String jiraIssueKey;

            int minutesSpent = 360;

            int advantaProjectStatus = 3 /*В процессе*/, advantaPercentComplete = 0;
            Project currentContract = new Project();
            String projectKey = null;
            ru.rbt.jetski.newmodel.Project currentJiraProject = new ru.rbt.jetski.newmodel.Project();
            if (currentTask.getLevel() == /*6*/2) {                                             //TODO: Раскрыть комментарии, если загрузка будет по открытым проектам, а не по тестовому
                currentContract = currentTask.getParent();
            } else if (currentTask.getLevel() == /*7*/3) {
                currentContract = currentTask.getParent().getParent();
            } else if (currentTask.getLevel() == 8) {
                currentContract = currentTask.getParent().getParent().getParent();
            } else if (currentTask.getLevel() == 9) {
                currentContract = currentTask.getParent().getParent().getParent().getParent();
            } else if (currentTask.getLevel() == 10) {
                currentContract = currentTask.getParent().getParent().getParent().getParent().getParent();
            }

            Project currentProject = currentContract.getParent();

            /*Находим в JIRA аналогичный проект */
            ProjectWrapper taskWrapper;
            ProjectJiraDao projectJiraDao = new ProjectJiraDao();
//            Map<String, String> projectsMap = projectJiraDao.map();
            String currentAdvantaProjectName = currentProject.getName().trim();
            if (jiraProjectsMap.containsKey(currentAdvantaProjectName)) {
                currentJiraProject = jiraProjectsMap.get(currentAdvantaProjectName);
                projectKey = currentJiraProject.getJiraId();
                System.out.println("Нашли проект " + currentAdvantaProjectName + " в jira - " + projectKey);
            }


           /* for (Subtask subtaskRow :
                    subtaskList) {
                Epic currentInnerEpic = subtaskRow.getParentEpic();
                ru.rbt.jetski.jira.model.Component currentInnerComponent = currentInnerEpic.getParentComponent();
                ru.rbt.jetski.jira.model.Project currentInnerProject = currentInnerComponent.getParentProject();
                String currentInnerProjectName = currentInnerProject.getProjectWrapper().getName();

                if (currentInnerProjectName.trim().equalsIgnoreCase(currentProject.getName().trim())) {
                    projectKey = currentInnerProject.getKey();
                    currentJiraProject = currentInnerProject;
                    System.out.println("Нашли проект в JIRA - " + projectKey);
                    break;
                }
            }*/
            if (currentJiraProject == null) {
                int status = 0;
                String url = "https://rbtechnologies.atlassian.net/rest/api/2/project";
                JsonTemplates template = new JsonTemplates();
                HTTPRequest httpRequest = new HTTPRequest();
                String encoded = httpRequest.getHttpAuthentication();
                String projectName = currentProject.getName();

                /*START Генерация Jira Project Key*/
                String jiraProjectKey = "";
                if (projectName.length()
                        - projectName.toUpperCase()
                        .replaceAll("B|C|D|F|G|H|J|K|L|M|N|P|Q|R|S|T|V|W|X|Z|", "")
                        .length() < 4) {
                    String[] f = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ч", "Ц", "Ш", "Щ", "Э", "Ю", "Я", "Ы", "Ъ", "Ь", "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ч", "ц", "ш", "щ", "э", "ю", "я", "ы", "ъ", "ь"};
                    String[] t = {"A", "B", "V", "G", "D", "E", "Jo", "Zh", "Z", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "H", "Ch", "C", "Sh", "Csh", "E", "Ju", "Ja", "Y", "`", "'", "a", "b", "v", "g", "d", "e", "jo", "zh", "z", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "ch", "c", "sh", "csh", "e", "ju", "ja", "y", "`", "'"};


                    for (int i = 0; i < projectName.length(); ++i) {
                        String add = projectName.substring(i, i + 1);
                        for (int j = 0; j < f.length; j++) {
                            if (f[j].equals(add)) {
                                add = t[j];
                                break;
                            }
                        }
                        projectKey += add;
                    }
                    projectKey = projectKey.toUpperCase().replaceAll("A|E|I|O|U|", "");

                } else {
                    projectKey = projectName.toUpperCase().replaceAll("A|E|I|O|U|А|Б|В|Г|Д|Е|Ё|Ж|З|И|К|Л|М|Н|О|П|Р|С|Т|У|Ф|Х|Ц|Ч|Ш|Щ|Ь|Ы|Ъ|Э|Ю|Я|", "");
                }

                if (projectKey.length() > 4) {
                    projectKey = projectKey.substring(0, 4);
                }
                /*END Генерация Jira Project Key*/


                JsonObject projectCreationData = template
                        .jiraProjectCreationData(jiraProjectKey, projectName,
                                "software", user.getName());

                status = httpRequest.doPostWithJson(projectCreationData, url, encoded);

                if (status == 201) {
                    currentJiraProject = new ru.rbt.jetski.newmodel.Project();
                    currentJiraProject.setJiraId(jiraProjectKey);
                    currentJiraProject.setName(projectName);

                    currentJiraProject.setComponents(ComponentUtil.initilizeComponent(currentJiraProject));
           /*         currentJiraProject.setProjectWrapper(prjt);
                    currentJiraProject.setLevel(0);*/
                }
                System.out.println("Создали проект в JIRA - " + projectKey);
            }


            Assert.assertNotNull(projectKey);
            /*Находим в JIRA аналогичный проект */

            LocalDate plannedStartDate, plannedEndDate;
            plannedStartDate = LocalDate.now();
            plannedEndDate = LocalDate.now().plusWeeks(1); //Обнуление конечной даты до некоторой бесконечной
            taskWrapper = currentTask.getProjectWrapper(); //Получаем слепок проекта из Advanta
            System.out.println("Задача из Advanta: " + taskWrapper.getName());

            /* Start Обнуление статусов по задаче Advanta*/
            ProjectWrapper pw = projectDao.makeProjectWrapper(currentTask.getUID(), advantaProjectStatus, advantaPercentComplete);

            UpdateProjectDataContract updDataContract = projectDao.makeUpdateProjectDataContract(sessionId, pw);

            String updateResult = projectDao.updateProject(updDataContract);

            System.out.println("Статусы обновлены: " + updateResult);
            /*End Обнуление статусов по задаче Advanta*/


            plannedStartDate = (taskWrapper.getPlannedStartDate() == null || taskWrapper.getPlannedStartDate().toXMLFormat().equals("0001-01-01T00:00:00")) ? plannedStartDate :
                    LocalDate.parse(
                            taskWrapper.getPlannedStartDate().toXMLFormat(),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

            plannedEndDate = (taskWrapper.getPlannedEndDate() == null || taskWrapper.getPlannedEndDate().toXMLFormat().equals("0001-01-01T00:00:00")) ? plannedEndDate :
                    LocalDate.parse(taskWrapper.getPlannedEndDate().toXMLFormat(),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));


           /* complexity = projectDao.getWorkingHoursBetweenTwoDates(plannedStartDate,
                    (plannedEndDate != null) ? plannedEndDate : LocalDate.now().plusYears(1),
                    1D);*/ //Расчитываем трудоемкость для 8 часового рабочего дня(100% загрузка)

            /*Проверка и установка Компонента*/
            ComponentJiraDao rootJiraComponent = new ComponentJiraDao();
            String currentJiraProjectKey = currentJiraProject.getJiraId();
            Component currentJiraComponent = new Component();
            String componentId = null;

            List<Component> componentList = currentJiraProject.getComponents();
            Map<String, Component> jiraComponentsMap
                    = componentList.stream()
                    .collect(Collectors.toMap(Component::getComponentName, jiraComponent -> jiraComponent));

            String currentContractName = currentContract.getName();
            if (jiraComponentsMap.containsKey(currentContractName)) {
                currentJiraComponent = jiraComponentsMap.get(currentContractName);
                componentId = currentJiraComponent.getJiraId();
                System.out.println("Нашли компонент " + currentContractName + " в jira - " + componentId);
            }

            String jiraUser = null;
            if (currentJiraComponent == null) {
                try {
                    jiraUser = jiraCfg.getJiraUser();
                    BasicComponent component = rootJiraComponent.createComponent(jiraUser, projectKey, currentContract.getName());
                    currentJiraComponent.setJiraId(component.getId().toString());
                    currentJiraComponent.setComponentName(component.getName());

                    currentJiraComponent.setEpics(EpicUtil.initilizeEpic(currentJiraComponent));
                } catch (ConfigurationException | InterruptedException | ExecutionException | URISyntaxException e) {
                    e.printStackTrace();
                }
                System.out.println("Создали компонент " + currentContractName + " в jira - " + currentJiraComponent.getJiraId());
            }
            /*Проверка и установка Компонента*/

            /* Создаем epic в JIRA по данным, полученным из Advanta, если не нашли в JIRA */
            String epicName = taskWrapper.getName();
            List<ru.rbt.jetski.newmodel.Epic> epicList = currentJiraComponent.getEpics();
            Map<String, ru.rbt.jetski.newmodel.Epic> jiraEpicsMap
                    = epicList.stream()
                    .collect(Collectors.toMap(ru.rbt.jetski.newmodel.Epic::getEpicName, jiraEpic -> jiraEpic));

            String currentJiraEpicKey = null;
            ru.rbt.jetski.newmodel.Epic currentJiraEpic = null;
            if (jiraEpicsMap.containsKey(epicName)) {
                currentJiraEpic = jiraEpicsMap.get(epicName);
                currentJiraEpic.setAdvantaId(taskWrapper.getUID());
                currentJiraEpicKey = currentJiraEpic.getJiraId();
                System.out.println("Нашли эпик " + epicName + " в jira - " + currentJiraEpicKey);
            }

            if (currentJiraEpic == null) {
                ii = issueJiraDao.createIssueInput(jiraCfg.getJiraUser(),
                        projectKey, currentJiraComponent.getComponentName(),
                        epicName,
                        plannedStartDate, plannedEndDate,
                        complexity); //Отправляем данные для создания задачи в JIRA

                bi = issueJiraDao.create(ii); // Создаем задачу в JIRA
                currentJiraEpic.setJiraId(bi.getKey());
                currentJiraEpic.setEpicName(epicName);
                currentJiraEpic.setAdvantaId(taskWrapper.getUID());
                currentJiraEpic.setTasks(SubtaskUtil.initilizeSubtask(currentJiraEpic));

                currentJiraEpicKey = currentJiraEpic.getJiraId();

                System.out.println("Создали в JIRA Epic " + epicName + " в jira - " + currentJiraEpicKey);
            }
            /* Создаем epic в JIRA по данным, полученным из Advanta, если не нашли в JIRA */

            /* Добавляем в Jira новый Worklog *//*  //TODO: Если добавляем ворклог, то добавлять нужно в Sub-task, а не в Epic
            Void createLog = issueJiraDao.createWorklog(jiraIssueKey, minutesSpent); //Добавляем worklog

            Assert.assertNull(createLog);

            System.out.println(bi);
            System.out.println("Worklog: " + worklogJiraDao.worklogList(jiraIssueKey));
            *//* Добавляем в Jira новый Worklog *//*

            Worklog newWorkLog = worklogJiraDao.worklogList(jiraIssueKey).iterator().next();


            System.out.println("Дата: " + newWorkLog.getStartDate() + " Время: " + newWorkLog.getMinutesSpent());
            assertEquals(newWorkLog.getMinutesSpent(), minutesSpent);


            Assert.assertNotNull(bi.getKey());*/


            System.out.println(projectKey + " " + currentJiraEpicKey);

            List<ru.rbt.jetski.newmodel.Subtask> subTaskList = currentJiraEpic.getTasks();
            Map<String, ru.rbt.jetski.newmodel.Subtask> jiraSubTaskMap
                    = subTaskList.stream()
                    .collect(Collectors.toMap(ru.rbt.jetski.newmodel.Subtask::getName, jiraSubTask -> jiraSubTask));

          /*  String jql = "project = " + projectKey +
                    " AND " +
                    "parent = " + jiraIssueKey;

            List<Issue> innerSubtaskList = issueJiraDao.list(jql);*/



            List<Worklog> basicWorklogList = new LinkedList<>();
            List<Worklog> mainWorklogList = new LinkedList<>();
            if (subTaskList.size() != 0) {
                for (ru.rbt.jetski.newmodel.Subtask subtask :
                        subTaskList) {
                    String currentSubtaskName = subtask.getName();
                    List<Worklog> worklogList = subtask.getWorkLogs();
                    for (Worklog w :
                            worklogList) {
                        w.setSubtask(currentSubtaskName);
                        basicWorklogList.add(w); //Собираем все Ворклоги по эпику
                    }
                }
                mainWorklogList.addAll(worklogJiraDao.calculateLastWeekEmployeeWorklogOfIssue(basicWorklogList));


                System.out.println("Сняли - " + mainWorklogList.size() + " ворклога");

                /*  Удаляем задачу в Jira */
            /*deletionResult = deleteIssue(bi.getKey());   //TODO: Uncomment if need to delete epics

            assertEquals(deletionResult, "");*/
                /* Удаляем задачу в Jira */

                /*  Start Установка часов, списанных в JIRA, в Адванту */

                DirectoryWsDao directoryWsDao = new DirectoryWsDao();
                String newTimesheetCode = null;

                for (Worklog basicWorklog :
                        mainWorklogList) {
                    Project taskToSetWorklog = null;
                    String currentAdvantaId = currentJiraEpic.getAdvantaId();
                    if (advantaTaskMap.containsKey(currentAdvantaId))
                        taskToSetWorklog = advantaTaskMap.get(currentAdvantaId);
                    System.out.println("Нашли в Advanta задачу, на которую надо установить часы: " + taskToSetWorklog.getName());

                    String employeeName = basicWorklog.getExecutor().getName();
                    Boolean overfact_flag = false;
                    String jiraSubtaskName = basicWorklog.getSubtask();

                    String description = "Компонент: " + currentJiraComponent.getComponentName() + "\n" +
                            "Epic: " + currentJiraEpic.getEpicName() + "\n" +
                            "Task: " + jiraSubtaskName + "\n" +
                            "Employee: " + employeeName + "\n" +
                            "Overfact hours: " + overfact_flag;

                    if (taskToSetWorklog != null) {
                        newTimesheetCode = directoryWsDao
                                .insertField(sessionId, advantaCfg.getDirectoryId(),
                                        taskToSetWorklog.getUID(),
                                        description, LocalDate.now(),
                                        employeeName,
                                        basicWorklog.getFactWorkHours() + "");


                        Assert.assertNotNull(newTimesheetCode);
                        System.out.print("Установили новый таймшит в адванта - " + newTimesheetCode);

                    /*for (Project task :
                            advantaTasks) {
                            String advantaTaskName = task.getName();
                            String jiraEpicName = currentJiraEpic.getEpicName();
                            if (jiraEpicName != null && advantaTaskName != null)
                                if (jiraEpicName.trim().equalsIgnoreCase(advantaTaskName.trim())) {
                                    taskToSetWorklog = task;
                                    System.out.println("Нашли в Advanta задачу, на которую надо установить часы: " + taskToSetWorklog.getName());

                                    String employeeName = basicWorklog.getEmployee().getName();
                                    Boolean overfact_flag = false;
                                    String jiraSubtaskName = subtaskMap
                                            .get(basicWorklog.getParentSubtaskKey())
                                            .getSubtaskWrapper().getSummary();

                                    String description = "Компонент: " + basicRootJiraComponent.getName() + "\n" +
                                            "Epic: " + jiraEpicName + "\n" +
                                            "Task: " + jiraSubtaskName + "\n" +
                                            "Employee: " + employeeName + "\n" +
                                            "Overfact hours: " + overfact_flag;


                                    if (taskToSetWorklog != null) {
                                        newTimesheetCode = directoryWsDao
                                                .insertField(sessionId, advantaCfg.getDirectoryId(),
                                                        taskToSetWorklog.getUID(),
                                                        description, LocalDate.now(),
                                                        employeeName,
                                                        basicWorklog.getWorklogHours() + "");


                                        Assert.assertNotNull(newTimesheetCode);
                                        System.out.print("Установили новый таймшит в адванта - " + newTimesheetCode);
                                    }
                                }

                        }*/

                    }
                }


                /*End Установка часов, списанных в JIRA, в Адванту */

                /* Start Закрытие проекта Advanta текущей датой*//* //TODO: UNCOMMENT THIS. Если раскрыть, задачи закроются и при следующей загрузке эти задачи не попадут в список
            advantaProjectStatus = 6 *//*Завершен*//*;
            advantaPercentComplete = 100;
            pw = projectDao.makeProjectWrapper(currentTask.getUID(), advantaProjectStatus, advantaPercentComplete);

            updDataContract = projectDao.makeUpdateProjectDataContract(sessionId, pw);

            updateResult = projectDao.updateProject(updDataContract);
            *//*End Закрытие проекта Advanta текущей датой*/

                assertEquals("Everything allright", updateResult);
            }
        }

        //Project create
            /*Long id = projectJiraDao.create(name, "TestProj", user);
            System.out.println("id = " + id);*/


        System.exit(0); //FIXME: реализовать естественный выход из приложения. Потоки не завершаются после использования метода .claim() в методе createWorklog() класса IssueJiraDao
    }

    public String deleteIssue(String issueCode) {

        IssueJiraDao is = new IssueJiraDao();
        String deletionResult = is.httpDeleteIssue(issueCode);

        System.out.println(deletionResult);

        return deletionResult;
//        assertNotNull(deletionResult);
    }
}