package com.example.ibrary.service.book;

import com.example.ibrary.data.dao.book.BookDAO;
import com.example.ibrary.data.dao.category.CategoryDAO;
import com.example.ibrary.data.dto.book.BookDTO;
import com.example.ibrary.data.entity.book.Book;
import com.example.ibrary.data.entity.category.Category;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

  private final BookDAO bookDAO;
  private final CategoryDAO categoryDAO;

  @Override
  public List<BookDTO> getBooks(){
    return bookDAO.getAllBooks().stream()
        .map(this::toDTO)
        .toList();
  }

  @Override
  public BookDTO getBook(Long id) {
    Book book = bookDAO.getBook(id);
    return toDTO(book);
  }

  @Override
  public BookDTO createBook(BookDTO bookDTO) {

    Category category = bookDTO.getCategoryId() != null // 카테고리 id가 있는지 없는지 부터 확인하고
        ? categoryDAO.getCategories(null).stream()// 전체 목록 가져와서
        .filter(e -> e.getId().equals(bookDTO.getCategoryId()))// 입력받은 카테고리 ID와 일치하는 카테고리 찾고
        .findFirst() // 첫 번째로 찾은 카테고리 선택해서
        .orElseThrow(()-> new IllegalArgumentException("category not found")) // 업으면 예외처리하고
        : null; // id null 이면 null 할당

    Book book = toEntity(bookDTO);
    book.setCategory(category);

    Book saveBook = bookDAO.addBook(book);
    return toDTO(saveBook);
  }

  @Override
  public BookDTO updateBook(Long id, BookDTO bookDTO) {
    Category category = bookDTO.getCategoryId() != null
        ? categoryDAO.getCategories(null).stream()
        .filter(c -> c.getId().equals(bookDTO.getCategoryId()))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Category not found"))
        : null;

    Book updatedBook = toEntity(bookDTO);
    updatedBook.setId(id);  // ID 설정 중요
    updatedBook.setCategory(category);  // 카테고리 설정

    Book resultBook = bookDAO.updateBook(id, updatedBook);
    return toDTO(resultBook);
  }

  @Override
  public void deleteBook(Long id) {
    bookDAO.deleteBook(id);
  }

  @Override
  public boolean checkRentalStatus(Long id) {
    return bookDAO.checkRentalStatus(id);
  }

  @Override
  public BookDTO toggleRentalStatus(Long id) {
    Book book = bookDAO.toggleRentalStatus(id);
    return toDTO(book);
  }

}
