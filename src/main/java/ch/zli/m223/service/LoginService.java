package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import ch.zli.m223.model.User;

@ApplicationScoped
public class LoginService {


   

    public String login(User user) {
        var token = "";
        
        token = AuthenticationService.returnkey(user);
          
        return token;
    }
    
    
}