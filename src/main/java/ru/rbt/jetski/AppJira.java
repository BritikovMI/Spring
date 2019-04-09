package ru.rbt.jetski;

import com.atlassian.jira.rest.client.domain.BasicIssue;
import ru.rbt.jetski.jira.ProjectClient;
import ru.rbt.jetski.security.AuthWrapper;
import ru.rbt.jetski.security.BritikovMIWrapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Hello world!
 * KryukovMV@rbtechnologies.ru:ffYhrLkRjGCNFmwBXs3SC81E
 * <p>
 * Created by misha on 14.08.2018.
 */
public class AppJira {

    private static final Logger logger = Logger.getLogger(AppJira.class.getName());
    private AuthWrapper auth = new BritikovMIWrapper();

    public static void main(String[] args) {
        System.out.println("Searching issues");
        AppJira app = new AppJira();
        app.issue();
        System.out.println("Done!");
    }

    private void project() {
        ProjectClient client = new ProjectClient();
        List<LinkedHashMap> list = client.list(null, null);
    }

    private void issue() {
        ProjectClient client = new ProjectClient();
        List<BasicIssue> list = client.list(null, null);
        for (BasicIssue basicIssue : list) {
            System.out.println("basicIssue.getKey() = " + basicIssue.getKey());
        }
    }

    private void issues() {
//        Response response = request("https://rbtechnologies.atlassian.net/rest/api/2/search?jql=project=VJGH&maxResults=100");
//        if (response == null) return;
//        LinkedHashMap res = response.readEntity(LinkedHashMap.class);
//        List<LinkedHashMap> list = (List<LinkedHashMap>) res.get("issues");
//        Object fields;
//        String summary;
//        LinkedHashMap fieldsMap;
//        for (LinkedHashMap map : list) {
//            fields = map.get("fields");
//            if (fields instanceof LinkedHashMap) {
//                fieldsMap = (LinkedHashMap) fields;
//                summary = (String) fieldsMap.get("summary");
//            } else {
//                summary = "";
//            }
//            System.out.println(map.get("key").toString() + " - " + summary);
//        }
    }
}
