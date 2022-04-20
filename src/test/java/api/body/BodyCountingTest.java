package api.body;

import api.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class BodyCountingTest extends BaseApiTest {

    static int bodySizeCounter = 1;
    @Description("The test verifying length of body")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("The test verifying length of body")
    @TmsLink("TTTT-5406")
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
