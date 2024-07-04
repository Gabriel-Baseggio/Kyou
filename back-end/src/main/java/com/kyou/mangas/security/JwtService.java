package com.kyou.mangas.security;

import com.kyou.mangas.controller.dto.UserLogin;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JwtService {

    private final JwtEncoder encoder;

    public String generateToken(UserLogin userLogin){
        Instant now = Instant.now();
        long expiry = 3600l;

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("kyou-mangas")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(userLogin.username())
                .build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
