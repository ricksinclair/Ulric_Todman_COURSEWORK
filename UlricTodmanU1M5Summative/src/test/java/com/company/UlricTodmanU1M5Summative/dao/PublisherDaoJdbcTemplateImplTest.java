package com.company.UlricTodmanU1M5Summative.dao;

import com.company.UlricTodmanU1M5Summative.model.Publisher;
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
public class PublisherDaoJdbcTemplateImplTest {
    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        //clean out the test db
        List<Publisher> publisherList = publisherDao.getAllPublishers();
        publisherList.stream().forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisherId()));
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("123 Sesame Place");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10013");
        publisher.setEmail("randomEmail@randomhouse.com");
        publisher.setPhone("212-867-5309");
        publisher = publisherDao.addPublisher(publisher);
        Publisher publisher2;
        publisher2 = publisherDao.getPublisher(publisher.getPublisherId());
        assertEquals(publisher, publisher2);
        publisherDao.deletePublisher(publisher.getPublisherId());
        publisher2 = publisherDao.getPublisher(publisher.getPublisherId());
        assertNull(publisher2);
    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("123 Sesame Place");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10013");
        publisher.setEmail("randomEmail@randomhouse.com");
        publisher.setPhone("212-867-5309");

        publisherDao.addPublisher(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Harper Collins");
        publisher2.setStreet("546 Memory Lane");
        publisher2.setCity("Los Angeles");
        publisher2.setState("CA");
        publisher2.setPostalCode("90213");
        publisher2.setEmail("randomEmail@HarperCollins.com");
        publisher2.setPhone("323-867-5309");

        publisherDao.addPublisher(publisher2);

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        assertEquals(publisherList.size(), 2);
    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("123 Sesame Place");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10013");
        publisher.setEmail("randomEmail@randomhouse.com");
        publisher.setPhone("212-867-5309");

        publisherDao.addPublisher(publisher);

        publisher.setName("UPDATED RECORD");

        publisherDao.updatePublisher(publisher);
        Publisher publisher2 = publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher, publisher2);


    }
}
