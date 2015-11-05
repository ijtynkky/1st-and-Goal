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
    private int route;
    private boolean isOffensivePlayer;
    private int[] goal;
    private char drawChar; //what ascii wark the program will draw

    public PlayerStrategy(int[] starts, int route, int[] goal, boolean offensivePlayer) {
        this.goal = goal;
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.drawChar = "?".charAt(0);
    }

    public PlayerStrategy(int[] starts, int route, boolean offensivePlayer) {
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.drawChar = "?".charAt(0);
    }

    public PlayerStrategy(int[] starts, int route, boolean offensivePlayer, char c) {
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.drawChar = c;
    }

    public PlayerStrategy(int[] starts, int route, int[] goal, boolean offensivePlayer, char c) {
        this.goal = goal;
        this.route = route;
        this.startingLocation = starts;
        this.isOffensivePlayer = offensivePlayer;
        this.drawChar = c;
    }

    public int[] getStartingLocation() {
        return this.startingLocation;
    }

    public int getRoute() {
        return this.route;
    }

    public int[] getGoal() {
        return this.goal;
    }

    public boolean getIsOffensive() {
        return this.isOffensivePlayer;
    }

    public char getDrawChar() {
        return this.drawChar;
    }
}
