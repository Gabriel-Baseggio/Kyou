package com.kyou.mangas.controller.dto;

import java.util.List;
import java.util.Set;

public record MangaGetDTO(String title, String cover, String banner, Double rating, String description, String status, Set<MangaCategoryGetDTO> categories, List<MangaChapterGetDTO> chapters) {
}
