package ru.rbt.jetski.jira.model;

import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.Issue;
import ru.rbt.jetski.jira.dao.IssueJiraDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by BritikovMI on 14.03.2019.
 */
public class Epic {
    private String epicKey;
    private Issue epicWrapper;
    private int Level;
    private Long parentComponentId;
    private Component parentComponent;

    protected Epic epic;
    protected List<Epic> epics;

    public List<Epic> epicsList() {
        if (epics == null) {
            epics = new ArrayList<>();
        }
        return this.epics;
    }

    public String getEpicKey() {
        return epicKey;
    }

    public void setEpicKey(String epicKey) {
        this.epicKey = epicKey;
    }

    public Issue getEpicWrapper() {
        return epicWrapper;
    }

    public void setEpicWrapper(Issue issueWrapper) {
        this.epicWrapper = issueWrapper;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public Long getParentComponentId() {
        return parentComponentId;
    }

    public void setParentComponentId(Long parentComponentId) {
        this.parentComponentId = parentComponentId;
    }

    public Component getParentComponent() {
        return parentComponent;
    }

    public void setParentComponent(Component parentComponent) {
        this.parentComponent = parentComponent;
    }

    public List<Epic> initilizeEpic() {
        Epic rootEpic = new Epic();
        String jqlQuery = null;
        String projectName;
        String componentName;
        IssueJiraDao is = new IssueJiraDao();
        BasicComponent currentJiraComponent = null;

        ru.rbt.jetski.jira.model.Component component = new ru.rbt.jetski.jira.model.Component();
        List<Component> componentList = component.initilizeComponent();
        Set<Epic> innerEpicsList = new HashSet<>();

        for (ru.rbt.jetski.jira.model.Component currentComponent :
                componentList) {
            currentJiraComponent = currentComponent.getComponentWrapper();
            projectName = currentComponent.getParentProject().getProjectWrapper().getName();
            componentName = currentJiraComponent.getName();

            jqlQuery = "project = \"" + projectName +
                    "\" AND component = \"" + componentName +
                    "\" AND issuetype = Epic";

            List<Issue> issues = is.list(jqlQuery);
            for (Issue issue :
                    issues) {
                Epic epic = new Epic();
                epic.setEpicKey(issue.getKey());
                epic.setEpicWrapper(issue);
                epic.setParentComponentId(currentComponent.getId());
                epic.setParentComponent(currentComponent);
                epic.setLevel(2);

                innerEpicsList.add(epic);
            }

        }
        rootEpic.epicsList().addAll(innerEpicsList);

        return rootEpic.epicsList();
    }
}
