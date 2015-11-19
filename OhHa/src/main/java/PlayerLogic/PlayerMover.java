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

    public void playerMove(Player player) {
        System.out.println(player.toString());
        int movingMode = player.getMovingMode();
        if (movingMode == 0) {
            this.moveRoute(player);
        }
        if (movingMode == 11) {
            this.moveManCover1(player);
            System.out.println("ManCover");
        }
    }

    public void moveManCover1(Player player) {
        this.moveTowards(player, player.getPlayerToFollow().getLocation());
    }

    public void moveRoute(Player player) {
        this.movePlayerOneStep(player, reader.readRoute(player));
        player.routeMoved();
    }

    public boolean movePlayerOneStep(Player player, int directrion) {

        int[] tryToMove = player.tryMovePlayer(directrion);
        System.out.println(tryToMove[0] + "," + tryToMove[1]);
        if (field.partOfField(tryToMove) == 0) {                        //if out of field
            System.out.println("false\n");
            return false;
        }
        if (field.getPlayerInThisPlace(tryToMove) == null) {          //If there is no other player in the same square
            player.movePlayer(directrion);
            System.out.println("true\n");
            return true;
        } else {
            System.out.println("false\n");
            return false;
        }

    }

    public void moveTowards(Player player, int[] partOfField) {
        int x = partOfField[0] - player.getLocation()[0];
        int y = partOfField[1] - player.getLocation()[1];
        if (x < 0) {
            if (y < 0) {
                movePlayerOneStep(player, 1);
            } else if (y > 0) {
                movePlayerOneStep(player, 7);
            } else {
                movePlayerOneStep(player, 4);
            }
        } else if (x > 0) {
            if (y < 0) {
                movePlayerOneStep(player, 3);
            } else if (y > 0) {
                movePlayerOneStep(player, 9);
            } else {
                movePlayerOneStep(player, 6);
            }
        } else {
            if (y < 0) {
                movePlayerOneStep(player, 2);
            } else {
                movePlayerOneStep(player, 8);
            }
        }

//    public boolean dodge()
    }
}
