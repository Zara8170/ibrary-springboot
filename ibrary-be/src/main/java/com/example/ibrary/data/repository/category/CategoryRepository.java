package com.example.ibrary.data.repository.category;

import com.example.ibrary.data.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Query("SELECT c from Category c left join FETCH c.books where c.name = :name")
  Category findByNameWithBooks(String name);
}
