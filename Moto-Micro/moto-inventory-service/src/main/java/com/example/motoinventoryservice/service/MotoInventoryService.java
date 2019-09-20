package com.example.motoinventoryservice.service;

import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.model.Motorcycle;
import com.example.motoinventoryservice.viewmodel.MotoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class MotoInventoryService {

    MotoInventoryDao motoInventoryDao;

    @Autowired
    public MotoInventoryService(MotoInventoryDao motoInventoryDao) {
        this.motoInventoryDao = motoInventoryDao;
    }

    @Transactional
    public MotoViewModel saveMoto(MotoViewModel motoViewModel) {

        Integer year;
        try {
            year = Integer.parseInt(motoViewModel.getYear());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid year");
        }

        if(year < 1995){
                throw new IllegalArgumentException("year doesn't exist");
        }



        Motorcycle moto = new Motorcycle();
        moto.setVin(motoViewModel.getVin());
        moto.setMake(motoViewModel.getMake());
        moto.setModel(motoViewModel.getModel());
        moto.setYear(motoViewModel.getYear());
        moto.setColor(motoViewModel.getColor());
        moto = motoInventoryDao.addMotorcycle(moto);

        motoViewModel.setId(moto.getId());

        return motoViewModel;
    }

    private MotoViewModel buildMotoViewModel(Motorcycle moto) {

        MotoViewModel motoViewModel = new MotoViewModel();
        motoViewModel.setId(moto.getId());
        motoViewModel.setVin(moto.getVin());
        motoViewModel.setMake(moto.getMake());
        motoViewModel.setModel(moto.getModel());
        motoViewModel.setYear(moto.getYear());
        motoViewModel.setColor(moto.getColor());

        return motoViewModel;
    }

    public List<MotoViewModel> findAllMotos() {

        List<Motorcycle> motorcycleList = motoInventoryDao.getAllMotorcycles();

        List<MotoViewModel> motoViewModelList = new ArrayList<>();

        for(Motorcycle moto : motorcycleList) {
            MotoViewModel mvm = buildMotoViewModel(moto);
            motoViewModelList.add(mvm);
        }

        return motoViewModelList;
    }

    public MotoViewModel findMotoById(int id) {
        Motorcycle moto = motoInventoryDao.getMotorcycle(id);

        if(moto == null)
            return null;
        else
            return buildMotoViewModel(moto);
    }

    public void removeMoto(int id) {
        motoInventoryDao.deleteMotorcycle(id);
    }

    public void updateMoto(MotoViewModel motoViewModel) {

        Motorcycle moto = new Motorcycle();
        moto.setId(motoViewModel.getId());
        moto.setVin(motoViewModel.getVin());
        moto.setMake(motoViewModel.getMake());
        moto.setModel(motoViewModel.getModel());
        moto.setYear(motoViewModel.getYear());
        moto.setColor(motoViewModel.getColor());

        motoInventoryDao.updateMotorcycle(moto);
    }

    public List<MotoViewModel> findMotoByMake(String make) {
        List<Motorcycle> motorcycleList = motoInventoryDao.getMotorcyclesByMake(make);

        List<MotoViewModel> motoViewModelList = new ArrayList<>();

        for(Motorcycle moto : motorcycleList){
            MotoViewModel mvm = buildMotoViewModel(moto);
            motoViewModelList.add(mvm);
        }

        return motoViewModelList;
    }


}
