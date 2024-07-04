package com.kyou.mangas.entity.manga;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String category;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Manga> mangas;

    public void addManga(Manga manga){
        this.mangas.add(manga);
    }
}
