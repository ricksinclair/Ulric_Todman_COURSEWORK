package com.company.CarLotDaoUlricTodman;

import com.company.CarLotDaoUlricTodman.dao.CarLotDao;
import com.company.CarLotDaoUlricTodman.model.Car;
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
public class CarLotDaoTests {

    @Autowired
    protected CarLotDao dao;

    @Before
    public void setUp() throws Exception{
        List<Car> carLotInventory = dao.getAllCars();
        carLotInventory.forEach( car -> dao.deleteCar(car.getId()));
    }

    @Test
    public void addGetDeleteCar(){
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Rav4");
        car.setYear("2019");
        car.setColor("Candy Apple Red");

        car = dao.addCar(car);

        Car car1 = dao.getCar(car.getId());
        assertEquals(car1, car);
        dao.deleteCar(car.getId());
        car1 = dao.getCar(car.getId());
        assertNull(car1);

    }
}
