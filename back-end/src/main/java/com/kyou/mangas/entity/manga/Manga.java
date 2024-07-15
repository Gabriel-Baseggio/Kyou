package com.kyou.mangas.entity.manga;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

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
}
