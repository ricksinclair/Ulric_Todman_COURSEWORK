package com.company.CoffeeInventoryDaoUlricTodman;


import com.company.CoffeeInventoryDaoUlricTodman.dao.CoffeeInventoryDao;
import com.company.CoffeeInventoryDaoUlricTodman.model.Coffee;
import com.company.CoffeeInventoryDaoUlricTodman.model.Roaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

    import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class  CoffeeInventoryDaoTest {

    @Autowired
    protected CoffeeInventoryDao dao;

    @Before
    public void setUp() throws Exception {
        //clean out the test db
        List<Coffee> cList = dao.getAllCoffee();
        cList.forEach(coffee -> dao.deleteCoffee(coffee.getCoffeeId()));

        List<Roaster> rList = dao.getAllRoasters();
        rList.forEach(roaster -> dao.deleteRoaster(roaster.getRoasterId()));
    }


    @Test
    public void addGetDeleteCoffee() {
        Roaster roaster = new Roaster();
        roaster.setName("Rick's Roasts");
        roaster.setStreet("25th and Broadway");
        roaster.setCity("New York");
        roaster.setState("NY");
        roaster.setPostalCode("10019");
        roaster.setPhone("2128675309");
        roaster.setEmail("Roaster@RicksRoasts.com");
        roaster.setNote("This is some good stuff");
        roaster = dao.addRoaster(roaster);
        Roaster roaster1 = dao.getRoaster(roaster.getRoasterId());
        assertEquals(roaster1, roaster1);

        Coffee coffee = new Coffee();
        coffee.setName("African Gold Roast");
        coffee.setDescription("Beautifully roasted West African bean blend");
        coffee.setCount(20);
        coffee.setType("Dark");
        coffee.setUnitPrice(14.23);
        coffee.setRoasterId(roaster.getRoasterId());

        coffee = dao.addCoffee(coffee);
        Coffee coffee1 = dao.getCoffee(coffee.getCoffeeId());
        assertEquals(coffee, coffee1);
        dao.deleteCoffee(coffee.getCoffeeId());
        coffee1 = dao.getCoffee(coffee.getCoffeeId());

        assertNull(coffee1);
        dao.deleteRoaster(roaster.getRoasterId());
        roaster1 = dao.getRoaster(roaster.getRoasterId());
        assertNull(roaster1);

    }

}
