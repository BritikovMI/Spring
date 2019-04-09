package ru.rbt.jetski.jira.model;

import com.atlassian.jira.rest.client.domain.Issue;
import ru.rbt.jetski.jira.dao.IssueJiraDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by BritikovMI on 14.03.2019.
 */
public class Subtask {
    private String subtaskKey;
    private Issue subtaskWrapper;
    private int Level;
    private String parentEpicKey;
    private Epic parentEpic;

    protected Subtask subtask;
    protected List<Subtask> subtasks;

    public List<Subtask> subtasksList() {
        if (subtasks == null) {
            subtasks = new ArrayList<>();
        }
        return this.subtasks;
    }

    public String getSubtaskKey() {
        return subtaskKey;
    }

    public void setSubtaskKey(String subtaskKey) {
        this.subtaskKey = subtaskKey;
    }

    public Issue getSubtaskWrapper() {
        return subtaskWrapper;
    }

    public void setSubtaskWrapper(Issue subtaskWrapper) {
        this.subtaskWrapper = subtaskWrapper;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getParentEpicKey() {
        return parentEpicKey;
    }

    public void setParentEpicKey(String parentEpicKey) {
        this.parentEpicKey = parentEpicKey;
    }

    public Epic getParentEpic() {
        return parentEpic;
    }

    public void setParentEpic(Epic parentEpic) {
        this.parentEpic = parentEpic;
    }

    public List<Subtask> initilizeSubtask() {
        Subtask rootSubtask = new Subtask();
        String jqlQuery = null;
        String subtaskName = null;
        Issue currentJiraEpic = null;

        IssueJiraDao is = new IssueJiraDao();

        Epic epic = new Epic();
        List<Epic> epicList = epic.initilizeEpic();
        Set<Subtask> innerSubtasksList = new HashSet<>();

        for (Epic currentEpic :
                epicList) {
            currentJiraEpic = currentEpic.getEpicWrapper();
            String currentJiraEpicKey = currentJiraEpic.getKey();
            jqlQuery = "parent = \"" + currentJiraEpicKey + "\"";

            List<Issue> issues = is.list(jqlQuery);
            for (Issue issue :
                    issues) {
                Subtask subtask = new Subtask();
                subtask.setSubtaskKey(issue.getKey());
                subtask.setSubtaskWrapper(issue);
                subtask.setParentEpicKey(currentJiraEpic.getKey());
                subtask.setParentEpic(currentEpic);
                subtask.setLevel(3);

                innerSubtasksList.add(subtask);
            }

        }

        rootSubtask.subtasksList().addAll(innerSubtasksList);

        return rootSubtask.subtasksList();
    }
}

