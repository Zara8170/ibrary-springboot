package com.example.ibrary.service.category;

import com.example.ibrary.data.dao.category.CategoryDAO;
import com.example.ibrary.data.dao.category.CategoryDAOImpl;
import com.example.ibrary.data.dto.category.CategoryDTO;
import com.example.ibrary.data.entity.category.Category;
import com.example.ibrary.data.repository.category.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryDAO categoryDAO;

  @Override
  public List<CategoryDTO> getCategories(String name) {
    List<Category> categoList = categoryDAO.getCategories(name);
    return categoList.stream()
        .map(this::toDTO)
        .toList();
  }
}
