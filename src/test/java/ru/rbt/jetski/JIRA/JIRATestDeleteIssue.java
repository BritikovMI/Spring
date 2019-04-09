package ru.rbt.jetski.JIRA;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.rbt.jetski.HTTPRequest;
import ru.rbt.jetski.jira.dao.IssueJiraDao;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class JIRATestDeleteIssue {
    @Test
    public void deleteIssue() {
        String issueCode = "FRSE-45";

        IssueJiraDao is = new IssueJiraDao();
        String deletionResult = is.httpDeleteIssue(issueCode);

        System.out.println(deletionResult);

        assertEquals(deletionResult, "");
//        assertNotNull(deletionResult);
    }

    /*public void deleteEntity() throws MalformedURLException {
        URL url = new URL("https://rbtechnologies.atlassian.net");
        JIRAEnvironmentData ed = new JIRAEnvironmentData() {
            @Override
            public String getContext() {
                return null;
            }

            @Override
            public String getTenant() {
                return null;
            }

            @Override
            public boolean shouldCreateDummyTenant() {
                return false;
            }

            @Override
            public URL getBaseUrl() {
                URL url = null;
                try {
                    url = new URL("https://rbtechnologies.atlassian.net");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return url;
            }

            @Override
            public File getXMLDataLocation() {
                return null;
            }

            @Override
            public File getWorkingDirectory() {
                return null;
            }

            @Override
            public File getJIRAHomeLocation() {
                return null;
            }

            @Override
            public String getReleaseInfo() {
                return null;
            }

            @Override
            public boolean isBundledPluginsOnly() {
                return false;
            }

            @Override
            public boolean isAllTests() {
                return false;
            }

            @Override
            public boolean isSingleNamedTest() {
                return false;
            }

            @Override
            public Class<? extends TestCase> getSingleTestClass() {
                return null;
            }

            @Override
            public boolean isTpmLdapTests() {
                return false;
            }

            @Override
            public boolean isBlame() {
                return false;
            }

            @Override
            public String getProperty(String s) {
                return null;
            }
        };
        IssueTypeControl ist = new IssueTypeControl(ed);
        IssuesControl is = new IssuesControl(ed,ist);
        Response response = is.deleteIssue("FRSE-20",true);
        System.out.println(response);
    }*/
}
