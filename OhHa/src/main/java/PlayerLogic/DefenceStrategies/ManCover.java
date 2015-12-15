package PlayerLogic.DefenceStrategies;

import Objects.Field;
import Objects.Player;
import PlayerLogic.DefPlayerStrategy;
import PlayerLogic.PlayerStrategy;
import PlayerLogic.Tools.MovingTool;
import tools.Randomizer;

/**
 * Puolustajan strategia, jossa puolustaja seuraa nimettyä pelaajaa
 */
public class ManCover implements DefPlayerStrategy {

    private Player playerToFollow;
    private int[] StartingLocation;
    private char icon;
    private int xAdjustment;
    private int yAdjustment;
    private boolean qbHasBall;
    private Randomizer random;

    public ManCover(int[] startingLocation, String icon) {
        this.StartingLocation = startingLocation;
        this.icon = icon.charAt(0);
        this.xAdjustment = 0;
        this.yAdjustment = 0;
        this.qbHasBall = true;
        this.random = new Randomizer();
        this.playerToFollow = null;
    }

    //Man coveriin voi halutessa antaa x ja y parametrit, jolloin puolustaja
    //ei liiku suoraan kohti pelaajaa, vaan hieman siitä ohi    
    public void setAdjustmen(int x, int y) {
        this.xAdjustment = x;
        this.yAdjustment = y;
    }

    @Override
    public void setPlayerToFollow(Player player) {
        this.playerToFollow = player;
    }

    @Override
    public void setStartingLocationByOppPlayerLocation(Player player) {
        int x = player.getLocation()[0];
        int y = this.StartingLocation[1];
        this.StartingLocation = new int[]{x, y};
    }

    @Override
    public int getNextMove(Field field, int[] playerLocation) {
        if (this.playerToFollow.equals(null)) {
            this.setPlayerToFollow(field.getPlayerOff(random.randomNonLinemanPlayerPosition()));
        }
        if (this.qbHasBall && !field.getPlayerOff(1).isBallCarrier()) {
            if (random.testRandom(30)) {
                this.qbHasBall = false;
                this.setPlayerToFollow(field.playerWIthBall());
            }
        }

        if (this.playerToFollow.isBallCarrier()) {
            this.xAdjustment = 0;
            this.yAdjustment = 0;
        }
        MovingTool mTool = new MovingTool();
        int[] pointB = this.playerToFollow.getLocation();
        pointB[0] += this.xAdjustment;
        pointB[1] += this.yAdjustment;
        return mTool.directonTowardsPointB(playerLocation, pointB);
    }

    @Override
    public int[] getStartingLocation() {
        return this.StartingLocation;
    }

    @Override
    public char getIcon() {
        return this.icon;
    }

    @Override
    public boolean getIsOffensive() {
        return false;
    }

    @Override
    public void playerMoved(int[] where
    ) {
    }

}
