package com.kyou.mangas.controller;

import com.kyou.mangas.model.Manga;
import com.kyou.mangas.service.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public Manga createManga(@RequestBody Manga category) {
        return mangaService.createManga(category);
    }

    @PutMapping
    public Manga updateManga(@RequestBody Manga updatedManga) {
        return mangaService.updateManga(updatedManga);
    }

    @DeleteMapping
    public String deleteManga(@RequestParam Integer id) {
        return mangaService.deleteManga(id);
    }

}