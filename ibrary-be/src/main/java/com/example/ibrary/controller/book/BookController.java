package com.example.ibrary.controller.book;

import com.example.ibrary.data.dto.book.BookDTO;
import com.example.ibrary.service.book.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

  private final BookService bookService;

  /**
   * 책 모두 보기
   */
  @GetMapping
  public ResponseEntity<List<BookDTO>> getBooks() {
    return ResponseEntity.ok(bookService.getBooks());
  }

  /**
   * 책 상세 보기
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<BookDTO> detail(@PathVariable Long id) {
    return ResponseEntity.ok(bookService.getBook(id));
  }

  /**
   * 책 추가
   */
  @PostMapping
  public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
    BookDTO createBook = bookService.createBook(bookDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createBook);
  }

  /**
   * 책 수정
   */
  @PutMapping(value = "/{id}")
  public ResponseEntity<BookDTO> updateBook(@PathVariable Long id,@RequestBody BookDTO bookDTO) {
    BookDTO updatedBook = bookService.updateBook(id,bookDTO);
    return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
  }

  /**
   * 책 삭제
   */
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  /**
   * 대여 상태 확인
   */
  @GetMapping("/{id}/rental")
  public ResponseEntity<Boolean> checkRentalStatus(@PathVariable Long id) {
    return ResponseEntity.ok(bookService.checkRentalStatus(id));
  }

  /**
   * 대여 / 반납 처리
   */
  @PutMapping("/{id}/rental")
  public ResponseEntity<Void> updateRentalStatus(@PathVariable Long id) {
    bookService.toggleRentalStatus(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
