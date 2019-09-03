package com.company.UlricTodmanU1M5Summative.dao;

import com.company.UlricTodmanU1M5Summative.model.Book;

import java.util.List;

public interface BookDao {

    public Book addBook(Book book);

    public Book getBook(int bookId);

    public List<Book> getAllBooks();

    public List<Book> getBooksByAuthor(int authorId);

    public void updateBook(Book book);

    public void deleteBook(int bookId);
}
