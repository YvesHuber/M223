package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import io.smallrye.jwt.build.Jwt;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.Security.GenerateToken;
import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.service.EntryService;

@Path("/key")
@Tag(name = "Entries", description = "Handling of entries")
public class JWTController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public String index(ApplicationUser login) {
        System.out.println(login.username);
        if (login.username.equals("YvesHuber") && login.password.equals("123456")){
        String token = GenerateToken.returnkey(login.email, login.birthday);
        return token;
        }
        else {
            return "No a correct User";
        }
    }
    

}
