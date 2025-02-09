package com.example.LibraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryManagementSystem.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
