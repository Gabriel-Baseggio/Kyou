package com.kyou.mangas.entity.manga;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kyou.mangas.controller.dto.PageGetDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    private String pageImage;

    @ManyToOne
    private Chapter chapter;

    public PageGetDTO toDTO() {
        return new PageGetDTO(this.number, this.pageImage);
    }
}
