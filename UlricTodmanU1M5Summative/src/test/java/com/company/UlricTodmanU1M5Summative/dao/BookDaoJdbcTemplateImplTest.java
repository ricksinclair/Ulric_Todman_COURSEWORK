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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        List<Book> bookList = bookDao.getAllBooks();
        bookList.stream().forEach(book -> bookDao.deleteBook(book.getBookId()));

        List<Author> authorList = authorDao.getAllAuthors();
        authorList.stream().forEach(author -> authorDao.deleteAuthor(author.getAuthorId()));
        List<Publisher> publisherList = publisherDao.getAllPublishers();
        publisherList.stream().forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisherId()));


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

        Book book2 = bookDao.getBook(book1.getBookId());
        assertEquals(book1, book2);
        bookDao.deleteBook(book1.getBookId());
        book2 = bookDao.getBook(book1.getBookId());
        assertNull(book2);
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
        List<Book> bookList = bookDao.getAllBooks();
        assertEquals(bookList.size(), 2);

    }

    @Test
    public void getBooksByAuthor(){
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
        Author author2 = new Author();
        author2.setFirstName("Johnny");
        author2.setLastName("Dope");
        author2.setStreet("456 Main Street");
        author2.setCity("New York");
        author2.setState("NY");
        author2.setPostalCode("10026");
        author2.setPhone("212-555-2332");
        author2.setEmail("johnny@hotmail.com");
        author2 = authorDao.addAuthor(author2);
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

        Book book3 = new Book();
        book3.setIsbn("82973918673");
        book3.setAuthorId(author2.getAuthorId());
        book3.setPublisherId(publisher.getPublisherId());
        book3.setPrice(BigDecimal.valueOf(17.99));
        book3.setPublishDate(Date.valueOf("2019-08-26"));
        book3.setTitle("Java vs Javascript: Tales of a rivalry misunderstood");
        book3 = bookDao.addBook(book3);
        List<Book> bookList = bookDao.getBooksByAuthor(author.getAuthorId());
        assertEquals(bookList.size(), 2);

        List<Book> fullBookList = bookDao.getAllBooks();
        assertEquals(fullBookList.size(), 3);

    }
    @Test
    public void updateBook(){
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

        book1.setTitle("A WORK IN PROGRESS: MY LIFE CODING JAVA");
        bookDao.updateBook(book1);
        Book book2 = bookDao.getBook(book1.getBookId());
        assertEquals(book1, book2);
    }


}
