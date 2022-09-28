package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.User;

@ApplicationScoped
public class UserService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public User createUser(User user) throws Exception {
        try {
            entityManager.persist(user);
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