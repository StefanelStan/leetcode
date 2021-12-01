package com.ss.leetcode.LC2021.may;

public class JewelsAndStones {
    // https://leetcode.com/problems/jewels-and-stones/
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] markedJewels = new boolean['z' + 1];
        int numberOfJewels = 0;

        for (int i = 0; i < jewels.length(); i++) {
            markedJewels[jewels.charAt(i)] = true;
        }

        for (int i = 0; i < stones.length(); i++) {
            if (markedJewels[stones.charAt(i)]) {
                numberOfJewels++;
            }
        }

        return numberOfJewels;
    }
}
