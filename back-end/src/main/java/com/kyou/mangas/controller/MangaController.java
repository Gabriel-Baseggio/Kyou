package com.kyou.mangas.controller;

import com.kyou.mangas.model.Manga;
import com.kyou.mangas.service.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/manga")
@AllArgsConstructor
public class MangaController {

    private final MangaService mangaService;

    @GetMapping
    public List<Manga> getMangas() {
        return mangaService.getMangas();
    }

    @GetMapping("/{id}")
    public Manga getManga(@PathVariable Integer id) {
        return mangaService.getManga(id);
    }

    @GetMapping("/{title}")
    public Manga getManga(@PathVariable String title) {
        return mangaService.getManga(title);
    }

    @PostMapping
    public Manga createManga(@RequestBody Manga category) {
        return mangaService.createManga(category);
    }

    @PutMapping
    public Manga updateManga(@RequestBody Manga updatedManga) {
        return mangaService.updateManga(updatedManga);
    }

    @PutMapping("/adicionarCategoria/{mangaId}")
    public Manga addCategory(@PathVariable Integer mangaId, @RequestBody String categoryId) {
        return mangaService.addCategory(mangaId, categoryId);
    }

    @PutMapping("/adicionarCapitulo/{mangaId}")
    public Manga addChapter(@PathVariable Integer mangaId, @RequestBody String chapterId) {
        return mangaService.addChapter(mangaId, chapterId);
    }

    @DeleteMapping
    public String deleteManga(@RequestParam Integer id) {
        return mangaService.deleteManga(id);
    }

}