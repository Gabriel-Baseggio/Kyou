package com.kyou.mangas.controller;

import com.kyou.mangas.model.Chapter;
import com.kyou.mangas.model.Manga;
import com.kyou.mangas.model.Page;
import com.kyou.mangas.service.PageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagina")
@AllArgsConstructor
public class PageController {

    private final PageService pageService;

    @GetMapping
    public List<Page> getPages() {
        return pageService.getPages();
    }

    @GetMapping("/{id}")
    public Page getPageById(@PathVariable Integer id) {
        return pageService.getPageById(id);
    }

    @GetMapping("/{page}")
    public Page getPageByNumber(@PathVariable Integer page) {
        return pageService.getPageByNumber(page);
    }

    @PostMapping
    public Page createPage(@RequestBody Page category) {
        return pageService.createPage(category);
    }

    @PutMapping
    public Page updatePage(@RequestBody Page updatedPage) {
        return pageService.updatePage(updatedPage);
    }

    @DeleteMapping
    public String deletePage(@RequestParam Integer id) {
        return pageService.deletePage(id);
    }

}