package ru.rbt.jetski.jira.dao;

import com.atlassian.jira.rest.client.ComponentRestClient;
import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.domain.AssigneeType;
import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.Component;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.input.ComponentInput;
import com.atlassian.jira.rest.client.internal.domain.AssigneeTypeConstants;
import ru.rbt.jetski.jira.JiraAccess;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/**
 * Created by BritikovMI on 06.03.2019.
 */
public class ComponentJiraDao {
    private ComponentRestClient client;

    public ComponentJiraDao() {
        JiraRestClient jiraRestClient = JiraAccess.getClient();
        client = jiraRestClient.getComponentClient();
    }

    public BasicComponent createComponent(String jiraUser, String projectKey, String name) throws ExecutionException, InterruptedException, URISyntaxException {
        ComponentInput component = new ComponentInput(name, "",
                jiraUser, AssigneeType.valueOf(AssigneeTypeConstants.PROJECT_DEFAULT));

        BasicComponent componentObj = client.createComponent(projectKey, component).get();

        return componentObj;
    }

    public Iterator<BasicComponent> getComponents(String projectKey){
        ProjectJiraDao projectJiraDao = new ProjectJiraDao();
        Project project = projectJiraDao.get(projectKey);
        Iterable<BasicComponent> components = project.getComponents();
        Iterator<BasicComponent> componentIterator = components.iterator();

        return componentIterator;
    }

    public Component getComponent(String uri){
        URI componentUri = null;
        try {
             componentUri = new URI(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Component component = client.getComponent(componentUri).claim();

        return component;
    }

    public BasicComponent getComponentByName(String projectKey, String componentName){
        ComponentJiraDao componentJiraDao = new ComponentJiraDao();
        BasicComponent cmp = null;
        Iterator<BasicComponent> componentIterator = componentJiraDao.getComponents(projectKey);

        while (componentIterator.hasNext()){
            BasicComponent currentComponent = componentIterator.next();
            if(componentName.equals(currentComponent.getName()))
                 cmp = currentComponent;
        }
        return cmp;
    }

    public static void main(String[] args) {
        //https://rbtechnologies.atlassian.net/rest/api/2/component/10050
        ComponentJiraDao cmp = new ComponentJiraDao();

        Iterator<BasicComponent> s = cmp.getComponents("FRSE");

        while (s.hasNext()) {
            BasicComponent basicComponent = s.next();
            if("Test".equals(basicComponent.getName()))
            System.out.println(basicComponent.getName());
        }
    }
}
