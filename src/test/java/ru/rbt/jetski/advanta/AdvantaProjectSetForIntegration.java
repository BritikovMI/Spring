package ru.rbt.jetski.advanta;

import com.atlassian.jira.rest.client.domain.User;
import org.junit.Assert;
import org.junit.Test;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.advanta.ws.apiprojects.ProjectWrapper;
import ru.rbt.jetski.jira.JiraConfiguration;
import ru.rbt.jetski.jira.dao.UserJiraDao;

import java.util.Set;

/**
 * Created by BritikovMI on 07.03.2019.
 */
public class AdvantaProjectSetForIntegration {
    @Test
    public void getSet() throws ConfigurationException {
        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();

        AdvantaAccess access = new AdvantaAccess();

        ProjectWsDao projectDao = new ProjectWsDao();
        String sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());

        //Получаем имя проекта из Advanta
        String currentProject = "a77c8066-d1f2-406c-a265-85b36ffa64c3"; //Родительский проект
        ProjectWrapper project = projectDao.get(sessionId, currentProject);

        Assert.assertNotNull(project);

        String name = project.getName();
        System.out.println(name + " " + currentProject);

        Assert.assertNotNull(name);

        //Получаем множество задач из Адванта
        Set<String> taskSet = projectDao.getProjectTasks(sessionId, currentProject);

        Assert.assertNotNull(taskSet);

        for (String task :
                taskSet) {
            project = projectDao.get(sessionId, task);
            System.out.println(project.getName() + " " + task);
        }
    }
}
