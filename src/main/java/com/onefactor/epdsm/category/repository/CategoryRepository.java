package com.onefactor.epdsm.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefactor.epdsm.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
