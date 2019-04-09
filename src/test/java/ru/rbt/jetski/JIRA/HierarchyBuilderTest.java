package ru.rbt.jetski.JIRA;

import org.junit.Assert;
import org.junit.Test;
import ru.rbt.jetski.jira.model.Component;
import ru.rbt.jetski.jira.model.Epic;
import ru.rbt.jetski.jira.model.Project;
import ru.rbt.jetski.jira.model.Subtask;
import ru.rbt.jetski.newmodel.Worklog;
import ru.rbt.jetski.utils.ProjectUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by BritikovMI on 14.03.2019.
 */
public class HierarchyBuilderTest {
    public static void main(String[] args) {
        Subtask subtask = new Subtask();

        List<Subtask> subtaskList = subtask.initilizeSubtask();

        for (Subtask subtaskRow :
                subtaskList) {
            Epic currentEpic = subtaskRow.getParentEpic();
            Component currentComponent = currentEpic.getParentComponent();
            Project currentProject = currentComponent.getParentProject();

            System.out.printf("%10S\t", currentProject.getProjectWrapper().getName() + "\t");
        }
        System.out.println();
        for (Subtask subtaskRow :
                subtaskList) {
            Epic currentEpic = subtaskRow.getParentEpic();
            Component currentComponent = currentEpic.getParentComponent();

            System.out.printf("%10S\t\t", currentComponent.getComponentWrapper().getName());
        }
        System.out.println();
        for (Subtask subtaskRow :
                subtaskList) {
            Epic currentEpic = subtaskRow.getParentEpic();

            System.out.printf("%10S\t\t", currentEpic.getEpicKey());
        }
        System.out.println();
        for (Subtask subtaskRow :
                subtaskList) {
            System.out.printf("%10S\t\t", subtaskRow.getSubtaskKey());
        }


        System.exit(0);
    }

    @Test
    public void ptest(){
        List<ru.rbt.jetski.newmodel.Project> jiraProjectList = ProjectUtil.initilizeProject();
        Map<String, ru.rbt.jetski.newmodel.Project> jiraProjectsMap
                = jiraProjectList.stream()
                .collect(Collectors.toMap(ru.rbt.jetski.newmodel.Project::getName, jiraProject -> jiraProject));

        jiraProjectsMap.keySet().forEach(project-> {
            System.out.println(project + " " +  jiraProjectsMap.get(project));
        });
    }

    @Test
    public void buildHierarchy() {
        List<ru.rbt.jetski.newmodel.Project> projects = ProjectUtil.initilizeProject();

        for (ru.rbt.jetski.newmodel.Project project :
                projects) {
            String projectName = project.getName();

            Assert.assertNotNull(projectName);
            System.out.println("Project name: " + projectName);

            List<ru.rbt.jetski.newmodel.Component> components = project.getComponents();

            for (ru.rbt.jetski.newmodel.Component component :
                    components) {
                String componentName = component.getComponentName();

                Assert.assertNotNull(componentName);
                System.out.println("\tComponent name: " + componentName);

                List<ru.rbt.jetski.newmodel.Epic> epics = component.getEpics();

                for (ru.rbt.jetski.newmodel.Epic epic :
                        epics) {
                    String epicName = epic.getEpicName();

                    Assert.assertNotNull(epicName);
                    System.out.println("\t\tEpic name: " + epicName);

                    List<ru.rbt.jetski.newmodel.Subtask> subtasks = epic.getTasks();

                    for (ru.rbt.jetski.newmodel.Subtask subtask :
                            subtasks) {
                        String subtaskName = subtask.getName();

                        Assert.assertNotNull(subtaskName);
                        System.out.println("\t\t\tSubtask name: " + subtaskName);

                        List<Worklog> worklogList = subtask.getWorkLogs();

                        for (Worklog worklog :
                                worklogList) {
                            int worklogHrs = worklog.getFactWorkHours();
                            String worklogAutor = worklog.getExecutor().getName();

                            Assert.assertNotNull(worklogAutor);
                            System.out.println("\t\t\t\tWorklog autor: " + worklogAutor + " hrs: " + worklogHrs);

                        }
                    }
                }
            }
            System.out.println();
        }
    }
}