package com.example.LibraryManagementSystem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagementSystem.entity.Lending;
import com.example.LibraryManagementSystem.service.LendingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lendings")
@RequiredArgsConstructor
public class LendingController {
    private final LendingService lendingService;

    @PostMapping("/borrow")
    public ResponseEntity<Lending> borrowBook(@RequestParam Long bookId, @RequestParam Long studentId) {
        return ResponseEntity.ok(lendingService.borrowBook(bookId, studentId));
    }

    @PostMapping("/return/{lendingId}")
    public ResponseEntity<Lending> returnBook(@PathVariable Long lendingId) {
        return ResponseEntity.ok(lendingService.returnBook(lendingId));
    }
    
    @GetMapping
    public ResponseEntity<List<Lending>> getAllLendings() {
        return ResponseEntity.ok(lendingService.getAllLending());
    }
}
