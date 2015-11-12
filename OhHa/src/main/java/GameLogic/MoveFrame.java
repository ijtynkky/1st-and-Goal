/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import Objects.Field;
import Objects.Player;
import PlayerLogic.PlayerMover;
import java.util.ArrayList;

/**
 * Tämä luokka tullaan tarvitsemaan peliä laajentaessa. yhden Framen sisällä
 * tulee voida tapahtua monta eri juttua, ja ne tullaan koodaamaan tänne, eikä
 * play Downiin
 *
 * @author I
 */
public class MoveFrame {

    private Field gameField;
    private PlayerMover mover;

    public MoveFrame(Field field) {
        this.gameField = field;
        this.mover = new PlayerMover(field);
    }

    public void move() {
        for (Player player : gameField.getPlayers()) {
            mover.moveRoute(player);
        }
    }

    public boolean checkTD() {
        return (2 == (this.gameField.partOfField(this.gameField.playerWIthBall().getLocation())));
    }
}