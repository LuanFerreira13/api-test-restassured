import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetAuthProducts {

    String bearerToken1 = "1";

    @Test
    public void invalidTokenTest() {
        given().
            contentType(ContentType.JSON).
                header("Authorization" , "Bearer" + bearerToken1 ).
        when().
            get("https://dummyjson.com/auth/products").
        then().
            statusCode(401)
                .body(notNullValue())
                .body("message", is("Invalid/Expired Token!"));
    }

    @Test
    public void getListProductsWithTokenTest() {
        given().
            contentType(ContentType.JSON).
                header("Authorization" , "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3MzQ5MjU1MDgsImV4cCI6MTczNDkyOTEwOH0.kF1g8TJZxVKx-Qy8dNQymMkIOBJKeIraymU2OhraKac").
        when().
            get("https://dummyjson.com/auth/products").
        then().
            statusCode(200)
                .body("products" , notNullValue())
                .body("products[0].id", is(1))
                .body("products[0].title", is("Essence Mascara Lash Princess"))
                .body("products[0].category", is("beauty"))
                .body("total" , is(194))
                .body("limit" , is(30));
    }

    @Test
    public void tokenRequiredTest() {
       when().
            get("https://dummyjson.com/auth/products").
       then().
                statusCode(401)
               .body("message" , is("Access Token is required"));
    }
}
