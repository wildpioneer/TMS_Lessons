package tests.api;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientTest {

    /**
     * Данный класс предоставляет пример отрпавки простейшего запроса
     * на сайт reqres.in с использованием HttpClient-а
     */

    @Test
    public void simpleGetApiTest() throws IOException {
        String restURL = "https://reqres.in";

        // Create Object and pass the url
        HttpUriRequest request = new HttpGet(restURL);

        // send the request
        HttpResponse httpResponse = HttpClientBuilder
                .create()
                .build()
                .execute(request);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
}
