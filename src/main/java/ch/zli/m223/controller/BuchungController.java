package ch.zli.m223.controller;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import ch.zli.m223.model.Buchung;
import ch.zli.m223.model.User;
import ch.zli.m223.service.BuchungService;


@Path("/Buchung")
@Tag(name = "Buchung", description = "Handling of Buchungen")
public class BuchungController {

    @Inject
    JsonWebToken jwt;
    BuchungService buchungService;

    @GET
    @RolesAllowed({"Mitglied", "Admin"}) 
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Alle Benutzer zurück", description = "Gibt eine Liste mit allen Benutzern in der Datenbank zurück")
    public List<Buchung> index() {
        User user = jwt.getClaim("User");
        if (user.getRole().equals("Admin")){
            return buchungService.findAll();
        }
        else {
            return buchungService.findAllOfUser(user);
        }
        
    }

    @Path("{id}")
    @GET
    @RolesAllowed({"Admin"}) 
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Alle Benutzer zurück", description = "Gibt eine Liste mit allen Benutzern in der Datenbank zurück")
    public Buchung getById(long id) {
        return buchungService.findById(id);
    }

    @Path("/Public")
    @GET
    @RolesAllowed({"Mitglied","Admin"}) 
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Alle Benutzer zurück", description = "Gibt eine Liste mit allen Benutzern in der Datenbank zurück")
    public List<Buchung> indexpublic() {
        return buchungService.findAllPublic();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Erstellt einen neuen Benutzer", description = "Erstellt einen neuen Benutzer in der Datenbank und gibt diesen neuen Benutzer zurück.")
    public Buchung create(Buchung Buchung) {
       return buchungService.create(Buchung);
    }

    
    @Path("{id}")
    @DELETE
    @RolesAllowed({"Admin"}) 
    @Operation(summary = "Löscht einen Benutzer", description = "Löscht einen Benutzer")
    public void delete(int id) {
        buchungService.delete(id);
        
    }

    @Path("{id}")
    @PUT
    @RolesAllowed({"Admin"}) 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updated einen Benutzer", description = "Updated einen Benutzer in der Datenbank und gibt diesen gleich zurück")
    public Buchung update(int id, Buchung Buchung) {
        return buchungService.update(id, Buchung);
    }
    

}
