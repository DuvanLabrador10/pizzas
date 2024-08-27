package com.duvanlabrador.pizza.services.impl;

import com.duvanlabrador.pizza.persistence.dto.UserDto;
import com.duvanlabrador.pizza.persistence.entity.UserEntity;
import com.duvanlabrador.pizza.persistence.mappers.UserMapper;
import com.duvanlabrador.pizza.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));
        UserDto userDto = this.userMapper.userToUserDto(user);

        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .roles("ADMIN")
                .accountLocked(userDto.getLocked())
                .disabled(userDto.getDisabled())
                .build();
    }
}
