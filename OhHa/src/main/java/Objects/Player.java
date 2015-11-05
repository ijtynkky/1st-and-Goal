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

    public Player(PlayerInfo info, PlayerStrategy strategy) {
        this.hasBall = false;
        this.strategy = strategy;
        this.location = strategy.getStartingLocation();
        this.playerInfo = info;
        this.roateMoveCounter = 0;
    }

    public int[] getLocation() {
        return this.location;
    }

    public int getRoute() {
        return this.strategy.getRoute();
    }

    public void routeMoved() {
        this.roateMoveCounter++;
    }

    public int getRoateMoveCounter() {
        return this.roateMoveCounter;
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

}
