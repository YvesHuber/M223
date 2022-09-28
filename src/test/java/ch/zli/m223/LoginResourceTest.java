package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Login;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class LoginResourceTest {
    
    @Test
    public void testLoginFail() {
        //Unsuccessful Login
        Login login = new Login();

        login.setEmail("test@Admin.test");
        login.setPasswort("123456");

        given()
        .body(login)
        .contentType(ContentType.JSON)
        .when().post("/Login")
          .then()
             .statusCode(200)
             .body(is("Unsuccessful Login"));
    }

    @Test
    public void testLoginSuccessAdmin() {
        //Successful Login
        Login login = new Login();

        login.setEmail("Test@Admin.test");
        login.setPasswort("123456");

        given()
        .body(login)
        .contentType(ContentType.JSON)
        .when().post("/Login")
          .then()
             .statusCode(200);
    }

    @Test
    public void testLoginSuccessMitglied() {
        //Successful Login
        Login login = new Login();

        login.setEmail("Test@Mitglied.test");
        login.setPasswort("123456");

        given()
        .body(login)
        .contentType(ContentType.JSON)
        .when().post("/Login")
          .then()
             .statusCode(200);
    }
}
