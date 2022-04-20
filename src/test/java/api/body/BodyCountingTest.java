package api.body;

import api.BaseApiTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class BodyCountingTest extends BaseApiTest {

    static int bodySizeCounter = 1;

    @RepeatedTest(120)
    public void countBody() {
       String body =  given()
                .when()
                .get(posts, bodySizeCounter)
                .then()
                .extract()
                .path("body");

        bodySizeCounter++;

            Assertions.assertThat(body.length())
                    .as("body size id equal " + body.length())
                    .isGreaterThan(150);
    }
}
