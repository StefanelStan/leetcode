package com.ss.leetcode.LC2023.february;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaximizeWinFromTwoSegments {
    // https://leetcode.com/contest/biweekly-contest-97/problems/maximize-win-from-two-segments/
    /** Algorithm
        1. We want to know how many groups we can build by selecting i (0.n -k) and a number for > i+k.
            EG: [1,2,3,4,5,6,7], k = 3; We want to know the best selection of groups by 1 and >= 5 (> 1+3)
            Then for 2 + bestGroup >= 6 etc
        2. To know how many good group each number can make, we need to count the groups.
        3. Use a linkedList<int[]> to store the int and count of elements.
        4. While traversing, if next element - firstInList > k, we need to evict first element.
            At that stage, we know that ALL the elements in list are part of head's partition.
            Evict head and put the group and size of that number in map/separate list.
        5. Once you have this second list/map, from right to left you need to determine the largest group even encountered.
            As numbers are in order, this list is already sorted
        6. As we have determined step 5, start from head and see the max you can get by adding group of i and largestGroup starting from i +k + 1.
        7. Return the max.
     */
    public int maximizeWin(int[] prizePositions, int k) {
        if (k == 0) {
            return Math.min(prizePositions.length, 2);
        }
        List<int[]> maxGroupInterval = getMaxForEachGroupInterval(prizePositions, k);
        int col = maxGroupInterval.size();
        int[][] maxGroups = getMaxGroupsFromLeft(maxGroupInterval);
        int max = maxGroups[1][0];
        for (int i = 0; i < col - 1; i++) {
            max = Math.max(max, maxGroups[1][i] + getNextHighestGroup(maxGroups, maxGroups[0][i] + k + 1));
        }
        return max;
    }

    private int getNextHighestGroup(int[][] maxGroups, int from) {
        int col = maxGroups[0].length;
        if (maxGroups[0][col - 1] < from) {
            return 0;
        }
        int index = Arrays.binarySearch(maxGroups[0], from);
        if (index >= 0) {
            return maxGroups[2][index];
        } else {
            if (col == Math.abs(index)) {
                return maxGroups[2][col - 1];
            } else {
                return maxGroups[2][Math.abs(index + 1)];
            }
        }
    }

    private int[][] getMaxGroupsFromLeft(List<int[]> maxGroupInterval) {
        int col = maxGroupInterval.size();
        int[][] maxGroups = new int[3][col];
        int index =0;
        for (int[] group : maxGroupInterval) {
            maxGroups[0][index] = group[0];
            maxGroups[1][index] = group[1];
            index++;
        }
        maxGroups[2][col - 1] = maxGroups[1][col - 1];
        for (int i = col - 2; i>= 0; i--) {
            maxGroups[2][i] = Math.max(maxGroups[2][i+1], maxGroups[1][i]);
        }
        return maxGroups;
    }

    private List<int[]> getMaxForEachGroupInterval(int[] prizePositions, int k) {
        LinkedList<int[]> flexibleInterval = new LinkedList<>();
        List<int[]> maxGroupInterval = new LinkedList<>();
        flexibleInterval.add(new int[]{prizePositions[0] ,1});
        int size = 1;
        for (int i = 1; i < prizePositions.length; i++) {
            if (prizePositions[i] == flexibleInterval.peekLast()[0]) {
                flexibleInterval.peekLast()[1]++;
                size++;
            } else {
                if (prizePositions[i] - flexibleInterval.peekFirst()[0] > k) {
                    while (!flexibleInterval.isEmpty() && prizePositions[i] - flexibleInterval.peekFirst()[0] > k) {
                        int[] evicted = flexibleInterval.removeFirst();
                        maxGroupInterval.add(new int[]{evicted[0], size});
                        size -= evicted[1];
                    }
                }
                flexibleInterval.addLast(new int[]{prizePositions[i], 1});
                size++;
            }
        }
        while(!flexibleInterval.isEmpty()) {
            int[] evicted = flexibleInterval.removeFirst();
            maxGroupInterval.add(new int[]{evicted[0], size});
            size -= evicted[1];
        }
        return maxGroupInterval;
    }
}
