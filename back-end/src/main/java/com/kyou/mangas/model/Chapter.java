package com.kyou.mangas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double chapter;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Page> pages;

    public void addPage(Page page) {
        this.pages.add(page);
    }
}
