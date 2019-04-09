/**
 * 
 */
package ru.rbt.jetski.utils;

import com.atlassian.jira.rest.client.domain.BasicComponent;
import ru.rbt.jetski.jira.dao.ComponentJiraDao;
import ru.rbt.jetski.newmodel.Component;
import ru.rbt.jetski.newmodel.Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author sotnik
 *
 */
public class ComponentUtil {

	public static List<Component> initilizeComponent(Project currentProject) {
//        Component rootComponent = new Component();
//         = null;
        ComponentJiraDao component = new ComponentJiraDao();
//        String currentComponentId;
        List<Component> innerComponentList = new ArrayList<>();

//        Project project = new Project();

        
        Iterator<BasicComponent> componentList = component.getComponents(currentProject.getJiraId());

            while (componentList.hasNext()) {
            	BasicComponent currentComponent = componentList.next();
            	Component rootComponent = new Component();
                rootComponent.setJiraId(Long.toString(currentComponent.getId()));
                rootComponent.setComponentName(currentComponent.getName());
                rootComponent.setParentProjectName(currentProject.getName());
//                rootComponent.setComponentWrapper(currentComponent);
//                rootComponent.setParentProjectKey(currentProject.getKey());
//                rootComponent.setParentProject(currentProject);
//                rootComponent.setLevel(1);
                rootComponent.setEpics(EpicUtil.initilizeEpic(rootComponent));
                innerComponentList.add(rootComponent);
            }

//        rootComponent.componentsList().addAll(innerComponentList);

        return innerComponentList; //rootComponent.componentsList();
    }
	
}
