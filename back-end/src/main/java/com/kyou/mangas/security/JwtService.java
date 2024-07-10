package com.kyou.mangas.security;

import com.kyou.mangas.controller.dto.UserTokenDTO;
import com.kyou.mangas.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class JwtService {

    private final JwtEncoder encoder;

    public UserTokenDTO generateToken(User user){
        Instant now = Instant.now();
        long expiresIn = 3600L;

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("kyou-mangas")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .subject(user.getUsername())
                .build();

        String tokenValue = encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new UserTokenDTO(tokenValue, expiresIn);
    }

}
