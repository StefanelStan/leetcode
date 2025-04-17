package com.ss.leetcode.LC2022.february;

import java.util.ArrayList;
import java.util.List;

public class CountEqualAndDivisiblePairsInAnArray {
    // https://leetcode.com/contest/biweekly-contest-72/problems/count-equal-and-divisible-pairs-in-an-array/
    public int countPairs(int[] nums, int k) {
        int pairs = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pairs += (nums[i] == nums[j] && (i * j % k == 0) ? 1 : 0);
            }
        }
        return pairs;
    }


    public int countPairs2(int[] nums, int k) {
        List<Integer>[] count = countNums(nums);
        int pairs = 0;
        for (List times : count) {
            if (times != null && times.size() >=2) {
                pairs += getDivisibleCount(times, k);
            }
        }
        return pairs;
    }

    private List<Integer>[] countNums(int[] nums) {
        List<Integer>[] count = new List[101];
        for (int i = 0 ; i < nums.length; i++) {
            if (count[nums[i]] == null) {
                count[nums[i]] = new ArrayList<>();
            }
            count[nums[i]].add(i);
        }
        return count;
    }


    private int getDivisibleCount(List<Integer> times, int k) {
        int count = 0;
        for (int i = 0; i <= times.size() -2; i++) {
            for (int j = i +1; j < times.size(); j++){
                if (times.get(i) * times.get(j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
