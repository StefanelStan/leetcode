package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.march.FindMissingAndRepeatedValues;
import com.ss.leetcode.LC2025.march.MaximumCandiesAllocatedToKChildren;
import java.util.Arrays;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

        start.findMissingAndRepeatedValues();
        start.maximumCandiesAllocatedToKChildren();
    }

    public void findMissingAndRepeatedValues() {
        FindMissingAndRepeatedValues fmarv = new FindMissingAndRepeatedValues();

        System.out.println("[2,4] == " + Arrays.toString(fmarv.findMissingAndRepeatedValues(new int[][]{{1,3},{2,2}})));
        System.out.println("[9,5] == " + Arrays.toString(fmarv.findMissingAndRepeatedValues(new int[][]{{9,1,7},{8,9,2},{3,4,6}})));
    }

    public void maximumCandiesAllocatedToKChildren() {
        MaximumCandiesAllocatedToKChildren mcatkc = new MaximumCandiesAllocatedToKChildren();

        System.out.println("2 = " + mcatkc.maximumCandies(new int[]{5,8,6}, 8));
        System.out.println("0 = " + mcatkc.maximumCandies(new int[]{2,5}, 11));
        System.out.println("16 = " + mcatkc.maximumCandies(new int[]{4,5,6,54,3,2,3,5,67,74,53,32,34}, 17));
        System.out.println("10 = " + mcatkc.maximumCandies(new int[]{4,5,6,54,3,2,3,5,67,74,53,32,34}, 27));
        System.out.println("2 = " + mcatkc.maximumCandies(new int[]{4,5,6,54,3,2,3,5,67,74,53,32,34}, 119));
        System.out.println("53 = " + mcatkc.maximumCandies(new int[]{4,5,6,54,3,2,3,5,67,74,53,32,34}, 4));
    }
}
