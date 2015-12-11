package PlayerLogic.Tools;

import Objects.Field;
import Objects.Player;
import tools.DistanceTool;
import tools.Randomizer;

/*MOVING
 directions, @ is player:
 7 8 9
 4 @ 6
 1 2 3
    
 */
public class MovingTool {

    private Randomizer random;
    private DistanceTool dt;

    public MovingTool() {
        this.random = new Randomizer();
        this.dt = new DistanceTool();
    }

    public int directonTowardsPointB(int[] pointA, int[] pointB) {
        int x = pointB[0] - pointA[0];
        int y = pointB[1] - pointA[1];
        int returnThis = -999;
        if (x < 0) {
            if (y < 0) {
                returnThis = 1;
            } else if (y > 0) {
                returnThis = 7;
            } else {
                returnThis = 4;
            }
        } else if (x > 0) {
            if (y < 0) {
                returnThis = 3;
            } else if (y > 0) {
                returnThis = 9;
            } else {
                returnThis = 6;
            }
        } else {
            if (y < 0) {
                returnThis = 2;
            } else {
                returnThis = 8;
            }

        }
        return returnThis;
    }

    public int directionTowardsPlayerWithBall(Field field, int[] playerLocation) {
        if (field.playerWIthBall().equals(null)) {
            return 5;
        } else {
            int[] pointB = field.getPlayerOff(1).getLocation();
            return this.directonTowardsPointB(playerLocation, pointB);
        }
    }

    public int awayFromTheClosestOpponent(Field field, Player player) {
        int[] awayFromThis = dt.nearestOpponentPlayerLocation(field, player);
        int a = player.getLocation()[0] - (awayFromThis[0] - player.getLocation()[0]);
        int b = player.getLocation()[1] - (awayFromThis[1] - player.getLocation()[1]);
        return this.directonTowardsPointB(player.getLocation(), new int[]{a, b});
    }
    /*
    
     */

    public int dodge(int preferedDirection) {
        int option1 = 0;
        int option2 = 0;
        int option3 = 0;
        if (preferedDirection == 1) {
            option1 = 3;
            option2 = 2;
            option3 = 6;
        } else if (preferedDirection == 3) {
            option1 = 1;
            option2 = 2;
            option3 = 4;
        } else if (preferedDirection == 2) {
            option1 = 1;
            option2 = 3;
            option3 = 8;
        } else if (preferedDirection == 4) {
            option1 = 1;
            option2 = 7;
            option3 = 6;
        } else if (preferedDirection == 6) {
            option1 = 3;
            option2 = 9;
            option3 = 4;
        } else if (preferedDirection == 7) {
            option1 = 9;
            option2 = 8;
            option3 = 6;
        } else if (preferedDirection == 9) {
            option1 = 7;
            option2 = 8;
            option3 = 4;
        } else if (preferedDirection == 8) {
            return random.randomDirection();
        }
        int getRandom = random.threeOptions(20, 20);
        if (getRandom == 1) {
            return option1;
        } else if (getRandom == 2) {
            return option2;
        } else {
            return option3;
        }
    }

    public boolean tackle() {
    return random.testRandom(30);
    }
}
