package com.ss.leetcode.LC2023.march;

import java.util.ArrayList;
import java.util.List;

public class IntervalsBetweenIdenticalElements {
    /** Algorithm
        1. Traverse arr and map each number to a list of positions.
            [2,1,3,1,2,3,3,3,3,3,3,3]: 1 -> [1,3], 2 -> [0,4], 3-> [2,5,6,7,8,9,10,11].
        2. Intuition would tell you to traverse each position from arr, get its list of other positions and
            calculate the differences.
            EG: i = 7. List of positions of 3 : [2,5,6,7,8,9,10,11].
            Intuition would tell you to calculate the differences: Math.abs(2-7) + .. Math.abs(6-7) +
            Math.abs(8-7) + .. Math.abs(11-7).
        3. However, doing step #2 for all the 3 digits leads to a n^n complexity. What is arr has a length of 100000 and all elements are the same?
            You would have to traverse the list of positions for each element.
        4. Steps #2 and #3 reveal that calculating the diffs for each element is redundant.
            i = 7. We don't need to calculate the abs one by one, but simply apply math: (a-x) + (b-x) + (c-x) = (a+b+c) - 3x.
            We can calculate a+b+c because we know the list of positions => we can calculate the prefix sum.
            i = 7. prefix sum = (2+5+6) = 13. 7 x 3 = 21.  Abs(13 - 21) = 8 == (7-2 + 7-5 + 7-6)
        5. So for each group/unique number, calculate the prefix sum of each index position.
            Based on that, calculate the sum of ALL differences on left + sum of ALL differences on right.
            These two sums will give you the sum of ALL differences between element at pos p and rest of elements that have the same value as element at pos p.
     */
    public long[] getDistances(int[] arr) {
        int[] minMax = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        List[] indexPos = getElementIndexAndMinMax(arr, minMax);
        long[] distances = new long[arr.length];
        List<Integer> positions;
        while(minMax[0] <= minMax[1]) {
            positions = indexPos[minMax[0]];
            if (positions != null) {
                addPositions(distances, positions);
            }
            minMax[0]++;
        }
        return distances;
    }

    private List[] getElementIndexAndMinMax(int[] arr, int[] minMax) {
        List[] indexPos = new List[100_001];
        for(int i = 0; i < arr.length; i++) {
            minMax[0] = Math.min(minMax[0], arr[i]);
            minMax[1] = Math.max(minMax[1], arr[i]);
            if (indexPos[arr[i]] == null) {
                indexPos[arr[i]] = new ArrayList<>();
            }
            List<Integer> positions = indexPos[arr[i]];
            positions.add(i);
        }
        return indexPos;
    }

    private void addPositions(long[] distances, List<Integer> positions) {
        if (positions.size() == 1) {
            distances[positions.get(0)] = 0;
        } else {
            long sumOfDistances = 0L, diffOnLeft, diffOnRight, prefixSum = 0L;
            for (int position : positions) {
                sumOfDistances += position;
            }
            int pos;
            for (int i = 0; i < positions.size(); i++) {
                pos = positions.get(i);
                // (x -a) + (x - b) + (x -c) == 3x - (a+b+c). (Reversing them to avoid math.abs)
                diffOnLeft = i == 0 ? 0 : (long) i * pos - prefixSum;
                diffOnRight = (sumOfDistances - (prefixSum + pos)) - (pos * (long)(positions.size() -1 - i));
                distances[pos] = diffOnLeft + diffOnRight;
                prefixSum += pos;
            }
        }
    }
}
