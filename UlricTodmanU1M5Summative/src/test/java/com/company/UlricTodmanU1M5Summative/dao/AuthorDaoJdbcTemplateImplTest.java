package com.company.UlricTodmanU1M5Summative.dao;


import com.company.UlricTodmanU1M5Summative.model.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoJdbcTemplateImplTest {
    @Autowired
    protected AuthorDao authorDao;

    @Before
    public void setUp() throws Exception {
        //clean out the test db
        List<Author> authorList = authorDao.getAllAuthors();
        authorList.stream().forEach(author -> authorDao.deleteAuthor(author.getAuthorId()));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addGetDeleteAuthor(){
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
        Author author2;
        author2 = authorDao.getAuthor(author.getAuthorId());
        assertEquals(author, author2);
        authorDao.deleteAuthor(author.getAuthorId());
        author2 = authorDao.getAuthor(author.getAuthorId());
        assertNull(author2);
    }

    @Test
    public void getAllAuthors(){
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
        author2.setLastName("Cage");
        author2.setStreet("123 FAQUE BOULEVARD");
        author2.setCity("Beverly Hills");
        author2.setState("CA");
        author2.setPostalCode("90210");
        author2.setPhone("323-555-2332");
        author2.setEmail("johnny.cage@midway.com");

        author2 = authorDao.addAuthor(author2);

        List<Author> authorList = authorDao.getAllAuthors();
        assertEquals(authorList.size(), 2);
    }

    @Test
    public void updateAuthor(){
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setStreet("123 Main Street");
        author.setCity("New York");
        author.setState("NY");
        author.setPostalCode("10013");
        author.setPhone("212-555-2332");
        author.setEmail("john.doe@gmail.com");

        authorDao.addAuthor(author);

        author.setFirstName("Johnny");
        author.setLastName("Cage");
        author.setEmail("Johnny.Cage@UPDATED.com");
        authorDao.updateAuthor(author);
        Author author2 = authorDao.getAuthor(author.getAuthorId());
        assertEquals(author, author2);
    }
    

}
