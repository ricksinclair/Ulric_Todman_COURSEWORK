package com.example.motoinventoryservice.service;

import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.dao.MotoInventoryDaoJdbcTemplateImpl;
import com.example.motoinventoryservice.model.Motorcycle;
import com.example.motoinventoryservice.viewmodel.MotoViewModel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class MotoInventoryServiceTest {

    MotoInventoryService motoInventoryService;

    MotoInventoryDao motoInventoryDao;

    @Before
    public void setUp() throws Exception {

        setUpMotoInventoryMock();

        motoInventoryService = new MotoInventoryService(motoInventoryDao);
    }

    private void setUpMotoInventoryMock() {

        motoInventoryDao = mock(MotoInventoryDaoJdbcTemplateImpl.class);

        Motorcycle moto = new Motorcycle();
        moto.setId(1);
        moto.setVin("1234");
        moto.setMake("Harley Davidson");
        moto.setModel("V-Rod");
        moto.setYear("2019");
        moto.setColor("Red");

        Motorcycle moto1 = new Motorcycle();
        moto1.setVin("1234");
        moto1.setMake("Harley Davidson");
        moto1.setModel("V-Rod");
        moto1.setYear("2019");
        moto1.setColor("Red");

        // Mock addMotorcycle();
        doReturn(moto).when(motoInventoryDao).addMotorcycle(moto1);

        // Mock getMotorcycle(id)
        doReturn(moto).when(motoInventoryDao).getMotorcycle(1);

        //Second mock data
        Motorcycle moto2 = new Motorcycle();
        moto2.setId(2);
        moto2.setVin("5678");
        moto2.setMake("Harley Davidson");
        moto2.setModel("Dyna");
        moto2.setYear("2020");
        moto2.setColor("Silver");

        // Mock getAllMotorcycles();
        List<Motorcycle> motorcycleList = new ArrayList<>();
        motorcycleList.add(moto);
        motorcycleList.add(moto2);
        doReturn(motorcycleList).when(motoInventoryDao).getAllMotorcycles();

        // Mock data for update
        Motorcycle motoUpdate = new Motorcycle();
        motoUpdate.setId(3);
        motoUpdate.setVin("3333");
        motoUpdate.setMake("Harley Davidson");
        motoUpdate.setModel("Sportster");
        motoUpdate.setYear("2000");
        motoUpdate.setColor("Blue");

        // Mock updateMotorcycle();
        doNothing().when(motoInventoryDao).updateMotorcycle(motoUpdate);
        doReturn(motoUpdate).when(motoInventoryDao).getMotorcycle(3);

        // Mock data for delete
        Motorcycle motoDelete = new Motorcycle();
        motoDelete.setId(4);
        motoDelete.setVin("4444");
        motoDelete.setMake("Harley Davidson");
        motoDelete.setModel("Trike");
        motoDelete.setYear("2010");
        motoDelete.setColor("Black");

        // Mock deleteMotorcycle();
        doNothing().when(motoInventoryDao).deleteMotorcycle(4);
        doReturn(null).when(motoInventoryDao).getMotorcycle(4);

        // Custom Method, get
        List<Motorcycle> motorcyclesByMakeList = new ArrayList<>();
        motorcyclesByMakeList.add(moto);
        motorcyclesByMakeList.add(moto2);
        doReturn(motorcyclesByMakeList).when(motoInventoryDao).getMotorcyclesByMake("Harley Davidson");
    }


    @Test(expected = IllegalArgumentException.class)
    public void saveMoto() {

        MotoViewModel moto = new MotoViewModel();
        moto.setVin("1234");
        moto.setMake("Harley Davidson");
        moto.setModel("V-Rod");
        moto.setYear("2019");
        moto.setColor("Red");

        moto = motoInventoryService.saveMoto(moto);

        MotoViewModel fromService = motoInventoryService.findMotoById(moto.getId());
        assertEquals(fromService, moto);
    }

    @Test
    public void findAllMotos() {

        List<MotoViewModel> motoViewModelList = motoInventoryService.findAllMotos();
        assertEquals(2, motoViewModelList.size());
    }

    @Test
    public void findMotoById() {

        MotoViewModel moto = new MotoViewModel();

        moto.setVin("1234");
        moto.setMake("Harley Davidson");
        moto.setModel("V-Rod");
        moto.setYear("2019");
        moto.setColor("Red");

        moto = motoInventoryService.saveMoto(moto);

        MotoViewModel fromService = motoInventoryService.findMotoById(1);
        assertEquals(moto, fromService);
    }

    @Test
    public void updateMoto() {

        MotoViewModel mvmUpdate = new MotoViewModel();

        Motorcycle motoUpdate = new Motorcycle();
        motoUpdate.setId(3);
        motoUpdate.setVin("3333");
        motoUpdate.setMake("Harley Davidson");
        motoUpdate.setModel("Sportster");
        motoUpdate.setYear("2000");
        motoUpdate.setColor("Blue");

        mvmUpdate.setId(motoUpdate.getId());
        mvmUpdate.setVin(motoUpdate.getVin());
        mvmUpdate.setMake(motoUpdate.getMake());
        mvmUpdate.setModel(motoUpdate.getModel());
        mvmUpdate.setYear(motoUpdate.getYear());
        mvmUpdate.setColor(motoUpdate.getColor());

        motoInventoryService.updateMoto(mvmUpdate);

        MotoViewModel mvm2 = motoInventoryService.findMotoById(3);

        Motorcycle motorAfterUpdate = new Motorcycle();
        motorAfterUpdate.setId(mvm2.getId());
        motorAfterUpdate.setVin(mvm2.getVin());
        motorAfterUpdate.setMake(mvm2.getMake());
        motorAfterUpdate.setModel(mvm2.getModel());
        motorAfterUpdate.setYear(mvm2.getYear());
        motorAfterUpdate.setColor(mvm2.getColor());

        assertEquals(motorAfterUpdate, motoUpdate);

    }

    @Test
    public void deleteMoto() {

        motoInventoryService.removeMoto(4);

        MotoViewModel mvm = motoInventoryService.findMotoById(4);

        assertNull(mvm);

    }

    @Test
    public void findMotoByMake() {

        List<MotoViewModel> motoByMakeList = motoInventoryService.findMotoByMake("Harley Davidson");
        assertEquals(2, motoByMakeList.size());

        motoByMakeList = motoInventoryService.findMotoByMake("Honda");
        assertEquals(0, motoByMakeList.size());

    }

}
