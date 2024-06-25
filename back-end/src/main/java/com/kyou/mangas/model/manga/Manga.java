package com.kyou.mangas.model.manga;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String cover;

    private String banner;

    private Integer numberOfChapters;

    @Column(precision = 2)
    private Double rating;

    @Column(length = 100000)
    private String description;

    @Enumerated
    private Status status;

    @ManyToMany(mappedBy = "mangas", cascade = CascadeType.ALL)
    private Set<Category> categories;

    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters;

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }
}
