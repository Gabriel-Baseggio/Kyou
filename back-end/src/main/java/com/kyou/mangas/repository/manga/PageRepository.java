package com.kyou.mangas.repository.manga;

import com.kyou.mangas.entity.manga.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, Integer> {
    Page findByNumber(Integer page);
}
