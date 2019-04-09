/**
 * 
 */
package ru.rbt.jetski.utils;

import com.atlassian.jira.rest.client.domain.Issue;
import ru.rbt.jetski.jira.dao.IssueJiraDao;
import ru.rbt.jetski.newmodel.Epic;
import ru.rbt.jetski.newmodel.Subtask;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sotnik
 *
 */
public class SubtaskUtil {

	public static List<Subtask> initilizeSubtask(Epic epic) {
//        Subtask rootSubtask = new Subtask();
        String jqlQuery = null;
//        String subtaskName = null;
//        Issue currentJiraEpic = null;

        IssueJiraDao is = new IssueJiraDao();

//        Epic epic = new Epic();
//        List<Epic> epicList = epic.initilizeEpic();
        List<Subtask> innerSubtasksList = new LinkedList<>();

//        for (Epic currentEpic :
//                epicList) {
//            currentJiraEpic = currentEpic.getEpicWrapper();
//            String currentJiraEpicKey = currentJiraEpic.getKey();
            jqlQuery = "parent = \"" + epic.getJiraId() + "\"";

            List<Issue> issues = is.list(jqlQuery);
            for (Issue issue :
                    issues) {
                Subtask subtask = new Subtask();
                subtask.setJiraId(issue.getKey());
                subtask.setName(issue.getSummary());

                subtask.setWorkLogs(WorklogUtil.initilizeWorklog(subtask));
                innerSubtasksList.add(subtask);
            }

//        }

//        rootSubtask.subtasksList().addAll(innerSubtasksList);

        return innerSubtasksList;
    }
	
}
