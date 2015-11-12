package ohha.ohha;

import GameLogic.*;
import Graphics.*;
import Objects.*;
import PlayerLogic.*;

public class Main {

    public static void main(String[] args) {

        Field kentta = new Field(53, 20);
        SimpleGraphics piirturi = new SimpleGraphics();

        PlayerInfo pManning = new PlayerInfo("Payton Manning", 18);
        int[] alkupaikka1 = {27, 10};
        PlayerStrategy testiOff = new PlayerStrategy(alkupaikka1, "879987444448888888888", true);
        Player qb = new Player(pManning, testiOff);
        qb.giveBall();
        kentta.addPlayer(qb);
        piirturi.drawSmallField(kentta);

        System.out.println("PAYTON HAS THE BALL");
        
        PlayDown pelaaAlas = new PlayDown();

        pelaaAlas.move(kentta);
    }
}
