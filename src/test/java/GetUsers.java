import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetUsers {

    @Test
    public void listUsersTest() {
        when().
            get("https://dummyjson.com/users").
        then().
            statusCode(200)
                .body("users", notNullValue())
                .body("users[0].id", is(1))
                .body("users[0].firstName", is("Emily"))
                .body("users[0].email", is("emily.johnson@x.dummyjson.com"))
                .body("users[1].id", is(2))
                .body("users[1].firstName", is("Michael"))
                .body("users[1].email", is("michael.williams@x.dummyjson.com"));
    }
}