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
    //Jos pelaajan liike onnistuu, metodi kertoo siitä pelaajalle (tieto välittyy
    //pelaajan strategiaan, jolloin
    public void movePlayer(Player player) {
        int direction = player.getPlayersNextMove(this.field);
        if (direction == 999) {
            return;
        }
        boolean movePlayer = movePlayerOneStep(player, direction);
        if (movePlayer == true) {
            player.playerMoved(player.getLocation());
        }
    }

    //Liikuttaa pelaajaa annettuun suuntaan
    /*MOVING
     directions, @ is player:
     7 8 9
     4 @ 6
     1 2 3
    
     Metodi aloittaa luomalla kysymällä pelaajalta ruudun mihin pelaaja haluaisi
     liikkua (tryToMove), sen jälkeen metodi testaa
     1. yrittääkö pelaaja liikkua pois kentältä (ei liiku, return false)
     2. onko ruutu, johon pelaaja koittaa liikkua tyhjä. Jos on, tapahtuu liike 
     käytännössä, ja return true
    
     jos kyseessä ei ole kohda 1 tai 2 tilanne, tarkoittaa että ruudussa johon koitetaan
     liikkua on toinen pelaaja. siispä
     3.1 jos liikkuva pelaaja on puolujasta, ja hän koittaa liikkua hyökkääjän
     pallollisen pleaajan ruutuun, tapahtuu taklaus. taklauks on liike, ja palautus on true
     3.2 kyseisessä ruudussa on toinen pelaaja, ja liikkuva pelaaja koittaa väistää. tällä hetkellä
     tools.dodge(direction) antaa antaa jonkun kolmesta satunnaisesta suunnasta, jotka
     riippuvat yritetyn liikkeen suunnasta. Tämän jälkeen metodi käy kohdat 1 ja 2 uudestaan läpi,
     mutta kohta 3 ohitetaan. Eli jos dodgen suuntakin on laiton, ei pelaaja liiku laisinkaan.
    
     */
    public boolean movePlayerOneStep(Player player, int direction) {

        int[] tryToMove = player.tryMovePlayer(direction);

        if (field.partOfField(tryToMove) == 0) {                      //kohta 1.

            return false;
        }
        if (field.getPlayerInThisPlace(tryToMove) == null) {          //kohta 2.
            player.movePlayer(direction);

            return true;
        } else if (!player.askIsOffence() && this.tacklePlayerWithBallIfNeeded(tryToMove)) {
            return true;                                              //kohta 3.1
        } else {                                                      //kohta 3.2
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
                return true;
            } else {
                return false;
            }
        }

    }
}
