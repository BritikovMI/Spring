package ru.rbt.jetski.jira;


import static ru.rbt.jetski.api.RestApiContextNames.API_ISSUE;

/**
 * Created by misha on 15.08.2018.
 */
public class IssueClient extends AbstractJiraRestClient {

    @Override
    protected String getContext() {
        return API_ISSUE;
    }
}
