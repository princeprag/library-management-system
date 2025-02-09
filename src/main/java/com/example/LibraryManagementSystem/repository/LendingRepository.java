package com.example.LibraryManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.entity.Lending;
import com.example.LibraryManagementSystem.entity.Student;

@Repository
public interface LendingRepository extends JpaRepository<Lending, Long> {
    List<Lending> findByStudent(Student student);
    List<Lending> findByBook(Book book);
}
