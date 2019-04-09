package ru.rbt.jetski.jira.model;

import ru.rbt.jetski.jira.dao.ProjectJiraDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BritikovMI on 14.03.2019.
 */
public class Project {
    private String Key;
    private com.atlassian.jira.rest.client.domain.Project projectWrapper;
    private int Level;

    protected Project project;
    protected List<Project> projects;

    public List<Project> projectsList() {
        if (projects == null) {
            projects = new ArrayList<>();
        }
        return this.projects;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public com.atlassian.jira.rest.client.domain.Project getProjectWrapper() {
        return projectWrapper;
    }

    public void setProjectWrapper(com.atlassian.jira.rest.client.domain.Project projectWrapper) {
        this.projectWrapper = projectWrapper;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }


    public List<Project> initilizeProject() {
        Project rootProject = new Project();
        ProjectJiraDao project = new ProjectJiraDao();
        String currentProjectKey;

        List<com.atlassian.jira.rest.client.domain.Project> projects = project.list();
        List<Project> projectWrapperMap = new ArrayList<>();

        for (com.atlassian.jira.rest.client.domain.Project currentProject :
                projects) {
            rootProject = new Project();
            currentProjectKey = currentProject.getKey();

            rootProject.setKey(currentProjectKey);
            rootProject.setProjectWrapper(currentProject);
            rootProject.setLevel(0);

            projectWrapperMap.add(rootProject);
        }
        rootProject.projectsList().addAll(projectWrapperMap);
        return rootProject.projectsList();
    }

    public static void main(String[] args) {
        Project project = new Project();

        List<Project> s = project.initilizeProject();

        project.projectsList().forEach(fw-> System.out.println(fw.getKey() + " " + fw.getProjectWrapper().getKey() + " " + fw.getLevel()));
        System.out.println("==========================================");
        s.forEach(fw-> System.out.println(fw.getKey() + " " + fw.getProjectWrapper().getKey() + " " + fw.getLevel()));
//        project.projectsList().forEach(fw -> System.out.println(fw.getKey() + " " + ((fw.getProjectWrapper().getName() != null) ? fw.getProjectWrapper().getName() :  null) ));

    }
}

/*        System.out.println(currentProject.getKey() + "\n" +
                currentProject.getName() + "\n" +
                currentProject.getIssueTypes() + "\n" +
                currentProject.getComponents() + "\n" +
                currentProject.getDescription() + "\n" +
                currentProject.getLead() + "\n" +
                currentProject.getProjectRoles() + "\n" +
                currentProject.getUri() + "\n" +
                currentProject.getVersions() + "\n" +
                currentProject.getSelf());*/