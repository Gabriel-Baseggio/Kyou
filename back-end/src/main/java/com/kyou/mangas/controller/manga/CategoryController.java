package com.kyou.mangas.controller.manga;

import com.kyou.mangas.model.manga.Category;
import com.kyou.mangas.model.manga.Manga;
import com.kyou.mangas.service.manga.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @GetMapping("/{category}")
    public ResponseEntity<Category> getCategory(@PathVariable String category) {
        return ResponseEntity.ok(categoryService.getCategory(category));
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category updatedCategory) {
        return ResponseEntity.ok(categoryService.updateCategory(updatedCategory));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCategory(@RequestParam Integer id) {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }

}