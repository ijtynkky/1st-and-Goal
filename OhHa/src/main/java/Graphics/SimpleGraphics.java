/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Objects.Field;

public class SimpleGraphics {

    public void drawSmallField(Field field){
        int i = 1;
        while(i<field.getSize()[1]+5) {
            this.DrawRow(field, i);
        }
    }
    
    public void DrawRow(Field field, int y){
        int i = 1;
        while (i<field.getSize()[0]+1) {
            int[] square = {i,y};
            ///** JOS PELAAJA if (field.)
            
        }
        
    }
}
