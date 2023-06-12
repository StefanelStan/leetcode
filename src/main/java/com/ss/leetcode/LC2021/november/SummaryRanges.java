package com.ss.leetcode.LC2021.november;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    // https://leetcode.com/problems/summary-ranges/
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) {
            return ranges;
        }
        int start = nums[0], previous = start;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - previous != 1) {
                ranges.add(previous == start ? toRangeString(start) : toRangeString(start, previous));
                start = nums[i];
            }
            previous = nums[i];
        }
        ranges.add(previous == start ? toRangeString(start) : toRangeString(start, previous));
        return ranges;
    }

    private String toRangeString(int... nums) {
        StringBuilder stb = new StringBuilder();
        stb.append(nums[0]);
        if (nums.length > 1) {
            stb.append("->").append(nums[1]);
        }
        return stb.toString();
    }


    public List<String> summaryRanges2(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) {
            return ranges;
        }
        if (nums.length == 1) {
            ranges.add(String.valueOf(nums[0]));
            return ranges;
        }
        int current = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            if (Math.abs(nums[i+1] - nums[i]) > 1) {
                ranges.add(buildRange(current, nums[i]));
                current = nums[i+1];
            }
        }
        if (Math.abs(nums[nums.length -2] - nums[nums.length -1]) > 1) {
            ranges.add(buildRange(nums[nums.length -1], nums[nums.length-1]));
        } else {
            ranges.add(buildRange(current, nums[nums.length -1]));
        }
        return ranges;
    }

    private String buildRange(int nr1, int nr2) {
        return nr1 == nr2 ? String.valueOf(nr1) : nr1 + "->" + nr2;
    }
}
