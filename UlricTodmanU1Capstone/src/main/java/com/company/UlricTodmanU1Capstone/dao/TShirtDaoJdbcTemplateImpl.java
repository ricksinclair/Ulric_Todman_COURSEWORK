package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.TShirt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao{

    @Override
    public TShirt addTShirt(TShirt tShirt) {
        return null;
    }

    @Override
    public TShirt getTShirt(int tShirtId) {
        return null;
    }

    @Override
    public void updateTShirt(TShirt tShirt) {

    }

    @Override
    public List<TShirt> getAllTShirts() {
        return null;
    }

    @Override
    public List<TShirt> getTShirtsByColor(String color) {
        return null;
    }

    @Override
    public List<TShirt> getTShirtsBySize(String size) {
        return null;
    }

    @Override
    public void deleteTShirt(int tShirtId) {

    }
}
