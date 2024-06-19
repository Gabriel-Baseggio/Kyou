package com.kyou.mangas.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private Set<Manga> mangas;

    private String category;

    public void addManga(Manga manga) {
        this.mangas.add(manga);
    }
}
