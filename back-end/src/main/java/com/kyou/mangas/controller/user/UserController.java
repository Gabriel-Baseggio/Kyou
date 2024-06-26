package com.kyou.mangas.controller.user;

import com.kyou.mangas.model.user.User;
import com.kyou.mangas.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UserController {

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @PostMapping("/registro")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userService.registerUser(user));
    }

}
