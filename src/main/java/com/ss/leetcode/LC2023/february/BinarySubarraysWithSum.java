package com.ss.leetcode.LC2023.february;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    // https://leetcode.com/problems/binary-subarrays-with-sum/
    /** Algorithm
        1. Traverse the nums and use a map to store/count the prefix sums
            EG: [0,0,0,1]
                i == 3, prefix sum = 1, map will have (0 -> 3, 1 ->1) (3 prefix sums of 0 and 1 of 1)
            EG [0,1,0,1]
                 i ==3, prefix sum = 2, map: 0 -> 1, 1 -> 2, 2 -> 1 (1 sum of 0, 2 sums of 1 and 1 of 2)
        2. The idea is as follows: if you have a prefix sum of 5 and your goal is 2, you wish to know
            if you have a prefix sum of 3. If you do, it means anything between that prefix sum index and current index has a sum of 2 (your goal)
            EG: 0,1,1,1,0,0,0,0,1,1 goal = 2.
         At index 9 your prefix sum is 5. 5 - 2 = 3.
         We observe that prefixSum of 3 is at index 3,4,5,6,7 (5 sums of 3)
         This means that the segments from index 4 onwards have a sum of 2 (000011, 00011, 0011, 011, 11)
         Thus, we increment the count of subarrays by 5.
        3. The detailed mechanism from step 2 can be applied to the case 0111 with goal = 2.
     */

    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] sums = new int[nums.length + 1];
        int rollingSum = 0;
        int count = 0;
        for (int num : nums) {
            rollingSum += num;
            if (rollingSum == goal) {
                count++;
            }
            if (rollingSum >= goal) {
                count += sums[rollingSum - goal];
            }
            sums[rollingSum]++;
        }
        return count;
    }


    public int numSubarraysWithSum2(int[] nums, int goal) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int subarrays = 0;
        for (int num : nums) {
            prefixSum += num;
            if (prefixSum == goal) {
                subarrays++;
            }
            // mini optimization. Don't search until you actually have a prefixSum >= goal
            if (prefixSum >= goal){
                subarrays += prefixSumMap.getOrDefault(prefixSum - goal, 0);
            }
            prefixSumMap.merge(prefixSum, 1, Integer::sum);
        }
        return subarrays;
    }
}
