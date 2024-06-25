package com.kyou.mangas.model.user;

import lombok.Getter;

@Getter
public enum Role {

    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    Role(String role) {
        this.role = role;
    }

}
