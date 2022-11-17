package baseEntity;

import adapters.ProjectAdapter;
import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import javax.naming.spi.ResolveResult;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected ProjectAdapter projectAdapter = new ProjectAdapter();

    @BeforeTest
    public void setupApiTest() {
        // Setup RestAssured
        RestAssured.baseURI = ReadProperties.getUrl();

        // Setup request Object
        RestAssured.requestSpecification = given()
            .header(HTTP.CONTENT_TYPE, ContentType.JSON)
            .auth().preemptive().basic(ReadProperties.getUsername(), ReadProperties.getPassword());
    }
}