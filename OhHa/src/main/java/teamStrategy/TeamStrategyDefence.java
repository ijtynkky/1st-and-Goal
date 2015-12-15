/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamStrategy;

import Objects.Field;
import Objects.Player;
import Objects.PlayerInfo;
import Objects.Team;
import PlayerLogic.PlayerStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import tools.StrategyReader;

/**
 *
 * @author I
 */
public class TeamStrategyDefence {

    private Team team;
    private HashMap<Integer, Player> formation;
    /*
     DEF:
     1   DT                  
     2   DE                 
     3   DE
     4   LB
     5   LB
     6   LB
     7   LB
     8   CB
     9   CB
     10  SS
     11  SS
     */

    public TeamStrategyDefence(Team team) {
        this.formation = new HashMap();
        this.team = team;
    }

    public void getWholeTeamStrategyFromFile(File file) throws FileNotFoundException {

    }

    public void setWholeTeamOnTheField(Field field) {
//        if (formation.size() != 11) {
//            throw new IllegalArgumentException("väärä määrä pelaajia");
//        }
        int i = 1;
        while (i < 12) {
            Player player = this.formation.get(i);
            if (i == 4) {
                player.getDefPlayerStrategy().setStartingLocationByOppPlayerLocation(field.getPlayerOff(11));
                player.getDefPlayerStrategy().setPlayerToFollow(field.getPlayerOff(11));
            }
            if (i == 6) {
                player.getDefPlayerStrategy().setPlayerToFollow(field.getPlayerOff(7));
            }
            if (i == 7) {
                player.getDefPlayerStrategy().setPlayerToFollow(field.getPlayerOff(8));
            }
            if (i == 8 || i == 9) {

                player.getDefPlayerStrategy().setStartingLocationByOppPlayerLocation(field.getPlayerOff(i + 1));
                player.getDefPlayerStrategy().setPlayerToFollow(field.getPlayerOff(i + 1));
            }
            field.addPlayerDefensive(i, player);
            i++;
        }
    }

    public void getDefenceFromFile(File file) throws FileNotFoundException {
        int i = 1;
        int dtCounter = 0;
        int deCounter = 0;
        int lbCounter = 0;
        int cbCounter = 0;
        int ssCounter = 0;
        while (i < 12) {
            StrategyReader reader = new StrategyReader(file);
            PlayerStrategy playerStrategy = reader.getStrategy("player" + i);
            String position = "";
            if (i == 1) {
                position = "DT";
                Player defensiveTackle = new Player(this.team.getPlayersByPosition(position).get(dtCounter), playerStrategy);
                this.formation.put(i, defensiveTackle);
                dtCounter++;
            } else if (i == 2 || i == 3) {
                position = "DE";
                Player defensiveEnd = new Player(this.team.getPlayersByPosition(position).get(deCounter), playerStrategy);
                this.formation.put(i, defensiveEnd);
                deCounter++;
            } else if (i == 4 || i == 5 || i == 6 || i == 7) {
                position = "LB";
                Player lineBack = new Player(this.team.getPlayersByPosition(position).get(lbCounter), playerStrategy);
                this.formation.put(i, lineBack);
                lbCounter++;
            } else if (i == 8 || i == 9) {
                position = "CB";
                Player cornerback = new Player(this.team.getPlayersByPosition(position).get(cbCounter), playerStrategy);
                this.formation.put(i, cornerback);
                cbCounter++;
            } else if (i == 10 || i == 11) {
                position = "SS";
                Player safety = new Player(this.team.getPlayersByPosition(position).get(ssCounter), playerStrategy);
                ssCounter++;
                this.formation.put(i, safety);
            }
            i++;
        }
    }

}
