package com.company.CoffeeInventoryDaoUlricTodman.dao;

import com.company.CoffeeInventoryDaoUlricTodman.model.Coffee;
import com.company.CoffeeInventoryDaoUlricTodman.model.Roaster;

import java.util.List;

public interface CoffeeInventoryDao {

    Coffee getCoffee(int id);

    List<Coffee> getAllCoffee();

    Coffee addCoffee(Coffee coffee);

    void updateCoffee(Coffee coffee);

    void deleteCoffee(int id);

    List<Coffee> getCoffeeByRoaster(int roasterId);

    Roaster getRoaster(int id);

    List<Roaster> getAllRoasters();

    Roaster addRoaster(Roaster roaster);

    void updateRoaster(Roaster roaster);

    void deleteRoaster(int id);
}



