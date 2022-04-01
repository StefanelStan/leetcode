package com.ss.leetcode.LC2022.april;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
    // https://leetcode.com/problems/find-unique-binary-string/
    /** Algorithm 1
         1. We know that the set of nums has a very limited length: n.
         So for n = 3 it can only have 3 elements, out of 8 combinations.
         So if we have a default string [000] and we swap characters from 0 to 1 from backwords,
         we will find a combination
         000, then 001, then 011, 111. We swap from 0 to 1 from last element to first.
         Due to small set, we are bound to find one combination.
         2. Declare an array char[n], fill it with '0'.
         3. From last index, check if nums contains it, if not, swap last digit to 1.
         4. Repeat step 3, changing last digit - i to 1.
     */
    public String findDifferentBinaryString(String[] nums) {
        Set<String> numsSet = new HashSet<>();
        Collections.addAll(numsSet, nums);
        char[] candidate = new char[nums[0].length()];
        Arrays.fill(candidate, '0');
        String toString;
        for (int i = candidate.length -1; i >= -1; i--) {
            toString = new String(candidate);
            if (!numsSet.contains(toString)) {
                return toString;
            } else {
                candidate[i] = '1';
            }
        }
        return "";
    }

    /** Algorithm
         1. The above solution applies to cases when your input is of length n.
         Unlike previous version, this solves the cases when input has more n elements.
         EG: n = 4, and your input is [1111, 0000, 0001, 0011, 0111].
         The above solution will not find any.
         Thus, we need to enhance it
         2. Parse the nums and store them into a set of integers
         3. Starting from index 0, loop, increment and check if the set contains given i.
         If it doesn't, format/pad a string with 0 and binary representation of i and return it
     */
    public String findDifferentBinaryString2(String[] nums) {
        Set<Integer> nrs = new HashSet<>();
        for (String nr : nums) {
            nrs.add(Integer.parseInt(nr, 2));
        }
        for (int i = 0;; i++) {
            if (!nrs.contains(i)) {
                String binaryI = Integer.toBinaryString(i);
                return "0".repeat(nums[0].length() - binaryI.length()) + binaryI;
            }
        }
    }
}
