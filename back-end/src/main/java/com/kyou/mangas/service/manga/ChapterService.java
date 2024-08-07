package com.kyou.mangas.service.manga;

import com.kyou.mangas.entity.manga.Chapter;
import com.kyou.mangas.entity.manga.Page;
import com.kyou.mangas.repository.manga.ChapterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final PageService pageService;

    public List<Chapter> getChapters() {
        return chapterRepository.findAll();
    }

    public Chapter getChapter(Integer id) {
        Optional<Chapter> optional = chapterRepository.findById(id);

        if (optional.isEmpty())
            throw new RuntimeException("Capítulo não encontrado");

        return optional.get();
    }

    public Chapter getChapter(Double chapter) {
        return chapterRepository.findByChapter(chapter);
    }

    public Chapter createChapter(Chapter category) {
        return chapterRepository.save(category);
    }

    public Chapter updateChapter(Chapter updatedChapter) {
        validateChapter(updatedChapter.getId());
        return chapterRepository.save(updatedChapter);
    }

    public String deleteChapter(Integer id) {
        validateChapter(id);

        chapterRepository.deleteById(id);

        if (chapterRepository.existsById(id))
            throw new RuntimeException("Não foi possível deletar o capítulo de id: " + id);

        return "Capítulo de id " + id + " deletado";
    }

    private void validateChapter(Integer id) {
        if (!(chapterRepository.existsById(id)))
            throw new RuntimeException("Capítulo não encontrado");
    }

    public Chapter addPages(Integer chapterId, Set<Integer> pagesId) {
        Chapter chapter = getChapter(chapterId);

        for (Integer pageId: pagesId) {
            Page page = pageService.getPageById(pageId);

            page.setChapter(chapter);
            pageService.updatePage(page);

            chapter.addPage(page);
        }

        return updateChapter(chapter);
    }
}
