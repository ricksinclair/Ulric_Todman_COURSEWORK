package com.company.carlotjpadao;

import com.company.carlotjpadao.dao.CarRepository;
import com.company.carlotjpadao.dto.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarLotJpaDaoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	CarRepository carRepo;


	@Test
	@Transactional
	public void createTest(){
		carRepo.deleteAll();
		Car testCar = new Car();
		testCar.setMake("Toyota");
		testCar.setModel("Rav4");
		testCar.setModelYear("2009");
		testCar.setColor("Silver");
	carRepo.save(testCar);
		testCar = carRepo.getOne(1);
		Car testCar2 = carRepo.getOne(1);
		assertEquals(testCar, testCar2);

	}




}
