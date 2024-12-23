import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PostProductsAdd {

    @Test
    public void addProductTest() {
        given().
            contentType(ContentType.JSON).
            body("{\n" + "    \"id\": 195,\n" +
                    "    \"title\": \"Perfume Oil\",\n" +
                    "    \"price\": 13,\n" +
                    "    \"stock\": 65,\n" +
                    "    \"rating\": 4.26,\n" +
                    "    \"thumbnail\": \"https://i.dummyjson.com/data/products/11/thumnail.jpg\",\n" +
                    "    \"description\": \"Mega Discount, Impression of A...\",\n" +
                    "    \"brand\": \"Impression of Acqua Di Gio\",\n" +
                    "    \"category\": \"fragrances\"\n" + "}").
        when().
            post("https://dummyjson.com/products/add").
        then().
            statusCode(201)
                .body(notNullValue())
                .body("id", is(195))
                .body("title", is("Perfume Oil"))
                .body("price", is(13));
    }
}
