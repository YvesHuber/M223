package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.User;
import ch.zli.m223.service.UserService;


@Path("/User")
@Tag(name = "User", description = "Handling of Users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Alle Benutzer zurück", description = "Gibt eine Liste mit allen Benutzern in der Datenbank zurück")
    public List<User> index() {
        return userService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Erstellt einen neuen Benutzer", description = "Erstellt einen neuen Benutzer in der Datenbank und gibt diesen neuen Benutzer zurück.")
    public User create(User user) {
       return userService.createUser(user);
    }

    
    @Path("{id}")
    @DELETE
    @Operation(summary = "Löscht einen Benutzer", description = "Löscht einen Benutzer")
    public void delete(int id) {
        userService.delete(id);
        
    }

    @Path("{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updates a new entry.", description = "Updates a new entry and returns the newly added entry.")
    public User update(int id, User user) {
        return userService.update(id, user);
    }
    

}
