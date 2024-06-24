package com.kyou.mangas.controller.user;

import com.kyou.mangas.model.user.User;
import com.kyou.mangas.model.user.UserAuthDTO;
import com.kyou.mangas.model.user.UserCreationDTO;
import com.kyou.mangas.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Validated UserAuthDTO data) {
        return ResponseEntity.ok(userService.login(data));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<User> register(@RequestBody @Validated UserCreationDTO data) {
        try {
            return ResponseEntity.ok(userService.register(data));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
