package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Buchung;
import ch.zli.m223.model.User;

@ApplicationScoped
public class UserService {
    @Inject
    private EntityManager entityManager;
    @Inject
    BuchungService buchungService;

    @Transactional
    public User createUser(User user) throws Exception {
        try {
            // Autoincrement startet bei 1 und nicht bei 3 obwohl schon 2 Elemente vorhanden
            // sind in der Datenbank
            entityManager.persist(user);
            entityManager.flush();
            entityManager.refresh(user);
            return user;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<User> findAll() throws Exception {
        try {
            var query = entityManager.createQuery("FROM User", User.class);
            return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    public User findById(long id) throws Exception {
        try {
            var query = entityManager.find(User.class, id);
            return query;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public void delete(long id) throws Exception {
        try {
            User user = entityManager.find(User.class, id);
            var buchungen = buchungService.findAllOfUser(user.getId().toString());

            for (Buchung buchung : buchungen) {
                if (buchung.getUser().getId() == user.getId()) {
                    entityManager.remove(buchung);
                }
            }

            entityManager.remove(user);
        } catch (Exception e) {
            throw e;
        }

    }

    @Transactional
    public User update(long id, User user) {
        entityManager.merge(user);
        return user;
    }

}