package com.example.ibrary.data.repository.book;

import com.example.ibrary.data.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
