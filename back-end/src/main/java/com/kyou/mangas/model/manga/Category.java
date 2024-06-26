package com.kyou.mangas.model.manga;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Manga> mangas;

    public void addManga(Manga manga){
        this.mangas.add(manga);
    }
}
