package com.company.CoffeeInventoryDaoUlricTodman.dao;

import com.company.CoffeeInventoryDaoUlricTodman.model.Coffee;
import com.company.CoffeeInventoryDaoUlricTodman.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoffeeInventoryDaoJdbcTemplateImpl implements CoffeeInventoryDao{

    //prepared statement Strings
    private static final String INSERT_COFFEE_SQL =
            "INSERT INTO  coffee(name, count, unit_price, description, type, roaster_id) VALUES (?, ?, ?, ?, ?,?)";

    private static final String SELECT_COFFEE_SQL =
            "SELECT * from coffee WHERE coffee_id = ? ";

    private static final String SELECT_ALL_COFFEE_SQL =
            "SELECT * from coffee";

    private static final String DELETE_COFFEE_SQL =
            "DELETE from coffee where coffee_id = ?";

    private static final String UPDATE_COFFEE_SQL =
            "UPDATE coffee SET  name = ?, count = ?, unit_price = ?, description = ?, type = ?, roaster_id = ? WHERE coffee_id = ?";

    private static final String SELECT_COFFEE_BY_ROASTER_SQL =
            "SELECT * FROM  coffee WHERE roaster_id = ?";

    private static final String INSERT_ROASTER_SQL =
            "INSERT INTO  roaster(name, street, city, state, postal_code, phone, email, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ROASTER_SQL =
            "SELECT * from roaster WHERE roaster_id = ? ";

    private static final String SELECT_ALL_ROASTERS_SQL =
            "SELECT * from roaster";

    private static final String DELETE_ROASTER_SQL =
            "DELETE FROM roaster WHERE roaster_id = ?";

    private static final String UPDATE_ROASTER_SQL =
            "UPDATE roaster SET name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ?, note = ? WHERE roaster_id = ?";

private JdbcTemplate jdbcTemplate;

    @Autowired
    public CoffeeInventoryDaoJdbcTemplateImpl(JdbcTemplate newjdbcTemplate){
        this.jdbcTemplate = newjdbcTemplate;
    }

    private Roaster mapRowToRoaster(ResultSet rs, int rowNum) throws SQLException{
    Roaster roaster = new Roaster();
    roaster.setRoasterId(rs.getInt("roaster_id"));
    roaster.setName(rs.getString("name"));
    roaster.setStreet(rs.getString("street"));
    roaster.setState(rs.getString("state"));
    roaster.setPostalCode((rs.getString("postal_code")));
    roaster.setPhone(rs.getString("phone"));
    roaster.setEmail(rs.getString("email"));
    roaster.setNote(rs.getString("note"));
    return roaster;
    }

    private Coffee mapRowToCoffee(ResultSet rs, int rowNum) throws SQLException{
        Coffee coffee = new Coffee();
        coffee.setCoffeeId(rs.getInt("coffee_id"));
        coffee.setRoasterId(rs.getInt("roaster_id"));
        coffee.setName(rs.getString("name"));
        coffee.setCount(rs.getInt("count"));
        coffee.setUnitPrice(rs.getDouble("unit_price"));
        coffee.setDescription(rs.getString("description"));
        coffee.setType(rs.getString("type"));
        return coffee;
    }

    @Override
    public Coffee getCoffee(int coffeeId) {
        try{
return jdbcTemplate.queryForObject(SELECT_COFFEE_SQL, this::mapRowToCoffee,coffeeId);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<Coffee> getAllCoffee() {
        return jdbcTemplate.query(SELECT_ALL_COFFEE_SQL, this::mapRowToCoffee);
    }

    @Override
    @Transactional
    public Coffee addCoffee(Coffee coffee) {
        jdbcTemplate.update(INSERT_COFFEE_SQL,
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnitPrice(),
                coffee.getDescription(),
                coffee.getType(),
                coffee.getRoasterId());

        int id =jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
            coffee.setCoffeeId(id);
                //            "INSERT INTO  coffee(name, count, unit_price, description, type) VALUES (?, ?, ?, ?, ?)";

        return coffee;
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        //            "UPDATE coffee set name = ?, count = ?, unit_price = ?, description = ?, type = ?, roaster_id = ? WHERE coffee_id = ?";
        jdbcTemplate.update(UPDATE_COFFEE_SQL,
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnitPrice(),
                coffee.getDescription(),
                coffee.getType(),
                coffee.getRoasterId(),
                coffee.getCoffeeId());

    }

    @Override
    public void deleteCoffee(int coffeeId) {
    jdbcTemplate.update(DELETE_COFFEE_SQL, coffeeId);

    }

    @Override
    public List<Coffee> getCoffeeByRoaster(int roasterId) {
return jdbcTemplate.query(SELECT_COFFEE_BY_ROASTER_SQL, this::mapRowToCoffee, roasterId);
        //"SELECT * FROM  coffee WHERE roaster_id = ?";
  }

    @Override
    public Roaster getRoaster(int roasterId) {
        try{
        return jdbcTemplate.queryForObject(SELECT_ROASTER_SQL, this::mapRowToRoaster, roasterId);
    }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Roaster> getAllRoasters() {
        return jdbcTemplate.query(SELECT_ALL_ROASTERS_SQL, this::mapRowToRoaster);
    }

    @Override
    @Transactional
    public Roaster addRoaster(Roaster roaster) {
        //            "INSERT INTO  roaster(name, street, city, state, postal_code, phone, email, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(INSERT_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostalCode(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote());

        int id =jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        roaster.setRoasterId(id);

        return roaster;

    }

    @Override
    public void updateRoaster(Roaster roaster) {
        jdbcTemplate.update(UPDATE_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostalCode(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote(),
                roaster.getRoasterId());
        //            "UPDATE roaster SET name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ?, note = ? WHERE roaster_id = ?";
    }

    @Override
    public void deleteRoaster(int roasterId) {
        jdbcTemplate.update(DELETE_ROASTER_SQL, roasterId);

    }
}
