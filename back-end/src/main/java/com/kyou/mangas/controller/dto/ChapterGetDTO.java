package com.kyou.mangas.controller.dto;

import java.util.List;

public record ChapterGetDTO(Double chapter, List<PageGetDTO> pages) {
}
