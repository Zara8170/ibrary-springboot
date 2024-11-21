package com.example.ibrary.data.dao.book;

import com.example.ibrary.data.entity.book.Book;
import com.example.ibrary.data.repository.book.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookDAO {

  private final BookRepository bookRepository;

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Book getBook(Long id) {
    return bookRepository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("Book not found"));
  }

  public Book addBook(Book book) {
    return bookRepository.save(book);
  }

  public Book updateBook(Long id, Book updatedBook) {
    Book book = bookRepository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("book not found"));

    book.setTitle(updatedBook.getTitle());
    book.setAuthor(updatedBook.getAuthor());
    book.setPublisher(updatedBook.getPublisher());
    book.setRented(updatedBook.isRented());
    book.setDescription(updatedBook.getDescription());
    book.setCategory(updatedBook.getCategory());

    return bookRepository.save(book);
  }

  public void deleteBook(Long id) {
    bookRepository.deleteById(id);
  }

  public boolean checkRentalStatus(Long id) {
    Book book = getBook(id);
    return book.isRented();
  }

  public Book toggleRentalStatus(Long id) {
    Book book = getBook(id);
    book.setRented(!book.isRented());
    return bookRepository.save(book);
  }
}
