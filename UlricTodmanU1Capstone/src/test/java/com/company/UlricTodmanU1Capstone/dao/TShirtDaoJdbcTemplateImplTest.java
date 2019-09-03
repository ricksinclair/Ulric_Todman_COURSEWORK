package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoJdbcTemplateImplTest {

    @Autowired
    TShirtDao tShirtDao;

    @Before
    public void setUp() {
        List<TShirt> tShirtList = tShirtDao.getAllTShirts();
        tShirtList.forEach(tShirt -> tShirtDao.deleteTShirt(tShirt.getTShirtId()));
    }


    @Test
    public void addGetDeleteTShirts() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("XL");
        tShirt.setColor("Black");
        tShirt.setDescription("Black Bella Canvas shirt featuring COD theme");
        tShirt.setPrice(new BigDecimal("24.95"));
        tShirt.setQuantity(20);
        tShirt = tShirtDao.addTShirt(tShirt);
        TShirt tShirt2 = tShirtDao.getTShirt(tShirt.getTShirtId());
        assertEquals(tShirt, tShirt2);
        tShirtDao.deleteTShirt(tShirt.getTShirtId());
        tShirt2 = tShirtDao.getTShirt(tShirt.getTShirtId());
        assertNull(tShirt2);
    }

    @Test
    public void updateTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("XL");
        tShirt.setColor("Black");
        tShirt.setDescription("Black Bella Canvas shirt featuring COD theme");
        tShirt.setPrice(new BigDecimal("24.95"));
        tShirt.setQuantity(20);
        tShirt = tShirtDao.addTShirt(tShirt);
        tShirt.setPrice(new BigDecimal("29.99"));
        tShirtDao.updateTShirt(tShirt);
        TShirt tShirt2 = tShirtDao.getTShirt(tShirt.getTShirtId());
        assertEquals(tShirt, tShirt2);

    }
}
