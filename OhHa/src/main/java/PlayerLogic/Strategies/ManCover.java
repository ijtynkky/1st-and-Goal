/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.Strategies;

import Objects.Field;
import Objects.Player;
import PlayerLogic.PlayerStrategy;

/**
 *
 * @author I
 */
public class ManCover implements PlayerStrategy {

    private Player playerToFollow;
    private int[] StartingLocation;
    private final char playerIcon;

    public ManCover(int[] startingLocation, Player followThisPlayer, String icon) {
        this.StartingLocation = startingLocation;
        this.playerIcon = icon.charAt(0);
        this.playerToFollow = followThisPlayer;
    }

    public ManCover(Player followThisPlayer) {
        this.StartingLocation = null;
        this.playerToFollow = followThisPlayer;
        this.playerIcon = '?';
    }

    public void setPlayerToFollow(Player player) {
        this.playerToFollow = player;
    }

    @Override
    public int getNextMove(Field field, int[] playerLocation) {
        int x = playerToFollow.getLocation()[0] - playerLocation[0];
        int y = playerToFollow.getLocation()[1] - playerLocation[1];
        int returnThis = -999;
        if (x < 0) {
            if (y < 0) {
                returnThis = 1;
            } else if (y > 0) {
                returnThis = 7;
            } else {
                returnThis = 4;
            }
        } else if (x > 0) {
            if (y < 0) {
                returnThis = 3;
            } else if (y > 0) {
                returnThis = 9;
            } else {
                returnThis = 6;
            }
        } else {
            if (y < 0) {
                returnThis = 2;
            } else {
                returnThis = 8;
            }

        }
        return returnThis;
    }

    @Override
    public int[] getStartingLocation() {
        return this.StartingLocation;
    }

    @Override
    public char getIcon() {
        return this.playerIcon;
    }

    @Override
    public boolean getIsOffensive() {
        return false;
    }

    @Override
    public void playerMoved(int[] where) {
    }

}
