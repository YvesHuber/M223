package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Buchung;

@ApplicationScoped
public class BuchungService {
    @Inject
    private EntityManager entityManager;

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
            var query = entityManager.createQuery("FROM Buchung Where user_id = " + userid, Buchung.class);
            return query.getResultList();
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
    public void delete(long id) throws Exception {
        try {
            Buchung buchung = entityManager.find(Buchung.class, id);
            entityManager.remove(buchung);
        } catch (Exception e) {
            throw e;
        }

    }

    @Transactional
    public Buchung update(long id, Buchung buchung) throws Exception {
        try {
            entityManager.merge(buchung);
            return buchung;
        } catch (Exception e) {
            throw e;
        }
    }

}