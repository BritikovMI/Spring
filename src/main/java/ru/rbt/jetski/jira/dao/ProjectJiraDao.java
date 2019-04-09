package ru.rbt.jetski.jira.dao;

import com.atlassian.jira.bc.project.ProjectCreationData;
import com.atlassian.jira.bc.project.ProjectService;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.ProjectRestClient;
import com.atlassian.jira.rest.client.domain.*;
import com.atlassian.jira.user.ApplicationUser;
import ru.rbt.jetski.jira.JiraAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectJiraDao {

    private ProjectRestClient client;

    public ProjectJiraDao() {
        JiraRestClient jiraRestClient = JiraAccess.getClient();
        client = jiraRestClient.getProjectClient();
    }

    public Project get(String key) {
        Project project = client.getProject(key).claim();
        return project;
    }

    public List<Project> list() {
        List<Project> list = new ArrayList<>();
        client.getAllProjects().claim().forEach(basic -> list.add(client.getProject(basic.getKey()).claim()));
        return list;
    }

    public Map<String, String> map() {
        Map<String, String> map = new HashMap<>();
        client.getAllProjects().claim().forEach(basic -> map.put(client.getProject(basic.getKey()).claim().getName(), client.getProject(basic.getKey()).claim().getKey()));
        return map;
    }

    public List<BasicProject> basic() {
        List<BasicProject> list = new ArrayList<>();
        client.getAllProjects().claim().forEach(basic -> list.add(basic));
        return list;
    }

public void get(){
    Project p  = client.getProject("FRSE").claim();

}

    public com.atlassian.jira.project.Project create(String name, String key, BasicUser user) {
        ProjectService projectService = ComponentAccessor.getComponent(ProjectService.class);
        ApplicationUser applicationUser = ComponentAccessor.getUserManager().getUserByName(user.getDisplayName());
        ProjectCreationData.Builder projectBuilder = new ProjectCreationData.Builder();
        ProjectCreationData projectCreationData = projectBuilder
                .withKey(key)
                .withName(name)
                .withLead(applicationUser)
//                .withAssigneeType(jiraProject.getAssigneeType())
//                .withDescription(jiraProject.getDescription())
//                .withType(jiraProject.getProjectType())
                .build();
        ProjectService.CreateProjectValidationResult validatedProject =
                projectService.validateCreateProject(applicationUser, projectCreationData);
        com.atlassian.jira.project.Project project = projectService.createProject(validatedProject);
        return project;
    }

}
