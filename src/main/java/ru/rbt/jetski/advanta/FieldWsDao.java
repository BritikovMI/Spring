package ru.rbt.jetski.advanta;

import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.advanta.ws.apiprojects.APIProjects;
import ru.rbt.jetski.advanta.ws.apiprojects.APIProjectsSoap;
import ru.rbt.jetski.advanta.ws.apiprojects.ArrayOfFieldWrapper;
import ru.rbt.jetski.advanta.ws.apiprojects.FieldWrapper;
import ru.rbt.jetski.advanta.ws.apiservice.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FieldWsDao {

    public static final String DATE_FLD_NAME = "Дата";

    public static final String RESOURCE_FLD_NAME = "Ресурс";

    public static final String FACT_HOURS_FLD_NAME = "Фактические трудозатраты";

    public static final String OVERFACT_HOURS_FLD_NAME = "Сверхурочные";

    /**
     * Created by BritikovMI on 18.10.2018.
     */
    public Map<String, Double> get(String sessionId, String projectId, String directoryID) {
        String[] whitelist = {DATE_FLD_NAME, RESOURCE_FLD_NAME/*, "Сверхурочные"*/, FACT_HOURS_FLD_NAME};
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss'Z'");
        DateFormat month = new SimpleDateFormat("MM");
        DateFormat year = new SimpleDateFormat("yyyy");
        Date date = new Date();
//        int hours = 0;
        try {
            date = df.parse(cal.get(Calendar.YEAR) + "-" + ((cal.get(Calendar.MONTH) + 1 < 10) ? "0" + (cal.get(Calendar.MONTH) + 1) : cal.get(Calendar.MONTH) + 1) + "-01 00:00:00Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDate = date;
//        String sessionId = initSession();
        Map<String, Double> employeeHours = new HashMap<>();
        Map<String, String> tempEmployeeHours = new HashMap<>();

        try {
            APIService service = new APIService();
            APIServiceSoap apiServicesSoap = service.getAPIServiceSoap12();
            apiServicesSoap.getRecords(sessionId, directoryID, projectId).getRecords().getRecordWrapper().stream().forEach(rw -> {
                rw.getFields().getFieldWrapper().stream().forEach(fw -> {
                    if (Arrays.stream(whitelist).anyMatch(fw.getFieldName().trim()::equals))
                        tempEmployeeHours.put(fw.getFieldName(), fw.getFieldVal());
                });
                try {
                    if ((month.format(df.parse(tempEmployeeHours.get(DATE_FLD_NAME))).equals(month.format(finalDate))) && (year.format(df.parse(tempEmployeeHours.get(DATE_FLD_NAME))).equals(year.format(finalDate)))) {
                        if (employeeHours.containsKey(tempEmployeeHours.get(RESOURCE_FLD_NAME))) {
                            employeeHours.put(tempEmployeeHours.get(RESOURCE_FLD_NAME), employeeHours.get(tempEmployeeHours.get(RESOURCE_FLD_NAME)) + Double.valueOf(tempEmployeeHours.get(FACT_HOURS_FLD_NAME)));
                            /*if (tempEmployeeHours.containsKey("Сверхурочные")) {
                                employeeHours.put(tempEmployeeHours.get(RESOURCE_FLD_NAME), employeeHours.get(tempEmployeeHours.get(RESOURCE_FLD_NAME)) + Double.valueOf(tempEmployeeHours.get("Сверхурочные")));
                            }*/
                        } else {
                            employeeHours.put(tempEmployeeHours.get(RESOURCE_FLD_NAME), Double.valueOf(tempEmployeeHours.get(FACT_HOURS_FLD_NAME)));
                            /*if (tempEmployeeHours.containsKey("Сверхурочные")) {
                                employeeHours.put(tempEmployeeHours.get("Ресурс"), employeeHours.get(tempEmployeeHours.get("Ресурс")) + Double.valueOf(tempEmployeeHours.get("Сверхурочные")));
                            }*/
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        employeeHours.values().removeIf(Objects::isNull);
        employeeHours.keySet().removeIf(Objects::isNull);
        for (String row :
                employeeHours.keySet()) {
            System.out.println("Получили " + employeeHours.get(row) + " часов списал сотрудник- " + row);
        }
        return employeeHours;
    }

    public void getWrapper(String sessionId, String projectId, String directoryId) {  // Получение записей таймшитов
        APIService service = new APIService();
        APIServiceSoap apiServicesSoap = service.getAPIServiceSoap12();
        apiServicesSoap.getRecords(sessionId, directoryId, projectId).getRecords().getRecordWrapper().stream().forEach(rw -> {
            rw.getFields().getFieldWrapper().stream().forEach(fw -> {
                System.out.println(fw.getFieldId() + " : " + fw.getFieldName() + " : " + fw.getFieldType() + " : " + fw.getFieldVal());
            });
        });
    }


    /* Справочник по таймшитам - Fields
        FieldID -- 0e63ef1b-aa39-4fd9-819b-ab1c19a323d6 : Вид деятельности :  : 6146ea12-7a5a-4af1-94f5-877b587a80d0 //Разработка ПО
        FieldID -- caaaaaac-8920-4ab0-a553-b4516a8417ac : Дата :  : 2019-01-28 00:00:00Z
        FieldID -- caaaaaac-8920-4ab0-a553-b4516a8417a1 : Ресурс :  : Бритиков Максим Игоревич
        FieldID -- caaaaaac-8920-4ab0-a553-b4516a8417aa : Статус :  : На редактировании
        FieldID -- b6977f0a-bf32-4946-af71-0865219ec846 : Сверхурочные :  : 0
        FieldID -- 06ff935a-c7fc-4ab3-8ad7-9012927cc651 : Фактические трудозатраты :  : 4
       Справочник по таймшитам - Fields */

    public String updateField (String sessionId, String projectId, String directoryId) { // Обновление таймшитов!
        FieldWrapper date = new FieldWrapper();
        date.setFieldId("caaaaaac-8920-4ab0-a553-b4516a8417ac");
        date.setFieldVal("2019-01-28 00:00:00Z");

        FieldWrapper employee = new FieldWrapper();
        employee.setFieldId("caaaaaac-8920-4ab0-a553-b4516a8417a1");
        employee.setFieldVal("BritikovMI");

        FieldWrapper hours = new FieldWrapper();
        hours.setFieldId("06ff935a-c7fc-4ab3-8ad7-9012927cc651");
        hours.setFieldVal("8");
        /*ArrayOfRecordWrapper arrayOfRecordWrapper = new ArrayOfRecordWrapper();

        arrayOfRecordWrapper.getRecordWrapper().forEach(rw -> {
            rw.getFields().getFieldWrapper().add(fw);
        });*/
        ArrayOfFieldWrapper arw = new ArrayOfFieldWrapper();
        arw.getFieldWrapper().add(date);
        arw.getFieldWrapper().add(employee);
        arw.getFieldWrapper().add(hours);

        arw.getFieldWrapper().forEach(fw -> System.out.println(fw.getFieldVal()));

        /*ProjectWsDao pwd = new ProjectWsDao();
        pwd.makeProjectWrapper("""""")
        UpdateProjectDataContract upd = new UpdateProjectDataContract();
        upd.setProject(pwd.makeUpdateProjectDataContract());*/
        APIProjects apiProjects = new APIProjects();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
        String result = apiProjectsSoap.updateProjectFields(sessionId, projectId, arw);


        return result;
    }

    public static void main(String[] args) {
        /*//Теперь приходит и с проектов и с договоров и с задач.
        Set<String> projects = new HashSet<>(); //DummyProjectSet
        projects.add("60677552-f22f-4c02-b301-897ac9e25667");
        projects.add("0eccc23d-3479-4bca-a820-122c57f6fb97");
        projects.add("d4352053-7f48-4561-8a54-347360553a4b");
        projects.add("4826bdc1-41c1-4f94-b15b-096236618adc");
        projects.add("09cace2f-ac42-4cb6-97f0-f17456bb786e");
        projects.add("099704f5-6178-4b5a-9bf4-68e1902887c1");
        projects.add("85b9a4df-5f57-4a8b-aa09-787d64b1263d");
        projects.add("214baa59-e8b4-40a2-bd12-fc6854caa9fb");
        projects.add("b517fb73-9918-4c6a-b2f2-aab49dc622f0");
        Map<String, Double> unmap = null;
        for (String project: projects) {
//             unmap = get(project, "977ff0ae-56f8-40ad-8919-8175788e38c8");
        }*/

       /* Set<String> unmapKeyset = new HashSet<>();
        unmapKeyset.removeIf(Objects::isNull);
        for (String key : unmapKeyset) {
            System.out.println(key + ": " + unmap.get(key));
        }
//        String[] arrayOfFields = sb.toString().replace(";#:#X", "").split(";#:#");
//        for (String field:arrayOfFields
//             ) {
//            System.out.println(field);
//        }
//        System.out.println(sb.toString());*/
        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();

        AdvantaAccess access = new AdvantaAccess();
        String sessionId = null;
        try {
            sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        String projectId = "53b37067-fe82-458d-9fb5-80fb25f2ab2f", directoryId = "977ff0ae-56f8-40ad-8919-8175788e38c8";

        FieldWsDao fwd = new FieldWsDao();
//        System.out.println(fwd.updateField(sessionId, projectId, directoryId));

//        fwd.getWrapper(sessionId,projectId,directoryId);

        System.out.println(fwd.get(sessionId, projectId, directoryId));
    }


   /* private ProjectIdDataContract makeContract(String sessionId, String uid,String directoryID) {
        ProjectIdDataContract contract = new ProjectIdDataContract();
        contract.setASPNETSessionId(sessionId);
        contract.setProjectId(uid);
        return contract;
    }*/
}
