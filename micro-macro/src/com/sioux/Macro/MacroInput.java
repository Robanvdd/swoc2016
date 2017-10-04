package com.sioux.Macro;

import java.util.List;

/**
 * Created by Ferdinand on 27-9-17.
 */
public class MacroInput {
    private List<MacroPlayer> players;
    private int gameId;
    private String ticks;

    public List<MacroPlayer> getPlayers() {
        return players;
    }

    public int getGameId() {
        return gameId;
    }

    public String getTicks() {
        return ticks;
    }
}
