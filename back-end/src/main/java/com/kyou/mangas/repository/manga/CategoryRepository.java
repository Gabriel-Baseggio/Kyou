package com.kyou.mangas.repository.manga;

import com.kyou.mangas.entity.manga.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByCategory(String category);
}
