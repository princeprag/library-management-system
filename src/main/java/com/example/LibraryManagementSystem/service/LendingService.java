package com.example.LibraryManagementSystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.entity.Lending;
import com.example.LibraryManagementSystem.entity.Student;
import com.example.LibraryManagementSystem.enums.AvailabilityStatus;
import com.example.LibraryManagementSystem.repository.BookRepository;
import com.example.LibraryManagementSystem.repository.LendingRepository;
import com.example.LibraryManagementSystem.repository.StudentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LendingService {
    private final LendingRepository lendingRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;
    
	@Transactional
    public Lending borrowBook(Long bookId, Long studentId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();

        if (book.getAvailabilityStatus() == AvailabilityStatus.BORROWED) {
            throw new IllegalStateException("Book is already borrowed");
        }
        
        book.setAvailabilityStatus(AvailabilityStatus.BORROWED);
        bookRepository.save(book);
        Lending lending = new Lending(null, book, student, LocalDate.now(), null);
        return lendingRepository.save(lending);
    }

    @Transactional
    public Lending returnBook(Long lendingId) {
        Lending lending = lendingRepository.findById(lendingId).orElseThrow();
        lending.setReturnDate(LocalDate.now());
        Book book = lending.getBook();
        book.setAvailabilityStatus(AvailabilityStatus.AVAILABLE);
        bookRepository.save(book);
        
        return lendingRepository.save(lending);
    }
    
    public List<Lending> getAllLending(){
    	return lendingRepository.findAll();
    }
}