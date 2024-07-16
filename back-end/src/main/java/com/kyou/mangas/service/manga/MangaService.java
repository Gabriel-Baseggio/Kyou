package com.kyou.mangas.service.manga;

import com.kyou.mangas.controller.dto.MangaCategoryGetDTO;
import com.kyou.mangas.controller.dto.MangaChapterGetDTO;
import com.kyou.mangas.controller.dto.MangaGetDTO;
import com.kyou.mangas.controller.dto.PageGetDTO;
import com.kyou.mangas.entity.manga.Category;
import com.kyou.mangas.entity.manga.Chapter;
import com.kyou.mangas.entity.manga.Manga;
import com.kyou.mangas.entity.manga.Page;
import com.kyou.mangas.repository.manga.MangaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class MangaService {

    private final MangaRepository mangaRepository;

    private final CategoryService categoryService;
    private final ChapterService chapterService;

    public List<MangaGetDTO> getMangas() {

        List<Manga> mangas = mangaRepository.findAll();

        List<MangaGetDTO> mangasDTOs = new ArrayList<>();

        mangas.forEach(manga -> {
            mangasDTOs.add(manga.toDTO());
        });

        return mangasDTOs;
    }

    public org.springframework.data.domain.Page<MangaGetDTO> getMangasDTOPage(Pageable pageable) {
        org.springframework.data.domain.Page<Manga> mangasPage = mangaRepository.findAll(pageable);
        return mangasPage.map(Manga::toDTO);
    }

    public Manga getManga(Integer id) {
        Optional<Manga> optional = mangaRepository.findById(id);

        if (optional.isEmpty())
            throw new RuntimeException("Mangá não encontrado");

        return optional.get();
    }

    public MangaGetDTO getMangaDTOByTitle(String title) {
        Manga manga = mangaRepository.findByTitle(title);
        return manga.toDTO();
    }

    public Manga getMangaByTitle(String title) {
        return mangaRepository.findByTitle(title);
    }

    public Manga createManga(Manga manga) {
        return mangaRepository.save(manga);
    }

    public Manga updateManga(Manga updatedManga) {
        validateManga(updatedManga.getId());
        return mangaRepository.save(updatedManga);
    }

    public String deleteManga(Integer id) {
        validateManga(id);

        mangaRepository.deleteById(id);

        if (mangaRepository.existsById(id))
            throw new RuntimeException("Não foi possível deletar o mangá de id: " + id);

        return "Mangá de id " + id + " deletado";
    }

    private void validateManga(Integer id) {
        if (!(mangaRepository.existsById(id)))
            throw new RuntimeException("Mangá não encontrado");
    }

    public Manga addCategories(Integer mangaId, Set<Integer> categoriesId) {
        Manga manga = getManga(mangaId);

        for (Integer categoryId : categoriesId) {
            Category category = categoryService.getCategory(categoryId);
            manga.getCategories().add(category);
        }

        return updateManga(manga);
    }

    public Manga addChapters(Integer mangaId, Set<Integer> chaptersId) {
        Manga manga = getManga(mangaId);

        for (Integer chapterId : chaptersId) {
            Chapter chapter = chapterService.getChapter(chapterId);

            chapter.setManga(manga);
            chapterService.updateChapter(chapter);

            manga.addChapter(chapter);
        }

        return updateManga(manga);
    }

}
