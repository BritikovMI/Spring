package ru.rbt.jetski.utils;

import ru.rbt.jetski.jira.dao.WorklogJiraDao;
import ru.rbt.jetski.newmodel.Subtask;
import ru.rbt.jetski.newmodel.Worklog;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by BritikovMI on 02.04.2019.
 */
public class WorklogUtil {

    public static List<Worklog> initilizeWorklog(Subtask subTask) {
        WorklogJiraDao wl = new WorklogJiraDao();
//        List<BasicWorklog> basicWorklogList = new ArrayList<>();
        List<com.atlassian.jira.rest.client.domain.Worklog> list = wl.worklogList(subTask.getJiraId());

//        String jqlQuery = null;
//        IssueJiraDao is = new IssueJiraDao();
//
        List<Worklog> worklogList = new LinkedList<>();
//
//        jqlQuery = "parent = \"" + subTask.getJiraId() + "\"";
//
//        List<Issue> issues = is.list(jqlQuery);

        for (com.atlassian.jira.rest.client.domain.Worklog worklog :
                list) {
            Worklog currentWorklog = new Worklog();
            currentWorklog.setFactWorkHours(worklog.getMinutesSpent() / 60);
            currentWorklog.setStartDate(worklog.getStartDate());
            currentWorklog.setExecutor(ExecutorUtil.initilizeExecutor(worklog));
            worklogList.add(currentWorklog);
        }


        return worklogList;
    }
}
