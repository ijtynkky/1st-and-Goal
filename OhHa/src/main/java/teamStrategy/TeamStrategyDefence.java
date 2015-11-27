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
     OFF:
     1   NT                  
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
        while (i < 6) {
            field.addPlayerDefensive(i, this.formation.get(i));
            i++;
        }
    }

    public void getDefenceFromFile(File file) throws FileNotFoundException {
        int i = 1;
        int deCounter = 0;
        int lbCounter = 0;
        int cbCounter = 0;
        int ssCounter = 0;
        while (i < 6) {
            StrategyReader reader = new StrategyReader(file);
            PlayerStrategy playerStrategy = reader.getStrategy("player" + i);
            String position = "";
            if (i == 1) {
                position = "NT";
                Player noseTackle = new Player(this.team.getPlayersByPosition(position).get(0), playerStrategy);
                this.formation.put(i, noseTackle);
            } else if (i == 2 || i == 3) {
                position = "DE";
                Player defensiveEnd = new Player(this.team.getPlayersByPosition(position).get(deCounter), playerStrategy);
                this.formation.put(i, defensiveEnd);
                deCounter++;
            } else {
                position = "LB";
                Player lineBack = new Player(this.team.getPlayersByPosition(position).get(lbCounter), playerStrategy);
                this.formation.put(i, lineBack);
            }
            i++;
        }
    }

}
