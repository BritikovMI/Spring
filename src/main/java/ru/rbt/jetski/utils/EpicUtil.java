/**
 *
 */
package ru.rbt.jetski.utils;

import com.atlassian.jira.rest.client.domain.Issue;
import ru.rbt.jetski.jira.dao.IssueJiraDao;
import ru.rbt.jetski.newmodel.Component;
import ru.rbt.jetski.newmodel.Epic;

import java.util.LinkedList;
import java.util.List;


/**
 * @author sotnik
 */
public class EpicUtil {

    public static List<Epic> initilizeEpic(Component currentComponent) {
//        Epic rootEpic = new Epic();
        String jqlQuery = null;
        IssueJiraDao is = new IssueJiraDao();
//        BasicComponent currentJiraComponent = null;

//        ru.rbt.ru.rbt.jetski.jira.model.Component component = new ru.rbt.ru.rbt.jetski.jira.model.Component();
//        List<Component> componentList = component.initilizeComponent();
        List<Epic> innerEpicsList = new LinkedList<>();

//        for (ru.rbt.ru.rbt.jetski.jira.model.Component currentComponent :
//                componentList) {
//            currentJiraComponent = currentComponent.getComponentWrapper();
        String projectName = currentComponent.getParentProjectName();
        String componentName = currentComponent.getComponentName();

        jqlQuery = "project = \"" + projectName +
                "\" AND component = \"" + componentName +
                "\" AND issuetype = Epic";

        List<Issue> issues = is.list(jqlQuery);
        for (Issue issue :
                issues) {
            Epic epic = new Epic();
            epic.setJiraId(issue.getKey());
            epic.setEpicName(issue.getSummary());
//                epic.setParentComponent(currentComponent);
//                epic.setLevel(2);
            epic.setTasks(SubtaskUtil.initilizeSubtask(epic));
            innerEpicsList.add(epic);
        }


//        rootEpic.epicsList().addAll(innerEpicsList);

        return innerEpicsList;
    }
}

