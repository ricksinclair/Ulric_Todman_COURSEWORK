package com.company.UlricTodmanU1Capstone.controller;


import com.company.UlricTodmanU1Capstone.exception.NotFoundException;
import com.company.UlricTodmanU1Capstone.model.Game;
import com.company.UlricTodmanU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class GameController {

    @Autowired
    ServiceLayer serviceLayer;


    @RequestMapping(path = "/Game", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames() {
        return serviceLayer.getAllGames();
    }

    @RequestMapping(path = "/Game/Studio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByStudio(@PathVariable String studio) {
        return serviceLayer.getGamesByStudio(studio);
    }

    @RequestMapping(path = "/Game/Rating/{rating}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByRating(@PathVariable String rating) {
        return serviceLayer.getGamesByRating(rating);
    }

    @RequestMapping(path = "/Game/Title/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByTitle(@PathVariable String title) {
        return serviceLayer.getGamesByTitle(title);
    }

    @RequestMapping(path = "/Game", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game addGame(@RequestBody @Valid Game game) {
        return serviceLayer.addGame(game);
    }

    @RequestMapping(path = "/Game", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void updateGame(@RequestBody @Valid Game game) {
        Game game2 = serviceLayer.getGame(game.getGameId());

        if (game2 == null)
            throw new NotFoundException("Game could not be retrieved for id " + game.getGameId());
        serviceLayer.updateGame(game);
    }

    @RequestMapping(path = "/Game/{gameId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGameById(@PathVariable int gameId) {
        Game game = serviceLayer.getGame(gameId);

        if (game == null)
            throw new NotFoundException("T shirt could not be retrieved for id " + gameId);
        return game;
    }

    @RequestMapping(path = "/Game/{gameId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteGame(@PathVariable int gameId) {
        Game game = serviceLayer.getGame(gameId);

        if (game == null)
            throw new NotFoundException("T shirt could not be retrieved for id " + gameId);

        serviceLayer.deleteGame(gameId);
    }


}
