package ch.zli.m223.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.hibernate.Criteria;

import ch.zli.m223.model.Buchung;
import ch.zli.m223.model.User;

@ApplicationScoped
public class BuchungService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Buchung create(Buchung buchung) {
        entityManager.persist(buchung);
        return buchung;
    }

    public List<Buchung> findAll() {
        var query = entityManager.createQuery("FROM Buchung", Buchung.class);
        return query.getResultList();
    }

    public List<Buchung> findAllOfUser(String userid) {
        var query = entityManager.createQuery("FROM Buchung Where user_id = "+userid, Buchung.class);
        return query.getResultList();
    }

    public Buchung findById(long id) {
    var query = entityManager.find(Buchung.class, id);
    return query;
    }


    public List<Buchung> findAllPublic() {
        
        List<Buchung> buchungen = entityManager.createQuery("FROM Buchung WHERE visability = true", Buchung.class).getResultList();
        return buchungen;
    }


    @Transactional
    public void delete(long id){
        Buchung buchung = entityManager.find(Buchung.class,id);
        entityManager.remove(buchung);

    }
    
    @Transactional
    public Buchung update(long id, Buchung buchung){
        entityManager.merge(buchung);
        return buchung;
    }
    
}