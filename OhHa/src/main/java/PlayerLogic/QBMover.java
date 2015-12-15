/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

import Objects.Field;
import Objects.Player;
import PlayerLogic.Tools.MovingTool;
import tools.DistanceTool;
import tools.Randomizer;

/**
 *
 * @author I
 */
public class QBMover extends PlayerMover {

    private DistanceTool dt;
    private boolean passBall;
    private Randomizer random;
    private MovingTool mt;

    public QBMover(MovingTool mt, Randomizer random, DistanceTool dt) {
        super(mt);
        this.passBall = false;
        this.dt = dt;
        this.random = random;
        this.mt = mt;
    }

    public boolean passBoolean() {
        return this.passBall;
    }

    /*
     QB MOVER:
     1. jos QB:lla ei ole palloa, liikkuu hän kuten normaalisti pelaajat liikkuu
     2. jos QB:n strategia palauttaa 999, heittää qb pallon pois
     3. Jos QB:n vieressä on vastustaja, liikkuu QB 90%tod näk pois päin vastustajasta,
     ja tämän tapahduttua heitto myöhästyy 50% tod näk
     4. jos QB:n lähellä on vastustajan pelaaja, liikkuu QB 50% tod näk pois päin
     vastustajasta. Jos QB liikkuu pois päin vastustajasta, on 30% mahdollisuus että
     hän kiirehtii, eli playerMoved() komentoa käytetään ylimääräisen kerran. muuten,
     5. QB liikkuu normaalin suunnitelman mukaan
     */
    @Override
    public void movePlayer(Field field, Player player) {
        //1.
        if (!player.isBallCarrier()) {
            super.movePlayer(field, player);
            return;
        }
        int command = player.getPlayersNextMove(field);
        //2.
        if (command == 999) {
            this.passBall = true;
        }
        //3.
        if (dt.getDistanceToNearestOpponent(field, player) < 1.5) {
            if (random.testRandom(50)) {
                super.movePlayerOneStep(field, player, mt.awayClosestOpponent(field, player));
                player.playerMoved(player.getLocation());
                if (random.testRandom(50)) {
                    player.getQBStrategy().delayPass();
                }
            }
            return;
            //4.
        } else if (dt.getDistanceToNearestOpponent(field, player) < 2) {
            if (random.testRandom(30)) {
                    player.playerMoved(player.getLocation());
                }
            if (random.testRandom(20)) {
                super.movePlayerOneStep(field, player, mt.awayClosestOpponent(field, player));
                player.playerMoved(player.getLocation());
                return;
            }
        } //5.
        else {
            super.movePlayer(field, player);
        }

    }
}
