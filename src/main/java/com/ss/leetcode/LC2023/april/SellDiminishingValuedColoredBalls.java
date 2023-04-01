package com.ss.leetcode.LC2023.april;

import java.util.Arrays;

public class SellDiminishingValuedColoredBalls {
    // https://leetcode.com/problems/sell-diminishing-valued-colored-balls
    /** Algorithm
        1. Count and group the colors: [2,2,3,4,45,6,6,6] orders = 7- > [2,1,2,3] / [2,3,4,6] (2 balls of color1, 1 of color 3 etc
        2. Starting from last index, decide if you can move all the balls from group 6 to grouping 4.
            This means a jump of 2. As you have 3 balls of 6, it means 2 * 3 = 6 orders. So we have 1 more order to fulfil (7-6)
        3. Move the balls from group 6 to group 4. Also increase the count of group 4 by 3.
            TotalValue = 3 (3 groups moved) * (6+5) = 33. (
            [2,1,5] -> [2,3,4].
        4. Next jump is from 4 to 3. 1 jump but 5 groups so 1*5 orders. Will this go over the needed orders? yes, as you only have 1 order
        5. As you have only 1 order, just add one single jump from 4 to 3. (+ 4)
     */
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int[][] group = getGroupCount(inventory);
        long total = 0L, ordersToMove;
        int left;
        for (int i = group[0].length -1; i >= 0 && orders > 0; i--) {
            // can you move whole group to next unique?
            left = i == 0 ? 0 : group[1][i-1];
            ordersToMove = (long)group[0][i] * (group[1][i] - left);
            // if we can move current grouping to next grouping as a whole
            if (orders >= ordersToMove) {
                total += (long)group[0][i] * getIntervalSum(left + 1, group[1][i]);
                orders -= ordersToMove;
                if (i > 0) {
                    group[0][i-1] += group[0][i];
                }
            } else {
                // we can only to a partial move;
                int steps = orders / group[0][i];
                if (steps > 0) {
                    total += (long)group[0][i] * getIntervalSum((group[1][i] - steps) + 1, group[1][i]);
                }
                int landingIndex = group[1][i] - steps;
                steps = orders % group[0][i];
                total += (long)steps * landingIndex;
                break;
            }
        }
        return (int)(total % 1_000_000_007);
    }

    private long getIntervalSum(int start, int end) {
        if (start == end) {
            return end;
        }
        return (long)end * (end + 1) / 2 - (long)start * (start - 1) / 2;
    }

    private int[][] getGroupCount(int[] inventory) {
        int unique = 1;
        for (int i = 1; i < inventory.length; i++) {
            if (inventory[i] != inventory[i-1]) {
                unique++;
            }
        }
        int[][] groupCount = new int[2][unique];
        int groupIndex = 0;
        groupCount[0][0] = 1;
        groupCount[1][0] = inventory[0];
        for (int i = 1; i < inventory.length; i++) {
            if (inventory[i] == inventory[i-1]) {
                groupCount[0][groupIndex]++;
            } else {
                groupIndex++;
                groupCount[0][groupIndex]++;
                groupCount[1][groupIndex] = inventory[i];
            }
        }
        return groupCount;
    }
}
