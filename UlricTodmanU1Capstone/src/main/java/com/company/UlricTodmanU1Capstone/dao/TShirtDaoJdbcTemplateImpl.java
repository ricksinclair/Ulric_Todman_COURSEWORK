package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao{

    //Prepared Statements
    private final String INSERT_T_SHIRT_SQL =
            "INSERT INTO t_shirt (size, color, description, price, quantity) VALUES (?, ?, ?, ?, ?)";

    private final String GET_T_SHIRT_SQL =
            "SELECT * FROM t_shirt WHERE t_shirt_id = ?";

    private final String UPDATE_T_SHIRT_SQL =
            "UPDATE t_shirt SET size = ?, color = ?, description = ?, price = ?, quantity = ? WHERE t_shirt_id = ?";
    private final String GET_ALL_T_SHIRTS_SQL =
            "SELECT * FROM t_shirt";
    private final String GET_T_SHIRTS_BY_SIZE_SQL =
            "SELECT * FROM t_shirt WHERE size = ?";
    private final String GET_T_SHIRTS_BY_COLOR_SQL =
            "SELECT * FROM t_shirt WHERE color = ?";
    private final String DELETE_T_SHIRTS_SQL =
            "DELETE FROM t_shirt WHERE t_shirt_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }

    private TShirt mapRowToTShirt(ResultSet rs, int rowNum) throws SQLException{
        TShirt tShirt = new TShirt();
        tShirt.setTShirtId(rs.getInt("t_shirt_id"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setQuantity(rs.getInt("quantity"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setColor(rs.getString("color"));
        tShirt.setSize(rs.getString("size"));
        return tShirt;

    }

    @Override
    @Transactional
    public TShirt addTShirt(TShirt tShirt) {
        jdbcTemplate.update(INSERT_T_SHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity()
                );
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        tShirt.setTShirtId(id);

        return tShirt;
    }

    @Override
    public TShirt getTShirt(int tShirtId) {
        try {

            return jdbcTemplate.queryForObject(GET_T_SHIRT_SQL, this::mapRowToTShirt, tShirtId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void updateTShirt(TShirt tShirt) {

        jdbcTemplate.update(UPDATE_T_SHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity(),
                tShirt.getTShirtId()
                );


    }

    @Override
    public List<TShirt> getAllTShirts() {
        return jdbcTemplate.query(GET_ALL_T_SHIRTS_SQL, this::mapRowToTShirt);
    }

    @Override
    public List<TShirt> getTShirtsByColor(String color) {
        return jdbcTemplate.query(GET_T_SHIRTS_BY_COLOR_SQL, this::mapRowToTShirt, color);
    }

    @Override
    public List<TShirt> getTShirtsBySize(String size) {
        return jdbcTemplate.query(GET_T_SHIRTS_BY_SIZE_SQL, this::mapRowToTShirt, size);
    }

    @Override
    public void deleteTShirt(int tShirtId) {
        jdbcTemplate.update(DELETE_T_SHIRTS_SQL, tShirtId);
    }
}
