package com.ss.leetcode.LC2021.february;

public class ShiftingLetters {
    private final char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public String shiftingLetters(String abc, int[] shifts) {
        int[] totalShifts = new int[shifts.length];
        totalShifts[shifts.length - 1] = shifts[shifts.length - 1] % alphabet.length;
        for (int i = shifts.length - 2; i >= 0; i--) {
            totalShifts[i] = (totalShifts[i + 1] + shifts[i]) % alphabet.length;
        }
        char[] returnChar = new char[abc.length()];

        for (int i = 0; i < abc.length(); i++) {
            returnChar[i] = alphabet[((abc.charAt(i) - 'a') + totalShifts[i]) % alphabet.length];
        }

        return new String(returnChar);
    }
}
