package com.company.rick;

import com.company.rick.controller.RickController;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class RickControllerTest {

    @Test
    public void HelloTest(){
        RickController rickController= new RickController();
        String hello = rickController.helloWorld();

        assertEquals(hello, "Hello World!");
    }
}
