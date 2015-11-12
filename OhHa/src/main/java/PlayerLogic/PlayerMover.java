/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

import Objects.Field;
import Objects.Player;

/**
 *
 * @author I
 */
public class PlayerMover {

    private Field field;
    private RouteReader reader;

    public PlayerMover(Field field) {
        this.field = field;
        this.reader = new RouteReader();
    }

    public void moveRoute(Player player) {
        this.movePlayerOneStep(player, reader.readRoute(player));
        player.routeMoved();
    }

    public boolean movePlayerOneStep(Player player, int directrion) {

        int[] tryToMove = player.tryMovePlayer(directrion);
        if (field.partOfField(tryToMove) == 0) {                        //if out of field
            return false;
        }
        if (field.getPlayerInThisPlace(tryToMove) == null) {          //If there is no other player in the same square
            player.movePlayer(directrion);
            return true;
        } else {
            return false;
        }

    }

}
