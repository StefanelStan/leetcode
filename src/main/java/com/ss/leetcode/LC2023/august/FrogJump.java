package com.ss.leetcode.LC2023.august;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    // https://leetcode.com/problems/frog-jump
    /** Algorithm
        1. Use a Map<Integer, Boolean>[] array to cache the answer of index can make a jump for given interval
        2. Starting with index 0, determine if jumps with interval k +[-1,0 +1] can be made.
        3. Use binary search to determine if stone index + k exists. If yes, cache the positive answer.
        4. Recursively, in a DFS manner, determine if from index 1 can jump to [1] + k[-1,0,1].
        5. If you reach the last index, it means you can jump to last stone.
     */
    public boolean canCross(int[] stones) {
        Map<Integer, Boolean>[] canJump = new Map[stones.length];
        canJump[stones.length - 1] = new HashMap<>();
        return jumpStones(0, 0, stones, canJump);
    }

    private boolean jumpStones(int index, int interval, int[] stones, Map<Integer, Boolean>[] canJump) {
        if (index == stones.length -1) {
            return true;
        }
        if (canJump[index] == null) {
            canJump[index] = new HashMap<>();
        }
        Map<Integer, Boolean> cache = canJump[index];
        boolean possibleJump = false;
        int kIntervalIndex;
        for (int i = interval - 1; i <= interval + 1 && !possibleJump; i++) {
            kIntervalIndex = findStone(stones, index + 1, stones[index] + i);
            if (kIntervalIndex != -1) {
                if (!cache.containsKey(i)) {
                    possibleJump = jumpStones(kIntervalIndex, i, stones, canJump);
                    cache.put(i, possibleJump);
                }
            }
        }
        return possibleJump;
    }

    private int findStone(int[] stones, int low, int target) {
        int high = stones.length - 1, pivot;
        while(low <= high) {
            pivot = low + (high - low) / 2;
            if (stones[pivot] == target) {
                return pivot;
            } else if (stones[pivot] < target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return -1;
    }
}
