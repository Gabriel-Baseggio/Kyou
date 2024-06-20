package com.kyou.mangas.model;

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

    private Integer numberOfChapters;

    @Column(precision = 2)
    private Double rating;

    private String description;

    @Enumerated
    private Status status;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Category> categories;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Chapter> chapters;

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }
}
