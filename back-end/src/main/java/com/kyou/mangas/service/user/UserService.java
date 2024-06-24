package com.kyou.mangas.service.user;

import com.kyou.mangas.model.user.User;
import com.kyou.mangas.model.user.UserAuthDTO;
import com.kyou.mangas.model.user.UserCreationDTO;
import com.kyou.mangas.repository.user.UserRepository;
import com.kyou.mangas.security.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }


    public String login(UserAuthDTO data) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        return tokenService.generateToken((User) auth.getPrincipal());
    }

    public User register(UserCreationDTO data) throws Exception {
        if (userRepository.findByUsername(data.username()) != null) {
            throw new Exception("Usuário existente");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User usuario = new User(null, data.username(), encryptedPassword, data.role());
        return userRepository.save(usuario);
    }
}
