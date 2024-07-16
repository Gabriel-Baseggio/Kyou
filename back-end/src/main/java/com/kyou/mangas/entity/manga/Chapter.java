package com.kyou.mangas.entity.manga;

import com.kyou.mangas.controller.dto.MangaChapterGetDTO;
import com.kyou.mangas.controller.dto.PageGetDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double chapter;

    @ManyToOne
    private Manga manga;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Page> pages;

    public void addPage(Page page) {
        this.pages.add(page);
    }

    public MangaChapterGetDTO toDTO() {

        List<PageGetDTO> pages = this.pages.stream().map(Page::toDTO).toList();

        return new MangaChapterGetDTO(this.chapter, pages);
    }
}
