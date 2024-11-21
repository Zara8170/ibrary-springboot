package com.example.ibrary.data.dao.category;

import com.example.ibrary.data.entity.category.Category;
import java.util.List;

public interface CategoryDAO {

  List<Category> getCategories(String name);
}
