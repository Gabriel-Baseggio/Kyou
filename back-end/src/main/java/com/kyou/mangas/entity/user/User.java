package com.kyou.mangas.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToOne
    private Role role;

    public boolean isLoginCorrect(String password, BCryptPasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(this.password, password);
    }

}
