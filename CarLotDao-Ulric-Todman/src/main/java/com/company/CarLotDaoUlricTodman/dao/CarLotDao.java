package com.company.CarLotDaoUlricTodman.dao;

import com.company.CarLotDaoUlricTodman.model.Car;

import java.util.List;

public interface CarLotDao {

    public Car addCar(Car car);
    public Car getCar(int id);
    public List<Car> getAllCars();
    public void updateCar(Car car);
    public void deleteCar(int id);
}
