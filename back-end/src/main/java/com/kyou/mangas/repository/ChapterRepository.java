package com.kyou.mangas.repository;

import com.kyou.mangas.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
    Chapter findByChapter(Double chapter);
}
