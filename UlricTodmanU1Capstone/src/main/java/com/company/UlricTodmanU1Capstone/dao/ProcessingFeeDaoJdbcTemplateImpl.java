package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {

    //prepared statements
    private final String GET_PROCESSING_FEE_SQL =
            "SELECT * FROM processing_fee WHERE product_type = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate) {
        this.jdbcTemplate = newJdbcTemplate;
    }

    @Override
    public ProcessingFee getProcessingFee(String productType) {


        try {
            return jdbcTemplate.queryForObject(GET_PROCESSING_FEE_SQL, this::mapRowToProcessingFee, productType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(rs.getBigDecimal("fee"));
        processingFee.setProductType(rs.getString("product_type"));
        return processingFee;
    }

}

