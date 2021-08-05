package com.ss.leetcode.august;

public class StoneGame {
    // https://leetcode.com/problems/stone-game/
    public boolean stoneGame(int[] piles) {
        int alex = 0, lee = 0, left = 0, right = piles.length -1;
        while(left < right) {
            if(piles[left] < piles[right]) {
                alex += piles[right--];
            } else {
                alex += piles[left++];
            }
            if(piles[left] < piles[right]) {
                lee += piles[left++];
            } else {
                lee += piles[right--];
            }
        }
        return alex > lee;
    }
}
