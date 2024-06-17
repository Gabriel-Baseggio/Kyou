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

    private Set<String> alternativeTitles;

    private int numberOfChapters;

    @Column(precision = 2)
    private double rating;

    private String description;

    private Status status;

    @OneToMany
    private Set<Category> categories;

    @OneToMany
    private List<Chapter> chapters;

}
