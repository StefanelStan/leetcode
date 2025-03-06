package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.march.FindMissingAndRepeatedValues;
import java.util.Arrays;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

        start.findMissingAndRepeatedValues();
    }

    public void findMissingAndRepeatedValues() {
        FindMissingAndRepeatedValues fmarv = new FindMissingAndRepeatedValues();

        System.out.println("[2,4] == " + Arrays.toString(fmarv.findMissingAndRepeatedValues(new int[][]{{1,3},{2,2}})));
        System.out.println("[9,5] == " + Arrays.toString(fmarv.findMissingAndRepeatedValues(new int[][]{{9,1,7},{8,9,2},{3,4,6}})));
    }
}
