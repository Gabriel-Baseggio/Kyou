package com.kyou.mangas.entity.manga;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kyou.mangas.controller.dto.MangaCategoryGetDTO;
import com.kyou.mangas.controller.dto.MangaChapterGetDTO;
import com.kyou.mangas.controller.dto.MangaGetDTO;
import com.kyou.mangas.controller.dto.PageGetDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String cover;

    @Column(nullable = false)
    private String banner;

    @Column(precision = 2, nullable = false)
    private Double rating;

    @Column(length = 100000, nullable = false)
    private String description;

    @Enumerated
    private Status status;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Category> categories;

    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters;

    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }

    public MangaGetDTO toDTO() {
        Set<MangaCategoryGetDTO> categories = new HashSet<>();
        for (Category category : this.categories) {
            categories.add(category.toDTO());
        }

        List<MangaChapterGetDTO> chapters = this.chapters.stream().map(Chapter::toDTO).toList();

        return new MangaGetDTO(this.title, this.cover, this.banner, this.rating, this.description, this.status.name(), categories, chapters);
    }
}
