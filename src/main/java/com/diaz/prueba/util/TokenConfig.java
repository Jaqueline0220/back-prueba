package com.diaz.prueba.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import  org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
public class TokenConfig {

    private static  String key = "neo_ris";

    public  String genToken(UserDetails userDatails){
        return Jwts.builder().setSubject(userDatails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(SignatureAlgorithm.HS256,key).compact();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        return  userDetails.getUsername().equals(getUsername(token)) && !expiredToken(token);
    }

    public String getUsername(String token){
        return getClaims(token).getSubject();
    }

    private  boolean expiredToken(String token){
        return  getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token){
        return  Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }
}
