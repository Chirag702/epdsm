package com.onefactor.epdsm.category.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onefactor.epdsm.category.entity.Category;
import com.onefactor.epdsm.category.repository.CategoryRepository;
import com.onefactor.epdsm.category.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> updateCategory(Integer id, Category categoryDetails) {
        return categoryRepository.findById(id).map(category -> {
            category.setTitle(categoryDetails.getTitle());
            category.setParentCategory(categoryDetails.getParentCategory());
            category.setParentCategoryPath(categoryDetails.getParentCategoryPath());
            category.setShowOn(categoryDetails.getShowOn());
            category.setStatus(categoryDetails.getStatus());
            return categoryRepository.save(category);
        });
    }

    @Override
    public boolean deleteCategory(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
