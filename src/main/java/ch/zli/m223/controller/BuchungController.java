package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import ch.zli.m223.model.Buchung;
import ch.zli.m223.service.BuchungService;

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
    @Operation(summary = "Gibt Alle Buchungen zurück", description = "Gibt alle buchugen zurück bei einem Admin und alle vom User bei einem Mitglied")
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
    @Operation(summary = "Gibt eine Buchung zurück mit der id ", description = "Gibt eine Buchung zurück mit der id ")
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
    @Operation(summary = "Erstellt eine Buchung", description = "Erstellt eine Buchung")
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
    @Operation(summary = "Löscht eine Buchung", description = "Löscht eine Buchung")
    public void delete(int id) throws Exception {
        try {
            buchungService.delete(id);
        } catch (Exception e) {
            throw e;
        }

    }

    @Path("{id}")
    @PUT
    @RolesAllowed({ "Mitglied", "Admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updated eine Buchung", description = "Updated eine Buchen in der Datenbank und gibt diese gleich zurück")
    public Response update(int id, Buchung Buchung) throws Exception {
        try {
            return buchungService.update(id, Buchung);
        } catch (Exception e) {
            throw e;
        }
    }

}
