package com.company.UlricTodmanU1M5Summative.dao;

import com.company.UlricTodmanU1M5Summative.model.Author;
import com.company.UlricTodmanU1M5Summative.model.Book;
import com.company.UlricTodmanU1M5Summative.model.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoJdbcTemplateImplTest {
    @Autowired
    protected PublisherDao publisherDao;
    @Autowired
    protected  AuthorDao authorDao;
    @Autowired
    protected BookDao bookDao;

    @Before
    public void setUp() throws Exception{
        //clean out the test db
        List<Author> authorList = authorDao.getAllAuthors();
        authorList.stream().forEach(author -> authorDao.deleteAuthor(author.getAuthorId()));
        List<Publisher> publisherList = publisherDao.getAllPublishers();
        publisherList.stream().forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisherId()));
        List<Book> bookList = bookDao.getAllBooks();
        bookList.stream().forEach(book -> bookDao.deleteBook(book.getBookId()));


    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void addGetDeleteBook(){
        //add publishers and authors as prerequisite table entries/foreign keys.
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("123 Sesame Place");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10013");
        publisher.setEmail("randomEmail@randomhouse.com");
        publisher.setPhone("212-867-5309");
        publisher = publisherDao.addPublisher(publisher);
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setStreet("123 Main Street");
        author.setCity("New York");
        author.setState("NY");
        author.setPostalCode("10013");
        author.setPhone("212-555-2332");
        author.setEmail("john.doe@gmail.com");
        author = authorDao.addAuthor(author);

        Book book1 = new Book();
        book1.setIsbn("82973918273");
        book1.setAuthorId(author.getAuthorId());
        book1.setPublisherId(publisher.getPublisherId());
        book1.setPrice(BigDecimal.valueOf(17.99));
        book1.setPublishDate(Date.valueOf("2019-08-26"));
        book1.setTitle("Java: A love story");
        book1 = bookDao.addBook(book1);

    }

    @Test
    public void getAllBooks(){
        //add publishers and authors as prerequisite table entries/foreign keys.
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("123 Sesame Place");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10013");
        publisher.setEmail("randomEmail@randomhouse.com");
        publisher.setPhone("212-867-5309");
        publisher = publisherDao.addPublisher(publisher);
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setStreet("123 Main Street");
        author.setCity("New York");
        author.setState("NY");
        author.setPostalCode("10013");
        author.setPhone("212-555-2332");
        author.setEmail("john.doe@gmail.com");
        author = authorDao.addAuthor(author);
        Book book1 = new Book();
        book1.setIsbn("82973918273");
        book1.setAuthorId(author.getAuthorId());
        book1.setPublisherId(publisher.getPublisherId());
        book1.setPrice(BigDecimal.valueOf(17.99));
        book1.setPublishDate(Date.valueOf("2019-08-26"));
        book1.setTitle("Java: A love story");
        book1 = bookDao.addBook(book1);
        Book book2 = new Book();
        book2.setIsbn("82973918673");
        book2.setAuthorId(author.getAuthorId());
        book2.setPublisherId(publisher.getPublisherId());
        book2.setPrice(BigDecimal.valueOf(17.99));
        book2.setPublishDate(Date.valueOf("2019-08-26"));
        book2.setTitle("Java vs Javascript: Tales of a rivalry misunderstood");
        book2 = bookDao.addBook(book2);

    }


}
