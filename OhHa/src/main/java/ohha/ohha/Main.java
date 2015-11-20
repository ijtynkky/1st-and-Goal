package ohha.ohha;

import GameLogic.*;
import Graphics.*;
import Objects.*;
import PlayerLogic.*;

public class Main {

    public static void main(String[] args) {

        Field kentta = new Field(53, 20);

        PlayerInfo pManning = new PlayerInfo("Peyton Manning", 18, "");
        int[] alkupaikka1 = {27, 10};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987444448888888888", true, "@");
        Player qb = new Player(pManning, testiOff);
        qb.giveBall();

        PlayerInfo jjWatt = new PlayerInfo("J.J. Watt", 99, "");
        int[] alkupaikka2 = {27, 15};
        PlayerStrategy testiDef = new PlayerStrategy(alkupaikka2, "879987444448888888888", false, "J");
        Player def = new Player(jjWatt, testiDef);
        def.setPlayerToFollow(qb);
        def.setMovingMode(11);

        kentta.addPlayer(qb);
        kentta.addPlayer(def);

        System.out.println("PAYTON HAS THE BALL");

        PlayDown pelaaAlas = new PlayDown(kentta);

        pelaaAlas.move();
    }
}
