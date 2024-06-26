package com.kyou.mangas.model.user;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");

    String role;

    UserRole(String role) {
        this.role = role;
    }
}
