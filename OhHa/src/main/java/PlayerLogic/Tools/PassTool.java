/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.Tools;

import Objects.Field;
import Objects.Player;
import tools.DistanceTool;
import tools.Randomizer;

/**
 *
 * @author I
 */
public class PassTool {

    private Randomizer random;
    private DistanceTool dt;

    public PassTool(DistanceTool dt) {
        this.random = new Randomizer();
        this.dt = dt;
    }

    public boolean pass(Field field, Player qb) {
        Player targetPlayer = null;
        int[] targets = qb.getQBStrategy().getPassTargets();
        int i = 0;
        while (i < 5) {
            int target = getTarget(targets);
            if (random.testRandom(targets[target])) {
                return passBall(field, qb, field.getPlayerOff(6 + target + 1));
            } else {
                targets[i] = 0;
                i++;
            }
        }
        return false;
    }

    //Simppeli versio tässä vaiheessa. Myöhemmin satunnaisuutta mukaan
    public boolean passBall(Field field, Player passer, Player reseiver) {
        System.out.println(passer + " PASSES");
        int difficulty = (int) (120 - 3 * Math.floor(dt.getDistance(passer.getLocation(), reseiver.getLocation())));
        if (dt.getDistanceToNearestOpponent(field, passer) <= 2) {
            difficulty -= 25 - 5 * dt.getDistanceToNearestOpponent(field, passer);
        }
        System.out.println("DIF: " + difficulty);
        if (random.testRandom(difficulty)) {
            passer.takeBall();
            reseiver.giveBall();
            System.out.println(reseiver + " CATCHES THE BALL");
            return true;
        } else {
            System.out.println(reseiver + " DROPS THE BALL");
            return false;
        }
    }

    private int getTarget(int[] targets) {
        int returnThis = 0;
        int highest = 0;
        int i = 0;
        while (i < targets.length) {
            if (targets[i] > highest) {
                returnThis = i;
            }
            i++;
        }
        return returnThis;
    }
}
