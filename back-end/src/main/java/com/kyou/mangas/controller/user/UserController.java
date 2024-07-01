package com.kyou.mangas.controller.user;

import com.kyou.mangas.model.user.dto.UserLogin;
import com.kyou.mangas.model.user.dto.UserToken;
import com.kyou.mangas.model.user.User;
import com.kyou.mangas.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLogin userLogin){
        return ResponseEntity.ok(userService.login(userLogin));
    }

    @PostMapping("/registro")
    public ResponseEntity registerUser(@RequestBody User user){
        try {
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

}
