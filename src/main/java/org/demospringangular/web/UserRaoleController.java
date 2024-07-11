package org.demospringangular.web;

import org.demospringangular.entities.Role;
import org.demospringangular.entities.User;
import org.demospringangular.services.UserRoleService;
import org.demospringangular.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/userole")
public class UserRaoleController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;


    @GetMapping("/role/{username}")
    public List<Role> list(@PathVariable String  username) {
        List<Role> liste = userRoleService.getAllRoleByUsername(username);
        return liste;
    }
}
