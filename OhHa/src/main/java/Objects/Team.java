package Objects;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Sisältää listan joukkueen pelaajien tiedoista, sekä joukkueen perustiedot
 * 
 */
public class Team {

    private ArrayList<PlayerInfo> players;
    private String name;
    private static final String[] POSITIONS = new String[]{ //Pelipaikkojen lyhenteet
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

    
    //palauttaa listan pelaajista tietylle pelipaikalle. position parametrin 
    //pitää olla joku POSITION lyhenteistä (ehto myöhemmin)
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
                for (PlayerInfo player : playersInPosition) {
                    returnString = returnString + POSITIONS[i] + " " + player + "\n";
                }
                i++;
            }
        }
        return returnString;
    }

}
