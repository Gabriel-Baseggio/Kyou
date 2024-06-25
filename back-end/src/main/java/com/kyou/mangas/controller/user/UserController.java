package com.kyou.mangas.controller.user;

import com.kyou.mangas.model.user.User;
import com.kyou.mangas.model.user.UserAuthDTO;
import com.kyou.mangas.model.user.UserCreationDTO;
import com.kyou.mangas.repository.user.UserRepository;
import com.kyou.mangas.security.TokenService;
import com.kyou.mangas.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Validated UserAuthDTO data) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok(tokenService.generateToken((User) auth.getPrincipal()));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<User> register(@RequestBody @Validated UserCreationDTO data) {
        try {
            if (userRepository.findByUsername(data.username()) != null) {
                throw new Exception("Usuário existente");
            }
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            User usuario = new User(null, data.username(), encryptedPassword, data.role());
            return ResponseEntity.ok(userRepository.save(usuario));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
