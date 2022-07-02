package com.ss.leetcode.LC2022.july;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    // https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
    /** Algorithm/Theory
         Theory: EG: h = 5, w = 4, horizontalCuts[1,2,4], verticalCuts[1,3]
             - Look at the grid, only at the horizontal cuts/slices, preferably sorted.
             - As you can observe, for each segment, (cut between 0,1 / 1-2 / 2-4, 4-5)
             - Once determined the max horizontal segment/slice/band, determine the max
             vertical segment of vertical cuts.
             - In the above example, the heighest band is given by horiozntal cuts 2 and 4.
             - Now determine the widest vertical cut: there are 3 vertical segments: 0-1, 1-3, 3-4.
             The maximum vertical cut is between vertical cuts of 1 and 3.
             - Now multiply them: 2 (4-2) * 2 (3-1) = 4;
         Algorithm:
             1. Sort and determine the widest vertical cut
             2. Sort and determing the heighest horizontal cut
             3. Multiply, modulo them and return the answer.
     */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxVerticalCut = getMaxCut(w, verticalCuts);
        int maxHorizontalCut = getMaxCut(h, horizontalCuts);
        return (int)(((long)maxVerticalCut * maxHorizontalCut) % 1_000_000_007);
    }

    private int getMaxCut(int edge, int[] cuts) {
        Arrays.sort(cuts);
        int maxCut = cuts[0];
        for(int i = 1; i < cuts.length; i++) {
            maxCut = Math.max(maxCut, cuts[i] - cuts[i-1]);
        }
        maxCut = Math.max(maxCut, edge - cuts[cuts.length - 1]);
        return maxCut;
    }

}
