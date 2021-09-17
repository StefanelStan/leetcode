package com.ss.leetcode.september;

public class LastStoneWeight {
    // https://leetcode.com/problems/last-stone-weight/
    public int lastStoneWeight(int[] stones) {
        int[] stoneCount = new int[1001];
        int end = -1;
        for (int stone : stones) {
            stoneCount[stone]++;
            end = Math.max(stone, end);
        }
        boolean noneFound;
        while (end >= 1) {
            if (stoneCount[end] % 2 != 0) {
                noneFound = true;
                for (int nextEnd = end - 1; nextEnd >= 1; nextEnd--) {
                    if (stoneCount[nextEnd] > 0) {
                        stoneCount[end - nextEnd]++;
                        stoneCount[nextEnd]--;
                        end = Math.max(nextEnd, end - nextEnd);
                        noneFound = false;
                        break;
                    }
                }
                if (noneFound) {
                    return end;
                }
            } else {
                end--;
            }
        }
        return end;
    }
}
