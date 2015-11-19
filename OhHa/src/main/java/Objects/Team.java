/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author I
 */
public class Team {

    private ArrayList<PlayerInfo> players;
    private String name;
    private static final String[] POSITIONS = new String[]{
        "QB", "FB", "RB", "WR", "TE",
        "LT", "LG", "C", "RT", "RG", "DE", "NT", "LB", "CB", "SS"};

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList();
    }

    public boolean addPlayer(PlayerInfo player) {
        this.players.add(player);
        return true;
    }

    public PlayerInfo getPlayerInfo(int i) {
        return this.players.get(i - 1);
    }

    public ArrayList<PlayerInfo> getPlayersByPosition(String position) {
        ArrayList<PlayerInfo> returnPlayers = new ArrayList();
        for (PlayerInfo p : this.players) {
            if (p.getPosition().equals(position)) {
                returnPlayers.add(p);
            }
        }
        return returnPlayers;
    }

    @Override
    public String toString() {
        String returnString = this.name + "\n";
        int i = 0;
        while (i < POSITIONS.length) {
            ArrayList<PlayerInfo> playersInPosition = this.getPlayersByPosition(POSITIONS[i]);
            if (playersInPosition.isEmpty()) {
                i++;
            } else {
                returnString = returnString + POSITIONS[i] + "\n";
                for (PlayerInfo player : playersInPosition) {
                    returnString = returnString + player + "\n";
                }
                i++;
            }
        }
        return returnString;
    }

}
