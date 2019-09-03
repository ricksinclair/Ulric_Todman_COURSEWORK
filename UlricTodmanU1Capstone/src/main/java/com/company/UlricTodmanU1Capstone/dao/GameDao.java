package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int gameId);

    List<Game> getAllGames();

    void updateGame(Game game);

    void deleteGame(int gameId);

    List<Game> getGamesByStudio(String studio);

    List<Game> getGamesByRating(String rating);

    List<Game> getGamesByTitle(String title);

}
