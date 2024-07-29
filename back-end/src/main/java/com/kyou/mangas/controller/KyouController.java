package com.kyou.mangas.controller;

import com.kyou.mangas.controller.dto.ChapterGetDTO;
import com.kyou.mangas.controller.dto.MangaGetDTO;
import com.kyou.mangas.service.KyouService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/kyou")
public class KyouController {

    private final KyouService kyouService;

    @GetMapping
    public ResponseEntity<List<MangaGetDTO>> getMangas() {
        return ResponseEntity.ok(kyouService.getMangas());
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<MangaGetDTO>> getMangasPage(@PageableDefault(8) Pageable pageable) {
        return ResponseEntity.ok(kyouService.getMangasPage(pageable));
    }

    @GetMapping("/{title}")
    public ResponseEntity<MangaGetDTO> getManga(@PathVariable String title) {
        return ResponseEntity.ok(kyouService.getManga(title));
    }

    @GetMapping("/{title}/{chapterNumber}")
    public ResponseEntity<ChapterGetDTO> getChapterOfManga(@PathVariable String title, @PathVariable Double chapterNumber) {
        return ResponseEntity.ok(kyouService.getChapterOfManga(title, chapterNumber));
    }

}
