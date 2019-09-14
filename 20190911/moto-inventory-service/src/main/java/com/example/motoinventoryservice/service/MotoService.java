package com.example.motoinventoryservice.service;


import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.model.Motorcycle;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MotoService {

    @Autowired
    MotoInventoryDao motoInventoryDao;

    public Motorcycle getMoto(int motoId){
        return motoInventoryDao.getMotorcycle(motoId);
    }

    public List<Motorcycle> getAllMotos(){
        return  motoInventoryDao.getAllMotorcycles();
    }

    public Motorcycle addMoto(Motorcycle motorcycle){
        return motoInventoryDao.addMotorcycle(motorcycle);
    }

    public void updateMotorcycle(Motorcycle motorcycle){
        motoInventoryDao.updateMotorcycle(motorcycle);
    }

    public void deleteMotorcycle(int motoId){
        motoInventoryDao.deleteMotorcycle(motoId);
    }

    public List<Motorcycle> getMotoByMake(String make){
        return motoInventoryDao.getMotorcyclesByMake(make);
    }

}
