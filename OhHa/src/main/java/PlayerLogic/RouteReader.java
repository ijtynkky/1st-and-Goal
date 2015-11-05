/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

import Objects.Player;

/**
 *
 * @author I
 */
public class RouteReader {

    public RouteReader() {

    }

    public int readRoute(Player player) {
        int i = player.getRoateMoveCounter();
        String readRoute = "" + player.getRoute();
        if (readRoute.length() < i) {
            return 999;
        }
        int readMove = Integer.parseInt(readRoute.charAt(i) + "");
        return readMove;
    }

}
