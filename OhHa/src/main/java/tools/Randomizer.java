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

    public boolean testRandom(int successRate) {
        int a = this.random.nextInt(99) + 1;
        {
            if (a > successRate) {
                return false;
            } else {
                return true;
            }
        }

    }
    
    public int randomNonLinemanPlayerPosition() {
        return 7+ this.random.nextInt(5);
    } 

    public int threeOptions(int firstProba, int secondProba) {
        int a = this.random.nextInt(99) + 1;
        if (a <= firstProba) {
            return 1;
        } else if (a <= secondProba + firstProba) {
            return 2;
        } else {
            return 3;
        }
    }

    public int randomDirection() {
        return this.random.nextInt(8) + 1;
    }
}
