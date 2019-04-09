package ru.rbt.jetski;

/*import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;*/

public class UnirestRequest {

    /*public JSONObject doUniPost(String uri, *//*ObjectNode*//* String payload, String encoded)  {
        HttpResponse<JsonNode> response = null;
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
