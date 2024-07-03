package com.kyou.mangas.service.user;

import com.kyou.mangas.controller.dto.UserLogin;
import com.kyou.mangas.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final JwtService jwtService;

    public String login(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }

}
