package com.kyou.mangas.controller;

import com.kyou.mangas.model.manga.Chapter;
import com.kyou.mangas.model.manga.Manga;
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
    public ResponseEntity<List<Manga>> getMangas() {
        return ResponseEntity.ok(testService.getMangas());
    }

    @GetMapping("/{title}")
    public ResponseEntity<Manga> getManga(@PathVariable String title) {
        return ResponseEntity.ok(testService.getManga(title));
    }

    @GetMapping("/{title}/{chapterNumber}")
    public ResponseEntity<Chapter> getChapterOfManga(@PathVariable String title, @PathVariable Double chapterNumber) {
        return ResponseEntity.ok(testService.getChapterOfManga(title, chapterNumber));
    }

}
