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
public class UserResourceTest {
    
    @Test
    public void testUserGet() {
        given()
          .when().get("/User")
          .then()
             .statusCode(401)
             .body(is(""));
    }

    @Test
    public void testUserPost() {

        User user = new User();
        try {
            user.setEmail("Yves.Huber@Gmail.com");
        } catch(Exception e){
            
        }
        user.setNachname("Huber");
        user.setVorname("Yves");
        user.setPasswort("Secure Password");
        user.setRole("Admin");

        given()
          .body(user)
          .contentType(ContentType.JSON)
          .when().post("/User")
          .then()
             .statusCode(200);

}
}
