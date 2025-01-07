package com.ss.leetcode.LC2023.august;

public class ShiftingLettersII {
    // https://leetcode.com/problems/shifting-letters-ii/submissions
    /** Algorithm
        1. Use a int[] shiftintCoefficients (sc) to mark the beginning and end of each shift.
        2. At the end, you can traverse this line and add the shifting coefficients.
            -  Moving backwards direction means you shift to the right by 25 positions
        3. EG:
            - shift = [0,2,1]
                => sc[0] += 1
                => sc[3] -= 1;
            - shift = [2,4,0]
                => sc[2] += 25 (move left aka move to the right by 25 positions)
                => sc[5] +-= 25
        4. For each index - prefixSum, apply a modulo % 26 and determine how many shift are needed for that letter.
     */
    public String shiftingLetters(String s, int[][] shifts) {
        int[] shiftCoefficients = new int[s.length() + 1];
        int shifting = 0;
        for (int[] shift : shifts) {
            shifting = shift[2] == 1 ? 1 : 25;
            shiftCoefficients[shift[0]] += shifting;
            shiftCoefficients[shift[1] + 1] -= shifting;
        }
        char[] chars = s.toCharArray();
        int currentCoefficient = 0;
        for (int i = 0; i < chars.length; i++) {
            currentCoefficient += shiftCoefficients[i];
            chars[i] = (char)('a' + (((chars[i] + currentCoefficient) - 97) % 26));
        }
        return new String(chars);
    }

    public String shiftingLetters2(String s, int[][] shifts) {
        int[] direction = mergeShifts(s.length() + 1, shifts);
        char[] chars = s.toCharArray();
        int orientation = 0;
        for (int i = 0; i < chars.length; i++) {
            orientation += direction[i];
            chars[i] = shiftLetter(chars[i], orientation % 26);
        }
        return new String(chars);
    }

    private char shiftLetter(char ch, int orientation) {
        if (orientation == 0) {
            return ch;
        }
        if (orientation < 0) {
            orientation = (26 - Math.abs(orientation));
        }
        int c = (ch + orientation) % 123;
        return (char) (c >= 'a' ? c : 'a' + c);
    }

    private int[] mergeShifts(int length, int[][] shifts) {
        int[] direction = new int[length];
        for(int[] shift : shifts) {
            if (shift[2] == 0) {
                direction[shift[0]] += -1;
                direction[shift[1] + 1] += 1;
            } else {
                direction[shift[0]] += 1;
                direction[shift[1] + 1] += -1;
            }

        }
        return direction;
    }
}
