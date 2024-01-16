package com.ss.leetcode.LC2024.january;

import java.util.ArrayList;
import java.util.List;

public class HouseRobberII {
    // https://leetcode.com/problems/house-robber-ii
    // TLE
    public int rob(int[] nums) {
        List<Integer> selectedIndices = new ArrayList<>();
        int[] maxLoot = {0};
        lootHouse(selectedIndices, 0, nums, 0, maxLoot);
        return maxLoot[0];
    }

    private void lootHouse(List<Integer> selectedIndices, int index, int[] houses, int currentLoot, int[] maxLoot) {
        if (index >= houses.length) {
            maxLoot[0] = Math.max(maxLoot[0], currentLoot);
            return;
        }
        //not pick
        lootHouse(selectedIndices, index + 1, houses, currentLoot, maxLoot);
        // pick / can you pick?
        if (selectedIndices.isEmpty()) {
            selectedIndices.add(index);
            lootHouse(selectedIndices, index + 2, houses, currentLoot + houses[index], maxLoot);
            selectedIndices.remove(selectedIndices.size() -1);
        } else {
            if (!(index == houses.length -1 && selectedIndices.get(0) == 0)) {
                selectedIndices.add(index);
                lootHouse(selectedIndices, index + 2, houses, currentLoot + houses[index], maxLoot);
                selectedIndices.remove(selectedIndices.size() -1);
            }
        }
    }
}
