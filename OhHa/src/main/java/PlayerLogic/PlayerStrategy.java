/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

/**
 *
 * @author I
 */
public class PlayerStrategy {
    /*
     "startingLocasion" will be relative to line of skirmish, so offensive player x value has to be -10 > x > 0
     "route" has two parts: route[0] is counter, which will tell what stage player is at route, second one is moving direction typed together,
     expample 44448 is four squares left, one up.
     "goal" is a place is a square in the field which player is trying to get. Can be used to override route.
     */

    private int[] startingLocation;
    private String route;
    private boolean isOffensivePlayer;
    private int[] goal;
    private String icon; //what ascii mark the program will draw

    
    public PlayerStrategy(int[] starts, String route, int[] goal, boolean offensivePlayer) {
        this.goal = goal;
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.icon = "?";
    }

    public PlayerStrategy(int[] starts, String route, boolean offensivePlayer) {
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.icon = "?";
    }

    public PlayerStrategy(int[] starts, String route, boolean offensivePlayer, String c) {
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.icon = c;
    }

    public PlayerStrategy(int[] starts, String route, int[] goal, boolean offensivePlayer, String c) {
        this.goal = goal;
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.icon = c;
    }

    public int[] getStartingLocation() {
        return this.startingLocation;
    }

    public String getRoute() {
        return this.route;
    }

    public int[] getGoal() {
        return this.goal;
    }

    public boolean getIsOffensive() {
        return this.isOffensivePlayer;
    }

    public String getIcon() {
        return this.icon;
    }
}
