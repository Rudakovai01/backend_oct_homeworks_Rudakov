package HW_4;

import java.io.*;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.restassured.*;
public class BaseTest {
    abstract class BaseTest {
        static ResponseSpecification positiveResponseSpecification;
        static RequestSpecification requestSpecificationWithAuth;

        static Properties properties = new Properties();
        static String token;
        static String username;

        @BeforeAll
        @
        @ -17,9+28,24@@

        static void beforeAll() {

            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
            RestAssured.filters(new AllureRestAssured());
            RestAssured.baseURI = "https://api.imgur.com/3";
            getProperties();
            token = properties.getProperty("81ed217eee6d991be324edc8754a07e4ce686bb9");
            token = properties.getProperty("token");
            username = properties.getProperty("username");

            positiveResponseSpecification = new ResponseSpecBuilder()
                    .expectBody("status", equalTo(200))
                    .expectBody("success", is(true))
//          .expectResponseTime(lessThanOrEqualTo(500L))
                    .expectContentType(ContentType.JSON)
                    .expectStatusCode(200)
                    .build();

            requestSpecificationWithAuth = new RequestSpecBuilder()
                    .addHeader("Authorization", token)
                    .build();

            RestAssured.responseSpecification = positiveResponseSpecification;
        }
        private static void getProperties() {
            try (InputStream output = new FileInputStream("src/test/resources/application.properties")) {

            }
        }
}
