/**
 * 
 */
package ru.rbt.jetski;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import com.atlassian.jira.rest.client.IssueRestClient;
import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.ProjectRestClient;
import com.atlassian.jira.rest.client.domain.BasicIssue;
import com.atlassian.jira.rest.client.domain.IssueType;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.input.IssueInput;
import com.atlassian.jira.rest.client.domain.input.IssueInputBuilder;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

/**
 * @author sotnik
 *
 */
public class TestCreateIssue {

	public static final String jiraUrl = "jiraUrl";
	public static final String jiraUser = "jiraUser";
	public static final String jiraPswd = "jiraPswd";

	public static final void main(String[] args)  {
        try {
        	ResourceBundle rb = ResourceBundle.getBundle("connection");
        	final AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
    		URI uri = new URI(rb.getString(jiraUrl));
    		final JiraRestClient jiraRestClient = factory.createWithBasicHttpAuthentication(uri, rb.getString(jiraUser),
    				rb.getString(jiraPswd));
            IssueRestClient issueClient = jiraRestClient.getIssueClient();
            ProjectRestClient projectClient = jiraRestClient.getProjectClient();
        	Project project = projectClient.getProject("BAKT").get();
        	
        	IssueType taskIssueType = null;
			for (IssueType issueType : project.getIssueTypes()) {
				if ("Задача".equals(issueType.getName())) {
					taskIssueType = issueType;
				} 
			}
        	
            IssueInputBuilder iib = new IssueInputBuilder(project, taskIssueType);
            iib.setProjectKey("BAKT");
            iib.setSummary("Test Summary");
            iib.setIssueType(taskIssueType);
            iib.setDescription("Test Description");
            iib.setPriorityId(3L);
            iib.setAssigneeName("SotnikovAV");
//            iib.setReporterName("SotnikovAV");
//            iib.setDueDate(new DateTime());

            IssueInput issue = iib.build();
            BasicIssue issueObj = issueClient.createIssue(issue).claim();

            System.out.println("Issue " + issueObj.getKey() + " created successfully");
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
//        	System.exit(1);
        }

		
		/*try {
			final AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
			URI uri = new URI(jiraUrl);
			final JiraRestClient jiraRestClient = factory.createWithBasicHttpAuthentication(uri, jiraUser,
					jiraPswd);
			
			ProjectRestClient projectClient = jiraRestClient.getProjectClient();
			projectClient.getAllProjects().get().forEach(prj -> System.out.println(prj.getName() + " : " + prj.getKey()));
			Project project = projectClient.getProject("BAKT").get();
			project.getIssueTypes().forEach(issueType -> System.out.println(issueType.getId() + " : " + issueType.getName()));
			
			IssueType taskIssueType = null;
			for (IssueType issueType : project.getIssueTypes()) {
				if ("Задача".equals(issueType.getName())) {
					taskIssueType = issueType;
				} 
			}
					
			
			
			
			//new FieldInput();
			
			SearchRestClient searchClient = jiraRestClient.getSearchClient();
			SearchResult result = searchClient.searchJql("project = BARS_Additional_Kanban_test AND status= CONSULTING").get();
			result.getIssues().forEach(issue -> System.out.println(issue.getKey()));
			
			
			IssueRestClient issueClient = jiraRestClient.getIssueClient(); 
			issueClient.getIssue("BAKT-2").get().getFields().forEach(field -> System.out.println(field.getId() + " : " + field.getName() + " : " + field.getType() + " : " + field.getValue()));

			if (taskIssueType != null) {
				final IssueType t = taskIssueType;
				Map<String, FieldInput> issueProps = new HashMap<String, FieldInput>() {
					{
						put("key", new FieldInput("key", "BAKT-3"));
						put("summary", new FieldInput("summary", "Test create issue by program"));
						put("issuetype", new FieldInput("issuetype", t));
					}
				};
				issueClient.createIssue(new IssueInput(issueProps));
			}
			
			UserRestClient userClient = jiraRestClient.getUserClient();
			
			
		} catch (URISyntaxException | InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
