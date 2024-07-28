package com.ss.leetcode.LC2024.july;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumTotalDamageWithSpellCasting {
    // https://leetcode.com/problems/maximum-total-damage-with-spell-casting
    /** Algorithm
        1. Sort and group/count the spells by power: [sellPower, count] [4,4,3,2,1,1] -> [1,2], [2,1], [3,1],[4,2] (2 spells of power 1, 1 spell of power 2)
            into an int[][] spellPower
        2. As they are sorted/grouped by power, we realize that for a index i, if we pick that index, we get the power * count damage AND whatever other
            totalDamage that can be found to the LEFT of i where spellPower[j][0] < spellPower[i][0] - 2 (cannot pick other spells +/- 2as power)
        3. Thus, using another array long[][]totalDamage, for each index i, we have to choose the max value we can get
            - pick current spell and look to the left for the first next totalDamage that has power < currentPow - 2
            - ignore current spell and chose the one from the left as it brings more total damage
        4. totalDamage[][] will store [totalPower, powerLimit]
            - if you pick current spell, then totalDamage[][1] is currentPower + 2, meaning you ban other RIGHT indices to pick this
                index if their used power is less than currentPower + 2
            - if you skip current spell, then the one in immediate left will propagate its power_threshold.
        5. Return totalDamage[n][0]
     */

    public long maximumTotalDamage(int[] power) {
        int[][] spellPower = getSpellPower(power);
        long[][] totalDamage = new long[spellPower.length][2]; // [totalDamage, power_threshold]
        for (int i = 0; i < spellPower.length; i++) {
            setTotalDamage(i, spellPower, totalDamage);
        }
        return totalDamage[spellPower.length - 1][0];
    }

    private void setTotalDamage(int index, int[][] spellPower, long[][] totalDamage) {
        long pickCurrentSpellDamage = (long)spellPower[index][0] * spellPower[index][1];
        long skipCurrentSpellDamage = index == 0 ? 0L : totalDamage[index - 1][0];
        for (int i = index - 1; i >= 0; i--) {
            if (totalDamage[i][1] < spellPower[index][0]) {
                pickCurrentSpellDamage += totalDamage[i][0];
                break;
            }
        }
        if (pickCurrentSpellDamage > skipCurrentSpellDamage) {
            totalDamage[index][0] = pickCurrentSpellDamage;
            totalDamage[index][1] = spellPower[index][0] + 2;
        } else {
            totalDamage[index][0] = skipCurrentSpellDamage;
            totalDamage[index][1] = totalDamage[index - 1][1];
        }
    }

    private int[][] getSpellPower(int[] power) {
        Arrays.sort(power);
        int[][] spellPower = new int[power.length][2];
        int insertIndex = 0;
        spellPower[0]= new int[]{power[0], 1};
        for (int i = 1; i < power.length; i++) {
            if (power[i] != power[i-1]) {
                insertIndex++;
            }
            spellPower[insertIndex][0] = power[i];
            spellPower[insertIndex][1]++;
        }
        Arrays.sort(spellPower, 0, insertIndex + 1, Comparator.comparingLong(a -> a[0]));
        return Arrays.copyOf(spellPower, insertIndex + 1);
    }
}
