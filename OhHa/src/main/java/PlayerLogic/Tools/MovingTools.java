/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic.Tools;

import Objects.Field;

/**
 *
 * @author I
 */
public class MovingTools {
    
    public MovingTools() {
        
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
}
