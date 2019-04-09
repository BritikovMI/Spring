package ru.rbt.jetski.JIRA;

import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.Component;
import org.junit.Test;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.jira.JiraConfiguration;
import ru.rbt.jetski.jira.dao.ComponentJiraDao;

import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/**
 * Created by BritikovMI on 06.03.2019.
 */
public class JiraComponentTest {
    @Test
    public void createComponent() {
        ComponentJiraDao componentJiraDao = new ComponentJiraDao();
        JiraConfiguration jiraCfg = JiraConfiguration.getInstance();
        String jiraUser = null, projectKey = "FRSE";
        try {
            jiraUser = jiraCfg.getJiraUser();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(componentJiraDao.createComponent(jiraUser, projectKey, "mainCmp"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getComponents() {
        ComponentJiraDao componentJiraDao = new ComponentJiraDao();
        String projectKey = "FRSE";

        Iterator<BasicComponent> componentIterator = componentJiraDao.getComponents(projectKey);

        while (componentIterator.hasNext()){
            BasicComponent cmp = componentIterator.next();

            System.out.println(cmp);
        }
    }

    @Test
    public void getComponent(){
        ComponentJiraDao componentJiraDao = new ComponentJiraDao();
        String uri = "https://rbtechnologies.atlassian.net/rest/api/2/component/10050";

        System.out.println(componentJiraDao.getComponent(uri));
    }
}
