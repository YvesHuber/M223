package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import ch.zli.m223.model.User;
import ch.zli.m223.service.UserService;

@Path("/User")
@Tag(name = "User", description = "Handling of Users")
public class UserController {

    @Inject
    JsonWebToken jwt;
    @Inject
    UserService userService;

    @GET
    @RolesAllowed({ "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Alle Benutzer zurück", description = "Gibt eine Liste mit allen Benutzern in der Datenbank zurück")
    public List<User> index() throws Exception {
        try {
            return userService.findAll();

        } catch (Exception e) {
            throw e;
        }
    }

    @Path("{id}")
    @GET
    @RolesAllowed({ "Mitglied", "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Einen Benutzer zurück", description = "Gibt eine Liste mit einem Benutzern in der Datenbank zurück")
    public User getById(long id) throws Exception {
        try {
            return userService.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Erstellt einen neuen Benutzer", description = "Erstellt einen neuen Benutzer in der Datenbank und gibt diesen neuen Benutzer zurück.")
    public User create(User user) throws Exception {
        try {
            return userService.createUser(user);
        } catch (Exception e) {
            throw e;
        }
    }

    @Path("{id}")
    @DELETE
    @RolesAllowed({ "Admin" })
    @Operation(summary = "Löscht einen Benutzer", description = "Löscht einen Benutzer")
    public void delete(int id) throws Exception {
        try {
            userService.delete(id);
        } catch (Exception e) {
            throw e;
        }

    }

    @Path("{id}")
    @PUT
    @RolesAllowed({ "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updated einen Benutzer", description = "Updated einen Benutzer in der Datenbank und gibt diesen gleich zurück")
    public User update(int id, User user) throws Exception {
        try {
            return userService.update(id, user);
        } catch (Exception e) {
            throw e;
        }
    }

}
