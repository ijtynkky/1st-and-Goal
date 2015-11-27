/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Objects.Player;

/**
 *
 * @author I
 */
public class BallTool {

    private Randomizer random;

    public BallTool() {
        this.random = new Randomizer();
    }

    //Simppeli versio tässä vaiheessa. Myöhemmin satunnaisuutta mukaan
    public void passBall(Player passer, Player reseiver) {
        passer.takeBall();
        reseiver.giveBall();
    }
}
