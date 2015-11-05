/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author I
 */
public class PlayerInfo {

    private String name;
    private int playerNumber;
    private int touchdowns;

    public PlayerInfo(String name, int number) {
        this.name = name;
        this.playerNumber = number;
        this.touchdowns = 0;
    }

    public void addTD() {
        this.touchdowns++;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.playerNumber;
    }

    public int getTD() {
        return this.touchdowns;
    }
    
    
}
