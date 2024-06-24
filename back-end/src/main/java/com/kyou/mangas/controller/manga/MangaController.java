package com.kyou.mangas.controller.manga;

import com.kyou.mangas.model.manga.Manga;
import com.kyou.mangas.service.manga.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/manga")
@AllArgsConstructor
public class MangaController {

    private final MangaService mangaService;

    @GetMapping
    public ResponseEntity<List<Manga>> getMangas() {
        return ResponseEntity.ok(mangaService.getMangas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manga> getManga(@PathVariable Integer id) {
        return ResponseEntity.ok(mangaService.getManga(id));
    }

    @GetMapping("/{title}")
    public ResponseEntity<Manga> getManga(@PathVariable String title) {
        return ResponseEntity.ok(mangaService.getManga(title));
    }

    @PostMapping
    public ResponseEntity<Manga> createManga(@RequestBody Manga category) {
        return ResponseEntity.ok(mangaService.createManga(category));
    }

    @PutMapping
    public ResponseEntity<Manga> updateManga(@RequestBody Manga updatedManga) {
        return ResponseEntity.ok(mangaService.updateManga(updatedManga));
    }

    @PutMapping("/adicionarCategoria/{mangaId}")
    public ResponseEntity<Manga> addCategory(@PathVariable Integer mangaId, @RequestBody String categoryId) {
        return ResponseEntity.ok(mangaService.addCategory(mangaId, categoryId));
    }

    @PutMapping("/adicionarCapitulo/{mangaId}")
    public ResponseEntity<Manga> addChapter(@PathVariable Integer mangaId, @RequestBody String chapterId) {
        return ResponseEntity.ok(mangaService.addChapter(mangaId, chapterId));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteManga(@RequestParam Integer id) {
        return ResponseEntity.ok(mangaService.deleteManga(id));
    }

}