import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

    public class BaseTest {

        protected static final String BASE_URL = "https://postman-echo.com";

        @BeforeClass
        public void setUp() {
            RestAssured.baseURI = BASE_URL;
        }

        protected ResponseModel executeGetRequest(String path) {
            Response response = given()
                    .when()
                    .get(path)
                    .then()
                    .extract()
                    .response();

            return response.as(ResponseModel.class);
        }

        protected ResponseModel executePostRequest(String path, Object body) {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(body)
                    .when()
                    .post(path)
                    .then()
                    .extract()
                    .response();

            return response.as(ResponseModel.class);
        }

        protected ResponseModel executePutRequest(String path, Object body) {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(body)
                    .when()
                    .put(path)
                    .then()
                    .extract()
                    .response();

            return response.as(ResponseModel.class);
        }

        protected ResponseModel executePatchRequest(String path, Object body) {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(body)
                    .when()
                    .patch(path)
                    .then()
                    .extract()
                    .response();

            return response.as(ResponseModel.class);
        }

        protected ResponseModel executeDeleteRequest(String path) {
            Response response = given()
                    .when()
                    .delete(path)
                    .then()
                    .extract()
                    .response();

            return response.as(ResponseModel.class);
        }
    }

