

package com.seuprojeto;

public class BoardGame {
    private String name;
    private int minPlayers;
    private int maxPlayers;
    private int playingTimeMinutes;

    public BoardGame(String name, int minPlayers, int maxPlayers, int playingTimeMinutes) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playingTimeMinutes = playingTimeMinutes;
    }

   
    public String getName() {
        return name;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getPlayingTimeMinutes() {
        return playingTimeMinutes;
    }

    

    @Override
    public String toString() {
        return "BoardGame{" +
               "name='" + name + '\'' +
               ", minPlayers=" + minPlayers +
               ", maxPlayers=" + maxPlayers +
               ", playingTimeMinutes=" + playingTimeMinutes +
               '}';
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardGame boardGame = (BoardGame) o;
        return name.equals(boardGame.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name);
    }
}