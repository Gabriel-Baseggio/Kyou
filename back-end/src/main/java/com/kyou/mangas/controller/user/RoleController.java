package com.kyou.mangas.controller.user;

import com.kyou.mangas.entity.user.Role;
import com.kyou.mangas.service.user.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PostMapping("/registrarRole")
    public ResponseEntity<Role> registerRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.registerRole(role));
    }

}
