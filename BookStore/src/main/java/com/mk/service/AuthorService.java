package com.mk.service;

import java.util.List;

import com.mk.data.entities.Author;

public interface AuthorService {

  List<Author> getAllAuthor();

  Author saveAuthor(Author author);

  Author findAuthorById(Long id);

  void delteById(Long id);
}