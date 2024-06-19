package com.kyou.mangas.service;

import com.kyou.mangas.model.Chapter;
import com.kyou.mangas.repository.ChapterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChapterService {

    private final ChapterRepository chapterRepository;

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

}
