package com.duvanlabrador.pizza.web.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        /*
        * 1. Valida que sea un Header Authorization Valido
        * 2. Valida que el JWT sea valido
        * 3. Carga el user del UserDetailService
        * 4. Carga el usuario en el context Holder
        * */

        //1. Valida que sea un Header Authorization Valido
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authHeader == null || authHeader.isEmpty() || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }

        //2. Valida que el JWT sea valido
        String jwt = authHeader.split(" ")[1].trim();
        if (!this.jwtUtil.isValid(jwt)){
            filterChain.doFilter(request,response);
            return;
        }

        //3. Carga el user del UserDetailService
        String username = this.jwtUtil.getUsername(jwt);
        User user = (User) this.userDetailsService.loadUserByUsername(username);

        //4. Carga el usuario en el context Holder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        System.out.println(authenticationToken);
        filterChain.doFilter(request,response);

    }
}
