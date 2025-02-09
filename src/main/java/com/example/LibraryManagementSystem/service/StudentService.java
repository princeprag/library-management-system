package com.example.LibraryManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LibraryManagementSystem.entity.Student;
import com.example.LibraryManagementSystem.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}