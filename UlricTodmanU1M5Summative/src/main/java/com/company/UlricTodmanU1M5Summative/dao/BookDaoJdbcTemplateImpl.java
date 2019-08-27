package com.company.UlricTodmanU1M5Summative.dao;

import com.company.UlricTodmanU1M5Summative.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao {
    //Prepared Statements.
    private static final String INSERT_BOOK_SQL =
            "INSERT INTO book (isbn, publish_date, author_id, publisher_id, title, price) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BOOK_SQL =
            "SELECT * FROM book WHERE book_id=?";
    private static final String SELECT_ALL_BOOKS_SQL =
            "SELECT * FROM book";
    private static final String SELECT_BOOKS_BY_AUTHOR_SQL =
            "SELECT * FROM book where author_id = ?";
    private static final String UPDATE_BOOK_SQL =
            "UPDATE book SET isbn = ?, publish_date = ?, author_id = ?, publisher_id = ?, title = ?, price = ? WHERE book_id = ?";
    private static final String DELETE_BOOK_SQL =
            "DELETE FROM book WHERE book_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }

    //Object mapper helper method
    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException{
        Book book = new Book();

        book.setTitle(rs.getString("title"));
        book.setBookId(rs.getInt("book_id"));
        book.setPublishDate(rs.getDate("publish_date"));
        book.setAuthorId(rs.getInt("author_id"));
        book.setPrice(rs.getBigDecimal("price"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setIsbn(rs.getString("isbn"));

        return book;
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        // "INSERT INTO book (isbn, publish_date, author_id, publisher_id, title, price) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getPublisherId(),
                book.getTitle(),
                book.getPrice());

        int id = jdbcTemplate.queryForObject("SELECT last_insert_id()", Integer.class);
        book.setBookId(id);
        return book;
    }

    @Override
    public Book getBook(int bookId) {
        try{
            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, bookId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    @Override
    public List<Book> getBooksByAuthor(int authorId) {
        return jdbcTemplate.query(SELECT_BOOKS_BY_AUTHOR_SQL, this::mapRowToBook, authorId);
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getPublisherId(),
                book.getTitle(),
                book.getPrice(),
                book.getBookId()
                );
    }

    @Override
    public void deleteBook(int bookId) {
        jdbcTemplate.update(DELETE_BOOK_SQL, bookId);
    }
}
