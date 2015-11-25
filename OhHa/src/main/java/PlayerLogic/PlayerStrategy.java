/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

import Objects.Field;

/**
 *
 * @author I
 */
public interface PlayerStrategy {

    public int[] getStartingLocation();

    public int getNextMove(Field field, int[] playerLocation);

    public char getIcon();

    public boolean getIsOffensive();
    
    public void playerMoved(int[] where);
}
