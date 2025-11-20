import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SimpleTest {

    @Test
    public void simpleGetTest() {
        given()
                .when()
                .get("https://postman-echo.com/get?test=123")
                .then()
                .statusCode(200)
                .body("args.test", equalTo("123"))
                .body("url", equalTo("https://postman-echo.com/get?test=123"));
    }
}