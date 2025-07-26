package com.example.ProductFinder.FindProduct.Controller;

import com.example.ProductFinder.FindProduct.Entity.Category;
import com.example.ProductFinder.FindProduct.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category-ui")
public class CategoryViewController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String viewAllCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "category_form";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/category-ui/list";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable int id, Model model) {
        Category existing = categoryService.getCategoryById(id);
        model.addAttribute("category", existing);
        return "category_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return "redirect:/category-ui/list";
    }
}
