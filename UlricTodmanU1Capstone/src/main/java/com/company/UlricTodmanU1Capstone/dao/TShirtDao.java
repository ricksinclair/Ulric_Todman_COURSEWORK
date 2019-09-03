package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.TShirt;

import java.util.List;

public interface TShirtDao {

    TShirt addTShirt(TShirt tShirt);

    TShirt getTShirt(int tShirtId);

    void updateTShirt(TShirt tShirt);

    List<TShirt> getAllTShirts();

    List<TShirt> getTShirtsByColor(String color);

    List<TShirt> getTShirtsBySize(String size);

    void deleteTShirt(int tShirtId);

}
