package GameLogic;

import Graphics.SimpleGraphics;
import Objects.Field;
import UserInterface.UserInterface;
import PlayerLogic.Tools.PassTool;
import tools.DistanceTool;

/**
 * Down viittaa jenkkifutiksessa yhteen hyökkäysyritykseen. PlayDown
 * pyörittää MoveFramen kautta läpi yhden hyökkäysyrityksen, sekä hoitaa
 * pelikentän piirturin päivittämisen. 
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

    
    /*
    Aluksi kenttä, ja pelaajat piirretään alkuasemissa.
    Down (hyökkäysyritys) lähtee liikkeelle keskushyökkääjän (Center, C) antaessa
    pallon quaterbackille (QB), ja piirturilla päivitetään pelikentän näkymä.
    Hyökkäysyritys jatkuu niin kauan kun MoveFramelta tulee tieto, että peli ei 
    jatku.
    Jokaisen MoveFramen jälkeen pelikenttä piirretään uudestaan UserInterfaceen.
    */
    public void move() throws InterruptedException {
        piirturi.drawField(field);
        Thread.sleep(800);
        System.out.println("PLAY");
        ballTool.passBall(field, field.playerWIthBall(), field.getPlayerOff(1));
        piirturi.drawField(field);
        Thread.sleep(800);
        while (moveFrame.getContinuePlay()) {
            this.moveFrame.move(this.field);
            this.piirturi.drawField(this.field);
            Thread.sleep(800);
        }
    }
}
