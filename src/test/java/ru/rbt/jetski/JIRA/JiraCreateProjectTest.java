package ru.rbt.jetski.JIRA;

import com.atlassian.jira.bc.project.ProjectCreationData;
import com.atlassian.jira.bc.project.ProjectService;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.config.ConstantsManager;
//import com.atlassian.jira.mock.component.MockComponentWorker;
import com.atlassian.jira.project.Project;
import com.atlassian.jira.project.ProjectManager;
import com.atlassian.jira.rest.client.domain.User;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.jira.user.ApplicationUser;
//import com.atlassian.jira.user.MockApplicationUser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
//import org.mockito.Mockito;
import ru.rbt.jetski.jira.dao.ProjectJiraDao;
import ru.rbt.jetski.jira.dao.UserJiraDao;

/**
 * Created by BritikovMI on 21.03.2019.
 */
public class JiraCreateProjectTest {
    @Test
    public void avv() {
        /*Long id = projectJiraDao.create(name, "TestProj", user);
        System.out.println("id = " + id);*/

        UserJiraDao userJiraDao = new UserJiraDao();
        User user = userJiraDao.get("BritikovMI");

        String projectName = "TestProj";
        String projectKey = "PTTRP";
        ProjectJiraDao pjd = new ProjectJiraDao();

        Project project = pjd.create(projectName, projectKey, user);

        System.out.println(project.getName() + " " + project.getKey());

    }

    @Test
    public void ttt() {


        String projectName = "TestProj";
        String projectKey = "PTTRP";

        ProjectCreationData.Builder pcdBuilder = new ProjectCreationData.Builder();
        pcdBuilder.withName("Test Project").withKey("TP");
        ProjectCreationData projectCreationData = pcdBuilder.build();

        UserJiraDao userJiraDao = new UserJiraDao();
        User user = userJiraDao.get("BritikovMI");
        Project project = ComponentAccessor.getProjectManager().createProject((ApplicationUser) user, projectCreationData);

        System.out.println(project.getName());


    }

    public static void main(String[] args) {
        String name = "New project";
        String key = "NEWKEY";

        UserJiraDao userJiraDao = new UserJiraDao();
        User user = userJiraDao.get("BritikovMI");

        ProjectJiraDao pjd = new ProjectJiraDao();

        ProjectManager pm = ComponentAccessor.getProjectManager();

        pm.createProject((ApplicationUser) user, new ProjectCreationData.Builder().withKey("FFF").withName("TestTestProj").build());
    }
}
