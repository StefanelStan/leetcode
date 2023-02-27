package com.ss.leetcode.LC2023.february;

public class OptimalPartitionOfString {
    // https://leetcode.com/problems/optimal-partition-of-string
    /** Algorithm
        1. Sliding/Flexible window: use a boolean[26] to mark the present letters.
        2. If current letter is NOT present, mark it as present and move on to next index
        3. Else, means you must do a cut/a partition:
            - mark as false all the positions from present[] and increase the partition number.
            - mark current as present
        4. Return the number of partitions
     */
    public int partitionString(String s) {
        int partitions = 1;
        boolean[] present = new boolean[26];
        present[s.charAt(0) - 'a'] = true;
        int left = 0;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (present[ch - 'a']) { // you can also reset the whole array = new boolean[26]
                while(left < i) {
                    present[s.charAt(left) - 'a'] = false;
                    left++;
                }
                partitions++;
            }
            present[ch - 'a'] = true;
        }
        return partitions;
    }
}
