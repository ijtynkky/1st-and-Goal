/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import PlayerLogic.PlayerStrategy;
import PlayerLogic.PlayerStrategy;
import java.util.ArrayList;

public class Player {
    /*
    
     */

    private PlayerStrategy strategy;
    private PlayerInfo playerInfo;
    private int[] location;
    private boolean hasBall;
    private final boolean isOffensivePlayer;
    private final char playerIcon;
    //private ArrayList<int[]> lastFiveLocations;

    public Player(PlayerInfo info, PlayerStrategy strategy) {
        this.hasBall = false;
        this.strategy = strategy;
        this.location = null;
        this.playerInfo = info;
        this.playerIcon = strategy.getIcon();
        this.isOffensivePlayer = strategy.getIsOffensive();
        //  this.lastFiveLocations = new ArrayList();
    }

    //This is just to get the information to this.strategy.
    //this.strategy.playerMoved does mostly moveCounter++;
    //int[] where is just for further aplications
    public void playerMoved(int[] where) {
        this.strategy.playerMoved(where);
    }

    public int[] getLocation() {
        return this.location;
    }

    public String getPlayerIcon() {
        return "" + this.playerIcon;
    }

    public int[] getStartingLocation() {
        return this.strategy.getStartingLocation();
    }

    public boolean askIsOffence() {
        return this.isOffensivePlayer;
    }

    public boolean isBallCarrier() {
        return this.hasBall;
    }

    public void giveBall() {
        this.hasBall = true;
    }

    public void takeBall() {
        this.hasBall = false;
    }

    public void setPlayerStrategy(PlayerStrategy strategy) {
        this.strategy = strategy;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return this.playerInfo.toString();
    }

    /*MOVING
     directions, @ is player:
     7 8 9
     4 @ 6
     1 2 3
    
     */
    public int getPlayersNextMove(Field field) {
        return this.strategy.getNextMove(field, this.location);
    }

//    public void addNewLocation() {
//        ArrayList<int[]> newList = new ArrayList();
//        newList.add(this.location);
//        int i = 0;
//        while (i < 4 && i < this.lastFiveLocations.size()) {
//            newList.add(this.lastFiveLocations.get(i));
//            i++;
//        }
//        this.lastFiveLocations = newList;
//    }
//
//    public ArrayList<int[]> getLastFiveLocations() {
//        return this.lastFiveLocations;
//    }
    public int[] movePlayer(int direction) {
        if (direction == 1) {
            this.location[0] -= 1;
            this.location[1] -= 1;
        } else if (direction == 2) {
            this.location[1] -= 1;
        } else if (direction == 3) {
            this.location[0] += 1;
            this.location[1] -= 1;
        } else if (direction == 4) {
            this.location[0] -= 1;
        } else if (direction == 6) {
            this.location[0] += 1;
        } else if (direction == 7) {
            this.location[1] += 1;
            this.location[0] -= 1;
        } else if (direction == 8) {
            this.location[1] += 1;
        } else if (direction == 9) {
            this.location[1] += 1;
            this.location[0] += 1;
        }
        return this.location;
    }

    public int[] tryMovePlayer(int direction) {
        int y = this.location[1];
        int x = this.location[0];
        if (direction == 1) {
            x -= 1;
            y -= 1;
        } else if (direction == 2) {
            y -= 1;
        } else if (direction == 3) {
            x += 1;
            y -= 1;
        } else if (direction == 4) {
            x -= 1;
        } else if (direction == 6) {
            x += 1;
        } else if (direction == 7) {
            y += 1;
            x -= 1;
        } else if (direction == 8) {
            y += 1;
        } else if (direction == 9) {
            y += 1;
            x += 1;
        }
        int[] newLocation = {x, y};
        return newLocation;
    }

}
