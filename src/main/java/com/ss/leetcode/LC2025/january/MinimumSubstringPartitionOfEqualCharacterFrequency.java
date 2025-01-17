package com.ss.leetcode.LC2025.january;

import java.util.Arrays;

public class MinimumSubstringPartitionOfEqualCharacterFrequency {
    // https://leetcode.com/problems/minimum-substring-partition-of-equal-character-frequency
    /** Algorithm
        1. Use a int[] partitions to cache the number of partitions can be formed starting from each index.
        2. If index [0..i] can form a partition, then the answer can be 1 + partitions[i+1]
        3. From each index, start adding chars into a count[] and if the count has all same numbers, then this window can make a partition.
            - The answer for current index could be 1 + findPartitions(i +1)
        4. The answer for partions[i] is the minimum answer while expanding the window from i to n
     */
    public int minimumSubstringsInPartition(String s) {
        int[] partitions = new int[s.length()];
        Arrays.fill(partitions, -1);
        return findPartitions(s.toCharArray(), 0, partitions);
    }

    private int findPartitions(char[] chars, int index, int[] partitions) {
        if (index == chars.length) {
            return 0;
        }
        if (partitions[index] == -1) {
            int[] charCount = new int[26];
            partitions[index] = chars.length - index;
            for (int i = index; i < chars.length; i++) {
                charCount[chars[i] - 'a']++;
                if (areAllEqual(charCount)) {
                    partitions[index] = Math.min(partitions[index], 1 + findPartitions(chars, i + 1, partitions));
                }
            }
        }
        return partitions[index];
    }

    private boolean areAllEqual(int[] charCount) {
        int prev = -1;
        for (int c : charCount) {
            if (c != 0) {
                if (prev == -1) {
                    prev = c;
                } else if (prev != c) {
                    return false;
                }
            }
        }
        return true;
    }
}
