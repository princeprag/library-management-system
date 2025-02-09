package com.example.LibraryManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {
	
	private final AuthorRepository authorRepository;
	
	public Author addAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public List<Author> getAuthors(){
		return authorRepository.findAll();
	}
	

}
