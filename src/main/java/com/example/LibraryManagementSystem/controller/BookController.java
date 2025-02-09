package com.example.LibraryManagementSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
        if (title != null) {
            return ResponseEntity.ok(bookService.searchBooksByTitle(title));
        } else if (author != null) {
            return ResponseEntity.ok(bookService.searchBooksByAuthor(author));
        }
        return ResponseEntity.badRequest().build();
    }
    
    @GetMapping("/search-partial")
    public ResponseEntity<List<Book>> searchBooksPartial(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
        if (title != null && !title.isEmpty()) {
            return ResponseEntity.ok(bookService.searchBooksByTitlePartial(title));
        } else if (author != null && !author.isEmpty()) {
            return ResponseEntity.ok(bookService.searchBooksByAuthorPartial(author));
        }
        return ResponseEntity.badRequest().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
