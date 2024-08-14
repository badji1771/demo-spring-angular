package org.demospringangular.services;

import org.demospringangular.entities.Role;
import org.demospringangular.entities.User;

import org.demospringangular.repository.RoleRepository;
import org.demospringangular.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserRoleService implements UserRoleServiceI{


    private UserRepository userRepository;

    private RoleRepository roleRepository;

    public UserRoleService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addNeUser(User user) {
        return userRepository.save(user);   }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String codeRole) {
        User user = userRepository.findByUsername(username).get();
        Role role = roleRepository.findByCode(codeRole).get();
        user.getUserRoles().add(role);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public Collection<Role> loadRoleByUsername(String username) {
       User user = userRepository.findByUsername(username).get();
       return user.getUserRoles();
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }



   /* public List<UserRole> getRolesByUsername(String username) {
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

    }*/
}
