package com.onefactor.epdsm.category.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @Column(name = "parent_category", nullable = false, columnDefinition = "int unsigned default '0'")
    private Integer parentCategory;

    @Column(name = "parent_category_path", length = 50, nullable = false)
    private String parentCategoryPath;

    @Column(name = "show_on", length = 1, nullable = false, columnDefinition = "char(1) default 'B'")
    private String showOn;

    @Column(name = "status", length = 1, nullable = false, columnDefinition = "char(1) default 'A'")
    private String status;


}
