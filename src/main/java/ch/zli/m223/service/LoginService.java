package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import ch.zli.m223.model.User;

@ApplicationScoped
public class LoginService {
    @Inject
    private EntityManager entityManager;

   

    public String login(User user) {
        var token = "";
        var query = entityManager.createQuery("FROM User", User.class).getResultList();
        for (User user2 : query) {
            if(user2.getVorname().equals(user.getVorname()) && user2.getPasswort().equals(user.getPasswort())){
                token = AuthenticationService.returnkey(user2);
            }
            else{
                token = "Unsuccessfull login";
            }
        }
        
        return token;
    }
    
    
}