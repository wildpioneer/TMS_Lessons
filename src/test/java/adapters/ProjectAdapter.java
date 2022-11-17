package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter {

    public ProjectBuilder add(ProjectBuilder projectBuilder) {
        return given()
                .body(projectBuilder, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(ProjectBuilder.class, ObjectMapperType.GSON);
    }

    public ProjectBuilder[] getAllProjects() {
        Response response = given()
                .get(Endpoints.GET_ALL_PROJECTS);

        //response.then().log().body();
        String projects = response.getBody().jsonPath().get("projects").toString();

        System.out.println(projects);

        return gson.fromJson(response.getBody().jsonPath().get("projects").toString(), ProjectBuilder[].class);
    }
}
