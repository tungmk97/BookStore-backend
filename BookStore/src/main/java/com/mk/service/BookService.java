package com.mk.service;

import java.util.List;

import com.mk.data.entities.Book;

public interface BookService {
  List<Book> getAllBook();

  Book saveBook(Book book);

  Book findBookById(Long id);

  void deleteBookById(Long id);

}