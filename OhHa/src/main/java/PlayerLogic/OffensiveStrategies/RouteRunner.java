package PlayerLogic.OffensiveStrategies;

import Objects.Field;
import PlayerLogic.PlayerStrategy;
import PlayerLogic.Tools.RouteReader;

/*
 * Hyökkääjän strategia, jossa hyökkääjä pyrkii juoksemaan ennalta
 * määrätty reitti. Käytetään pääasiassa "reseiver" pelaajilla
 * (WR, TE, ja RB)
 */
public class RouteRunner implements PlayerStrategy {

    private final int[] startingLocation;
    private String route;
    private int moveCounter;
    public static final boolean ISOFFENSIVE = true;
    private final char playerIcon;
    private RouteReader reader;

    //For starting strategy:
    public RouteRunner(int[] startingLocation, String route, String icon) {
        this.startingLocation = startingLocation;
        this.route = route;
        this.playerIcon = icon.charAt(0);
        this.moveCounter = 0;
        this.reader = new RouteReader();
    }

    // Short version of strategy to change during game.
    public RouteRunner(String route) {
        this.route = route;
        this.moveCounter = 0;
        this.startingLocation = null;
        this.playerIcon = "?".charAt(0);
        this.reader = new RouteReader();
    }

    @Override
    public int[] getStartingLocation() {
        return this.startingLocation;
    }

    @Override
    public int getNextMove(Field field, int[] playerLocation) {
        return this.reader.readRoute(this.route, this.moveCounter);
    }

    @Override
    public char getIcon() {
        return this.playerIcon;
    }

    @Override
    public boolean getIsOffensive() {
        return ISOFFENSIVE;
    }

    @Override
    public void playerMoved(int[] where) {
        this.moveCounter++;
    }

    public int geMoveCounter() {
        return this.moveCounter;
    }
}
