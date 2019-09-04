package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.Game;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {
    @Override
    public Game addGame(Game game) {
        return null;
    }

    @Override
    public Game getGame(int gameId) {
        return null;
    }

    @Override
    public List<Game> getAllGames() {
        return null;
    }

    @Override
    public void updateGame(Game game) {

    }

    @Override
    public void deleteGame(int gameId) {

    }

    @Override
    public List<Game> getGamesByStudio(String studio) {
        return null;
    }

    @Override
    public List<Game> getGamesByRating(String rating) {
        return null;
    }

    @Override
    public List<Game> getGamesByTitle(String title) {
        return null;
    }
}
