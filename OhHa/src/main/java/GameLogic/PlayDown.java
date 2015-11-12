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

    public PlayDown() {
    }

    public void move(Field field) {
        this.moveFrame = new MoveFrame(field);
        boolean continuePlay = true;
        int i = 0;
        while (continuePlay) {
            this.moveFrame.move();
            if (this.moveFrame.checkTD()) {
                System.out.println("TOUCHDOWN!!!!!!");
            }
            continuePlay = !this.moveFrame.checkTD();
            i++;
            SimpleGraphics piirturi = new SimpleGraphics();
            piirturi.drawSmallField(field);
            if (i > 20) {
                continuePlay = false;
            }
        }
    }

}
