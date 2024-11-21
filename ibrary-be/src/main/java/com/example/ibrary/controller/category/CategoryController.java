package com.example.ibrary.controller.category;

import com.example.ibrary.data.dto.category.CategoryDTO;
import com.example.ibrary.service.category.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<CategoryDTO>> getCategoryByName(@RequestParam(required = false) String name) {
    return ResponseEntity.ok(categoryService.getCategories(name));
  }
}
