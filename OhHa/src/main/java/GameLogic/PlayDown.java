/*
 Down viittaa jenkkifutiksessa yhteen yritykseen. PlayDown siis tulee 
 pyörittämään MoveFramen kautta läpi yhden pelitapahtuman kun taktiikat
 on syötetty sisään
 */
package GameLogic;

import Graphics.SimpleGraphics;
import Objects.Field;

/**
 *
 * @author I
 */
public class PlayDown {

    private MoveFrame moveFrame;
    private Field field;
    private SimpleGraphics piirturi;

    public PlayDown(Field field) {
        this.moveFrame = new MoveFrame(field);
        this.field = field;
        this.piirturi = new SimpleGraphics();
    }

    public void move() {
        piirturi.drawField(field);
        System.out.println("PLAY");
        boolean continuePlay = true;
        int i = 0;
        while (continuePlay) {
            this.moveFrame.move(this.field);
            if (this.checkTD(this.field)) {
                System.out.println("TOUCHDOWN!!!!!!");
            }
            continuePlay = !this.checkTD(this.field);
            i++;
            this.piirturi.drawField(this.field);
            if (i > 20) {
                continuePlay = false;
            }
        }
    }

    public boolean checkTD(Field gameField) {
        return (2 == (this.field.partOfField(this.field.playerWIthBall().getLocation())));
    }

}
