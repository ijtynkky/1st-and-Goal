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
    private String position;

    public PlayerInfo(String name, String position) {
        this.name = name;
        this.playerNumber = 0;
        this.position = position;
        this.touchdowns = 0;
    }

    //FOR TESTS ONLY
    public PlayerInfo(String name, int number) {
        this.name = name;
        this.playerNumber = number;
        this.position = "?";
        this.touchdowns = 0;
    }

    public PlayerInfo(String name, int number, String position) {
        this.name = name;
        this.playerNumber = number;
        this.position = position;
        this.touchdowns = 0;
    }

    public void addTD() {
        this.touchdowns++;
    }

    public String getPosition() {
        return this.position;
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

    @Override
    public String toString() {
        return this.playerNumber + " " + this.name;
    }

}
