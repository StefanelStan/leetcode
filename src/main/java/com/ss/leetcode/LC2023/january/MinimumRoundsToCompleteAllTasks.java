package com.ss.leetcode.LC2023.january;

import java.util.Arrays;

public class MinimumRoundsToCompleteAllTasks {
    // https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks
    /** Algorithm
         1. In order to determine the minRounds, we need to know how many of each numbers you have: how many 2s, 3s etc.
            EG: [6,7,8,6,7,8,6]
            3 6s, 2 7s and 2 8s
         2. Once you know this, you can determine the grouping by checking the modulo 3.
            eg: 11 groups: 11 mod 3 = [3,2] -> take 3 groups of 3 and 1 group of 2: 3 3 3 2 (so (count / 3) + 1 in total)
            10 groups: 10 mod 3 = [3,1] -> you cannot take 3 groups of 3, but only 2 (3 x 2 = 6 elements).
            The 4 elements will   be groups as 2 (3 3 2 2). So (count / 3) + 1 = 4 groups ij total)
            9 groups: 9 mod 3 = [3,0] -> you can take exactly 3 groups of 3
            1 groups: return -1
         3. You can sort OR count-map the numbers. Sorting O(1) memory O (n log n) and counting/mapping O(n) memory O(n) time
         4. If counting, traverse each entry in map and check how the value (group count) can be divided/modulo 3.
            Return -1 if any group count is -1
         5. If sorting, traverse each element if if current == previous, increase group count.
            If different, calculate/appent the minRound (by dividing/modulo 3)
     6. Return the minRounds or -1
     */
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int minRounds = 0;
        int currentGroupCount = 1;
        for (int i = 1; i < tasks.length && minRounds != -1; i++) {
            if (tasks[i] == tasks[i-1]) {
                currentGroupCount++;
            } else {
                minRounds = calculateMinRounds(minRounds, currentGroupCount);
                currentGroupCount = 1;
            }
        }
        minRounds = calculateMinRounds(minRounds, currentGroupCount);
        return minRounds;
    }

    private int calculateMinRounds(int minRounds, int currentGroupCount) {
        if (currentGroupCount == 1) {
            return -1;
        } else {
            int remainder = currentGroupCount % 3;
            return minRounds + (remainder == 0 ? currentGroupCount / 3 : currentGroupCount / 3 + 1);
        }
    }
}
