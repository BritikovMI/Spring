package ru.rbt.jetski.jira;

import com.google.gson.JsonObject;

/**
 * Created by BritikovMI on 01.04.2019.
 */
public class JsonTemplates {
    public JsonObject jiraProjectCreationData(String key, String name, String projectTypeKey, String userName){
        JsonObject projectCreationData = new JsonObject();
        projectCreationData.addProperty("key", key); //ProjectKey
        projectCreationData.addProperty("name", name); //Project name
        projectCreationData.addProperty("projectTypeKey", projectTypeKey); //e.g. -- "software" or "business"
        projectCreationData.addProperty("description", "Example Project description");
//        projectCreationData.addProperty("url", projectUrl);
        projectCreationData.addProperty("assigneeType", "PROJECT_LEAD");
        projectCreationData.addProperty("lead", userName);

        return projectCreationData;
    }
}
