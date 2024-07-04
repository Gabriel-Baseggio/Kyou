package com.kyou.mangas.service.user;

import com.kyou.mangas.entity.user.Role;
import com.kyou.mangas.repository.user.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role registerRole(Role role) {
        return roleRepository.save(role);
    }


}
