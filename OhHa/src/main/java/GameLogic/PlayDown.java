/*
 Down viittaa jenkkifutiksessa yhteen yritykseen. PlayDown siis tulee 
 pyörittämään MoveFramen kautta läpi yhden pelitapahtuman kun taktiikat
 on syötetty sisään
 */
package GameLogic;

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
        while (continuePlay) {
            int i = 0;
            this.moveFrame.move();
            continuePlay = !this.moveFrame.checkTD();
            i++;
            if (i > 20) {
                break;
            }
        }
    }

}
