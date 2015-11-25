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
public class PlayerStrategyasdf {
    /*
     */

    private int[] startingLocation;
    private String route;
    private boolean isOffensivePlayer;
    private int[] goal;
    private String icon; //what ascii mark the program will draw

    public PlayerStrategyasdf(int[] starts, String route, int[] goal, boolean offensivePlayer) {
        this.goal = goal;
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.icon = "?";
    }

    public PlayerStrategyasdf(int[] starts, String route, boolean offensivePlayer) {
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.icon = "?";
    }

    public PlayerStrategyasdf(int[] starts, String route, boolean offensivePlayer, String c) {
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.icon = c;
    }

    public PlayerStrategyasdf(int[] starts, String route, int[] goal, boolean offensivePlayer, String c) {
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
