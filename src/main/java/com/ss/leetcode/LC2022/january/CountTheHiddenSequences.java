package com.ss.leetcode.LC2022.january;

public class CountTheHiddenSequences {
    // https://leetcode.com/contest/biweekly-contest-70/problems/count-the-hidden-sequences/

    /**
     * Algorithm
     *  1. In an external loop L1 Start from i= lower & i < higher and try to find THE FIRST sequence of array[] that satisfies the differences
     *  2. In an internal loop L2 try to generate the array from 0 to n, using i as array[0] (starting item)
     *  3. If at any point, any value of the array < lower, break the loop L2 as the i is not right and go to next i
     *  4. If any point any value of array > upper, it means you went too further and you should stop and exit L1.
     *  5. While doing #2, if you have found one sequence, then the number of generated sequences = abs(upper - maxValueInArray).
     *  6. If no sequence was found, return 0;
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int numberOfArrays = 0, maxProposed = Integer.MIN_VALUE;
        int[] proposedArray = new int[differences.length + 1];
        boolean found = false, mustStop = false;
        int wLower = lower;
        while(wLower <= upper && !mustStop) {
            proposedArray[0] = wLower;
            found = true;
            maxProposed = proposedArray[0];
            for (int i = 1; i < proposedArray.length; i++) {
                proposedArray[i] = proposedArray[i-1] + differences[i-1];
                if (proposedArray[i] < lower) {
                    found = false;
                    break;
                } else if (proposedArray[i] > upper) {
                    found = false;
                    mustStop = true;
                } else {
                    maxProposed = Integer.max(maxProposed, proposedArray[i]);
                }
            }
            if (found) {
                return Math.abs(upper - maxProposed) + 1;
            }
            wLower++;
        }
        return 0;
    }
}
