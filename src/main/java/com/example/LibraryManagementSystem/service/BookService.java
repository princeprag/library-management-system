package com.example.LibraryManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	
    private final BookRepository bookRepository;
    
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> searchBooksByAuthor(String authorName) {
        return bookRepository.findByAuthor_NameContainingIgnoreCase(authorName);
    }
    
    public List<Book> searchBooksByTitlePartial(String title) {
        return bookRepository.findByTitlePartialContainingIgnoreCase(title);
    }

    public List<Book> searchBooksByAuthorPartial(String authorName) {
        return bookRepository.findByAuthorPartialContainingIgnoreCase(authorName);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}