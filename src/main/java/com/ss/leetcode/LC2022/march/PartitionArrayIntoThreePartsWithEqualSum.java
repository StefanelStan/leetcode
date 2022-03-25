package com.ss.leetcode.LC2022.march;

public class PartitionArrayIntoThreePartsWithEqualSum {
    // https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
    /** Algorithm
         1. Traverse the array and get the totalSum. If sum is not divisible by 3, return false.
         2. The idea is to travel the array and do a cumulative sum. When this sum is == totalSum/3, then you have one chunk.
            If you have 2 chunks and the remaining elements have the sum of third, then you can have the 3rd one
            If you have 3 segments not reached the end, it means you cannot have 3 segments but 3.5
         3. Start from i = 0 and do a partialSum. When partialSum == totalSum/3, increment the number of chunks.
            Also reset the partialSum and deduct it from totalSum.
         4. If at stage 2, the number of chunks is 2 and the totaSum == third, then you can have the 3rd segment
         If you have 3 segments but your i has not reached the end, then you cannot have 3 but 3 and something.
     */
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int nr : arr) {
            sum += nr;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int third = sum / 3, partialSum = 0, chunks =0;
        for(int i = 0; i < arr.length; i++) {
            partialSum += arr[i];
            if (partialSum == third) {
                sum -= partialSum;
                partialSum = 0;
                chunks++;
                if (chunks == 2 && sum == third && i != arr.length -1) {
                    return true;
                }
                if (chunks == 3 && i != arr.length -1) {
                    return false;
                }
            }
        }
        return false;
    }
}
