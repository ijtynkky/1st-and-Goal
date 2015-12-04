/*
 Down viittaa jenkkifutiksessa yhteen yritykseen. PlayDown siis tulee 
 pyörittämään MoveFramen kautta läpi yhden pelitapahtuman kun taktiikat
 on syötetty sisään
 */
package GameLogic;

import Graphics.SimpleGraphics;
import Objects.Field;
import tools.BallTool;

/**
 *
 * @author I
 */
public class PlayDown {

    private MoveFrame moveFrame;
    private Field field;
    private SimpleGraphics piirturi;
    private BallTool ballTool;

    public PlayDown(Field field) {
        this.moveFrame = new MoveFrame(field);
        this.field = field;
        this.piirturi = new SimpleGraphics();
        this.ballTool = new BallTool();
    }

    public void move() {
        piirturi.drawField(field);
        ballTool.passBall(field.playerWIthBall(), field.getPlayerOff(1));
        piirturi.drawField(field);
        System.out.println("PLAY");
        boolean continuePlay = true;
        int i = 0;
        while (continuePlay) {
            this.moveFrame.move(this.field);
            if (this.checkIsPlayerWithBallDown()) {
                int playerDownAt = this.field.getSize()[1] - this.field.getBallDropedY();
                System.out.println("PLAYER DOWN " + playerDownAt + " YARDS TO ENDZONE");

                continuePlay = !checkIsPlayerWithBallDown();
            }
            if (this.checkTD()) {
                System.out.println("TOUCHDOWN!!!!!!");

                continuePlay = !this.checkTD();
            }
            i++;
            this.piirturi.drawField(this.field);
            if (i > 20) {
                continuePlay = false;
            }
        }
    }

    public boolean checkTD() {
        if (field.getBallDropedY() != 999) {
            return false;
        } else {
            return (2 == (this.field.partOfField(this.field.playerWIthBall().getLocation())));
        }
    }

    public boolean checkIsPlayerWithBallDown() {
        if (this.field.getBallDropedY() != 999) {
            return true;
        } else {
            return false;
        }
    }
}
