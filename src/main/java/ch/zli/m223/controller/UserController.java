package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public Response getById(long id) {
        try {
            String userid = id + "";
            if(userid.equals(jwt.getName()) || jwt.getGroups().iterator().next().equals("Admin")){

            return Response.ok(userService.findById(id)).build();
            }
            return Response.ok("Not Valid User").build();

        } catch (Exception e) {
            System.out.println(e);
           return Response.status(Response.Status.BAD_REQUEST).build();
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
    @RolesAllowed({"Mitglied", "Admin" })
    @Operation(summary = "Löscht einen Benutzer", description = "Löscht einen Benutzer")
    public Response delete(int id) throws Exception {
        try {
            try {
                String userid = id + "";
                if(userid.equals(jwt.getName()) || jwt.getGroups().iterator().next().equals("Admin")){
    
                userService.delete(id);
                return Response.ok("Deleted User").build();
                }
                return Response.ok("Not Valid User").build();
    
            } catch (Exception e) {
                System.out.println(e);
               return Response.status(Response.Status.BAD_REQUEST).build();
            }
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
