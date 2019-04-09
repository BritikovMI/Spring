package ru.rbt.jetski;

import com.atlassian.jira.rest.client.domain.User;
import ru.rbt.jetski.jira.dao.UserJiraDao;


public class CustomJiraRestClient {

    public static void main(String[] args) {
        User user = new UserJiraDao().get("BritikovMI");
        System.out.println(String.format(
                "Your user's email address is: %s\r\n", user.getEmailAddress()));
//        new ProjectJiraDao().list().forEach(project -> System.out.println(project));
//        String jql = "project = VJGH AND status not in (Closed, Resolved) ORDER BY assignee, resolutiondate";
//        new IssueJiraDao().list(jql).forEach(issue -> System.out.println(issue));
        // Done
        System.out.println("Example complete. Now exiting.");
        System.exit(0);
    }
}
