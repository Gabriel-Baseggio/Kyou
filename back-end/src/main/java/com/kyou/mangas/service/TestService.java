package com.kyou.mangas.service;

import com.kyou.mangas.model.Category;
import com.kyou.mangas.model.Chapter;
import com.kyou.mangas.model.Manga;
import com.kyou.mangas.model.Page;
import com.kyou.mangas.repository.MangaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TestService {

    private final MangaService mangaService;

    private final ChapterService chapterService;

    public List<Manga> getMangas() {
        return mangaService.getMangas();
    }

    public Manga getManga(String title) {
        return mangaService.getManga(title);
    }


    public Chapter getChapterOfManga(String title, Double chapterNumber) {
        Manga manga = getManga(title);
        for (Chapter c : manga.getChapters()) {
            if (Objects.equals(c.getChapter(), chapterNumber)) {
                return c;
            }
        }
        return null;
    }

    public Page getPageOfChapter(String title, Double chapterNumber, Integer pageNumber) {
        Chapter chapter = getChapterOfManga(title, chapterNumber);
        for (Page p : chapter.getPages()) {
            if (Objects.equals(p.getNumber(), pageNumber)) {
                return p;
            }
        }
        return null;
    }
}