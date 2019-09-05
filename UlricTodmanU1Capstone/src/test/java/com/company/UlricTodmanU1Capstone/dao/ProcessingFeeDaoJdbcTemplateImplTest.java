package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.ProcessingFee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoJdbcTemplateImplTest {
    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Test
       public void  getProcessingFee(){

        ProcessingFee consoleFee = processingFeeDao.getProcessingFee("Consoles");

        ProcessingFee gamesFee = processingFeeDao.getProcessingFee("Games");

        ProcessingFee tShirtFee = processingFeeDao.getProcessingFee("T-Shirts");

        assertEquals(tShirtFee.getFee(), new BigDecimal("1.98"));
        assertEquals(consoleFee.getFee(), new BigDecimal("14.99"));
        assertEquals(gamesFee.getFee(), new BigDecimal("1.49"));


    }

}
