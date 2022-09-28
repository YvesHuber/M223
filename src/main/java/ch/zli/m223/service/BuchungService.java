package ch.zli.m223.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;

import ch.zli.m223.model.Buchung;

@ApplicationScoped
public class BuchungService {
    @Inject
    private EntityManager entityManager;
    @Inject
    JsonWebToken jwt;

    @Transactional
    public Buchung create(Buchung buchung) throws Exception {
        try {
            entityManager.persist(buchung);
            return buchung;
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Buchung> findAll() throws Exception {
        try {
            var query = entityManager.createQuery("FROM Buchung", Buchung.class);
            return query.getResultList();
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Buchung> findAllOfUser(String userid) throws Exception {
        try {
            List<Buchung> buchungen = new ArrayList<>();
            var query = entityManager.createQuery("FROM Buchung", Buchung.class);
            for (Buchung buchung : query.getResultList()) {
                if(buchung.getUser().getId().toString().equals(userid)){
                    buchungen.add(buchung);
                }
                
            }
            return buchungen;
        } catch (Exception e) {
            throw e;
        }
    }

    public Buchung findById(long id) throws Exception {
        try {
            var query = entityManager.find(Buchung.class, id);
            return query;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Buchung> findAllPublic() throws Exception {
        try {

            List<Buchung> buchungen = entityManager.createQuery("FROM Buchung WHERE visability = true", Buchung.class)
                    .getResultList();
            return buchungen;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public Response delete(long id) throws Exception {
        try {
            Buchung buchung = entityManager.find(Buchung.class, id);
            if(buchung.getUser().getId().toString().equals(jwt.getName()) || jwt.getGroups().iterator().next().equals("Admin")){
                entityManager.remove(buchung);
                return Response.ok().build();
            }else {
                //Nicht eigene Buchung und oder Kein Admin zum bearbeiten
                return Response.status(Response.Status.BAD_REQUEST).build(); 

            }
        } catch (Exception e) {
            throw e;
        }

    }

    @Transactional
    public Response update(long id, Buchung buchung) throws Exception {
        try {
            if(buchung.getUser().getId().toString().equals(jwt.getName()) || jwt.getGroups().iterator().next().equals("Admin")){
                entityManager.merge(buchung);
                return Response.ok(buchung).build();
            }else {
                //Nicht eigene Buchung und oder Kein Admin zum bearbeiten
                return Response.status(Response.Status.BAD_REQUEST).build(); 

            }



        } catch (Exception e) {
            throw e;
        }
    }

}