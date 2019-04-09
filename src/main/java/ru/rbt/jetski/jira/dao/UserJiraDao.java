package ru.rbt.jetski.jira.dao;

import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.UserRestClient;
import com.atlassian.jira.rest.client.domain.User;
import ru.rbt.jetski.jira.JiraAccess;

public class UserJiraDao {

    private UserRestClient client;

    public UserJiraDao() {
        JiraRestClient jiraRestClient = JiraAccess.getClient();
        client = jiraRestClient.getUserClient();
    }

    public User get(String name) {
        User user = client.getUser(name).claim();
        return user;
    }
}
