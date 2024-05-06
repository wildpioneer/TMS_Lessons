package tests.api;

import baseEntity.BaseApiTest;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResponseTestRailTest extends BaseApiTest {
    int projectID;

    @Test
    public void getAllProjectsTest() {
        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void GetSingleValueTest() {
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

    @Test
    public void GetFullResponseTest() {
        String endpoint = "/index.php?/api/v2/update_project/{project_id}";

        ProjectBuilder projectUpd = ProjectBuilder.builder()
                .name("WP_Project_04_UPD")
                .announcement("Test!!!")
                .isCompleted(true)
                .build();

        Response response = given()
                .pathParam("project_id", projectID)
                .body(projectUpd, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().get("name"),
                projectUpd.getName());
    }
}
