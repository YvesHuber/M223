/*package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.vertx.core.json.JsonObject;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Entry;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;

import org.h2.util.json.JSONObject;

@QuarkusTest
public class EntryResourceTest {

    @Test
    public void testIndexEndpoint() {
        given()
          .when().get("/entries")
          .then()
             .statusCode(200)
             .body(is("[]"));
    }
    @Test
    public void testDeleteEndpoint() {
        given()
          .pathParam("id", 2)
          .when().get("/entries/{id}")
          .then()
            .statusCode(200)
            .body(is("[]"));
    }

    @Test
    public void testPutEndpoint() {
        Entry entry = new Entry();
        entry.setCheckIn(LocalDateTime.now());
        entry.setCheckOut(LocalDateTime.now());
        entry.setId((long)2);
        given()
        .body(entry)
        .contentType(ContentType.JSON)
          .pathParam("id", 2)
          .when().put("/entries/{id}")
          .then()
            .statusCode(200)
            .body(is("{\"id\":2,\"checkIn\":\""+entry.getCheckIn().toString()+"\",\"checkOut\":\""+entry.getCheckOut().toString()+"\"}"));
    }

}*/