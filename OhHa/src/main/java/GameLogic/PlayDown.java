/*
 Down viittaa jenkkifutiksessa yhteen yritykseen. PlayDown siis tulee 
 pyörittämään MoveFramen kautta läpi yhden pelitapahtuman kun taktiikat
 on syötetty sisään
 */
package GameLogic;

import Graphics.SimpleGraphics;
import Objects.Field;
import UserInterface.UserInterface;
import PlayerLogic.Tools.PassTool;
import tools.DistanceTool;

/**
 *
 * @author I
 */
public class PlayDown {

    private MoveFrame moveFrame;
    private Field field;
    private SimpleGraphics piirturi;
    private PassTool ballTool;
    private DistanceTool dt;

    public PlayDown(Field field, UserInterface ui) {
        this.dt = new DistanceTool();
        this.moveFrame = new MoveFrame(field, dt);
        this.field = field;
        this.piirturi = new SimpleGraphics(ui);
        this.ballTool = new PassTool(dt);
    }

    public void move() throws InterruptedException {
        piirturi.drawField(field);
        ballTool.passBall(field, field.playerWIthBall(), field.getPlayerOff(1));
        piirturi.drawField(field);
        System.out.println("PLAY");
        while (moveFrame.getContinuePlay()) {
            this.moveFrame.move(this.field);
            this.piirturi.drawField(this.field);
            Thread.sleep(800);
        }
    }
}
