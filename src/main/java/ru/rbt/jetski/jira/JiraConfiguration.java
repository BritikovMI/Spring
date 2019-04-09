package ru.rbt.jetski.jira;

import ru.rb.cfg.SystemConfiguration;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rb.cfg.prop.PropertiesConfiguration;

public class JiraConfiguration {
    public static final String JIRA_PROPERTY_NAME = "JIRA";

    private static final JiraConfiguration INSTANCE = new JiraConfiguration();

    private static final SystemConfiguration cfg = SystemConfiguration.getInstance();

    private JiraConfiguration() {
    }

    public static final JiraConfiguration getInstance() {
        if (!cfg.containsConfig(JIRA_PROPERTY_NAME)) {
            try {
                cfg.add(PropertiesConfiguration.create(JIRA_PROPERTY_NAME, "src/test/properties/connection.properties"));
            } catch (ConfigurationException ex) {
                throw new RuntimeException(ex);
            }
        }
        return INSTANCE;
    }

    public String getJiraUrl() throws ConfigurationException {
        return cfg.getString("jiraUrl");
    }

    public String getJiraUser() throws ConfigurationException {
        return cfg.getString("jiraUser");
    }

    public String getJiraPassword() throws ConfigurationException {
        return cfg.getString("jiraPswd");
    }
    public String getJiraToken() throws ConfigurationException {
        return cfg.getString("jiraToken");
    }
}
