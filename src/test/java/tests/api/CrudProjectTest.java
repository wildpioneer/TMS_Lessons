package tests.api;

import baseEntity.BaseApiTest;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CrudProjectTest extends BaseApiTest {
    int projectID;


    @Test
    public void addProjectTest() {
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("WP_Project_04")
                .typeOfProject(ProjectType.SINGLE_SUITE_BASELINES)
                .build();

        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

        System.out.println(projectID);
    }

    @Test(dependsOnMethods = "updateProject")
    public void deleteProject() {
        String endpoint = "index.php?/api/v2/delete_project/{project_id}";

        given()
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
