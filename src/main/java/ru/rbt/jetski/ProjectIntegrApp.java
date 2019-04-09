package ru.rbt.jetski;

import com.atlassian.jira.rest.client.domain.*;
import com.atlassian.jira.rest.client.domain.input.IssueInput;
import ru.rbt.jetski.advanta.AdvantaAccess;
import ru.rbt.jetski.advanta.AdvantaConfiguration;
import ru.rbt.jetski.advanta.ProjectWsDao;
import ru.rbt.jetski.advanta.ws.apiprojects.ProjectWrapper;
import ru.rbt.jetski.jira.JiraConfiguration;
import ru.rbt.jetski.jira.dao.IssueJiraDao;
import ru.rbt.jetski.jira.dao.ProjectJiraDao;
import ru.rbt.jetski.jira.dao.UserJiraDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;

public class ProjectIntegrApp {

    public static void main(String[] args) {
        try {
            //BasicConfigurator.configure(); //TODO: включить Log4j по необходимости

            AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();
            JiraConfiguration jiraCfg = JiraConfiguration.getInstance();

            AdvantaAccess access = new AdvantaAccess();

            ProjectWsDao projectDao = new ProjectWsDao();
            String sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());
            /*String parentUId = "09cace2f-ac42-4cb6-97f0-f17456bb786e";
            String name = "Testing project";
            String ownerID = "eac9da1f-0abe-4175-a07e-1dd23ec5ab47";
            String projectTypeId = "eac9da1f-0abe-4175-a07e-1dd23ec5ab47";
            String responsibleId = "eac9da1f-0abe-4175-a07e-1dd23ec5ab47";
            LocalDate date = LocalDate.now();
            LocalDate startDate = date, endDate = date.plusDays(1);
            String taskCreateResult = projectDao.createProject(sessionId, parentUId, name, projectTypeId, ownerID, responsibleId, startDate, endDate);

            System.out.println(taskCreateResult);*/
            //Получаем имя проекта из Advanta
            String currentProject = "4826bdc1-41c1-4f94-b15b-096236618adc";
            ProjectWrapper project = projectDao.get(sessionId, currentProject);
            String name = project.getName();
            System.out.println("name = " + name);

            Set<String> taskSet = projectDao.getProjectTasks(sessionId, currentProject); //Получаем множество задач текущего проекта

            UserJiraDao userJiraDao = new UserJiraDao();
            User user = userJiraDao.get("BritikovMI");

            System.out.println("Username: " + user.getName());

            ProjectWrapper taskWrapper;
            ProjectJiraDao projectJiraDao = new ProjectJiraDao();
            Map<String, String> projectsMap = projectJiraDao.map();

            String projectKey = (projectsMap.containsKey(name)) ? projectsMap.get(name) : "FRSE";

            System.out.println(projectKey);

            IssueJiraDao issueJiraDao = new IssueJiraDao();
            IssueInput ii = null;
            BasicIssue bi;

            LocalDate plannedStartDate, plannedEndDate;

            Double complexity = 0D;
            for (String task :
                    taskSet) {
                plannedEndDate = LocalDate.now().plusYears(1); //Обнуление конечной даты до некоторой бесконечной
                taskWrapper = projectDao.taskWrapper(sessionId, task); //Получаем слепок проекта из Advanta

                plannedStartDate = LocalDate.parse(taskWrapper.getPlannedStartDate().toXMLFormat(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
                plannedEndDate = (taskWrapper.getPlannedEndDate() == null) ? plannedEndDate : LocalDate.parse(taskWrapper.getPlannedEndDate().toXMLFormat(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
//                complexity = projectDao.getWorkingHoursBetweenTwoDates(plannedStartDate, plannedEndDate, 1D); //Расчитываем трудоемкость для 8 часового рабочего дня(100% загрузка)

                ii = issueJiraDao.createIssueInput(jiraCfg.getJiraUser(),
                        projectKey, null, //FIXME вставить настоящий компонент
                        taskWrapper.getName(),
                        plannedStartDate, plannedEndDate, complexity); //Отправляем данные для создания задачи в JIRA


                bi = issueJiraDao.create(ii); // Создаем задачу в JIRA
                System.out.println(bi);
            }


            //Project create
            /*Long id = projectJiraDao.create(name, "TestProj", user);
            System.out.println("id = " + id);*/
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
