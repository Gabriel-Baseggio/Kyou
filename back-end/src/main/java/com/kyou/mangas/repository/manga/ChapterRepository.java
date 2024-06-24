package com.kyou.mangas.repository.manga;

import com.kyou.mangas.model.manga.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
    Chapter findByChapter(Double chapter);
}
