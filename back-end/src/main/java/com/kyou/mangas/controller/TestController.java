package com.kyou.mangas.controller;

import com.kyou.mangas.controller.dto.ChapterGetDTO;
import com.kyou.mangas.controller.dto.MangaGetDTO;
import com.kyou.mangas.entity.manga.Chapter;
import com.kyou.mangas.entity.manga.Manga;
import com.kyou.mangas.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public ResponseEntity<List<MangaGetDTO>> getMangas() {
        return ResponseEntity.ok(testService.getMangas());
    }

    @GetMapping("/{title}")
    public ResponseEntity<MangaGetDTO> getManga(@PathVariable String title) {
        return ResponseEntity.ok(testService.getManga(title));
    }

    @GetMapping("/{title}/{chapterNumber}")
    public ResponseEntity<ChapterGetDTO> getChapterOfManga(@PathVariable String title, @PathVariable Double chapterNumber) {
        return ResponseEntity.ok(testService.getChapterOfManga(title, chapterNumber));
    }

}
