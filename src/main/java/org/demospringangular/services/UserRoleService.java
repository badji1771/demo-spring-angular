package org.demospringangular.services;

import org.demospringangular.entities.Role;
import org.demospringangular.entities.UserRole;
import org.demospringangular.repository.RoleRepository;
import org.demospringangular.repository.UserRepository;
import org.demospringangular.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getRolesByUsername(String username) {
        return userRoleRepository.findByUsername(username);
    }

    public List<Role> getAllRoleByUsername(String username){
        List<UserRole> userRoles= getRolesByUsername(username);
        List<Role> roles = new ArrayList<>();
        if (!userRoles.isEmpty()){
            for(UserRole ur : userRoles){
                roles.add(ur.getRole());
            }
        }
        return roles;

    }
}
