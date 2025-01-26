package com.ss.leetcode.LC2025.january;

public class TakingMaximumEnergyFromTheMysticDungeon {
    // https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon
    /** Algorithm
        1. Traverse backwards with i from n-1 to 0.
        2. For each index, the current level of energy gain is energy[i].
        3. If i + k < n, then add the bonus from energy[i+k].
        4. At each step, keep track of maximum gained energy.
     */
    public int maximumEnergy(int[] energy, int k) {
        int maxEnergy = Integer.MIN_VALUE;
        for (int i = energy.length - 1; i >= 0; i--) {
            energy[i] = energy[i] + (i + k < energy.length ? energy[i + k] : 0);
            maxEnergy = Math.max(maxEnergy, energy[i]);
        }
        return maxEnergy;
    }
}
