package com.example.ibrary.service.book;

import com.example.ibrary.data.dto.book.BookDTO;
import com.example.ibrary.data.entity.book.Book;
import java.util.List;

public interface BookService {

  /**
   * 책 전체 출력
   * @return  책목록
   */
  List<BookDTO> getBooks();

  /**
   * 책 상세 페이지
   * @param id
   * @return 책 한개 정보
   */
  BookDTO getBook(Long id);

  /**
   * 책 추가
   * @param bookDTO
   */
  BookDTO createBook(BookDTO bookDTO);

  /**
   * 책 수정(렌트만)
   * @param id
   * @param bookDTO
   */
  BookDTO updateBook(Long id,BookDTO bookDTO);

  /**
   * 책 삭제
   * @param id
   */
  void deleteBook(Long id);

  /**
   * 대여 상태 확인
   * @param id
   * @return 대여 상태
   */
  boolean checkRentalStatus(Long id);

  /**
   * 대여/반납 처리
   * @param id
   * @return 변경된 대여 상태 정보
   */
  BookDTO toggleRentalStatus(Long id);

  // entity -> dto
  default BookDTO toDTO(Book book) {
    return BookDTO.builder()
        .id(book.getId())
        .title(book.getTitle())
        .author(book.getAuthor())
        .rented(book.isRented())
        .imgsrc(book.getImgsrc())
        .description(book.getDescription())
        .publisher(book.getPublisher())
        .categoryId(book.getCategory() != null ? book.getCategory().getId() : null)
        .categoryName(book.getCategory() != null ? book.getCategory().getName() : null)
        .build();
  }

  // dto -> entity
  default Book toEntity(BookDTO bookDTO) {
    return Book.builder()
        .title(bookDTO.getTitle())
        .author(bookDTO.getAuthor())
        .publisher(bookDTO.getPublisher())
        .rented(bookDTO.isRented())
        .description(bookDTO.getDescription())
        .imgsrc("http://via.placeholder.com/150x150/00ff00")
        .build();
  }

}
