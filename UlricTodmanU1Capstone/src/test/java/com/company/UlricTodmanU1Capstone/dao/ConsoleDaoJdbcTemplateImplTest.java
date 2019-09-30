package com.company.UlricTodmanU1Capstone.dao;


import com.company.UlricTodmanU1Capstone.model.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoJdbcTemplateImplTest {


    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception{
    List<Console> consoleList = consoleDao.getAllConsoles();
    consoleList.forEach(console -> consoleDao.deleteConsole(console.getConsoleId()));
    }

    @Test
    public void addGetDeleteConsole(){
        Console console = new Console();
        console.setManufacturer("Sony");
        console.setModel("PS4 Pro");
        console.setMemoryAmount("8GB");
        console.setProcessor("AMD");
        console.setQuantity(20);
        console.setPrice(new BigDecimal("299.99"));
        console = consoleDao.addConsole(console);
        Console console2 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console, console2);
        consoleDao.deleteConsole(console.getConsoleId());
        console2 = consoleDao.getConsole(console.getConsoleId());
        assertNull(console2);
    }


    @Test
    public void updateConsole(){
        Console console = new Console();
        console.setManufacturer("Sony");
        console.setModel("PS4 Pro");
        console.setMemoryAmount("8GB");
        console.setProcessor("AMD");
        console.setQuantity(20);
        console.setPrice(new BigDecimal("299.99"));
        console = consoleDao.addConsole(console);
        console.setModel("PS4");
        consoleDao.updateConsole(console);
        Console console2 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console, console2);
    }


    @Test
    public void getConsoleByManufacturer(){
        Console ps4Pro = new Console();
        ps4Pro.setManufacturer("Sony");
        ps4Pro.setModel("PS4 Pro");
        ps4Pro.setMemoryAmount("8GB");
        ps4Pro.setProcessor("AMD");
        ps4Pro.setQuantity(20);
        ps4Pro.setPrice(new BigDecimal("399.99"));
        ps4Pro = consoleDao.addConsole(ps4Pro);
        Console ps4 = new Console();
        ps4.setManufacturer("Sony");
        ps4.setModel("PS4");
        ps4.setMemoryAmount("8GB");
        ps4.setProcessor("AMD");
        ps4.setQuantity(20);
        ps4.setPrice(new BigDecimal("299.99"));
        ps4 = consoleDao.addConsole(ps4);
        Console xbox = new Console();
        xbox.setManufacturer("Microsoft");
        xbox.setModel("Xbox One X");
        xbox.setMemoryAmount("8GB");
        xbox.setProcessor("AMD");
        xbox.setQuantity(20);
        xbox.setPrice(new BigDecimal("349.99"));
        xbox = consoleDao.addConsole(xbox);

        List<Console> sonyList = consoleDao.getConsolesByManufacturer("Sony");
        List<Console> xboxList = consoleDao.getConsolesByManufacturer("Microsoft");
        List<Console> allConsoles = consoleDao.getAllConsoles();

        assertEquals(sonyList.size(), 2);
        assertEquals(xboxList.size(), 1);
        assertEquals(allConsoles.size(), 3);

    }
}
