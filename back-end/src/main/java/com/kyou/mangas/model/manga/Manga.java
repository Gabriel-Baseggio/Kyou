package com.kyou.mangas.model.manga;

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

    private String title;

    private String cover;

    private String banner;

    @Column(precision = 2)
    private Double rating;

    @Column(length = 100000)
    private String description;

    @Enumerated
    private Status status;

    @JsonManagedReference
    @ManyToMany(mappedBy = "mangas", cascade = CascadeType.ALL)
    private Set<Category> categories;

    @JsonManagedReference
    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters;

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }
}
