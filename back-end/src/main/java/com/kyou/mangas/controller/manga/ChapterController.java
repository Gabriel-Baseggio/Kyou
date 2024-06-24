package com.kyou.mangas.controller.manga;

import com.kyou.mangas.model.manga.Chapter;
import com.kyou.mangas.service.manga.ChapterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/capitulo")
@AllArgsConstructor
public class ChapterController {

    private final ChapterService chapterService;

    @GetMapping
    public ResponseEntity<List<Chapter>> getChapters() {
        return ResponseEntity.ok(chapterService.getChapters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chapter> getChapter(@PathVariable Integer id) {
        return ResponseEntity.ok(chapterService.getChapter(id));
    }

    @GetMapping("/{chapter}")
    public ResponseEntity<Chapter> getChapter(@PathVariable Double chapter) {
        return ResponseEntity.ok(chapterService.getChapter(chapter));
    }

    @PostMapping
    public ResponseEntity<Chapter> createChapter(@RequestBody Chapter category) {
        return ResponseEntity.ok(chapterService.createChapter(category));
    }

    @PutMapping
    public ResponseEntity<Chapter> updateChapter(@RequestBody Chapter updatedChapter) {
        return ResponseEntity.ok(chapterService.updateChapter(updatedChapter));
    }

    @PutMapping("/adicionarPagina/{chapterId}")
    public ResponseEntity<Chapter> addPage(@PathVariable Integer chapterId, @RequestBody String pageId) {
        return ResponseEntity.ok(chapterService.addPage(chapterId, pageId));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteChapter(@RequestParam Integer id) {
        return ResponseEntity.ok(chapterService.deleteChapter(id));
    }

}