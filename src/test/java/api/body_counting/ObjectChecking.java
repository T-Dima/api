package api.body_counting;

import api.BaseApiTest;
import org.junit.jupiter.api.RepeatedTest;
import utils.pojo.Article;

import static io.restassured.RestAssured.given;

public class ObjectChecking extends BaseApiTest {

    static int bodySizeObjectCounter = 1;

    @RepeatedTest(120)
    public void countBody1() {
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
