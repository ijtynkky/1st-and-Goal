/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.Tools;

import Objects.Player;

/**
 *
 * @author I
 */
public class RouteReader {

    public RouteReader() {

    }

    //Pelaajien juoksureitit (Route) ovat string muodossa, ja koostuvat numeroista
    //route reader lukee String routen n:nen merkin, ja palauttaa sen int muodossa
    //Itse ohjelma tulkitsee palautetun intin yhtenä suuntana, johon pelaaja seuraavaksi liikkuu
    public int readRoute(String route, int moveCounter) {
        if (route.length() <= moveCounter) {
            return -999;
        }
        int readMove = Integer.parseInt(route.charAt(moveCounter) + "");
        return readMove;
    }

}
