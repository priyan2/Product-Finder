package com.example.ProductFinder.FindProduct.Service.ServiceImpl;
import com.example.ProductFinder.FindProduct.Entity.Category;
import com.example.ProductFinder.FindProduct.Repository.CategoryRepository;
import com.example.ProductFinder.FindProduct.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        Optional<Category> existing = categoryRepository.findByCategoryName(category.getCategoryName());
        if (existing.isPresent()) {
            return existing.get(); // or throw error or skip saving
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }
    
    @Override
    public Category updateCategory(int id, Category newCategory) {
        Category existing = getCategoryById(id);
        if (existing != null) {
            existing.setCategoryName(newCategory.getCategoryName());
            return categoryRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
