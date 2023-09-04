package com.ss.leetcode.LC2023.september;

import java.util.Arrays;

public class CanConvertStringInKMoves {
    // https://leetcode.com/problems/can-convert-string-in-k-moves
    /** Algorithm
        1. The key is to count how many group of modulos you have for the given k.
            EG: 27: [1,2,3...26,27]. All of these % 26 would result [1,2,...1]. Two elements (1 and 27) % 26 = 1. So modulo[1] = 2.
        2. For given k calculate the groups of modulos
        3. Traverse s and t and for each index, if the chars are disting, calculate their distance.
            a -> c = 2 ; y -> b = 3.
        4. For each such distinct pair, deduct 1 from their modulo groups. If the modulo groups goes below 0,
            it means you do not have enough numbers to cover their modulos.
     */
    public boolean canConvertString(String s, String t, int k) {
        if (k == 0) {
            return s.equals(t);
        } else if (s.length() != t.length()) {
            return false;
        }
        int[] modulos = getModulos(k);
        return canConvert(s, t, modulos);
    }

    private boolean canConvert(String s, String t, int[] modulos) {
        char first, second;
        int distance;
        for (int i = 0; i < s.length(); i++) {
            first = s.charAt(i);
            second = t.charAt(i);
            if (first != second) {
                distance = first < second ? second - first : (26 - first) + second;
                if (--modulos[distance] < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] getModulos(int k) {
        int[] modulos = new int[26];
        int div = k / 26;
        Arrays.fill(modulos, div);
        k = k % 26;
        while (k >= 0) {
            modulos[k--]++;
        }
        return modulos;
    }
}
