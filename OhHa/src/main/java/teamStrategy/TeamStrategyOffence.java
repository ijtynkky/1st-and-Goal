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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import tools.StrategyReader;

/**
 *
 * @author I
 */
public class TeamStrategyOffence {

    private Team team;
    private HashMap<Integer, Player> formation;
    /*
     OFF:
     1   QB                  
     2   LT                 
     3   LG
     4   C
     5   RG
     6   RT
     7   RB
     8   TE
     9   WR
     10  WR
     11  WR
     */

    public TeamStrategyOffence(Team team) {
        this.formation = new HashMap();
        this.team = team;
    }

    public void getWholeTeamStrategyFromFile(File file) throws FileNotFoundException {
        this.getQbFromFile(file);
        this.getLinemenFromFile(file);
        this.getRbFromFile(file);
        this.getReseiversFromFile(file);

    }

    public void setWholeTeamOnTheField(Field field) {
        if (formation.size() != 11) {
            throw new IllegalArgumentException("väärä määrä pelaajia");
        }
        int i = 1;
        while (i < 12) {
            field.addPlayerOffensive(this.formation.get(i));
            i++;
        }
    }

    public ArrayList<Player> getSrategies() {
        int i = 1;
        ArrayList<Player> returnStrategies = new ArrayList();
        if (this.formation.size() != 11) {
            return null;
        }
        while (i < 12) {
            returnStrategies.add(this.formation.get(i));
            i++;
        }
        return returnStrategies;
    }

    public void getQbFromFile(File file) throws FileNotFoundException {
        StrategyReader reader = new StrategyReader(file);
        PlayerStrategy qbStrategy = reader.getStrategy("player1");
        Player quaterBack = new Player(this.team.getPlayersByPosition("QB").get(0), qbStrategy);
        this.formation.put(1, quaterBack);
    }

    public void getRbFromFile(File file) throws FileNotFoundException {
        StrategyReader reader = new StrategyReader(file);
        PlayerStrategy qbStrategy = reader.getStrategy("player7");
        Player quaterBack = new Player(this.team.getPlayersByPosition("RB").get(0), qbStrategy);
        this.formation.put(7, quaterBack);
    }

    public void getReseiversFromFile(File file) throws FileNotFoundException {
        int i = 8;
        int teCounter = 0;
        int wrCounter = 0;
        while (i < 12) {
            StrategyReader reader = new StrategyReader(file);
            PlayerStrategy playerStrategy = reader.getStrategy("player" + i);
            String position = "";
            if (i == 8) {
                position = "TE";
                Player reseiver = new Player(this.team.getPlayersByPosition(position).get(teCounter), playerStrategy);
                this.formation.put(i, reseiver);
                teCounter++;
            } else {
                position = "WR";
                Player reseiver = new Player(this.team.getPlayersByPosition(position).get(wrCounter), playerStrategy);
                this.formation.put(i, reseiver);
                wrCounter++;
            }
            i++;
        }
    }

    public void getLinemenFromFile(File file) throws FileNotFoundException {
        StrategyReader reader = new StrategyReader(file);

        PlayerStrategy ltStrategy = reader.getStrategy("player2");
        Player leftTackle = new Player(this.team.getPlayersByPosition("LT").get(0), ltStrategy);
        this.formation.put(2, leftTackle);

        PlayerStrategy lgStrategy = reader.getStrategy("player3");
        Player leftGuard = new Player(this.team.getPlayersByPosition("LG").get(0), lgStrategy);
        this.formation.put(3, leftGuard);

        PlayerStrategy cStrategy = reader.getStrategy("player4");
        Player center = new Player(this.team.getPlayersByPosition("C").get(0), cStrategy);
        center.giveBall();
        this.formation.put(4, center);

        PlayerStrategy rgStrategy = reader.getStrategy("player5");
        Player rightGuard = new Player(this.team.getPlayersByPosition("RG").get(0), rgStrategy);
        this.formation.put(5, rightGuard);

        PlayerStrategy rtStrategy = reader.getStrategy("player6");
        Player rightTackle = new Player(this.team.getPlayersByPosition("RT").get(0), rtStrategy);
        this.formation.put(6, rightTackle);
    }

    public void setLinemenOnField(Field field) {
        int i = 2;
        while (i < 7) {
            field.addPlayerOffensive(this.formation.get(i));
            i++;
        }
    }
}
