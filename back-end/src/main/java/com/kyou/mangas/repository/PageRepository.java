package com.kyou.mangas.repository;

import com.kyou.mangas.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, Integer> {
    Page findByNumber(Integer page);
}
