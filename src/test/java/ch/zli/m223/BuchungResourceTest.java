package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.vertx.core.json.JsonObject;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;

import org.h2.util.json.JSONObject;


@QuarkusTest
public class BuchungResourceTest {
    
    @Test
    public void testBuchungGet() {
        given()
          .when().get("/Buchung")
          .then()
             .statusCode(401)
             .body(is(""));
    }

    @Test
    public void testPublicBuchungGet() {

        given()
          .when().get("/Buchung/Public")
          .then()
             .statusCode(200)
             .body(is("[]"));

}
}
