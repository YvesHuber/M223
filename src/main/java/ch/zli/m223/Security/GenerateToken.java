package ch.zli.m223.Security;

import java.util.Arrays;
import java.util.HashSet;


import io.smallrye.jwt.build.Jwt;

public class GenerateToken {
    /**
     * Generate JWT token
     */

    public static String returnkey(String email, String role){
        String token =
           Jwt.issuer("https://example.com/issuer") 
             .upn(email) 
             .groups(new HashSet<>(Arrays.asList(role))) 
           .sign();
        System.out.println(token);
        return token;
    }
}