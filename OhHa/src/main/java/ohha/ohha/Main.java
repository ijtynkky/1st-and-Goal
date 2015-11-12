package ohha.ohha;

import Graphics.*;
import Objects.*;
import PlayerLogic.*;

public class Main {

    public static void main(String[] args) {

        Field kentta = new Field(5, 5);
        SimpleGraphics piirturi = new SimpleGraphics();

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {1, 5};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, 879987, true);
        Player qb = new Player(pManning, testiOff);
        System.out.println("pelaajat " + kentta.getPlayers().toString());
        kentta.addPlayer(qb);
        System.out.println("pelaajat " + kentta.getPlayers().toString());
        System.out.println(kentta.getPlayerLocations().contains(alkupaikka1));
        System.out.println("jee");
        System.out.println(qb.getPlayerIcon());
        System.out.println(qb.getLocation().toString());

        int x = qb.getLocation()[0];
        int y = qb.getLocation()[1];
        System.out.println("paikka: " + x + " " + y);

        System.out.println(kentta.getPlayerLocations().toString());

        System.out.println(kentta.getPlayerInThisPlace(alkupaikka1));
        piirturi.drawSmallField(kentta);
    }
}
