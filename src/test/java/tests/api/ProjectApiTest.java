package tests.api;

import baseEntity.BaseApiTest;
import enums.ProjectType;
import models.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectApiTest extends BaseApiTest {

    @Test
    public void addProjectTest() {
        ProjectBuilder project = ProjectBuilder.builder()
                .name("WP_Project_04")
                .typeOfProject(ProjectType.SINGLE_SUITE_BASELINES)
                .build();

        ProjectBuilder actualProject = projectAdapter.add(project);
        Assert.assertEquals(actualProject, project);
    }

    @Test
    public void getAllProjectsTest() {
        Assert.assertEquals(projectAdapter.getAllProjects().getProjects().length, 40);
    }
}
