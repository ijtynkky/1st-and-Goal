/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.OffensiveStrategies;

import Objects.Field;
import PlayerLogic.PlayerStrategy;
import PlayerLogic.Tools.MovingTool;
import PlayerLogic.Tools.RouteReader;

/**
 *
 * @author I
 */
public class Quaterback implements PlayerStrategy {

    private final int[] startingLocation;
    private final char playerIcon;
    private int passTimer;
    private int routeCounter;
    private String route;
    private int firstTarget;        //luku 0-100, tod näk että heittää kyseiselle
    private int secondTarget;
    private int thirdTarget;
    private int forthTarget;
    private int fifthTarget;

    public Quaterback(int[] startingLocation, String icon, String route, int passTimer) {
        this.startingLocation = startingLocation;
        this.playerIcon = icon.charAt(0);
        this.passTimer = passTimer;
        this.route = route;
        this.routeCounter = 0;
        this.firstTarget = 0;
        this.secondTarget = 0;
        this.thirdTarget = 0;
        this.forthTarget = 0;
        this.fifthTarget = 0;
    }

    public void addRoute(String string) {
        this.route = string;
    }

    @Override
    public int[] getStartingLocation() {
        return this.startingLocation;
    }

    @Override
    public int getNextMove(Field field, int[] playerLocation) {
        if (this.passTimer < 1) {
            return 999;
        }
        MovingTool mTools = new MovingTool();
        if (this.routeCounter + 1 < this.route.length()) {
            RouteReader reader = new RouteReader();
            return reader.readRoute(route, routeCounter);
        } else {
            return 5;
        }
    }

    @Override
    public char getIcon() {
        return this.playerIcon;
    }

    @Override
    public boolean getIsOffensive() {
        return true;
    }

    @Override
    public void playerMoved(int[] where) {
        this.routeCounter++;
        this.passTimer--;
    }

    public int getPassTimer() {
        return this.passTimer;
    }

    public void setPassTarget(int player1to5, int proba) {
        if (player1to5 == 1) {
            this.firstTarget = proba;
        }
        if (player1to5 == 2) {
            this.secondTarget = proba;
        }
        if (player1to5 == 3) {
            this.thirdTarget = proba;
        }
        if (player1to5 == 4) {
            this.forthTarget = proba;
        }
        if (player1to5 == 5) {
            this.fifthTarget = proba;
        }
    }

    public int[] getPassTargets() {
        return new int[]{this.firstTarget, this.secondTarget, this.thirdTarget, this.forthTarget, this.fifthTarget};
    }

    public void hurryPass() {
        this.passTimer--;
    }

    public void delayPass() {
        this.passTimer++;
    }
}
