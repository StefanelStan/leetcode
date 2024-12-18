package com.ss.leetcode.LC2024.december;

import java.util.Arrays;

public class MaximumPointsAfterEnemyBattles {
    // https://leetcode.com/problems/maximum-points-after-enemy-battles
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        long points = 0, energy = currentEnergy;
        for (int left = 0, right = enemyEnergies.length - 1; left <= right;) {
            if (energy >= enemyEnergies[left]) {
                points += (energy / enemyEnergies[left]);
                energy = energy % enemyEnergies[left];
            } else if (points > 0) {
                energy += enemyEnergies[right--];
            } else {
                break;
            }
        }
        return points;
    }
}
