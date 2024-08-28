package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.persistence.dto.UserDto;
import com.duvanlabrador.pizza.persistence.entity.UserEntity;
import com.duvanlabrador.pizza.persistence.entity.UserRolEntity;
import com.duvanlabrador.pizza.persistence.mappers.UserMapper;
import com.duvanlabrador.pizza.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));
        List<String> role = user.getUserRol().stream().map(UserRolEntity::getRolName).toList();
        //String[] roles = user.getUserRol().stream().map(UserRolEntity::getRolName).toArray(String[]::new);
        UserDto userDto = this.userMapper.userToUserDto(user);



        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                //.roles(role.toArray(new String[0]))
                .authorities(this.grantedAuthorities(role))
                .accountLocked(userDto.getLocked())
                .disabled(userDto.getDisabled())
                .build();
    }

    private List<String> getAuthorities(String role){
        if("ADMIN".equals(role) || "CUSTOMER".equals(role)){
             return List.of("get_available_pizzas");
        }
        return new ArrayList<>();
    }

    private List<GrantedAuthority> grantedAuthorities(List<String> role){
        List<GrantedAuthority> authorities = new ArrayList<>(role.size());

        for (String roles: role){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roles));
            for (String authority:this.getAuthorities(roles)){
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authorities;
    }

}
