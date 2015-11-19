/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamStrategy;

import Objects.Field;
import Objects.Team;
import Objects.Player;
import PlayerLogic.PlayerStrategy;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author I
 */
public class TeamStrategy {

    private HashMap<Integer, PlayerStrategy> formation;
    /*
     OFF:                DEF
     1   QB                  
     2   LT                 
     3   LG
     4   C
     5   RG
     6   RT
     7   RB
     8   TE
     9   WR1
     10  WR2
     11  WR3
     */

    public TeamStrategy() {
        this.formation = new HashMap();
    }

    public void setPlayerStrategy(int i, PlayerStrategy strategy) {
        if (i > 0 && i < 12) {
            this.formation.put(i, strategy);
        }
    }

    public ArrayList<PlayerStrategy> getSrategies() {
        int i = 1;
        ArrayList<PlayerStrategy> returnStrategies = new ArrayList();
        if (this.formation.size() != 11) {
            return null;
        }
        while (i < 12) {
            returnStrategies.add(this.formation.get(i));
            i++;
        }
        return returnStrategies;
    }

    public void placeFormation(Field field, Team team) {
        int i = 1;
        while (i < 12) {
            field.addPlayer(new Player(team.getPlayerInfo(i), this.formation.get(i)));
            i++;
        }
    }
}
