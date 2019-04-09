package ru.rbt.jetski.jira.dao;

import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.domain.*;
import org.apache.commons.collections.IteratorUtils;
import ru.rbt.jetski.jira.JiraAccess;
import ru.rbt.jetski.newmodel.Executor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

//import org.json.JSONObject;

public class WorklogJiraDao {
    private JiraRestClient jiraRestClient;

    public WorklogJiraDao() {
        jiraRestClient = JiraAccess.getClient();
    }

    public List<Worklog> worklogList(String key) {
        Issue issue = jiraRestClient.getIssueClient().getIssue(key).claim();

        Iterable<Worklog> worklogs = issue.getWorklogs();
        Iterator<Worklog> worklogIterator = worklogs.iterator();

        List<Worklog> list = IteratorUtils.toList(worklogIterator);

        return list;
    }

    public List<ru.rbt.jetski.newmodel.Worklog> calculateLastWeekEmployeeWorklogOfIssue(List<ru.rbt.jetski.newmodel.Worklog> worklogList) {
        Map<Executor, Integer> planHours = new HashMap<>();
        LocalDate startDate = LocalDate.now(); // first period initiallization
        TemporalField fieldISO = WeekFields.of(Locale.getDefault()).dayOfWeek();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate thisMonday = startDate.with(fieldISO, 1);
        LocalDate endDate = LocalDate.now();

        if (startDate.equals(thisMonday)) {
            startDate = startDate.minusWeeks(1).with(DayOfWeek.MONDAY);
            endDate = endDate.minusWeeks(1).with(DayOfWeek.SUNDAY);
        } else {
            startDate = thisMonday;
            endDate = endDate.with(fieldISO, 7);
        }
        Map<Executor, String> userTask = new HashMap<>();
        for (ru.rbt.jetski.newmodel.Worklog row :
                worklogList) {
            LocalDate date = LocalDate.parse(row.getStartDate().toLocalDate().toString(), formatter);

            if (date.isAfter(startDate.minusDays(1)) && date.isBefore(endDate.plusDays(1)))
                if (!planHours.containsKey(row.getExecutor())) {
                    planHours.put(row.getExecutor(), row.getFactWorkHours());
                    userTask.put(row.getExecutor(), row.getSubtask());
                }
                else {
                    planHours.put(row.getExecutor(), planHours.get(row.getExecutor()) + row.getFactWorkHours());
                    userTask.put(row.getExecutor(), row.getSubtask());
                }
//            System.out.println("================\n" + row.getExecutor() + " " + row.getFactWorkHours() + "\n=========");

        }
        Set<Executor> basicUserSet = planHours.keySet();

        List<ru.rbt.jetski.newmodel.Worklog> mainWorklogList = new LinkedList<>();

        for (Executor row :
                basicUserSet) {
            ru.rbt.jetski.newmodel.Worklog basicWorklog = new ru.rbt.jetski.newmodel.Worklog();
            basicWorklog.setExecutor(row);
            basicWorklog.setSubtask(userTask.get(row));
//            basicWorklog.setParentSubtaskKey(worklogList);
            basicWorklog.setFactWorkHours(planHours.get(row));

            mainWorklogList.add(basicWorklog);
        }
        return mainWorklogList;
    }

    public static void main(String[] args) {
        WorklogJiraDao worklogJiraDao = new WorklogJiraDao();
        Set<String> kss = new HashSet<>();
        kss.add("FRSE-235");
        kss.add("FRSE-236");
        kss.add("FRSE-237");

       /* List<BasicWorklog> worklogList = new LinkedList<>();
        for (String key :
                kss) {
            worklogList.addAll(worklogJiraDao.calculateLastWeekEmployeeWorklogOfIssue(key));
        }

        for (BasicWorklog worklog :
                worklogList) {
            System.out.println(worklog.getParentSubtaskKey() + " " + worklog.getWorklogHours());
        }*/

       List<Worklog> e = worklogJiraDao.worklogList("FRSE-280");

        e.forEach(es-> {
           BasicUser s = es.getAuthor();
            System.out.println(s.getName());

        });
    }

    /*public String sWrkLg() {

     *//*JiraConfiguration jiraCgf = JiraConfiguration.getInstance();
        Worklog worklog;
        UserJiraDao userJiraDao = new UserJiraDao();
        User user = userJiraDao.get("BritikovMI");
        URI jiraUri = null, issueUri = null;
        String issueKey = "FRSE-49";

        LocalDate crDate = LocalDate.now();

        DateUtils du = new DateUtils();

        DateTime dt = du.toDateTime(crDate);
        try {
            jiraUri = URI.create(jiraCgf.getJiraUrl());
            issueUri = URI.create(jiraCgf.getJiraUrl() + "/rest/api/3/issue/" + issueKey + "/worklog");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        worklog = new Worklog(jiraUri, issueUri, user, user, "", dt, dt, dt, 120, null);
*//*
     *//*IssueJiraDao issueJiraDao = new IssueJiraDao();
     *//*

        Issue issue = issueJiraDao.get("FRSE-49");

        issueJiraDao.jira

        WorklogInput worklogInput = new WorklogInputBuilder(
                issue.getSelf()).setStartDate(new DateTime())
                .setComment("updated")
                .setMinutesSpent(1)
                .build();

        Promise<Void> result = issueClient.addWorklog(issue.getWorklogUri(), worklogInput);
        result.claim();



        return null;
    }*/

    /*public JSONObject setJiraWorklog(String issueKey) {
        //Preparing date
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+0000");
        String loggingDate = sdf.format(date);

        //Preparing workLogTime
        int workedMinutes = 60;

        //Preparing workLog in objectNode format
        WorklogJiraDao worklogJiraDao = new WorklogJiraDao();
        *//*ObjectNode*//*
        String objNode = worklogJiraDao.makingWorklog(loggingDate, workedMinutes);

        JiraConfiguration jiraCfg = JiraConfiguration.getInstance();
        String uri = null;
        try {
            uri = jiraCfg.getJiraUrl() + "/rest/api/3/issue/" + issueKey + "/worklog";
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        HTTPRequest httpRequest = new HTTPRequest();
        String encoded = httpRequest.getHttpAuthentication();

        UnirestRequest unirestRequest = new UnirestRequest();
        JSONObject pr = unirestRequest.doUniPost(uri, objNode, encoded);

        return pr;
    }

    public *//*ObjectNode*//* String makingWorklog(String loggingDate, int workedMinutes) {
     *//*JsonNodeFactory jnf = JsonNodeFactory.instance;
        ObjectNode payload = jnf.objectNode();
        {
            payload.put("started", loggingDate); //"2019-02-06T14:54:27.252+0000" - worked dateTime template
            payload.put("timeSpent", workedMinutes);
        }*//*
        String payload = "{\n" +
                "\t\"started\": \"" + loggingDate + "\",\n" +
                "\t\"timeSpent\": " + workedMinutes + "\n" +
                "}";

        return payload;
    }*/
}
