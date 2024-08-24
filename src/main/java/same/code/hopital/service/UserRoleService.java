package same.code.hopital.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import same.code.hopital.entity.RoleEntity;
import same.code.hopital.entity.UserRoleEntity;
import same.code.hopital.repository.RoleRepository;
import same.code.hopital.repository.UserRepository;
import same.code.hopital.repository.UserRoleRepository;

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

    public List<UserRoleEntity> getRolesByUsername(String username) {
        return userRoleRepository.findByUsername(username);
    }

    public List<RoleEntity> getAllRoleByUsername(String username){
        List<UserRoleEntity> userRoles= getRolesByUsername(username);
        List<RoleEntity> roles = new ArrayList<>();
        if (!userRoles.isEmpty()){
            for(UserRoleEntity ur : userRoles){
                roles.add(ur.getRole());
            }
        }
        return roles;

    }
}
