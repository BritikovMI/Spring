package ru.rbt.jetski;

/*import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;*/
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.jira.JiraConfiguration;

public class UniRequestTest {
    /*public static void main(String[] args) throws UnirestException {
        JiraConfiguration jiraCfg = JiraConfiguration.getInstance();
        UniRequestTest uni = new UniRequestTest();
        HTTPRequest httpRequest = new HTTPRequest();

        String uri = new String(), encoded = new String(), issueKey = "FRSE-46";
        try {
            uri = jiraCfg.getJiraUrl() + "/rest/api/3/issue/" + issueKey + "/worklog";
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        encoded = httpRequest.getHttpAuthentication();
        JsonNode payload = null;
        int workedMinutes = 60;
        uni.postTest(uri, encoded, workedMinutes);
    }

    public void postTest(String uri, String encoded, int workedMinutes) throws UnirestException {
        String jsonCode = "{\n" +
                "\t\"started\": \"2019-02-06T14:54:27.252+0000\",\n" +
                "\t\"timeSpent\": 60\n" +
                "}";
        HttpResponse<JsonNode> response = Unirest.post(uri)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic " + encoded)
                    .body(jsonCode)
                    .asJson();
        System.out.println(response.getBody().getObject());
    }

    public void testyTest() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/post")
                .header("accept", "application/json")
                .queryString("apiKey", "123")
                .field("parameter", "value")
                .field("foo", "bar")
                .asJson();

        System.out.println(jsonResponse.getBody().getObject().get("args"));
    }*/
}
