package com.ruthwik.nimap.test.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruthwik.nimap.test.entity.Category;
import com.ruthwik.nimap.test.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
    	System.out.println("CategoryController.getAllCategories()");
        return categoryService.getAllCategories(page, size);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
    	System.out.println("CategoryController.createCategory()");
    	System.out.println("Category: "+category);
        return categoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
    	System.out.println("CategoryController.getCategoryById()");
    	System.out.println("id: "+id);
        Optional<Category> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
    	System.out.println("id: "+id+"| categoryDetails: "+categoryDetails);
    	System.out.println("CategoryController.updateCategory()");
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    	System.out.println("CategoryController.deleteCategory()");
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
