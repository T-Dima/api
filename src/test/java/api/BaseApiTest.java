package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest extends BaseApi{

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = BaseLink;
    }

}
