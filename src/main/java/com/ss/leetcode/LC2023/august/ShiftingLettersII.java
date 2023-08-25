package com.ss.leetcode.LC2023.august;

public class ShiftingLettersII {
    // https://leetcode.com/problems/shifting-letters-ii/submissions
    public String shiftingLetters(String s, int[][] shifts) {
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
