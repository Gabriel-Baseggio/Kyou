package com.kyou.mangas.security;

import com.kyou.mangas.model.user.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    private JwtEncoder encoder;

    public String generateToken(User user){
        Instant now = Instant.now();
        long expiresIn = 3600L;

        String scopes = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet tokenClaims = JwtClaimsSet.builder()
                .issuer("kyou-mangas")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .subject(user.getUsername())
                .claim("scope", scopes)
                .build();

        return encoder.encode(JwtEncoderParameters.from(tokenClaims)).getTokenValue();
    }


}
