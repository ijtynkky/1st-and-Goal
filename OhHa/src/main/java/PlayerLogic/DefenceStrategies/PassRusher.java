package PlayerLogic.DefenceStrategies;

import Objects.Field;
import PlayerLogic.PlayerStrategy;
import PlayerLogic.Tools.MovingTools;
import PlayerLogic.Tools.RouteReader;

/**
 * Puolustavan pelaajan strategia, jossa pelaaja jahtaa pallollista
 * pelaajaa
 */
public class PassRusher implements PlayerStrategy {

    private int[] StartingLocation;
    private final char playerIcon;
    private String optionaRoute;
    private int routeCounter;

    public PassRusher(int[] startingLocation, String icon) {
        this.StartingLocation = startingLocation;
        this.playerIcon = icon.charAt(0);
        this.optionaRoute = "";
        this.routeCounter = 1;

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
        if (this.routeCounter < this.optionaRoute.length()) {
            RouteReader reader = new RouteReader();
            return reader.readRoute(optionaRoute, routeCounter);
        } else {
            MovingTools mTool = new MovingTools();
            int[] pointB = field.getPlayerOff(1).getLocation();
            return mTool.directonTowardsPointB(playerLocation, pointB);
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
        routeCounter++;
    }

}
