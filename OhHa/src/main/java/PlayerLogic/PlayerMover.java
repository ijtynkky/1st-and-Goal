package PlayerLogic;

import Objects.Field;
import Objects.Player;

/*Tämä luokka ei tee vielä paljon mitään, mutta
 tulevaisuudessa tätä tullaan laajentamaan. Käytännössä erikoistilanteet
 ja poikkeukset käsitellään satunnaisgeneraattorin kanssa
 */
public class PlayerMover {

    private Field field;

    public PlayerMover(Field field) {
        this.field = field;
    }

//liikuttaa pelaajaa yhden ruudun pelaajan strategian antamaan suuntaan
    public void movePlayer(Player player) {
        movePlayerOneStep(player, player.getPlayersNextMove(this.field));
        player.playerMoved(player.getLocation());

    }

    //Liikuttaa pelaajaa annettuun suuntaan
    /*MOVING
     directions, @ is player:
     7 8 9
     4 @ 6
     1 2 3
    
     */
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
