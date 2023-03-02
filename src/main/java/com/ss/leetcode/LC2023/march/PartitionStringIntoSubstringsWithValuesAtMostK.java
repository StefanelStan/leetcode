package com.ss.leetcode.LC2023.march;

public class PartitionStringIntoSubstringsWithValuesAtMostK {
    // https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k
    /** Algorithm
        1. If k == 9, return s.length() as partitions can be max 1 digit
        2. Iterate over s and add each char/digit to a partitionValue: partitionValue * 10 + digit.
        3. Fail fast: if current digit > k, return -1
        4. If partitionValue > k, increment the number of partitions and set partitionValue = current digit.
        5. Return the number of partitions
     */
    public int minimumPartition(String s, int k) {
        if (k == 9) {
            return s.length();
        }
        int partitions = 1;
        long partitionValue = 0, digit;
        for(int i = 0; i < s.length(); i++) {
            digit = s.charAt(i) - '0';
            if (digit > k) {
                return -1;
            }
            partitionValue = partitionValue * 10 + digit;
            if (partitionValue > k) {
                partitionValue = digit;
                partitions++;
            }
        }
        return partitions;
    }
}
