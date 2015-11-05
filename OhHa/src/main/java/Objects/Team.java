/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;

/**
 *
 * @author I
 */
public class Team {

    private ArrayList<PlayerInfo> players;
    private String name;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList();
    }

    public boolean addPlayer(PlayerInfo player) {
        this.players.add(player);
        return true;
    }

}
