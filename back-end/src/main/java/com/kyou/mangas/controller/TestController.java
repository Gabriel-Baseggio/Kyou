package com.kyou.mangas.controller;

import com.kyou.mangas.model.Chapter;
import com.kyou.mangas.model.Manga;
import com.kyou.mangas.model.Page;
import com.kyou.mangas.service.TestService;
import lombok.AllArgsConstructor;
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
    public List<Manga> getMangas() {
        return testService.getMangas();
    }

    @GetMapping("/{title}")
    public Manga getManga(@PathVariable String title) {
        return testService.getManga(title);
    }

    @GetMapping("/{title}/{chapterNumber}")
    public Chapter getChapterOfManga(@PathVariable String title, @PathVariable Double chapterNumber) {
        return testService.getChapterOfManga(title, chapterNumber);
    }

}
