package com.company.UlricTodmanU1M5Summative.dao;

import com.company.UlricTodmanU1M5Summative.model.Author;

import java.util.List;

public interface AuthorDao {
    public Author addAuthor(Author author);
    public Author getAuthor(int authorId);
    public List<Author> getAllAuthors();
    public void updateAuthor(Author author);
    public void deleteAuthor(int authorId);

}
