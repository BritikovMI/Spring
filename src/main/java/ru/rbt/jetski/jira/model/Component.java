package ru.rbt.jetski.jira.model;

import com.atlassian.jira.rest.client.domain.BasicComponent;
import ru.rbt.jetski.jira.dao.ComponentJiraDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by BritikovMI on 14.03.2019.
 */
public class Component {
    private Long Id;
    private BasicComponent componentWrapper;
    private int Level;
    private String parentProjectKey;
    private Project parentProject;

    protected Component component;
    protected List<Component> components;

    public List<Component> componentsList() {
        if (components == null) {
            components = new ArrayList<>();
        }
        return this.components;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public BasicComponent getComponentWrapper() {
        return componentWrapper;
    }

    public void setComponentWrapper(com.atlassian.jira.rest.client.domain.BasicComponent componentWrapper) {
        this.componentWrapper = componentWrapper;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getParentProjectKey() {
        return parentProjectKey;
    }

    public void setParentProjectKey(String parentProjectKey) {
        this.parentProjectKey = parentProjectKey;
    }

    public Project getParentProject() {
        return parentProject;
    }

    public void setParentProject(Project parentProject) {
        this.parentProject = parentProject;
    }

    public List<Component> initilizeComponent() {
        Component rootComponent = new Component();
        BasicComponent currentComponent = null;
        ComponentJiraDao component = new ComponentJiraDao();
        String currentComponentId;
        List<Component> innerComponentList = new ArrayList<>();

        Project project = new Project();

        List<Project> projectList = project.initilizeProject();
        Iterator<BasicComponent> componentList;

        for (Project currentProject :
                projectList) {
            componentList = component.getComponents(currentProject.getKey());

            while (componentList.hasNext()) {
                currentComponent = componentList.next();
                rootComponent = new Component();
                rootComponent.setId(currentComponent.getId());
                rootComponent.setComponentWrapper(currentComponent);
                rootComponent.setParentProjectKey(currentProject.getKey());
                rootComponent.setParentProject(currentProject);
                rootComponent.setLevel(1);

                innerComponentList.add(rootComponent);
            }

        }
        rootComponent.componentsList().addAll(innerComponentList);

        return rootComponent.componentsList();
    }

    public static void main(String[] args) {
        Component cmp = new Component();

        List<Component> cmpList = cmp.initilizeComponent();

        cmpList.forEach(t -> System.out.println(t.getId() + " " + t.getParentProject().getKey()));

        System.exit(0);
    }
}
