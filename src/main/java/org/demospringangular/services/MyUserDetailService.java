package org.demospringangular.services;

import org.demospringangular.entities.Role;

import org.demospringangular.entities.User;
import org.demospringangular.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();

             return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(passwordEncoder.encode(userObj.getPassword()))
                    .roles(getRoles(userObj))
                    .build();

        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(User user) {
        if (user.getUserRoles() == null) {
            return new String[]{"USER"};
        }
        String[] rolesArray = user.getUserRoles().stream()
                .map(Role::getCode) // Récupère le nom de chaque rôle
                .toArray(String[]::new);
        return rolesArray;
    }
}
