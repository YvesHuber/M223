package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import ch.zli.m223.model.User;
import ch.zli.m223.service.AuthenticationService;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;



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
    public void testBuchungGetJWTAdmin() {
      
      User user = new User();
      user.setId(Long.parseLong("1"));
      user.setVorname("Yves");
      user.setNachname("Huber");
      user.setPasswort("123456");
      try {
      user.setEmail("Test@Admin.test");
      } catch (Exception e){

      }
      user.setRole("Admin");

      String token = AuthenticationService.returnkey(user);
        given()
        .header("Authorization", "Bearer "+token)
          .when().get("/Buchung")
          .then()
             .statusCode(200)
             .body(is("[]"));
    }

    @Test
    public void testBuchungGetJWTMitglied() {
      User user = new User();
      user.setId(Long.parseLong("2"));
      user.setVorname("Severin");
      user.setNachname("Machaz");
      user.setPasswort("123456");
      try {
      user.setEmail("Test@Mitglied.test");
      } catch (Exception e){

      }
      user.setRole("Mitglied");

      String token = AuthenticationService.returnkey(user);
      
        given()
        .header("Authorization", "Bearer "+token)
          .when().get("/Buchung")
          .then()
             .statusCode(200)
             .body(is("[]"));
    }


    @Test 
    public void testGetBuchungById(){
      given()
      .when().get("/Buchung/2")
      .then()
         .statusCode(401)
         .body(is(""));
    }

    @Test 
    public void testGetBuchungByIdJWT(){

      User user = new User();
      user.setId(Long.parseLong("1"));
      user.setVorname("Yves");
      user.setNachname("Huber");
      user.setPasswort("123456");
      try {
      user.setEmail("Test@Admin.test");
      } catch (Exception e){

      }
      user.setRole("Admin");
      String token = AuthenticationService.returnkey(user);
      given()
      .header("Authorization", "Bearer "+token)
      .when().get("/Buchung/2")
      .then()
         .statusCode(204)
         .body(is(""));
    }


}
