package ch.zli.m223.controller;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.User;
import ch.zli.m223.service.LoginService;

@Path("/Login")
@Tag(name = "Login", description = "Handling of Login")
public class LoginController {

    @Inject
    LoginService loginService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Alle Benutzer zurück", description = "Gibt eine Liste mit allen Benutzern in der Datenbank zurück")
    public String login(User user) {
        return loginService.login(user);

    }
    

}
