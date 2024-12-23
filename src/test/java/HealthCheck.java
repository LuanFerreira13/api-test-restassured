import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class HealthCheck {
    @Test
    public void healthCheckTest() {
        when().
            get("https://dummyjson.com/test").
        then().
            statusCode(200);
    }
}
