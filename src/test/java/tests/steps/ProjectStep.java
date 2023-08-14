package tests.steps;

import org.openqa.selenium.WebDriver;
import tests.baseEntities.BaseStep;
import tests.models.Project;

public class ProjectStep extends BaseStep {
    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    public void AddProject(Project project) {
        addProjectPage.openPageByUrl();

        addProjectPage.getNameInput().sendKeys(project.getProjectName());
        addProjectPage.getAnnouncementTextArea().sendKeys(project.getAnnouncement());

        if (project.isFlag()) {
            addProjectPage.getShowAnnouncementCheckBox().set();
        } else {
            addProjectPage.getShowAnnouncementCheckBox().remove();
        }

        addProjectPage.getTypeRadioButton().selectByIndex(project.getProjectType());
    }
}
