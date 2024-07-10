package com.kyou.mangas.service.user;

import com.kyou.mangas.controller.dto.UserLoginDTO;
import com.kyou.mangas.controller.dto.UserRegisterDTO;
import com.kyou.mangas.controller.dto.UserTokenDTO;
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

    public UserTokenDTO login(UserLoginDTO userLoginDTO) {
        Optional<User> user = userRepository.findByUsername(userLoginDTO.username());

        if (user.isEmpty() || !this.validatePassword(userLoginDTO, user.get())) {
            throw new BadCredentialsException("Usuário ou senha inválidos!");
        }

        return jwtService.generateToken(user.get());
    }

    private boolean validatePassword(UserLoginDTO userLoginDTO, User user) {
        return bCryptPasswordEncoder.matches(userLoginDTO.password(), user.getPassword());
    }

    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();

        user.setUsername(userRegisterDTO.username());
        user.setPassword(bCryptPasswordEncoder.encode(userRegisterDTO.password()));

        userRepository.save(user);
    }

}
