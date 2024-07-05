package com.kyou.mangas.service.user;

import com.kyou.mangas.controller.dto.UserLogin;
import com.kyou.mangas.controller.dto.UserRegister;
import com.kyou.mangas.controller.dto.UserToken;
import com.kyou.mangas.entity.user.User;
import com.kyou.mangas.repository.user.UserRepository;
import com.kyou.mangas.security.JwtService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private JwtService jwtService;
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(JwtService jwtService, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserToken login(UserLogin userLogin) {
        Optional<User> user = userRepository.findByUsername(userLogin.username());


        if (user.isEmpty() || !this.validatePassword(userLogin, user.get())) {
            throw new BadCredentialsException("Usuário ou senha inválidos!");
        }

        return new UserToken(jwtService.generateToken(user.get()));
    }

    private boolean validatePassword(UserLogin userLogin, User user) {
        return bCryptPasswordEncoder.matches(userLogin.password(), user.getPassword());
    }

    public void registerUser(UserRegister userRegister) {
        User user = new User();

        user.setUsername(userRegister.username());
        user.setPassword(bCryptPasswordEncoder.encode(userRegister.password()));

        userRepository.save(user);
    }

}