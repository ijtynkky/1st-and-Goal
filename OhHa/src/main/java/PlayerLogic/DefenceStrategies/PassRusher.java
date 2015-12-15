package PlayerLogic.DefenceStrategies;

import Objects.Field;
import Objects.Player;
import PlayerLogic.DefPlayerStrategy;
import PlayerLogic.PlayerStrategy;
import PlayerLogic.Tools.MovingTool;
import PlayerLogic.Tools.RouteReader;
import tools.Randomizer;

/**
 * Puolustavan pelaajan strategia, jossa pelaaja jahtaa pallollista pelaajaa
 */
public class PassRusher implements DefPlayerStrategy {

    private Player followThisPlayer;
    private int[] StartingLocation;
    private final char playerIcon;
    private String optionaRoute;
    private int routeCounter;
    private boolean qbHasBall;
    private Randomizer random;

    public PassRusher(int[] startingLocation, String icon) {
        this.StartingLocation = startingLocation;
        this.playerIcon = icon.charAt(0);
        this.optionaRoute = "";
        this.routeCounter = 0;
        this.qbHasBall = true;
        this.random = new Randomizer();
    }

    @Override
    public void setStartingLocationByOppPlayerLocation(Player player) {
        int x = player.getLocation()[0];
        int y = this.StartingLocation[1];
        this.StartingLocation = new int[]{x, y};
    }

    @Override
    public void setPlayerToFollow(Player player) {
        this.followThisPlayer = player;
    }

    //Strategialle voi määrittää reitin, jonka pelaaja ensiki kulkee, ennen 
    //kuin lähtee jahtaamaan pallollista pelaajaa
    public PassRusher(int[] startingLocation, String icon, String route) {
        this.StartingLocation = startingLocation;
        this.playerIcon = icon.charAt(0);
        this.optionaRoute = route;
        this.routeCounter = 0;

    }

    public void setRoute(String string) {
        this.optionaRoute = string;
        this.routeCounter = 0;
    }

    @Override
    public int[] getStartingLocation() {
        return this.StartingLocation;
    }

    @Override
    public int getNextMove(Field field, int[] playerLocation) {
        if (this.qbHasBall) {
            this.setPlayerToFollow(field.getPlayerOff(1));
            //Jos QB:lla ei olekkaan palloa, 40% tod näk pass rusher
            //alkaa seuraamaan pelaajaa jolla on pallo
            if (!field.getPlayerOff(1).isBallCarrier()) {
                if (random.testRandom(40)) {
                    this.qbHasBall = false;
                    this.setPlayerToFollow(field.playerWIthBall());
                }
            }
        }

        MovingTool mTools = new MovingTool();

        if (this.routeCounter + 1 < this.optionaRoute.length() && this.qbHasBall) {
            RouteReader reader = new RouteReader();
            return reader.readRoute(optionaRoute, routeCounter);
        } else {

            int[] pointB = this.followThisPlayer.getLocation();
            return mTools.directonTowardsPointB(playerLocation, pointB);
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
    public void playerMoved(int[] where
    ) {
        routeCounter++;
    }

}
