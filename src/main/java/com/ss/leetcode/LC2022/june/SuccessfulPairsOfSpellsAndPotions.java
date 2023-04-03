package com.ss.leetcode.LC2022.june;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SuccessfulPairsOfSpellsAndPotions {
    // https://leetcode.com/contest/biweekly-contest-80/problems/successful-pairs-of-spells-and-potions/
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] successfulPairs = new int[spells.length];
        for (int i = 0; i < successfulPairs.length; i++) {
            successfulPairs[i] = getSuccessfulPairs(spells[i], potions, success);
        }
        return successfulPairs;
    }

    private int getSuccessfulPairs(int spell, int[] potions, long success) {
        long minStrength = success / spell;
        if (minStrength * spell < success) {
            minStrength++;
        }
        if (minStrength > 100_000) {
            return 0;
        }
        return potions.length - findMinIndexOf(potions, (int)minStrength);
    }

    private int findMinIndexOf(int[] potions, int minStrength) {
        if (potions[0] == minStrength) {
            return 0;
        } else if (minStrength > potions[potions.length -1]) {
            return potions.length;
        }
        int idx = Arrays.binarySearch(potions, minStrength);
        if (idx >= 0) {
            while (idx > 0 && potions[idx-1] == minStrength) {
                idx--;
            }
        } else {
            idx = Math.abs(idx + 1);
        }
        return Math.max(0, idx);
    }

    /**
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        TreeMap<Integer, int[]> countOfPotions = getCountOfPotions(potions);
        int[] pairs = new int[spells.length];
        long toLookFor = 0;
        for (int i = 0; i < spells.length; i++) {
            toLookFor = success / spells[i];
            if (toLookFor > 100_000) {
                pairs[i] = 0;
                continue;
            }
            Entry<Integer, int[]> found = countOfPotions.floorEntry((int) toLookFor);
            if (found == null) {
                pairs[i] = potions.length;
            } else {
                long product = (long)found.getKey() * spells[i];
                if (product < success) {
                    pairs[i] = potions.length - found.getValue()[0];
                } else {
                    pairs[i] = (potions.length - found.getValue()[0]) + found.getValue()[1];
                }
            }
        }
        return pairs;
    }

    private TreeMap<Integer, int[]> getCountOfPotions(int[] potions) {
        TreeMap<Integer, int[]> countOfPotions = new TreeMap<>();
        for (int i = 0; i < potions.length; i++) {
            int[] nrOfPotions = countOfPotions.computeIfAbsent(potions[i], k -> new int[]{0,0});
            nrOfPotions[1]++;
            if (i == potions.length -1) {
                nrOfPotions[0] = i + 1;
            } else if (i < potions.length-1 && potions[i] != potions[i+1]) {
                nrOfPotions[0] = i + 1;
            }
        }
        return countOfPotions;
    }
     */
}
