package com.ss.leetcode.LC2021.august;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    // https://leetcode.com/problems/partition-labels/
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        int[] positions = countAndGetPositions(s);
        int endPosition = 0;
        for (int i = 0; i < s.length(); i++) {
            if (positions[s.charAt(i) - 'a'] == i) {
                partitions.add(1);
            } else {
                endPosition = calculateSegment(positions, s, i);
                partitions.add(endPosition - i + 1);
                i = endPosition;
            }
        }
        return partitions;
    }

    private int[] countAndGetPositions(String s) {
        int[] positions = new int[26];
        for (int i = 0; i < s.length(); i++) {
            positions[s.charAt(i) - 'a'] = i;
        }
        return positions;
    }

    private int calculateSegment(int[] positions, String s, int start) {
        int end = positions[s.charAt(start) - 'a'];
        int lastPosition = 0;
        for (int i = start + 1; i < end; i++) {
            lastPosition = positions[s.charAt(i) - 'a'];
            if (lastPosition > end) {
                end = lastPosition;
            }
        }
        return end;
    }
}
