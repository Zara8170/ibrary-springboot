package com.example.ibrary.service.category;

import com.example.ibrary.data.dto.category.CategoryDTO;
import com.example.ibrary.data.entity.category.Category;
import java.util.List;

public interface CategoryService {

  List<CategoryDTO> getCategories(String name);

  default CategoryDTO toDTO(Category category) {
    if(category == null) {
      return null;
    }
    return CategoryDTO.builder()
        .id(category.getId())
        .name(category.getName())
        .bookCount(category.getBooks().size())
        .build();
  }

}
