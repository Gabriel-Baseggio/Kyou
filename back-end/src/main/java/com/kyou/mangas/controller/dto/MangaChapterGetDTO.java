package com.kyou.mangas.controller.dto;

import java.util.List;

public record MangaChapterGetDTO(Double chapter, List<PageGetDTO> pages) {
}
