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

    public PlayerMover(Field field) {
        this.field = field;
    }

    
    /*Tämä luokka ei tee vielä paljon mitään, mutta
    tulevaisuudessa tätä tullaan laajentaa tilanteisiin 
    joissa erikoistapauksen (ei pysty liikkua haluttuun suuntaan)
    käsitellään
    */
    public void movePlayer(Player player) {
        movePlayerOneStep(player, player.getPlayersNextMove(this.field));
        player.playerMoved(player.getLocation());

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

}
