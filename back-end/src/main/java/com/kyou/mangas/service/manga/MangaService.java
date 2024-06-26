package com.kyou.mangas.service.manga;

import com.kyou.mangas.model.manga.Category;
import com.kyou.mangas.model.manga.Chapter;
import com.kyou.mangas.model.manga.Manga;
import com.kyou.mangas.repository.manga.MangaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class MangaService {

    private final MangaRepository mangaRepository;

    private final CategoryService categoryService;
    private final ChapterService chapterService;

    public List<Manga> getMangas() {
        return mangaRepository.findAll();
    }

    public Manga getManga(Integer id) {
        Optional<Manga> optional = mangaRepository.findById(id);

        if (optional.isEmpty())
            throw new RuntimeException("Mangá não encontrado");



        return optional.get();
    }

    public Manga getManga(String title) {
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

        for (Integer categoryId: categoriesId) {
            Category category = categoryService.getCategory(categoryId);

            category.addManga(manga);
            categoryService.updateCategory(category);

            manga.addCategory(category);
        }

        return updateManga(manga);
    }

    public Manga addChapters(Integer mangaId, Set<Integer> chaptersId) {
        Manga manga = getManga(mangaId);

        for (Integer chapterId: chaptersId) {
            Chapter chapter = chapterService.getChapter(chapterId);

            chapter.setManga(manga);
            chapterService.updateChapter(chapter);

            manga.addChapter(chapter);
        }

        return updateManga(manga);
    }
}
