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
        
        token = AuthenticationService.returnkey(user);
          
        return token;
    }
    
    
}