/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import Objects.Field;
import Objects.Player;
import PlayerLogic.PlayerMover;
import PlayerLogic.QBMover;
import PlayerLogic.Tools.MovingTool;
import PlayerLogic.Tools.PassTool;
import java.util.ArrayList;
import tools.DistanceTool;
import tools.Randomizer;

/**
 * Tämä luokka tullaan tarvitsemaan peliä laajentaessa. yhden Framen sisällä
 * tulee voida tapahtua monta eri testiä/tapahtumaa, ja ne tullaan koodaamaan
 * tänne, eikä play Downiin
 *
 * @author I
 */
public class MoveFrame {

    private Field field;
    private boolean continuePlay;
    private PlayerMover mover;
    private QBMover qbMover;
    private MovingTool mt;
    private Randomizer random;
    private DistanceTool dt;
    private PassTool pt;

    public MoveFrame(Field field, DistanceTool dt) {
        this.field = field;
        this.continuePlay = true;
        this.dt = dt;
        this.random = new Randomizer();
        this.mt = new MovingTool();
        this.mover = new PlayerMover(mt);
        this.qbMover = new QBMover(mt, random, dt);
        this.pt = new PassTool(dt);
    }

    public boolean getContinuePlay() {
        return this.continuePlay;
    }

    public void move(Field gameField) {
        ArrayList<Player> players = gameField.getPlayers();
        qbMover.movePlayer(this.field, players.get(0));
        if (qbMover.passBoolean() && players.get(0).isBallCarrier()) {
            continuePlay = pt.pass(this.field, players.get(0));
        }
        if (testTD()) {
            System.out.println(this.field.playerWIthBall() + " TOUCHDOWN!!!!!!");
            continuePlay = false;
        }
        int i = 1;
        while (i < players.size() && continuePlay) {
            mover.movePlayer(this.field, players.get(i));
            if (players.get(i).isBallCarrier()) {
                if (testTD()) {
                    System.out.println(field.playerWIthBall() + " TOUCHDOWN!!!!!!");
                    continuePlay = false;
                }
            }
            this.checkIsPlayerWithBallDown();

            i++;
        }
    }

    private boolean testTD() {
        if (field.getBallDropedY() != 999) {
            return false;
        } else {
            return (2 == (this.field.partOfField(this.field.playerWIthBall().getLocation())));
        }
    }

    private boolean checkIsPlayerWithBallDown() {
        if (this.field.getBallDropedY() == 999) {
            return false;
        } else {
            int playerDownAt = this.field.getSize()[1] - this.field.getBallDropedY();
            System.out.println("PLAYER DOWN " + playerDownAt + " YARDS TO ENDZONE");
            this.continuePlay = false;
            return true;
        }
    }
}
