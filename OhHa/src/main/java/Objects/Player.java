/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import PlayerLogic.PlayerStrategy;

/**
 *
 * @author I
 */
public class Player {

    private PlayerStrategy strategy;
    private PlayerInfo playerInfo;
    private int[] location;
    private int roateMoveCounter;
    private boolean hasBall;
    private int movingMode;
    private Player playerToFollow;

    public Player(PlayerInfo info, PlayerStrategy strategy) {
        this.hasBall = false;
        this.strategy = strategy;
        this.location = strategy.getStartingLocation();
        this.playerInfo = info;
        this.roateMoveCounter = 0;
        this.movingMode = 0;
        this.playerToFollow = null;
    }

    public int[] getLocation() {
        return this.location;
    }

    public String getRoute() {
        return this.strategy.getRoute();
    }

    public void routeMoved() {
        this.roateMoveCounter++;
    }

    public int getRoateMoveCounter() {
        return this.roateMoveCounter;
    }

    public String getPlayerIcon() {
        return "" + this.strategy.getIcon();
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

    public boolean askIsOffence() {
        return this.strategy.getIsOffensive();
    }

    public int getMovingMode() {
        return this.movingMode;
    }

    public void setMovingMode(int i) {
        this.movingMode = i;
    }

    public void setPlayerToFollow(Player player) {
        this.playerToFollow = player;
    }

    public Player getPlayerToFollow() {
        return this.playerToFollow;
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
