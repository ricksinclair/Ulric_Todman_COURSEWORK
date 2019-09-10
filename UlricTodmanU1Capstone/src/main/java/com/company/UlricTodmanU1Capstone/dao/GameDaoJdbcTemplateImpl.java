package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {
    //Prepared Statements

    private final String INSERT_GAME_SQL =
            "INSERT INTO game (title, esrb_rating, description, price, studio, quantity) VALUES (?, ?, ?, ?, ?, ?)";
    private final String GET_GAME_SQL =
            "SELECT * FROM game WHERE game_id = ?";
    private final String GET_ALL_GAMES_SQL =
            "SELECT * FROM game";
    private final String GET_GAMES_BY_STUDIO_SQL =
            "SELECT * FROM game WHERE studio like ?";
    private final String GET_GAMES_BY_RATING_SQL =
            "SELECT * FROM game WHERE esrb_rating = ?";
    private final String GET_GAMES_BY_TITLE =
            "SELECT * FROM game WHERE title like ? ";
    private final String UPDATE_GAME_SQL =
            "UPDATE game SET title =?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? WHERE game_id = ?";
    private final String DELETE_GAME_SQL =
            "DELETE FROM game WHERE game_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate) {
        this.jdbcTemplate = newJdbcTemplate;
    }

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("game_id"));
        game.setDescription(rs.getString("description"));
        game.setQuantity(rs.getInt("quantity"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setEsrbRating(rs.getString("esrb_rating"));
        game.setStudio(rs.getString("studio"));
        game.setTitle(rs.getString("title"));
        return game;
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity()
        );
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        game.setGameId(id);

        return game;
    }

    @Override
    public Game getGame(int gameId) {
        try {
            return jdbcTemplate.queryForObject(GET_GAME_SQL, this::mapRowToGame, gameId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(GET_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public void updateGame(Game game) {

        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getGameId()
        );
    }

    @Override
    public void deleteGame(int gameId) {
        jdbcTemplate.update(DELETE_GAME_SQL, gameId);
    }

    @Override
    public List<Game> getGamesByStudio(String studio) {
        return jdbcTemplate.query(GET_GAMES_BY_STUDIO_SQL, this::mapRowToGame, "%" + studio + "%");
    }

    @Override
    public List<Game> getGamesByRating(String rating) {
        return jdbcTemplate.query(GET_GAMES_BY_RATING_SQL, this::mapRowToGame, rating);
    }

    @Override
    public List<Game> getGamesByTitle(String title) {
        return jdbcTemplate.query(GET_GAMES_BY_TITLE, this::mapRowToGame, "%" + title + "%");
    }
}
