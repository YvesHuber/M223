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
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    public List<User> findAll() {
        var query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Transactional
    public void delete(long id){
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);

    }
    
    @Transactional
    public User update(long id, User user){
        entityManager.merge(user);
        return user;
    }
    
}