package tests.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tests.models.Project;
import tests.models.User;
import utils.configuration.ReadProperties;

public class DataHelper {
    static Logger logger = LogManager.getLogger(DataHelper.class);

    public static User getAdminUser() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        logger.info(user.toString());
        return user;
    }

    public static Project getProject() {
        Project project = new Project();
        project.setProjectName("WP_Test_01");
        project.setAnnouncement("Test Announcement");
        project.setFlag(true);
        project.setProjectType(2);

        return project;
    }
}
