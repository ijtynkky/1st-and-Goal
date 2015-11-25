/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author I
 */
public class StringTools {

    public StringTools() {

    }

    public String removeSpaces(String string) {
        String returnString = "";
        int i = 0;
        while (i < string.length()) {
            String helpString = string.charAt(i) + "";
            if (!helpString.equals(" ")) {
                returnString = returnString + helpString;
            }
            i++;
        }
        return returnString;
    }

    public int readPlayerNumber(String string, int startIndex, int endIndex) {
        String intString = "";
        while (endIndex != startIndex - 1) {
            intString = string.charAt(endIndex) + intString;
            endIndex--;
        }
        return Integer.parseInt(intString);

    }

    public int[] readLocation(String string) {
        int firstNumber = 10 * Integer.parseInt(string.charAt(0) + "") + Integer.parseInt(string.charAt(1) + "");
        System.out.println(firstNumber);
        int secondNumber = 10 * Integer.parseInt(string.charAt(3) + "") + Integer.parseInt(string.charAt(4) + "");
        System.out.println(secondNumber);
        return new int[]{firstNumber, secondNumber};
    }
}
