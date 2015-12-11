/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Objects.Field;
import Objects.Player;

/**
 *
 * @author I
 */
public class DistanceTool {

    public double getDistance(int[] a, int[] b) {
        return Math.sqrt(Math.pow((b[0] - a[0]), 2) + Math.pow((b[1] - a[1]), 2));
    }

    public int[] nearestOpponentPlayerLocation(Field field, Player player) {
        int[] locationOfClosestOpponent = new int[]{0, 0};
        double shortestDistance = 999;
        for (Player opponent : field.getPlayers()) {
            if (opponent.askIsOffence() != player.askIsOffence()) {
                if (this.getDistance(player.getLocation(), opponent.getLocation()) < shortestDistance) {
                    shortestDistance = this.getDistance(player.getLocation(), opponent.getLocation());
                    locationOfClosestOpponent = opponent.getLocation();
                }
            }
        }
        return locationOfClosestOpponent;
    }

    public double getDistanceToNearestOpponent(Field field, Player player) {
        return this.getDistance(player.getLocation(), this.nearestOpponentPlayerLocation(field, player));
    }

}
