import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.notNullValue;


public class PostAuthLogin {

    @Test
    public void authLoginTest() {
        given().
                contentType(ContentType.JSON).
                body("{\"username\": \"emilys\", \"password\": \"emilyspass\"}").
        when().
            post("https://dummyjson.com/auth/login").
        then().
            statusCode(200)
                .body(notNullValue())
                .body("id", is(1))
                .body("email", is("emily.johnson@x.dummyjson.com"))
                .body("firstName", is("Emily"))
                .body("accessToken", notNullValue());
    }
}
