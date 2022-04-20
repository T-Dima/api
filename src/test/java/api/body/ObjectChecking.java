package api.body;

import api.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import utils.pojo.Article;

import static io.restassured.RestAssured.given;

public class ObjectChecking extends BaseApiTest {

    static int bodySizeObjectCounter = 1;

    @Tag("smoke")
    @Description("The test is verifying an Object")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("The test is verifying an Object")
    @TmsLink("TTTT-5401")
    @RepeatedTest(120)
    public void objectChecking() {
        given()
                .when()
                .get(posts, bodySizeObjectCounter)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(Article.class);

        bodySizeObjectCounter++;
    }
}
