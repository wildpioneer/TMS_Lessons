package tests;

import baseEntity.BaseTest;
import models.Milestone;
import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.MilestoneSteps;
import steps.ProjectSteps;

public class MilestoneTests extends BaseTest {

    @Test
    public void test1() {
        Project project = new Project();
        User user = new User();
        Milestone milestone = new Milestone();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);

        projectSteps.addProject(project);
        milestoneSteps.createMilestone(project, milestone);


    }
}
