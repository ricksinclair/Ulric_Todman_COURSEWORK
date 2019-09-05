package com.company.UlricTodmanU1Capstone.dao;


import com.company.UlricTodmanU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoJdbcTemplateImplTest {

    @Autowired
    GameDao gameDao;


    @Before
    public void setUp() throws Exception {
        List<Game> gameList = gameDao.getAllGames();
        gameList.forEach(game -> gameDao.deleteGame(game.getGameId()));
    }


    @Test
    public void addGetDeleteGame() {
        Game game = new Game();
        game.setTitle("Call of Duty: Modern Warfare");
        game.setDescription("A modern reboot of the 2004 mega-hit Call of Duty 4: Modern Warfare");
        game.setEsrbRating("M");
        game.setStudio("Infinity Ward");
        game.setPrice(new BigDecimal("49.99"));
        game.setQuantity(35);
        game = gameDao.addGame(game);
        Game game2 = gameDao.getGame(game.getGameId());
        assertEquals(game, game2);
        gameDao.deleteGame(game.getGameId());
        game2 = gameDao.getGame(game.getGameId());
        assertNull(game2);
    }

    @Test
    public void getGamesLists() {
        Game game = new Game();
        game.setTitle("Call of Duty: Modern Warfare");
        game.setDescription("A modern reboot of the 2004 mega-hit Call of Duty 4: Modern Warfare");
        game.setEsrbRating("M");
        game.setStudio("Activision");
        game.setPrice(new BigDecimal("49.99"));
        game.setQuantity(35);
        gameDao.addGame(game);
        game.setTitle("Call of Duty: World at War");
        game.setDescription("A modern look at some of the lesser known battles of WWII");
        game.setEsrbRating("M");
        game.setStudio("Activision");
        game.setPrice(new BigDecimal("49.99"));
        game.setQuantity(35);
        gameDao.addGame(game);
        game.setTitle("NBA 2k20");
        game.setDescription("The definitive basketball game is back for the 2019-2020 season.");
        game.setEsrbRating("E");
        game.setStudio("2K Sports");
        game.setPrice(new BigDecimal("49.99"));
        game.setQuantity(30);
        gameDao.addGame(game);

        List<Game> allGames = gameDao.getAllGames();
        assertEquals(allGames.size(), 3);

        List<Game> activisionGames = gameDao.getGamesByStudio("Activision");
        assertEquals(activisionGames.size(), 2);

        List<Game> callOfDutyTitles = gameDao.getGamesByTitle("Call of Duty");
        assertEquals(callOfDutyTitles.size(), 2);

        List<Game> matureTitles = gameDao.getGamesByRating("M");

        assertEquals( 2, matureTitles.size());

    }

    @Test
    public void updateGame(){
        Game game = new Game();
        game.setTitle("Call of Duty: Modern Warfare");
        game.setDescription("A modern reboot of the 2004 mega-hit Call of Duty 4: Modern Warfare");
        game.setEsrbRating("M");
        game.setStudio("Activision");
        game.setPrice(new BigDecimal("49.99"));
        game.setQuantity(35);
        game = gameDao.addGame(game);
        game.setPrice(new BigDecimal("19.99"));
        gameDao.updateGame(game);
        Game game2 = gameDao.getGame(game.getGameId());
        assertEquals(game, game2);
    }
}
