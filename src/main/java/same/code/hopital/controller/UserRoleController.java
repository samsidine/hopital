package same.code.hopital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import same.code.hopital.entity.RoleEntity;
import same.code.hopital.service.UserRoleService;
import same.code.hopital.service.UserService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/userole")
public class UserRoleController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;


    @GetMapping("/role/{username}")
    public List<RoleEntity> list(@PathVariable String  username) {
        List<RoleEntity> liste = userRoleService.getAllRoleByUsername(username);
        return liste;
    }


}
