package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.model.Book;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();
    private long idCounter = 1;
    
    @Operation(summary = "Get all books", description = "Retrieve a list of all books")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Books retrieved successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    // GET /books - Retrieve all books or filtered books
    @GetMapping
    public ResponseEntity<List<EntityModel<Book>>> getBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) String author) {

        Stream<Book> bookStream = books.stream();

        if (title != null && !title.isEmpty()) {
            bookStream = bookStream.filter(book -> book.getTitle().equalsIgnoreCase(title));
        }

        if (author != null && !author.isEmpty()) {
            bookStream = bookStream.filter(book -> book.getAuthor().equalsIgnoreCase(author));
        }

        List<EntityModel<Book>> bookResources = bookStream
                .map(book -> EntityModel.of(book,
                        linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel(),
                        linkTo(methodOn(BookController.class).getBooks(null, null)).withRel("books")))
                .collect(Collectors.toList());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Books-Fetched");

        return ResponseEntity.ok().headers(headers).body(bookResources);
    }

    // GET /books/{id} - Retrieve a book by its ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Book>> getBookById(@PathVariable("id") Long id) {
        Book book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Book with ID " + id + " not found"));

        EntityModel<Book> bookResource = EntityModel.of(book,
                linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel(),
                linkTo(methodOn(BookController.class).getBooks(null, null)).withRel("books"));

        return ResponseEntity.ok().body(bookResource);
    }

    // POST /books - Create a new book
    @PostMapping
    public ResponseEntity<EntityModel<Book>> createBook(@RequestBody Book book) {
        book.setId(idCounter++);
        books.add(book);

        EntityModel<Book> bookResource = EntityModel.of(book,
                linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel(),
                linkTo(methodOn(BookController.class).getBooks(null, null)).withRel("books"));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Created");

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(bookResource);
    }

    // PUT /books/{id} - Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Book>> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> existingBookOpt = books.stream().filter(b -> b.getId().equals(id)).findFirst();
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setIsbn(updatedBook.getIsbn());

            EntityModel<Book> bookResource = EntityModel.of(existingBook,
                    linkTo(methodOn(BookController.class).getBookById(existingBook.getId())).withSelfRel(),
                    linkTo(methodOn(BookController.class).getBooks(null, null)).withRel("books"));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Updated");

            return ResponseEntity.ok().headers(headers).body(bookResource);
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
