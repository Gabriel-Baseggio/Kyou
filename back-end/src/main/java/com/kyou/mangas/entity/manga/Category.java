package com.kyou.mangas.entity.manga;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kyou.mangas.controller.dto.MangaCategoryGetDTO;
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

    public MangaCategoryGetDTO toDTO() {
        return new MangaCategoryGetDTO(this.category);
    }
}
