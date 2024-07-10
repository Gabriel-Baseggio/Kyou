package com.kyou.mangas.controller.dto;

public record UserTokenDTO(String token, Long expiresIn) {
}
