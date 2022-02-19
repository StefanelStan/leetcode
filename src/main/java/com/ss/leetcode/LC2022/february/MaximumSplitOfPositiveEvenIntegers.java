package com.ss.leetcode.LC2022.february;

import java.util.ArrayList;
import java.util.List;

public class MaximumSplitOfPositiveEvenIntegers {
    // https://leetcode.com/contest/biweekly-contest-72/problems/maximum-split-of-positive-even-integers/
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> split = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return split;
        }
        if (finalSum == 2 || finalSum == 4) {
            return List.of(finalSum);
        }

        long index = 2;
        while (true) {
            if ((finalSum < index) || (finalSum == index && finalSum == split.get(split.size() -1))) {
                split.set(split.size() -1,  split.get(split.size() -1) + Math.abs(finalSum));
                break;
            }
            split.add(index);
            finalSum -= index;
            index += 2;
        }
        return split;
    }
}
