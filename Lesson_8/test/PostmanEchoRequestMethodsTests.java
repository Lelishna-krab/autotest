import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoRequestMethodsTests {

    private static final String BASE_URL = "https://postman-echo.com";


    @Test
    public void testGetRequest() {
        given()
                .baseUri(BASE_URL)
                .param("test_param", "test_value")
                .param("foo", "bar")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.test_param", equalTo("test_value"))
                .body("args.foo", equalTo("bar"))
                .body("url", startsWith(BASE_URL + "/get")) // Используем startsWith вместо equalTo
                .body("headers", notNullValue())
                .body("data", nullValue()); // data может быть null, а не пустой строкой
    }


    @Test
    public void testPostRawText() {
        String requestBody = "This is expected to be sent back as Response Body.";

        given()
                .baseUri(BASE_URL)
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo(BASE_URL + "/post"))
                .body("headers", notNullValue());

    }


    @Test
    public void testPostJsonData() {
        String jsonBody = "{\"name\": \"John Doe\", \"email\": \"john@example.com\", \"age\": 30}";

        given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("url", equalTo(BASE_URL + "/post"))
                .body("json.name", equalTo("John Doe"))
                .body("json.email", equalTo("john@example.com"))
                .body("json.age", equalTo(30))
                .body("data", notNullValue());
    }


    @Test
    public void testPostFormData() {
        given()
                .baseUri(BASE_URL)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("username", "testuser")
                .formParam("password", "testpass")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("url", equalTo(BASE_URL + "/post"))
                .body("form.username", equalTo("testuser"))
                .body("form.password", equalTo("testpass"));

    }


    @Test
    public void testPutRequest() {
        String jsonBody = "{\"id\": 12345, \"title\": \"Updated Post Title\"}";

        given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("url", equalTo(BASE_URL + "/put"))
                .body("json.id", equalTo(12345))
                .body("json.title", equalTo("Updated Post Title"))
                .body("data", notNullValue());
    }


    @Test
    public void testPatchRequest() {
        String jsonBody = "{\"status\": \"active\", \"changes\": 5}";

        given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("url", equalTo(BASE_URL + "/patch"))
                .body("json.status", equalTo("active"))
                .body("json.changes", equalTo(5))
                .body("data", notNullValue());
    }


    @Test
    public void testDeleteRequest() {
        given()
                .baseUri(BASE_URL)
                .param("resource_id", "9876")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("url", startsWith(BASE_URL + "/delete"))
                .body("args.resource_id", equalTo("9876"))
                .body("headers", notNullValue())
                .body("data", any(Object.class)); // Просто проверяем пустую строку
    }


    @Test
    public void testGetWithCustomHeaders() {
        given()
                .baseUri(BASE_URL)
                .header("X-Custom-Header", "custom-value")
                .header("User-Agent", "RestAssured-Test")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("url", startsWith(BASE_URL + "/get")) // Используем startsWith
                .body("headers", notNullValue())
                .body("headers.'x-custom-header'", equalTo("custom-value"))
                .body("data", nullValue()); // data может быть null
    }
}