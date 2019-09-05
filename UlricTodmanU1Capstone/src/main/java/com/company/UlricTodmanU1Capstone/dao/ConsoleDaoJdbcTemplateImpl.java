package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {

//Prepared Statements

    private final String INSERT_CONSOLE_SQL =
            "INSERT INTO console (model, manufacturer, memory_amount, processor, price, quantity) VALUES (?,?, ?, ?, ?, ?)";

    private final String GET_CONSOLE_SQL =
            "SELECT * FROM console WHERE console_id = ?";

    private final String GET_ALL_CONSOLES_SQL =
            "SELECT * FROM console";

    private final String GET_CONSOLES_BY_MANUFACTURER_SQL =
            "SELECT * FROM console WHERE manufacturer like ? ";

    private final String UPDATE_CONSOLE_SQL =
            "UPDATE console SET manufacturer = ?, model = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? WHERE console_id = ?";
    private final String DELETE_CONSOLE_SQL =
            "DELETE FROM console WHERE console_id = ?";


    private JdbcTemplate jdbcTemplate;


    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate) {
        this.jdbcTemplate = newJdbcTemplate;
    }


    private Console mapRowToConsole(ResultSet rs, int rowNum) throws SQLException {

        Console console = new Console();
        console.setConsoleId(rs.getInt("console_id"));
        console.setModel(rs.getString("model"));
        console.setManufacturer(rs.getString("manufacturer"));
        console.setMemoryAmount(rs.getString("memory_amount"));
        console.setProcessor(rs.getString("processor"));
        console.setPrice(rs.getBigDecimal("price"));
        console.setQuantity(rs.getInt("quantity"));
        return console;
    }


    @Override
    @Transactional
    public Console addConsole(Console console) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity()
        );

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        console.setConsoleId(id);

        return console;
    }

    @Override
    public Console getConsole(int consoleId) {

        try {
            return jdbcTemplate.queryForObject(GET_CONSOLE_SQL, this::mapRowToConsole, consoleId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Console> getAllConsoles() {
        return jdbcTemplate.query(GET_ALL_CONSOLES_SQL, this::mapRowToConsole);
    }

    @Override
    public List<Console> getConsolesByManufacturer(String manufacturer) {
        return jdbcTemplate.query(GET_CONSOLES_BY_MANUFACTURER_SQL, this::mapRowToConsole, manufacturer);
    }

    @Override
    public void updateConsole(Console console) {
        jdbcTemplate.update(UPDATE_CONSOLE_SQL,
                console.getManufacturer(),
                console.getModel(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity(),
                console.getConsoleId());
    }

    @Override
    public void deleteConsole(int consoleId) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, consoleId);
    }
}
