package com.kyou.mangas.controller;

import com.kyou.mangas.model.Category;
import com.kyou.mangas.model.Manga;
import com.kyou.mangas.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Integer id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/{category}")
    public Category getCategory(@PathVariable String category) {
        return categoryService.getCategory(category);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category updatedCategory) {
        return categoryService.updateCategory(updatedCategory);
    }

    @DeleteMapping
    public String deleteCategory(@RequestParam Integer id) {
        return categoryService.deleteCategory(id);
    }

}