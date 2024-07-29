package com.kyou.mangas.service;

import com.kyou.mangas.controller.dto.ChapterGetDTO;
import com.kyou.mangas.controller.dto.MangaGetDTO;
import com.kyou.mangas.controller.dto.PageGetDTO;
import com.kyou.mangas.entity.manga.Chapter;
import com.kyou.mangas.entity.manga.Manga;
import com.kyou.mangas.entity.manga.Page;
import com.kyou.mangas.service.manga.ChapterService;
import com.kyou.mangas.service.manga.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class KyouService {

    private final MangaService mangaService;

    private final ChapterService chapterService;

    public List<MangaGetDTO> getMangas() {
        return mangaService.getMangas();
    }

    public MangaGetDTO getManga(String title) {
        return mangaService.getMangaDTOByTitle(title);
    }

    public org.springframework.data.domain.Page<MangaGetDTO> getMangasPage(Pageable pageable) {
        return mangaService.getMangasDTOPage(pageable);
    }

    public ChapterGetDTO getChapterOfManga(String title, Double chapterNumber) {
        Manga manga = mangaService.getMangaByTitle(title);
        for (Chapter c : manga.getChapters()) {
            if (Objects.equals(c.getChapter(), chapterNumber)) {
                return new ChapterGetDTO(c.getChapter(), createPagesDTO(c.getPages()));
            }
        }
        return null;
    }

    private List<PageGetDTO> createPagesDTO(List<Page> pages) {
        ArrayList<PageGetDTO> pagesDTOs = new ArrayList<>();

        pages.forEach(page -> {
            pagesDTOs.add(new PageGetDTO(page.getNumber(), page.getPageImage()));
        });

        return pagesDTOs;
    }

    public PageGetDTO getPageOfChapter(String title, Double chapterNumber, Integer pageNumber) {
        ChapterGetDTO chapter = getChapterOfManga(title, chapterNumber);
        for (PageGetDTO p : chapter.pages()) {
            if (Objects.equals(p.number(), pageNumber)) {
                return new PageGetDTO(p.number(), p.pageImage());
            }
        }
        return null;
    }


}
