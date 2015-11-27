package PlayerLogic.DefenceStrategies;

import Objects.Field;
import Objects.Player;
import PlayerLogic.PlayerStrategy;
import PlayerLogic.Tools.MovingTools;

/**
 *Puolustajan strategia, jossa puolustaja seuraa nimettyä pelaajaa
 */
public class ManCover implements PlayerStrategy {

    private Player playerToFollow;
    private int[] StartingLocation;
    private final char playerIcon;
    private int xAdjustment;
    private int yAdjustment;

    public ManCover(int[] startingLocation, Player followThisPlayer, String icon) {
        this.StartingLocation = startingLocation;
        this.playerIcon = icon.charAt(0);
        this.playerToFollow = followThisPlayer;
        this.xAdjustment = 0;
        this.yAdjustment = 0;
    }

    //Man coveriin voi halutessa antaa x ja y parametrit, jolloin puolustaja
    //ei liiku suoraan kohti pelaajaa, vaan hieman siitä ohi
    public ManCover(int[] startingLocation, Player followThisPlayer, String icon, int x, int y) {
        this.StartingLocation = startingLocation;
        this.playerIcon = icon.charAt(0);
        this.playerToFollow = followThisPlayer;
        this.xAdjustment = x;
        this.yAdjustment = y;
    }

    //Pelin käydessä lennosta vaihdettavaa taktiikkaa varten oleva konstruktori
    public ManCover(Player followThisPlayer) {
        this.StartingLocation = null;
        this.playerToFollow = followThisPlayer;
        this.playerIcon = '?';
        this.xAdjustment = 0;
        this.yAdjustment = 0;
    }

    public void setPlayerToFollow(Player player) {
        this.playerToFollow = player;
    }

    @Override
    public int getNextMove(Field field, int[] playerLocation) {
        if (this.playerToFollow.isBallCarrier()) {
            this.xAdjustment = 0;
            this.yAdjustment = 0;
        }
        MovingTools mTool = new MovingTools();
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
        return this.playerIcon;
    }

    @Override
    public boolean getIsOffensive() {
        return false;
    }

    @Override
    public void playerMoved(int[] where) {
    }

}
