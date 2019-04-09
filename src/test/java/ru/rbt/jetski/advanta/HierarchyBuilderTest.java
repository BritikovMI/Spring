package ru.rbt.jetski.advanta;

import org.junit.Test;
import ru.rbt.jetski.advanta.model.Project;

import java.util.List;

/**
 * Created by BritikovMI on 20.03.2019.
 */
public class HierarchyBuilderTest {
    @Test
    public void buildHierarchy() {
        Project project = new Project();

        List<Project> projects = project.buildAdvantaProjectHierarchy("4826bdc1-41c1-4f94-b15b-096236618adc");

        for (Project project1:
             projects) {
//            if(project1.getLevel() == 4)
            System.out.println(project1.getName() + " " + project1.getLevel() + " " + project1.getParentProjectId());
        }
    }
}
