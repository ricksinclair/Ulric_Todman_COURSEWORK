package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.SalesTaxRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoJdbcTemplateImplTest {

    @Autowired
    SalesTaxRateDao salesTaxRateDao;

    @Test
    public void getTaxRate(){
      SalesTaxRate ny =  salesTaxRateDao.getTaxRate("NY");
      assertEquals(ny.getRate(), new BigDecimal(" .06"));
      SalesTaxRate ca =  salesTaxRateDao.getTaxRate("CA");
      assertEquals(ca.getRate(), new BigDecimal(" .06"));
      SalesTaxRate ga =  salesTaxRateDao.getTaxRate("GA");
      assertEquals(ga.getRate(), new BigDecimal(" .07"));
    }

}
