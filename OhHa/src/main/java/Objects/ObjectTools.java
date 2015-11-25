/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author I
 */
public class ObjectTools {

    public ObjectTools(Field field) {
    }

    public double distance(int[] a, int[] b) {
        double x = Math.pow(b[0] - a[0], 2);
        double y = Math.pow(b[1] - a[1], 2);
        return Math.sqrt(x + y);
    }

    public Player getClosestPlayer(Field field, int[] from, boolean isOffencivePlayer) {
        double shortestDistance = 9999;
        Player returnThis = null;
        for (Player player : field.getPlayers()) {
            double distance = distance(from, player.getLocation());
            if (distance < shortestDistance) {
                shortestDistance = distance;
                returnThis = player;
            }
        }
        return returnThis;
    }
}
