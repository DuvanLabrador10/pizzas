package com.duvanlabrador.pizza.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "6caf2fb867d76fe8ffca674e4b125bbb1eeb74a4a04b732a83978c0948289ffe";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);


    public String create(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer("duvan-labrador")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1800000)) // The token last 30 min
                .withJWTId(UUID.randomUUID().toString())
                .withNotBefore(new Date(System.currentTimeMillis()))// Is valid NOW
                .sign(ALGORITHM);
    }

    public boolean isValid(String jwt) {
        try {
            JWT.require(ALGORITHM)
                    .build()
                    .verify(jwt);
            return true;
        } catch (JWTVerificationException ex) {
            return false;
        }
    }

    public String getUsername(String jwt){
       return JWT.require(ALGORITHM)
                .build()
                .verify(jwt)
                .getSubject();
    }

}
