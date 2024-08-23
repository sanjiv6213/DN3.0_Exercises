package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();
    private long idCounter = 1;

    // GET /books - Retrieve all books or filtered books
    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) String author) {

        Stream<Book> bookStream = books.stream();

        if (title != null && !title.isEmpty()) {
            bookStream = bookStream.filter(book -> book.getTitle().equalsIgnoreCase(title));
        }

        if (author != null && !author.isEmpty()) {
            bookStream = bookStream.filter(book -> book.getAuthor().equalsIgnoreCase(author));
        }

        List<BookDTO> filteredBooks = bookStream
                .map(BookMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Books-Fetched");

        return ResponseEntity.ok().headers(headers).body(filteredBooks);
    }

    // GET /books/{id} - Retrieve a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(book -> ResponseEntity.ok().body(BookMapper.INSTANCE.toDTO(book)))
                .orElseThrow(() -> new ResourceNotFoundException("Book with ID " + id + " not found"));
    }

    // POST /books - Create a new book
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        book.setId(idCounter++);
        books.add(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Created");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(BookMapper.INSTANCE.toDTO(book));
    }

    // PUT /books/{id} - Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Optional<Book> existingBookOpt = books.stream().filter(b -> b.getId().equals(id)).findFirst();
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(bookDTO.getTitle());
            existingBook.setAuthor(bookDTO.getAuthor());
            existingBook.setPrice(bookDTO.getPrice());
            existingBook.setIsbn(bookDTO.getIsbn());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Updated");
            return ResponseEntity.ok().headers(headers).body(BookMapper.INSTANCE.toDTO(existingBook));
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Not-Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }
    }

    // DELETE /books/{id} - Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean removed = books.removeIf(b -> b.getId().equals(id));
        if (removed) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Deleted");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Not-Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }
    }
}
