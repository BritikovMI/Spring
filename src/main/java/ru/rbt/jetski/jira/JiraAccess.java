package ru.rbt.jetski.jira;

import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.JiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

import java.net.URI;

public class JiraAccess {

    private static final String jiraUrl = "https://rbtechnologies.atlassian.net";//"/rest/api/3";
    private static final String jiraUsername = "BritikovMI@rbtechnologies.ru";
    private static final String jiraToken = "A5stDGO0eTysTJJT0Mj084B8";

    public static JiraRestClient getClient() {
        JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
        URI uri = URI.create(jiraUrl);
        JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, jiraUsername, jiraToken);
        return client;
    }

}
