package tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in"; // Замените на ваш URL
    }

    @Test
    public void testResponseSchema() {
        int userID = 2;
        String endpoint = "/api/users/" + userID;

        given()
                .when()
                .get("endpoint") // Замените на ваш эндпоинт
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("response-schema.json")); // Замените на путь к JSON Schema файлу
    }
}
