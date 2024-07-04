package com.kyou.mangas.controller.manga;

import com.kyou.mangas.entity.manga.Page;
import com.kyou.mangas.service.manga.PageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pagina")
@AllArgsConstructor
public class PageController {

    private final PageService pageService;

    @GetMapping
    public ResponseEntity<List<Page>> getPages() {
        return ResponseEntity.ok(pageService.getPages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page> getPageById(@PathVariable Integer id) {
        return ResponseEntity.ok(pageService.getPageById(id));
    }

    @GetMapping("/number")
    public ResponseEntity<Page> getPageByNumber(@RequestParam Integer page) {
        return ResponseEntity.ok(pageService.getPageByNumber(page));
    }

    @PostMapping
    public ResponseEntity<Page> createPage(@RequestBody Page category) {
        return ResponseEntity.ok(pageService.createPage(category));
    }

    @PutMapping
    public ResponseEntity<Page> updatePage(@RequestBody Page updatedPage) {
        return ResponseEntity.ok(pageService.updatePage(updatedPage));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePage(@RequestParam Integer id) {
        return ResponseEntity.ok(pageService.deletePage(id));
    }

}