package PlayerLogic;

import Objects.Field;
import Objects.Player;
import PlayerLogic.Tools.MovingTools;

/*

 */
public class PlayerMover {

    private Field field;
    private MovingTools tools;

    public PlayerMover(Field field) {
        this.field = field;
        this.tools = new MovingTools();
    }

//liikuttaa pelaajaa yhden ruudun pelaajan strategian antamaan suuntaan
    public void movePlayer(Player player) {
        int direction = player.getPlayersNextMove(this.field);
        if (direction == 999) {
            return;
        }
        boolean movePlayer = movePlayerOneStep(player, direction);

        player.playerMoved(player.getLocation());

    }

    //Liikuttaa pelaajaa annettuun suuntaan
    /*MOVING
     directions, @ is player:
     7 8 9
     4 @ 6
     1 2 3
    
     */
    public boolean movePlayerOneStep(Player player, int direction) {

        int[] tryToMove = player.tryMovePlayer(direction);

        if (field.partOfField(tryToMove) == 0) {                        //if out of field

            return false;
        }
        if (field.getPlayerInThisPlace(tryToMove) == null) {          //If there is no other player in the same square
            player.movePlayer(direction);

            return true;
        } else if (player.askIsOffence() == false) {
            return this.tacklePlayerWithBallIfNeeded(tryToMove);
        } else {
            int tryToDodgeInDirection = tools.dodge(direction);
            int[] tryToDodge = player.tryMovePlayer(tryToDodgeInDirection);
            if (field.partOfField(tryToDodge) == 0) {

                return false;
            }
            if (field.getPlayerInThisPlace(tryToDodge) == null) {
                player.movePlayer(tryToDodgeInDirection);
                System.out.println(player + "DODGE");
                return true;

            } else {
                return false;
            }
        }
    }

    public boolean tacklePlayerWithBallIfNeeded(int[] tryToMove) {
        if (field.getBallDropedY() != 999) {
            return false;
        } else {
            if (field.getPlayerInThisPlace(tryToMove) == field.playerWIthBall()) {
                System.out.println("TACKLE");
                boolean tackleSuccess = tools.tackle();
                if (tackleSuccess == true) {
                    System.out.println("SUCCESS");
                    field.setBallDropedY(field.playerWIthBall().getLocation()[1]);
                    field.playerWIthBall().takeBall();
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }

    }
}
