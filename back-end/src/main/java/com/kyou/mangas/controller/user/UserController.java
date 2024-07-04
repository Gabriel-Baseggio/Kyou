package com.kyou.mangas.controller.user;

import com.kyou.mangas.controller.dto.UserLogin;
import com.kyou.mangas.controller.dto.UserRegister;
import com.kyou.mangas.controller.dto.UserToken;
import com.kyou.mangas.entity.user.User;
import com.kyou.mangas.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<UserToken> login(@RequestBody UserLogin userLogin) {
        return ResponseEntity.ok(userService.login(userLogin));
    }

    @PostMapping("/registro")
    public ResponseEntity<Void> register(@RequestBody UserRegister userRegister) {
        userService.registerUser(userRegister);
        return ResponseEntity.ok().build();
    }

}
