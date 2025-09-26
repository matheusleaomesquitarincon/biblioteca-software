

package com.seuprojeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BoardGameCatalogTest {

    private BoardGameCatalog catalog;
    private BoardGame game1;
    private BoardGame game2;

    @BeforeEach
    void setUp() {
        catalog = new BoardGameCatalog();
        game1 = new BoardGame("Catan", 3, 4, 90);
        game2 = new BoardGame("Ticket to Ride", 2, 5, 60);
        catalog.addGame(game1);
    }

    @Test
    void testAddGame() {
        assertEquals(1, catalog.getAllGames().size());
        catalog.addGame(game2);
        assertEquals(2, catalog.getAllGames().size());
    }

    @Test
    void testAddDuplicateGame() {
        
        BoardGame duplicateGame = new BoardGame("Catan", 3, 4, 90);
        catalog.addGame(duplicateGame);
        assertEquals(1, catalog.getAllGames().size());
    }

    @Test
    void testFindGameByName() {
        Optional<BoardGame> foundGame = catalog.findGameByName("Catan");
        assertTrue(foundGame.isPresent());
        assertEquals(game1, foundGame.get());
        
        Optional<BoardGame> notFoundGame = catalog.findGameByName("Terraforming Mars");
        assertFalse(notFoundGame.isPresent());
    }

    @Test
    void testRemoveGame() {
        assertTrue(catalog.removeGame("Catan"));
        assertFalse(catalog.findGameByName("Catan").isPresent());
        assertEquals(0, catalog.getAllGames().size());

        assertFalse(catalog.removeGame("Outro Jogo"));
    }

    @Test
    void testGetGamesByPlayerCount() {
        catalog.addGame(game2);
        
        List<BoardGame> gamesFor3Players = catalog.getGamesByPlayerCount(3);
        assertEquals(2, gamesFor3Players.size());
        
        List<BoardGame> gamesFor5Players = catalog.getGamesByPlayerCount(5);
        assertEquals(1, gamesFor5Players.size());
        assertEquals("Ticket to Ride", gamesFor5Players.get(0).getName());
    }
}
