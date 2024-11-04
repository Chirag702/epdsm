package com.onefactor.epdsm.category.service;

import java.util.List;
import java.util.Optional;

import com.onefactor.epdsm.category.entity.Category;

public interface CategoryService {

	List<Category> getAllCategories();

	Optional<Category> getCategoryById(Integer id);

	Category createCategory(Category category);

	Optional<Category> updateCategory(Integer id, Category category);

	boolean deleteCategory(Integer id);
}
