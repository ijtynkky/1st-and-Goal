package PlayerLogic.DefenceStrategies;

import Objects.Field;
import Objects.Player;
import PlayerLogic.DefPlayerStrategy;
import PlayerLogic.PlayerStrategy;
import PlayerLogic.Tools.MovingTool;
import tools.Randomizer;

/**
 *Puolustavan pelaajan strategia, jossa puolustajalla on alue kentällä, jota hän puolustaa.
 */
public class ZoneCover implements DefPlayerStrategy {

    private Player followThisPlayer;
    private int[] StartingLocation;
    private int[] zoneCenter;
    private final char playerIcon;
    private boolean qbHasBall;
    private Randomizer random;
    private int moveCounter;

    public ZoneCover(int[] startingLocation, String playerIcon) {
        this.StartingLocation = startingLocation;
        this.playerIcon = playerIcon.charAt(0);
        this.qbHasBall = true;
        this.random = new Randomizer();
        this.zoneCenter = new int[]{0, 0};
        this.moveCounter = 0;
    }

    @Override
    public void setStartingLocationByOppPlayerLocation(Player player) {
        int x = player.getLocation()[0];
        int y = this.StartingLocation[1];
        this.StartingLocation = new int[]{x, y};
    }

    public void setZoneCenter(int[] center) {
        this.zoneCenter = center;
    }

    @Override
    public void setPlayerToFollow(Player player) {
        this.followThisPlayer = player;
    }

    @Override
    public int[] getStartingLocation() {
        return this.StartingLocation;
    }

    @Override
    public int getNextMove(Field field, int[] playerLocation) {
        if (this.qbHasBall && !field.getPlayerOff(1).isBallCarrier()) {
            if (random.testRandom(30)) {
                this.qbHasBall = false;
                this.setPlayerToFollow(field.playerWIthBall());
            }
        }
        MovingTool mTool = new MovingTool();
        if (!qbHasBall) {
            return mTool.directionTowardsPlayerWithBall(field, playerLocation);
        }
        if (this.moveCounter < 5 && this.qbHasBall) {
            return mTool.directonTowardsPointB(playerLocation, zoneCenter);
        } else {
            return mTool.towardsClosestOpponent(field, playerLocation, false);
        }

    }

    @Override
    public char getIcon() {
        return this.playerIcon;
    }

    @Override
    public boolean getIsOffensive() {
        return false;
    }

    @Override
    public void playerMoved(int[] where) {
        this.moveCounter++;
    }
}
