package ru.rbt.jetski.JIRA;

import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.BasicIssue;
import com.atlassian.jira.rest.client.domain.Issue;
import com.atlassian.jira.rest.client.domain.input.IssueInput;
import org.junit.Test;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.jira.JiraConfiguration;
import ru.rbt.jetski.jira.dao.IssueJiraDao;
import ru.rbt.jetski.jira.model.Component;
import ru.rbt.jetski.jira.model.Epic;
import ru.rbt.jetski.jira.model.Project;
import ru.rbt.jetski.jira.model.Subtask;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

/**
 * Created by BritikovMI on 14.03.2019.
 */
public class JiraIssueTest {
    @Test
    public void getComponentByIssue(){
        IssueJiraDao is = new IssueJiraDao();
        String issueKey = "FRSE-135";
        Iterator<BasicComponent> components = is.getIssueComponents(issueKey);

        while (components.hasNext()){
            BasicComponent cmp = components.next();
            System.out.println(cmp);
        }
    }

    @Test
    public void getParentTask(){
        String issueKey = "FRSE-135";
        IssueJiraDao is = new IssueJiraDao();
        System.out.println(is.getParent(issueKey));
        System.out.println(is.get(is.getParent(issueKey).getKey()).getIssueType().getId());
    }

    @Test
    public void getIssueName(){
        String issueKey = "FRSE-236";
        IssueJiraDao is = new IssueJiraDao();
        System.out.println(is.get(issueKey).getSummary());
    }

    @Test
    public void createIssue(){
        IssueJiraDao ijd = new IssueJiraDao();
        Subtask s = new Subtask();
        List<Subtask> subtaskList = s.initilizeSubtask();
        IssueInput issueInput = null;
        BasicIssue bi = null;
        JiraConfiguration jiraCfg = JiraConfiguration.getInstance();

        BasicComponent needTo = null;
        for (Subtask subtaskRow :
                subtaskList) {
            Epic currentEpic = subtaskRow.getParentEpic();
            Component currentComponent = currentEpic.getParentComponent();

            if("тест".equalsIgnoreCase(currentComponent.getComponentWrapper().getName().trim()))
                needTo = currentComponent.getComponentWrapper();
        }

        try {
            issueInput = ijd.createIssueInput( jiraCfg.getJiraUser(),
                    "FRSE", needTo.getName(), "NewTask-96",
                    LocalDate.now(), LocalDate.now().plusDays(1),
                    1D);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        bi = ijd.create(issueInput);

        System.out.println(bi.getSelf());
    }

    @Test
    public void deleteAllTasksInComponent(){
        IssueJiraDao ijd = new IssueJiraDao();

        List<Issue> issues = ijd.list("project = \"FRSE\"" +
                " AND" +
                " component = \"тест\"");

        issues.forEach(issue -> {
            ijd.httpDeleteIssue(issue.getKey());
        });

        System.exit(0);
    }

}
