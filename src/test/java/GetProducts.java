import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetProducts {

    @Test
    public void listProductsTest() {
        when().
            get("https://dummyjson.com/products").
        then().
            statusCode(200)
                .body("products", notNullValue())
                .body("products[0].id", is(1))
                .body("products[0].title", is("Essence Mascara Lash Princess"))
                .body("products[0].category", is("beauty"))

                .body("products[3].id", is(4))
                .body("products[3].title", is("Red Lipstick"))
                .body("products[3].category", is("beauty"));
    }

    @Test
    public void getProductsIdTest() {
        when().
            get("https://dummyjson.com/products/1").
        then().
            statusCode(200)
                .body("id", is(1))
                .body("title", is("Essence Mascara Lash Princess"))
                .body("category", is("beauty"));
    }

    @Test
    public void getProductsId0Test() {
        when().
            get("https://dummyjson.com/products/0").
        then().
            statusCode(404)
            .body("message", is("Product with id '0' not found"));
    }
}
