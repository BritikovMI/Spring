/**
 * 
 */
package ru.rbt.jetski.utils;

import ru.rbt.jetski.jira.dao.ProjectJiraDao;
import ru.rbt.jetski.newmodel.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sotnik
 *
 */
public class ProjectUtil {

	public static List<Project> initilizeProject() {
//        Project rootProject = new Project();
        ProjectJiraDao project = new ProjectJiraDao();
        String currentProjectKey;

        List<com.atlassian.jira.rest.client.domain.Project> projects = project.list();
        List<Project> projectWrapperMap = new ArrayList<>();

        for (com.atlassian.jira.rest.client.domain.Project currentProject :
                projects) {
            Project prj = new Project();
            currentProjectKey = currentProject.getKey();

            prj.setJiraId(currentProjectKey);
            prj.setName(currentProject.getName());
//            rootProject.setProjectWrapper(currentProject);
//            rootProject.setLevel(0);

            prj.setComponents(ComponentUtil.initilizeComponent(prj));
            
            projectWrapperMap.add(prj);
        }
//        rootProject.projectsList().addAll(projectWrapperMap);
        return projectWrapperMap;//rootProject.projectsList();
    }
	
}
