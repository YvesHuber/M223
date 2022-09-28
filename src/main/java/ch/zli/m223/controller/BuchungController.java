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
import ch.zli.m223.service.UserService;

@Path("/Buchung")
@Tag(name = "Buchung", description = "Handling of Buchungen")
public class BuchungController {

    @Inject
    BuchungService buchungService;

    @Inject
    JsonWebToken jwt;

    @GET
    @RolesAllowed({ "Mitglied", "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Alle Benutzer zurück", description = "Gibt eine Liste mit allen Benutzern in der Datenbank zurück")
    public List<Buchung> index() throws Exception {
        try {
            var userid = jwt.getName();
            var groups = jwt.getGroups();
            if (groups.iterator().next().equals("Admin")) {
                return buchungService.findAll();
            } else {
                return buchungService.findAllOfUser(userid);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    @Path("{id}")
    @GET
    @RolesAllowed({ "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Alle Benutzer zurück", description = "Gibt eine Liste mit allen Benutzern in der Datenbank zurück")
    public Buchung getById(long id) throws Exception {
        try {
            return buchungService.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Path("/Public")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gibt Alle Benutzer zurück", description = "Gibt eine Liste mit allen Benutzern in der Datenbank zurück")
    public List<Buchung> indexpublic() throws Exception {
        try {
            return buchungService.findAllPublic();
        } catch (Exception e) {
            throw e;
        }
    }

    @POST
    @RolesAllowed({ "Mitglied", "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Erstellt einen neuen Benutzer", description = "Erstellt einen neuen Benutzer in der Datenbank und gibt diesen neuen Benutzer zurück.")
    public Buchung create(Buchung Buchung) throws Exception {
        try {
            return buchungService.create(Buchung);
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
            buchungService.delete(id);
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
    public Buchung update(int id, Buchung Buchung) throws Exception {
        try {
            return buchungService.update(id, Buchung);
        } catch (Exception e) {
            throw e;
        }
    }

}
