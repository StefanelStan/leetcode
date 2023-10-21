package com.ss.leetcode.LC2023.october;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindingPairsWithACertainSum {
    // https://leetcode.com/problems/finding-pairs-with-a-certain-sum
    /** Algorithm
        1. It's best to get the count of numbers/groups for each array:nums1 & nums2.
            Knowing that you have 3 4s and 7 1s, you can easily say that you can make 21 pairs that have the sum of 5
            - The 3 numbers of 4 will be paired with the 7 numbers of 1, thus 3 x 7 = 21 pairs of (4 & 1).
        2. nums1 is of length 1000, so it's easier to use a simple [][] num1Group [value, count] to store the value and count in ORDER
            - EG: [4,6,2,6,1,2,1,2,1,1,4] => [1,4], [2,3],[4,2],[6,2]
        3. nums2 will be updated via add(index, val), so it's best to use a Map<Integer, Integer> (value -> count)
            Using a Map:
            - deduct the count of exisiting key at of nums[index] (if new key is 0, then remove the entry)
            - add new key(merge new key) with the new value nums[index] + val.
        4. Loop with i from 0 until END of num1Group OR while num1Group[i][0] <= tot
            - get the entry from that map that matches tot - num1Group[i][0] (value)
            - if any key exists, then multiply the count of the two findings. (value from map * num1Group[i][1])
        5. Return the answer;
     */
    private final int[] nums2;
    private final int[][] groupedNums1;
    private final Map<Integer, Integer> nums2Count;
    public FindingPairsWithACertainSum(int[] nums1, int[] nums2) {
        groupedNums1 = getGroupedNums(nums1);
        this.nums2 = nums2;
        nums2Count = countNums(nums2);
    }

    public void add(int index, int val) {
        Integer prevValue = nums2Count.merge(nums2[index], -1, Integer::sum);
        if (prevValue == 0) {
            nums2Count.remove(nums2[index]);
        }
        nums2[index] += val;
        nums2Count.merge(nums2[index], 1, Integer::sum);
    }

    public int count(int tot) {
        int total = 0, found;
        for (int i = 0; i < groupedNums1.length && groupedNums1[i][0] <= tot; i++) {
            found = nums2Count.getOrDefault(tot - groupedNums1[i][0] , 0);
            total += (groupedNums1[i][1] * found);
        }
        return total;
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        for (int num : nums) {
            numsCount.merge(num, 1, Integer::sum);
        }
        return numsCount;
    }

    private int[][] getGroupedNums(int[] nums) {
        Arrays.sort(nums);
        int[][] groupedNums = new int[nums.length][2];
        //[value, count]
        groupedNums[0][0] = nums[0];
        groupedNums[0][1] = 1;
        int insertIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                insertIndex++;
                groupedNums[insertIndex][0] = nums[i];
            }
            groupedNums[insertIndex][1]++;
        }

        return Arrays.copyOf(groupedNums, insertIndex + 1);
    }
}
