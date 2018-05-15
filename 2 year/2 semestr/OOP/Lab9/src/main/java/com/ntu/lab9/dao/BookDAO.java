package com.ntu.Lab9.dao;

import java.util.List;

import com.ntu.Lab9.domain.Book;

public interface BookDAO {	
	
    Book getBookById(long id);
    List<Book> getBookByTitleAndAuthor(String title, String author);
    List<Book> getAllBooks();
    boolean insertBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(long id);

}
