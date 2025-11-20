import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class RequestMethodsTest extends BaseTest {

    // 1. GET Request Test
    @Test
    public void testGetRequest() {
        ResponseModel response = executeGetRequest("/get?test=123");

        // Проверка кода ответа
        assertEquals(given().when().get("/get?test=123").getStatusCode(), 200);

        // Проверка тела ответа
        assertNotNull(response.getArgs());
        assertEquals(response.getArgs().getTest(), "123");
        assertNotNull(response.getHeaders());
        assertEquals(response.getUrl(), BASE_URL + "/get?test=123");
        assertNotNull(response.getData());
    }

    // 2. POST Request with Raw Text
    @Test
    public void testPostRawText() {
        String rawText = "This is expected to be sent back as Response Body.";

        ResponseModel response = executePostRequest("/post", rawText);

        // Проверка кода ответа
        assertEquals(given()
                .body(rawText)
                .when()
                .post("/post")
                .getStatusCode(), 200);

        // Проверка тела ответа
        assertEquals(response.getData(), rawText);
        assertEquals(response.getUrl(), BASE_URL + "/post");
        assertNotNull(response.getHeaders());
    }

    // 3. POST Request with Form Data
    @Test
    public void testPostFormData() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("foo1", "bar1");
        formParams.put("foo2", "bar2");

        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParams(formParams)
                .when()
                .post("/post")
                .then()
                .extract()
                .response();

        // Проверка кода ответа
        assertEquals(response.getStatusCode(), 200);

        // Проверка тела ответа с использованием RestAssured matchers
        response.then()
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("url", equalTo(BASE_URL + "/post"))
                .body("headers", notNullValue());
    }

    // 4. PUT Request
    @Test
    public void testPutRequest() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("foo1", "bar1");
        requestBody.put("foo2", "bar2");

        ResponseModel response = executePutRequest("/put", requestBody);

        // Проверка кода ответа
        assertEquals(given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/put")
                .getStatusCode(), 200);

        // Проверка тела ответа
        assertEquals(response.getUrl(), BASE_URL + "/put");
        assertNotNull(response.getJson());

        // Проверяем что данные вернулись
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }

    // 5. PATCH Request
    @Test
    public void testPatchRequest() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("foo1", "bar1");
        requestBody.put("foo2", "bar2");

        ResponseModel response = executePatchRequest("/patch", requestBody);

        // Проверка кода ответа
        assertEquals(given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/patch")
                .getStatusCode(), 200);

        // Проверка тела ответа
        assertEquals(response.getUrl(), BASE_URL + "/patch");
        assertNotNull(response.getJson());

        // Проверяем отправленные данные
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }

    // 6. DELETE Request
    @Test
    public void testDeleteRequest() {
        ResponseModel response = executeDeleteRequest("/delete");

        // Проверка кода ответа
        assertEquals(given().when().delete("/delete").getStatusCode(), 200);

        // Проверка тела ответа
        assertEquals(response.getUrl(), BASE_URL + "/delete");
        assertNotNull(response.getHeaders());
        assertNotNull(response.getArgs());
        assertEquals(response.getData(), "");
    }
}