package ch.zli.m223.service;

import java.util.Arrays;
import java.util.HashSet;

import ch.zli.m223.model.User;
import io.smallrye.jwt.build.Jwt;

public class AuthenticationService {

    public static String returnkey(User user){


        String token =
           Jwt.issuer("https://example.com/issuer") 
             .claim("User_id", user.getId())
             .upn(user.getEmail()) 
             .groups(new HashSet<>(Arrays.asList(user.getRole()))) 
           .sign();
        System.out.println(token);
        return token;
    }
    
}
