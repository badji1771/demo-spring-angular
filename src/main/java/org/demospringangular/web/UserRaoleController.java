package org.demospringangular.web;

import org.demospringangular.entities.Role;
import org.demospringangular.entities.User;
import org.demospringangular.services.UserRoleService;
import org.demospringangular.services.UserRoleServiceI;
import org.demospringangular.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/userole")
public class UserRaoleController {


  @Autowired
    private UserRoleServiceI userRoleService;


    @GetMapping("/role/{username}")
    public Collection<Role> list(@PathVariable String  username) {
        Collection<Role> liste = userRoleService.loadRoleByUsername(username);
        return liste;
    }
}
