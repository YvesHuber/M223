package ch.zli.m223.controller;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Login;
import ch.zli.m223.model.User;
import ch.zli.m223.service.LoginService;
import ch.zli.m223.service.UserService;

@Path("/Login")
@Tag(name = "Login", description = "Handling of Login")
public class LoginController {

    @Inject
    LoginService loginService;

    @Inject
    UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Alle Benutzer zurück", description = "Gibt eine Liste mit allen Benutzern in der Datenbank zurück")
    public String login(Login login) {

        var query = userService.findAll();
        var token = "Unsuccessful Login";
        for (User user2 : query) {
            String useremail = user2.getEmail();
            String userpassword = user2.getPasswort();

            if(useremail.equals(login.getEmail()) && userpassword.equals(login.getPasswort())){
                token = loginService.login(user2);
                System.out.println(loginService.login(user2));
            }
        }

        return token;

    }
}
