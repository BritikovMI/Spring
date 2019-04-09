/**
 * 
 */
package ru.rbt.jetski;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import com.atlassian.jira.rest.client.ComponentRestClient;
import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.ProjectRestClient;
import com.atlassian.jira.rest.client.domain.AssigneeType;
import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.IssueType;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.input.ComponentInput;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.domain.AssigneeTypeConstants;
import org.junit.Test;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.jira.JiraConfiguration;
import ru.rbt.jetski.jira.dao.ComponentJiraDao;
import ru.rbt.jetski.jira.dao.ProjectJiraDao;

/**
 * @author sotnik
 *
 */
public class TestCreateComponent {
	public static final String jiraUrl = "jiraUrl";
	public static final String jiraUser = "jiraUser";
	public static final String jiraPswd = "jiraPswd";

	public static final void main(String[] args) {
		try {
			ResourceBundle rb = ResourceBundle.getBundle("connection");
			final AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
			URI uri = new URI(rb.getString(jiraUrl));
			final JiraRestClient jiraRestClient = factory.createWithBasicHttpAuthentication(uri, rb.getString(jiraUser),
					rb.getString(jiraPswd));
			ComponentRestClient componentClient = jiraRestClient.getComponentClient();
			ProjectRestClient projectClient = jiraRestClient.getProjectClient();
			Project project = projectClient.getProject("BAKT").get();

			IssueType taskIssueType = null;
			for (IssueType issueType : project.getIssueTypes()) {
				if ("Задача".equals(issueType.getName())) {
					taskIssueType = issueType;
				}
			}

			ComponentInput component = new ComponentInput("COMPONENT-1", "Здесь должно быть описание компонента",
					"SotnikovAV", AssigneeType.valueOf(AssigneeTypeConstants.PROJECT_DEFAULT));

			BasicComponent componentObj = componentClient.createComponent("BAKT", component).get();

			System.out.println("ComponentObj " + componentObj.getName() + " created successfully");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// System.exit(1);
		}
	}

	@Test
	public void createComponent(){
		ComponentJiraDao componentJiraDao = new ComponentJiraDao();
		JiraConfiguration jiraCfg = JiraConfiguration.getInstance();
		String jiraUser = null, projectKey = "FRSE";
		try {
			jiraUser = jiraCfg.getJiraUser();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(componentJiraDao.createComponent(jiraUser, projectKey, "Tes1"));
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
