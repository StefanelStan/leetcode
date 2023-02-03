package com.ss.leetcode.LC2023.february;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    // https://leetcode.com/problems/tuple-with-same-product
    /** Algorithm
        1. In loop with i = [0, n-2] and j [i+1, n-1] and count & put the product of nums[i,j] in a map
            EG: [1,2,3,6] -> 2-> 1, 3-> 1, 4 ->1, 6->2, 8 -> 1, 12 ->1, 18->1
        2. We are interested in the values (sum counts) that are greater than 1. This means there were
            at least 2 pairs that gave that sum.
        3. Calculate the permutations of count by taken by 2. (shorthand formula is  k * (k-1)) (avoid factorial)
        4. Let's say we have 3 sums of 12. This means 3 pairs of nums [a,b],[c,d],[e,f], which leads to 6 permutations
        5. Let's inspect one permutation: (a,b,c,d): this can be arranged in 4 ways:
            (a,b - c,d), (a,b - d,c), (b,a - c,d), (b,a - d,c).
            Thus, we see that each permutation can be permuted 4 times as well.
        6. Multiply each result of permutations by 4.
     */
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> countOfSums = new HashMap<>();
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i+ 1; j < nums.length; j++) {
                countOfSums.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }
        int tuples = 0;
        for(int count : countOfSums.values()) {
            if (count > 1) {
                tuples += (count * (count - 1) * 4);
            }
        }
        return tuples;
    }
}
