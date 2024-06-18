package com.kyou.mangas.controller;

import com.kyou.mangas.model.Chapter;
import com.kyou.mangas.service.ChapterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capitulo")
@AllArgsConstructor
public class ChapterController {

    private final ChapterService chapterService;

    @GetMapping
    public List<Chapter> getChapters() {
        return chapterService.getChapters();
    }

    @GetMapping("/{id}")
    public Chapter getChapter(@PathVariable Integer id) {
        return chapterService.getChapter(id);
    }

    @PostMapping
    public Chapter createChapter(@RequestBody Chapter category) {
        return chapterService.createChapter(category);
    }

    @PutMapping
    public Chapter updateChapter(@RequestBody Chapter updatedChapter) {
        return chapterService.updateChapter(updatedChapter);
    }

    @DeleteMapping
    public String deleteChapter(@RequestParam Integer id) {
        return chapterService.deleteChapter(id);
    }

}