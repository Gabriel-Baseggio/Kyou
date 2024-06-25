package com.kyou.mangas.controller.manga;

import com.kyou.mangas.model.manga.Manga;
import com.kyou.mangas.service.manga.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @PutMapping("/adicionarCategorias/{mangaId}")
    public ResponseEntity<Manga> addCategories(@PathVariable Integer mangaId, @RequestBody Set<Integer> categoriesId) {
        return ResponseEntity.ok(mangaService.addCategories(mangaId, categoriesId));
    }

    @PutMapping("/adicionarCapitulos/{mangaId}")
    public ResponseEntity<Manga> addChapters(@PathVariable Integer mangaId, @RequestBody Set<Integer> chaptersId) {
        return ResponseEntity.ok(mangaService.addChapters(mangaId, chaptersId));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteManga(@RequestParam Integer id) {
        return ResponseEntity.ok(mangaService.deleteManga(id));
    }

}