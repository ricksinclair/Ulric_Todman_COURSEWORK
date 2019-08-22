package com.company.motoinventoryjdbctemplatedao.dao;

import com.company.motoinventoryjdbctemplatedao.model.Motorcycle;
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
public class MotoInventoryDaoTest {

    @Autowired
    protected MotoInventoryDao dao;


    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Motorcycle> mList = dao.getAllMotorcycles();

        mList.stream()
                .forEach(motorcycle -> dao.deleteMotorcycle(motorcycle.getId()));
    }

    @Test
    public void getMotorcycle() {
    }

    @Test
    public void addGetDeleteMotorcycle() {

        Motorcycle moto = new Motorcycle();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("black");

        moto = dao.addMotorcycle(moto);

        Motorcycle moto2 = dao.getMotorcycle(moto.getId());

        assertEquals(moto, moto2);

        dao.deleteMotorcycle(moto.getId());

        moto2 = dao.getMotorcycle(moto.getId());

        assertNull(moto2);
    }

    @Test
    public void getAllMotorcycles(){
        Motorcycle moto = new Motorcycle();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("black");

        dao.addMotorcycle(moto);

        moto = new Motorcycle();
        moto.setVin("3333");
        moto.setMake("Ferrari");
        moto.setModel("Enzo");
        moto.setYear("2012");
        moto.setColor("Pink");

        dao.addMotorcycle(moto);
        List<Motorcycle> motoList = dao.getAllMotorcycles();
        assertEquals(motoList.size(), 2);
    }

    @Test
    public void getMotorcyclesByMake(){
        Motorcycle moto = new Motorcycle();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("black");

        dao.addMotorcycle(moto);

        moto = new Motorcycle();
        moto.setVin("5555");
        moto.setMake("Ferrari");
        moto.setModel("Enzo");
        moto.setYear("2012");
        moto.setColor("Pink");

        dao.addMotorcycle(moto);

        moto = new Motorcycle();
        moto.setVin("3333");
        moto.setMake("Ferrari");
        moto.setModel("Expensivo");
        moto.setYear("2012");
        moto.setColor("Pink");

        dao.addMotorcycle(moto);
        List<Motorcycle> mList = dao.getMotorcyclesByMake("Ferrari");

        assertEquals(mList.size(), 2);


        mList = dao.getMotorcyclesByMake("Honda");
        assertEquals(mList.size(), 1);
    }
}
