package com.ss.leetcode.LC2022.january;

import java.util.HashSet;
import java.util.Set;

public class XOfAKindInADeckOfCards {
    // https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
    /** Algorithm
         1. Count the cards by type. Use an array[10000] as max card is 9999
         2. Traverse and add each count to a set or list (set to avoid duplicates).
         Also, keep track of min card count. Any deck size must be between 2 and minCardCount
         If any count is 1 then return false as min deck size must be 2.
         [1,2]* You can use a Map<Int, Int> and map.merge() but maps are slower than raw arrays
         3. Loop with i from 2 -> minCardCount; try to divide each card count of set to i.
         4. Return immediately when you found one i that divides all cards from set.
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] cardCount = new int[10000];
        for (int card : deck) {
            cardCount[card]++;
        }
        int minCount = 10001;
        Set<Integer> counts =  new HashSet<>();
        for(int count : cardCount) {
            if (count == 1) {
                return false;
            }
            if (count > 1) {
                counts.add(count);
                minCount = Math.min(minCount, count);
            }
        }
        boolean canSplit = true;
        for (int i = 2; i <= minCount; i++) {
            canSplit = true;
            for (int count : counts) {
                if (count % i != 0) {
                    canSplit = false;
                    break;
                }
            }
            if(canSplit) {
                break;
            }
        }
        return canSplit;
    }
}
