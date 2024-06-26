package com.kyou.mangas.service.user;

import com.kyou.mangas.model.user.User;
import com.kyou.mangas.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            return user.get();
        }


        throw new UsernameNotFoundException(username);
    }

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new RuntimeException("Já tem esse user");

        return userRepository.save(user);
    }
}
