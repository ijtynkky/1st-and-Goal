/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerLogic;

import Objects.Player;

/**
 *
 * @author I
 */
public interface DefPlayerStrategy extends PlayerStrategy {
    
    public void setStartingLocationByOppPlayerLocation(Player player);

    public void setPlayerToFollow(Player player);
}
