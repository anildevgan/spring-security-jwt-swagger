package com.devgan.jwtdemo.mappers;

import com.devgan.jwtdemo.entities.User;
import com.devgan.jwtdemo.models.UserPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserPrincipal userToPrincipal(User user) {
        UserPrincipal userp = new UserPrincipal();
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());

        userp.setUsername(user.getUsername());
        userp.setPassword(user.getPassword());
        userp.setEnabled(user.isEnabled());
        userp.setAuthorities(authorities);
        return userp;
    }
}