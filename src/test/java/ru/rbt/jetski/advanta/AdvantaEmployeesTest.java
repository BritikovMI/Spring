package ru.rbt.jetski.advanta;

import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.advanta.ws.apiprojects.ProjectWrapper;
import ru.rbt.jetski.advanta.ws.apiservice.APIService;
import ru.rbt.jetski.advanta.ws.apiservice.APIServiceSoap;
import ru.rbt.jetski.advanta.ws.persons.PersonQueryResult;
import ru.rbt.jetski.advanta.ws.persons.Persons;
import ru.rbt.jetski.advanta.ws.persons.PersonsSoap;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AdvantaEmployeesTest {

    private static final AdvantaConfiguration cfg = AdvantaConfiguration.getInstance();

    public static final String RESOURCE_FLD_NAME = "Ресурс";

    public static void main(String[] args) throws ConfigurationException {
        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();
        AdvantaAccess access = new AdvantaAccess();
        String sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());

        ProjectWsDao pwd = new ProjectWsDao();

        AdvantaEmployeesTest aet = new AdvantaEmployeesTest();

		/*


		 * */

        Set<String> activeProjects = new HashSet<>();
        activeProjects.add("35867785-7e0b-4293-a1dd-9f8d55ffae6f");
        activeProjects.add("d2555c36-d138-49f3-b221-ec3179d43d93");
        activeProjects.add("64144607-be86-4116-8379-78656b71d7d1");
        activeProjects.add("9ddd6874-bd60-4185-b37f-c55a097454b6");
        activeProjects.add("958dfb44-81d4-4705-a71f-4acba5538386");
        activeProjects.add("d8fbebf3-2503-47fc-bcfe-020c978ba52d");
        activeProjects.add("93437f4a-5190-4a4c-84a2-1a12b9420832");
        activeProjects.add("9aa4662e-015c-4863-94c4-2b8177667a93");
        activeProjects.add("fde16641-197c-4c20-a81c-015373d94b8e");
        activeProjects.add("fde16641-197c-4c20-a81c-015373d94b8e");
        activeProjects.add("84441fd4-3c45-4218-b58b-176d89f0b1c5");
        activeProjects.add("04b9e4cf-4498-4240-b2bb-97899bc7856a");
        activeProjects.add("9f818e0d-b2e9-4fa5-a393-8999400a87a8");
        activeProjects.add("e13c5283-9326-4617-b567-006b07756281");
        activeProjects.add("91d4a505-f4e9-45e4-957d-7b91080535d6");
        activeProjects.add("ac78d8cc-a6aa-4dc9-a29a-630c5eb4f6dd");
        activeProjects.add("46e2cd44-f258-49e8-84b7-6c9f26a75dd8");
        activeProjects.add("4ce14d92-8026-4f4a-aa9d-67737c9b0acc");

        activeProjects.add("9bed83aa-4fab-4c33-98b7-84c8ff24c187");
        activeProjects.add("11ce3474-a61f-4ac6-81bc-3080ce35d64d");
        activeProjects.add("96744422-af6b-49d4-bcf8-d4610fc166f4");
        activeProjects.add("d8f208ed-28be-4e8b-89b6-927d9803713b");
        activeProjects.add("191bf6ad-540a-461e-9db1-b7dbc9f85450");
        activeProjects.add("0d974c89-9c78-493f-96c5-cc8354945b0f");
        activeProjects.add("7628e04b-17c6-4bff-85a5-93ccdca49dc2");
        activeProjects.add("0b8d2f9a-47a9-4381-8260-714201ad74e7");
        activeProjects.add("e8cce625-e123-4ce5-83df-701fb02ca22a");
        activeProjects.add("d62fdf53-acfe-4e33-8eff-783705241be3");
        activeProjects.add("bca0c745-91d3-4e05-9f74-cb7442a4574d");
        activeProjects.add("06952d6e-4dd3-44d7-986f-944db0383c0f");
        activeProjects.add("38e2fa6d-6bfd-4330-ad06-e3b71230aeb1");
        activeProjects.add("35b72d27-4373-453b-9805-ff06e70445f3");
        activeProjects.add("92dcdc16-49fe-415f-850a-3f6b173bed7c");
        activeProjects.add("5c447a81-a43a-431c-b9cb-0897d8530640");
        activeProjects.add("213d04d9-6d39-4f9a-b12d-3c27914df63f");
        activeProjects.add("b9d89c15-f265-4cb3-a7f1-97430906cc14");
        activeProjects.add("b5725a76-e793-4b81-8c64-9404534e2a5d");
        activeProjects.add("9aebff25-06e4-44fa-ad89-de34457b6a23");
        activeProjects.add("cb3bb1f9-f7af-45b9-90f2-a6e10b8a2a0e");
        activeProjects.add("7d818aca-92fe-4f07-8f9e-d1ce276235dc");
        activeProjects.add("00e95d4d-b1d1-48ab-8b38-28f84a8b7f3f");
        activeProjects.add("37d6202d-fed1-405e-a569-491605e90356");
        activeProjects.add("3bb0a550-0d12-45fa-9cb4-d8be23c2c6b6");
        activeProjects.add("e1cf08ff-4f27-4a6f-a587-f907d4cf8cca");
        activeProjects.add("b27f880c-05a1-4345-8ac5-689026fe0e4e");
        activeProjects.add("397f2371-fb41-4212-b9e5-e51922e28329");
        activeProjects.add("e58937ac-26df-4acf-a3a6-bca8e5e1d636");
        activeProjects.add("7e051fd4-00e0-4424-9f5d-5165137e46fe");
        activeProjects.add("9d1974ef-9ef3-44ab-b37b-282ccf533bc0");

        ProjectWsDao projectDao = new ProjectWsDao();
        Set<String> projects = pwd.getProjectTasks(sessionId, "0e062f70-ae59-4e72-aed6-8bb5f6097263"); // DummyProjectSet
        for (String projectId : projects) {
            ProjectWrapper project = projectDao.get(sessionId, projectId);
            if ("0e062f70-ae59-4e72-aed6-8bb5f6097263".equals(project.getParentProjectId())) {
                activeProjects.add(project.getUID());
            }
        }

        for (String projectId : activeProjects) {
            // Get Project name

            ProjectWrapper project = projectDao.get(sessionId, projectId);
            String projectName = project.getName();
            Map<String, String> employees = aet.getResourceMap(sessionId, projectId, cfg.getDirectoryId());
            for (Map.Entry<String, String> entry : employees.entrySet()) {
                System.out.println(projectName + " : " + entry.getKey() + " : " + entry.getValue());
            }
        }

        // aet.getResourceMap(sessionId, "214baa59-e8b4-40a2-bd12-fc6854caa9fb",
        // cfg.getDirectoryId()); //Dummy resourceMap

    }

    public Map<String, String> getResourceMap(String sessionId, String projectId, String directoryID) {
        String[] whitelist = { RESOURCE_FLD_NAME };

        Map<String, String> employees = new HashMap<>();
        Map<String, String> tempEmployees = new HashMap<>();

        // Get Project name
        ProjectWsDao projectDao = new ProjectWsDao();
        ProjectWrapper project = projectDao.get(sessionId, projectId);
        String projectName = project.getName();

        APIService service = new APIService();
        APIServiceSoap apiServicesSoap = service.getAPIServiceSoap12();
        apiServicesSoap.getRecords(sessionId, directoryID, projectId).getRecords().getRecordWrapper().stream()
                .forEach(rw -> {
                    rw.getFields().getFieldWrapper().stream().forEach(fw -> {
                        if (Arrays.stream(whitelist).anyMatch(fw.getFieldName().trim()::equals))
                            tempEmployees.put(fw.getFieldName(), fw.getFieldVal());
                    });

                    employees.put(projectName, tempEmployees.get(RESOURCE_FLD_NAME));
                });

        employees.values().removeIf(Objects::isNull);
        employees.keySet().removeIf(Objects::isNull);

        AdvantaEmployeesTest aet = new AdvantaEmployeesTest();
        Map<String, String> mailMap = aet.getPersons(sessionId);

        Map<String, String> finalEmployees = new HashMap<>();
        for (String row : employees.keySet()) {
            String name = employees.get(row);
            finalEmployees.put(name, mailMap.get(name));
        }
        return finalEmployees;
    }

    public Map<String, String> getPersons(String sessionId) {
        // String sessionId = initSession();
        Map<String, String> employeesInfo = new HashMap<>();
        try {
            Persons persons = new Persons();
            PersonsSoap personsSoap = persons.getPersonsSoap12();
            PersonQueryResult personQueryResult = personsSoap.getPersons(sessionId);
            personQueryResult.getPersons().getSlPerson().stream().forEach(slp -> {
                employeesInfo.put(slp.getFullName(), slp.getEMail());
            });
            return employeesInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
