package api.body_counting;

import api.BaseApiTest;
import org.junit.jupiter.api.RepeatedTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class BodyCountingTest extends BaseApiTest {

    static int bodySizeCounter = 1;

    @RepeatedTest(120)
    public void countBody() {
        given()
                .when()
                .get(posts, bodySizeCounter)
                .then()
                .body("body.size()", greaterThanOrEqualTo(150));

        bodySizeCounter++;
    }
}
