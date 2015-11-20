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

    public int readNumber(String string, int startIndex, int endIndex) {
        String intString = "";
        while (endIndex != startIndex - 1) {
            intString = string.charAt(endIndex) + intString;
            endIndex--;
        }
        return Integer.parseInt(intString);

    }
}
