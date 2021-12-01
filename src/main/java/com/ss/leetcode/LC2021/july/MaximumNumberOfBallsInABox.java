package com.ss.leetcode.LC2021.july;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBallsInABox {
    // https://leetcode.com/problems/maximum-number-of-balls-in-a-box/
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> boxes = new HashMap<>();

        for (int i = lowLimit; i <= highLimit; i++) {
            boxes.merge(getDigitSum(i), 1, Integer::sum);
        }

        return Collections.max(boxes.values());
    }

    private Integer getDigitSum(int i) {
        int digitSum = 0;
        while (i > 0) {
            digitSum += i % 10;
            i = i / 10;
        }
        return digitSum;
    }
}
