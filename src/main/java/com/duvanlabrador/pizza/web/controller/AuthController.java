package com.duvanlabrador.pizza.web.controller;

import com.duvanlabrador.pizza.persistence.dto.LoginDto;
import com.duvanlabrador.pizza.web.config.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginDto loginDto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        this.authenticationManager.authenticate(login);

        //System.out.println(authentication.isAuthenticated());
        //System.out.println(authentication.getPrincipal());

        String jwt = jwtUtil.create(loginDto.getUsername());
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,jwt).build();


    }
}
