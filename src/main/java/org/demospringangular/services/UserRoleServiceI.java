package org.demospringangular.services;

import org.demospringangular.entities.Role;
import org.demospringangular.entities.User;

import java.util.Collection;
import java.util.List;

public interface UserRoleServiceI {

    User addNeUser (User user);
    Role addNewRole(Role role);
    void addRoleToUser( String username, String codeRole);
    User loadUserByUsername(String username);

    Collection<Role> loadRoleByUsername(String username);

    List<User> listUsers();
}
