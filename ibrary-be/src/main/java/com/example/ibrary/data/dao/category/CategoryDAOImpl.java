package com.example.ibrary.data.dao.category;

import com.example.ibrary.data.entity.category.Category;
import com.example.ibrary.data.repository.category.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryDAOImpl implements CategoryDAO {

  private final CategoryRepository categoryRepository;

  @Override
  public List<Category> getCategories(String name) {
    if(name != null && !name.isEmpty()) {
      List<Category> categoryList= new ArrayList<>();
      categoryList.add(categoryRepository.findByNameWithBooks(name));
      return categoryList;
    }
    else {
      return categoryRepository.findAll();
    }
  }
}
