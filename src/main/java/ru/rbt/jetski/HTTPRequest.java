package ru.rbt.jetski;

import com.atlassian.jira.rest.client.domain.User;
import com.google.gson.JsonObject;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.jira.JiraConfiguration;
import ru.rbt.jetski.jira.JsonTemplates;
import ru.rbt.jetski.jira.dao.UserJiraDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/*import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;*/

/**
 * Created by BritikovMI on 14.02.2019.
 */
public class HTTPRequest {
    public String getHttpAuthentication() {
        JiraConfiguration jiraConfiguration = JiraConfiguration.getInstance();
        String encoded;
        String username = null, password = null;
        try {
            username = jiraConfiguration.getJiraUser();
            password = jiraConfiguration.getJiraPassword();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        encoded = Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));

        return encoded;
    }

    public String doDelete(String url, String username, String password) {
        URL obj;
        HttpURLConnection connection;
        String encoded;
        BufferedReader in;
        StringBuffer response = new StringBuffer();
        try {
            obj = new URL(url);
            connection = (HttpURLConnection) obj.openConnection();

            encoded = Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + encoded);


            connection.setRequestMethod("DELETE");


            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            connection.disconnect();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    public static void main(String[] args) {
        HTTPRequest httpRequest = new HTTPRequest();
        JsonTemplates templates = new JsonTemplates();
        String encoded = httpRequest.getHttpAuthentication();
        String url = "https://rbtechnologies.atlassian.net/rest/api/2/project";
        String key = "NEWPROJ";
        String name = "New Dev Project";
        String projectTypeKey = "software";
        String projectUrl = "http://atlassian.com";

        UserJiraDao userJiraDao = new UserJiraDao();
        User user = userJiraDao.get("BritikovMI");

        String userName = user.getName();


        JsonObject projectCreationData = templates.jiraProjectCreationData(key, name, projectTypeKey, userName);


        httpRequest.doPostWithJson(projectCreationData, url, encoded);

    }


    public int doPostWithJson(JsonObject jsonQuery, String uri, String encoded) {
        URLConnection con = null;
        HttpURLConnection http = null;
        URL url = null;
        int status = 0;
        BufferedReader in = null;
        StringBuffer response = new StringBuffer();
        byte[] out = null;

        try {
            url = new URL(uri);
            con = url.openConnection();
            http = (HttpURLConnection) con;
            http.setRequestProperty("Authorization", "Basic " + encoded);
            http.setRequestMethod("POST"); // PUT is another valid option
        } catch (IOException e) {
            System.out.println(e);
        }

        http.setDoOutput(true);
        http.setDoInput(true);
        out = jsonQuery.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        out = jsonQuery.toString().getBytes(StandardCharsets.UTF_8);


        try {
            OutputStream os = http.getOutputStream();
            os.write(out);

            os.close();
            http.connect();

             status = http.getResponseCode();
        } catch (IOException e) {
            System.out.println(e);
        }

        return status;
    }

  /*  //HttpAsyncClient dependency conflict
    public static void main(String[] args) {
        //Preparing date
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+0000");
        String loggingDate = sdf.format(date);

        //Preparing workLogTime
        int workedMinutes = 60;

        //Preparing workLog in objectNode format
        WorklogJiraDao worklogJiraDao = new WorklogJiraDao();
//        ObjectNode
        String objNode = worklogJiraDao.makingWorklog(loggingDate, workedMinutes);

        JiraConfiguration jiraCfg = JiraConfiguration.getInstance();
        String issueKey = "FRSE-46", uri = null;
        try {
            uri = jiraCfg.getJiraUrl() + "/rest/api/3/issue/" + issueKey + "/worklog";
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        HTTPRequest httpRequest = new HTTPRequest();
        String encoded = httpRequest.getHttpAuthentication();

        UnirestRequest unirestRequest = new UnirestRequest();

        JSONObject pr = unirestRequest.doUniPost(uri, objNode, encoded);

        System.out.println(pr);
    }


    public JSONObject doHttpWorklogAdd(String uri, *//*ObjectNode*//* String payload, String encoded) {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
                    e.printStackTrace();
                }
                return null;

            }
        });

        // This code sample uses the  'Unirest' library:
        // http://unirest.io/java.html
        com.mashape.unirest.http.HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.post(uri)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic " + encoded)
                    .body(payload)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody().getObject();
    }*/
}
