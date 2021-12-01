package com.ss.leetcode.LC2021.october;

import java.util.ArrayList;
import java.util.List;

public class TwoOutOfThree {
    // https://leetcode.com/problems/two-out-of-three/
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> commonNumbers = new ArrayList<>();
        int[] occurrences = new int[101];
        countOccurrences(nums1, occurrences);
        countOccurrences(nums2, occurrences);
        countOccurrences(nums3, occurrences);
        for (int i = 1; i < occurrences.length; i++) {
            if (occurrences[i] > 1) {
                commonNumbers.add(i);
            }
        }
        return commonNumbers;
    }

    private void countOccurrences(int[] nums, int[] occurrences) {
        boolean[] visited = new boolean[101];
        for (int num : nums) {
            if (!visited[num]) {
                visited[num] = true;
                occurrences[num]++;
            }
        }
    }
}
