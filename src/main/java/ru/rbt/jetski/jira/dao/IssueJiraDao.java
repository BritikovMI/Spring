package ru.rbt.jetski.jira.dao;

import com.atlassian.jira.rest.client.IssueRestClient;
import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.ProjectRestClient;
import com.atlassian.jira.rest.client.SearchRestClient;
import com.atlassian.jira.rest.client.domain.*;
import com.atlassian.jira.rest.client.domain.input.*;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.json.BasicIssueJsonParser;
import com.sun.jersey.api.client.ClientResponse;
import org.codehaus.jettison.json.JSONObject;
import org.joda.time.DateTime;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.DateUtils;
import ru.rbt.jetski.HTTPRequest;
import ru.rbt.jetski.jira.JiraAccess;
import ru.rbt.jetski.jira.JiraConfiguration;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class IssueJiraDao {
    private final Set<ClientResponse> responses = null;
    private JiraRestClient jiraRestClient;

    public IssueJiraDao() {
        jiraRestClient = JiraAccess.getClient();
    }

    public Issue get(String key) {
        Issue issue = jiraRestClient.getIssueClient().getIssue(key).claim();
        return issue;
    }

    public BasicIssue create(IssueInput input) {
        BasicIssue issue = jiraRestClient.getIssueClient().createIssue(input).claim();
        return issue;
    }

    public Void createWorklog(String issueCode, int minutesSpent) {
        Issue issue = get(issueCode);

        WorklogInput worklogInput = new WorklogInputBuilder(
                issue.getSelf())
                .setStartDate(new DateTime())
//                .setComment("test")
                .setMinutesSpent(minutesSpent)
                .build();
        Void result = jiraRestClient.getIssueClient().addWorklog(issue.getWorklogUri(), worklogInput).claim();
        return result;
    }

    public BasicIssue getParent(String issueKey) {
        Issue iss2 = get(issueKey);
        Field ob = iss2.getField("parent");
        BasicIssue bi;
        if (ob != null) {
            JSONObject jsonParent = (JSONObject) ob.getValue();
            bi = null;
            try {
                bi = new BasicIssueJsonParser().parse(jsonParent);
            } catch (org.codehaus.jettison.json.JSONException e) {
                e.printStackTrace();
            }
        } else {
            bi = null;
        }
        return bi;
    }


    /**
     * For example jql can be like this
     * "project = VJGH AND status not in (Closed, Resolved) ORDER BY assignee, resolutiondate"
     */
    public List<Issue> list(String jql) {
        SearchRestClient client = jiraRestClient.getSearchClient();
        List<Issue> list = new ArrayList<>();
        client.searchJql(jql).claim().getIssues().forEach(basic -> list.add(get(basic.getKey())));
        return list;
    }

    public Iterator<BasicComponent> getIssueComponents(String key) {
        IssueJiraDao is = new IssueJiraDao();
        Iterator<BasicComponent> allComponents = is.get(key).getComponents().iterator();

        return allComponents;
    }

    public Issue findEpicByName(String projectKey, String epicName){
        IssueJiraDao is = new IssueJiraDao();
        String jql = "project = " + projectKey +
                " AND " +
                "\"Epic Name\" = "  + epicName;

        List<Issue> list = is.list(jql);

        Issue epic = null;
        for (Issue currentEpic :
                list) {
            if (epicName.trim().equalsIgnoreCase(currentEpic.getSummary()))
                 epic = currentEpic;
        }

        return epic;
    }

    public static void main(String[] args) {
        IssueJiraDao issueJiraDao = new IssueJiraDao();
        String projectKey = "FRSE";
        String jiraIssueKey = "FRSE-277";

        String jql = "project = " + projectKey +
                " AND " +
                "parent = " + jiraIssueKey;

        List<Issue> issueList = issueJiraDao.list(jql);

        issueList.forEach(issue -> System.out.println(issue.getKey() + " " + issue.getSummary()));

        System.exit(0);
    }


    public List<BasicIssue> basic(String jql) {
        SearchRestClient client = jiraRestClient.getSearchClient();
        List<BasicIssue> list = new ArrayList<>();
        client.searchJql(jql).claim().getIssues().forEach(basic -> list.add(basic));
        return list;
    }

    public IssueInput createIssueInput(String jiraUser, String projectKey, String component, String summary, LocalDate plannedStartDate, LocalDate plannedEndDate, Double complexity) {
//        ResourceBundle rb = ResourceBundle.getBundle("connection");
        Project project = null;
        DateUtils du = new DateUtils();
        try {
            ProjectRestClient projectClient = jiraRestClient.getProjectClient();
            project = projectClient.getProject(projectKey).get();
        }  catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        IssueType taskIssueType = null;
        for (IssueType issueType : project.getIssueTypes()) {
//            System.out.println(issueType.getName() + " " + issueType);
            if ("Epic".equals(issueType.getName())) {
                taskIssueType = issueType;
            }
        }
        IssueInputBuilder iib = new IssueInputBuilder(project, taskIssueType);
        iib.setProjectKey(projectKey);
        iib.setSummary(summary);
        iib.setIssueType(taskIssueType);
        iib.setDescription("Test Description");
        iib.setPriorityId(3L);

        System.out.println("Имя компонента: " + component);
        Iterable<String> components = Arrays.asList(component);

        iib.setComponentsNames(components);
//        iib.setDueDate(du.toDateTime(plannedEndDate)); //com.atlassian.jira.rest.client.RestClientException: Field 'duedate' cannot be set. It is not on the appropriate screen, or unknown.
        iib.setAssigneeName(jiraUser);
        iib.setFieldValue("customfield_10003", summary); //Epic name
        iib.setFieldValue("customfield_10073", du.toDateTime(plannedStartDate).toString()); //Apply String -- "2019-02-04T00:00:00.000Z"
        iib.setDueDate(du.toDateTime(plannedEndDate));

        try {
            iib.setReporterName(JiraConfiguration.getInstance().getJiraUser());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
//            iib.setDueDate(new DateTime());

        return iib.build();
    }

    public String httpDeleteIssue(String issueCode) {
        HTTPRequest httpRequest = new HTTPRequest();
        JiraConfiguration jiraCfg = JiraConfiguration.getInstance();
        String result = null;
        try {
            result = httpRequest.doDelete(jiraCfg.getJiraUrl() + "/rest/api/2/issue/" + issueCode, jiraCfg.getJiraUser(), jiraCfg.getJiraPassword());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return result;
    }

    public IssueInputBuilder setEstimateTime(String projectKey) {
        ProjectRestClient projectClient = jiraRestClient.getProjectClient();
        Project project = null;
        try {
            project = projectClient.getProject(projectKey).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        IssueType taskIssueType = null;
        for (IssueType issueType : project.getIssueTypes()) {
//            System.out.println(issueType.getName() + " " + issueType);
            if ("Epic".equals(issueType.getName())) {
                taskIssueType = issueType;
            }
        }


        IssueInputBuilder iib = new IssueInputBuilder(projectKey, taskIssueType.getId()); //TODO: set arguments
        Map<String, Object> map = new HashMap<>();
        map.put("originalEstimate", "4h 30m");
        return iib.setFieldInput(new FieldInput(IssueFieldId.TIMETRACKING_FIELD, new ComplexIssueInputFieldValue(map)));
    }

   /* public String WorklogManagerCRUD(){
        TimeTracking ttl = new TimeTracking();
        return null;
    }*/

    //TODO: Prepare a thread-safe way to delete a issues from JIRA
   /* public ErrorCollection delete(MutableIssue input){
        IssueService is = new IssueService.DeleteValidationResult("","");
        ErrorCollection ers = is.delete("gae",",");
        IssuesControl
        return ers;
    }*/

    /*public Response delete(final String issueKey, final String deleteSubtasks) throws UniformInterfaceException {
        return this.toResponse(new RestApiClient.Method() {
            public ClientResponse call() {
                WebResource deleteResource = new IssueJiraDao().createResource().path(issueKey);
                if (deleteSubtasks != null) {
                    deleteResource = deleteResource.queryParam("deleteSubtasks", deleteSubtasks);
                }

                return (ClientResponse)deleteResource.delete(ClientResponse.class);
            }
        });


    }
    protected WebResource createResource() {
        return this.createResource().path("issues");
    }

    protected Response<?> toResponse(RestApiClient.Method method) {
        ClientResponse clientResponse = this.registerResponse(method.call());
        if (clientResponse.getStatus() == 200) {
            Response<?> response = new Response(clientResponse.getStatus(), (Errors)null);
            clientResponse.close();
            return response;
        } else {
            return this.errorResponse(clientResponse);
        }
    }
    protected ClientResponse registerResponse(ClientResponse response) {
        this.responses.add(response);
        return response;
    }
    protected <T> Response<T> errorResponse(ClientResponse clientResponse) {
        Errors entity = null;
        if (clientResponse.hasEntity() && MediaType.APPLICATION_JSON_TYPE.isCompatible(clientResponse.getType())) {
            try {
                entity = (Errors)clientResponse.getEntity(Errors.class);
            } catch (Exception var4) {
                System.out.println("Failed to deserialise Errors from response" + var4);
            }
        }

        Response<T> response = new Response(clientResponse.getStatus(), entity);
        clientResponse.close();
        return response;
    }


    public Response deleteIssue(String issueKey, boolean deleteSubtasks) throws UniformInterfaceException {
        return new IssueJiraDao().delete(issueKey, Boolean.toString(deleteSubtasks));
    }*/

}
