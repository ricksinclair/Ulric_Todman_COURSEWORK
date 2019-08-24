package com.company.UlricTodmanU1M5Summative.dao;

import com.company.UlricTodmanU1M5Summative.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbcTemplateImpl implements PublisherDao {
    //Prepared statement Strings
    private static final String INSERT_PUBLISHER_SQL =
            "INSERT INTO publisher (name, street, city, state, postal_code, phone, email) VALUES (?,?,?,?,?,?,?)";
    private static final String SELECT_PUBLISHER_SQL =
            "SELECT * FROM publisher WHERE publisher_id = ?";
    private static final String SELECT_ALL_PUBLISHERS_SQL =
            "SELECT * FROM publisher";
    private static final String UPDATE_PUBLISHER_SQL =
            "UPDATE publisher SET name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? where publisher_id = ?";
    private static final String DELETE_PUBLISHER_SQL =
            "DELETE FROM publisher WHERE publisher_id = ?";

    //Object Mapper Helper Method
    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException{
        Publisher publisher = new Publisher();
        publisher.setPublisherId(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setStreet(rs.getString("street"));
        publisher.setCity(rs.getString("city"));
        publisher.setState(rs.getString("state"));
        publisher.setPostalCode(rs.getString("postal_code"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));
        return publisher;
    }
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PublisherDaoJdbcTemplateImpl(JdbcTemplate newjdbcTemplate){
        this.jdbcTemplate = newjdbcTemplate;
    }


    @Override
    @Transactional
    public Publisher addPublisher(Publisher publisher) {
        //            "INSERT INTO publisher (name, street, city, state, postal_code, phone, email) VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(INSERT_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostalCode(),
                publisher.getPhone(),
                publisher.getEmail());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        publisher.setPublisherId(id);
        return publisher;
    }

    @Override
    public Publisher getPublisher(int publisherId) {
        try{
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, publisherId);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHERS_SQL, this::mapRowToPublisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        //            "UPDATE publisher SET name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? where publisher_id = ?";
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostalCode(),
                publisher.getPhone(),
                publisher.getEmail(),
                publisher.getPublisherId());
    }

    @Override
    public void deletePublisher(int publisherId) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, publisherId);
    }
}
