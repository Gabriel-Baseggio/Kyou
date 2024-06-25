package com.kyou.mangas.model.manga;

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

    private String category;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Manga> mangas;

    public void addManga(Manga manga){
        this.mangas.add(manga);
    }
}
