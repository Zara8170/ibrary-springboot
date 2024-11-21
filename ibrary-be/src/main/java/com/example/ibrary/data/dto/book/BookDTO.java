package com.example.ibrary.data.dto.book;

import com.example.ibrary.data.entity.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookDTO {

  private Long id;
  private String title;
  private boolean rented;
  private Long categoryId;
  private String categoryName;
  private String author;
  private String publisher;
  private String description;
  private String imgsrc;
}
