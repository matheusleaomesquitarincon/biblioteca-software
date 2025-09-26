

package com.seuprojeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardGameCatalog {
    private List<BoardGame> games;

    public BoardGameCatalog() {
        this.games = new ArrayList<>();
    }

    public void addGame(BoardGame game) {
        
        if (findGameByName(game.getName()).isEmpty()) {
            games.add(game);
        }
    }

    public Optional<BoardGame> findGameByName(String name) {
        return games.stream()
                    .filter(game -> game.getName().equalsIgnoreCase(name))
                    .findFirst();
    }

    public boolean removeGame(String name) {
        return games.removeIf(game -> game.getName().equalsIgnoreCase(name));
    }

    public List<BoardGame> getAllGames() {
        return new ArrayList<>(games); 
    }
    
    public List<BoardGame> getGamesByPlayerCount(int players) {
        List<BoardGame> result = new ArrayList<>();
        for (BoardGame game : games) {
            if (players >= game.getMinPlayers() && players <= game.getMaxPlayers()) {
                result.add(game);
            }
        }
        return result;
    }
}
