/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Graphics.*;
import Objects.*;
import PlayerLogic.*;

public class SimpleGraphics {

    public void drawField(Field field) {
        int i = field.getSize()[1] + 10;
        while (i != 0) {
            this.DrawRow(field, i);
            System.out.println("");
            i--;
        }
    }
    /*
     field.partOfField(square) = int 
     Returns what type the squre is
     0 = totaly out, no go
     1 = normal field
     2 = Endzone
     4 = LOS
     TO DO grafiikkaa varten, tee myöhemmin:
     3 = out of bounds
     5 = 10 yard
     6 = Hashmark
     */

    private void DrawRow(Field field, int y) {
        int i = 1;
        int x = field.getSize()[0] + 1;
        while (i < x) {
            int[] square = {i, y};
            Player player = field.getPlayerInThisPlace(square);
            if (player != null) {
                System.out.print(player.getPlayerIcon());
            } else {
                int fieldType = field.partOfField(square);
                if (fieldType == 1) {
                    System.out.print(",");
                } else if (fieldType == 2) {
                    System.out.print("$");
                } else if (fieldType == 4) {
                    System.out.print("-");
                }
            }
            i++;
        }

    }
}
