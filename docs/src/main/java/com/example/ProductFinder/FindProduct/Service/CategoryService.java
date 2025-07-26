package com.example.ProductFinder.FindProduct.Service;

import com.example.ProductFinder.FindProduct.Entity.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    Category updateCategory(int id, Category category);
    void deleteCategory(int id);
}
