package com.kyou.mangas.service.user;

import com.kyou.mangas.model.user.User;
import com.kyou.mangas.model.user.dto.UserLogin;
import com.kyou.mangas.repository.user.UserRepository;
import com.kyou.mangas.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private JwtService jwtService;
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            return user.get();
        }

        throw new UsernameNotFoundException(username + " não encontrado!");
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public String login(UserLogin userLogin) {
        User user = (User) loadUserByUsername(userLogin.username());
        if (!user.isLoginValid(userLogin, bCryptPasswordEncoder)) {
            throw new BadCredentialsException("Usuário ou senha inválidos!");
        }
        return jwtService.generateToken(user);
    }

    public User registerUser(User user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new Exception("Já tem esse user");

        return userRepository.save(user);
    }
}
