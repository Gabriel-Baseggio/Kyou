package com.kyou.mangas.repository.manga;

import com.kyou.mangas.model.manga.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Integer> {
    Manga findByTitle(String title);
}
