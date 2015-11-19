/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Random;

/**
 *
 * @author I
 */
public class Randomizer {
    private Random random;
    
    public Randomizer() {
        this.random = new Random();
    }
    
    public boolean testRandom(int succesRate) {
        int a = this.random.nextInt(100);
        return true;
        
    }
}
