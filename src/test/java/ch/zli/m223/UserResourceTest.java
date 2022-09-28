package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.User;
import ch.zli.m223.service.AuthenticationService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

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
    public void testUserGetJWT() {

        User user = new User();
        user.setId(Long.parseLong("1"));
        user.setVorname("Yves");
        user.setNachname("Huber");
        user.setPasswort("123456");
        try {
            user.setEmail("Test@Admin.test");
        } catch (Exception e) {

        }
        user.setRole("Admin");

        String token = AuthenticationService.returnkey(user);
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/User")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUserPost() {

        User user = new User();
        try {
            user.setEmail("Yves.Huber@Gmail.com");
        } catch (Exception e) {

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

    @Test
    public void testDelete() {

        given()
                .when().delete("/User/1")
                .then()
                .statusCode(401);

    }

    @Test
    public void testUpdate() {

        given()
                .when().put("/User/1")
                .then()
                .statusCode(401);

    }

    @Test
    public void testUpdateJWT() {

        User user = new User();
        user.setId(Long.parseLong("1"));
        user.setVorname("Yves");
        user.setNachname("Huber");
        user.setPasswort("123456");
        try {
            user.setEmail("Test@Admin.test");
        } catch (Exception e) {

        }
        user.setRole("Admin");

        String token = AuthenticationService.returnkey(user);

        given()
                .body(user)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when().put("/User/2")
                .then()
                .statusCode(200);
    }

}
