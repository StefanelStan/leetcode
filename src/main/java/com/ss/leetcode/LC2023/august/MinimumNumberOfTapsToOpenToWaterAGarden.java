package com.ss.leetcode.LC2023.august;

import java.util.Arrays;
import java.util.LinkedList;

public class MinimumNumberOfTapsToOpenToWaterAGarden {
    // https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden
    public int minTaps(int n, int[] ranges) {
        int minToOpen = ranges.length;
        LinkedList<int[]> connectedTaps = new LinkedList<>();
        int[][] sortedTaps = getSortedTaps(ranges);
        if (sortedTaps.length == 0) {
            return -1;
        }
        connectedTaps.addLast(sortedTaps[0]);
        if (connectedTaps.peekFirst()[0] <= 0 && connectedTaps.peekLast()[1] >= n) {
            minToOpen = Math.min(minToOpen, connectedTaps.size());
        }
        int toEvict;
        for (int i = 1; i < sortedTaps.length; i++) {
            if (connectedTaps.peekLast()[1] < sortedTaps[i][0]) {
                return -1;
            }
            if (sortedTaps[i][1] > connectedTaps.peekLast()[1]) {
                if (sortedTaps[i][0] <= 0) {
                    connectedTaps.clear();
                    connectedTaps.addLast(sortedTaps[i]);
                } else if (connectedTaps.size() == 1) {
                    connectedTaps.addLast(new int[]{connectedTaps.peekLast()[1], sortedTaps[i][1]});
                } else {
                    toEvict = connectedTaps.peekLast()[0] >= sortedTaps[i][0] ? connectedTaps.removeLast()[0] : connectedTaps.peekLast()[1];
                    connectedTaps.addLast(new int[]{toEvict, sortedTaps[i][1]});
                }
                if (connectedTaps.peekFirst()[0] <= 0 && connectedTaps.peekLast()[1] >= n) {
                    minToOpen = Math.min(minToOpen, connectedTaps.size());
                }
            }
        }
        return minToOpen == ranges.length ? -1 : minToOpen;
    }

    private int[][] getSortedTaps(int[] ranges) {
        int[][] taps = new int[ranges.length][2];
        int insertIndex = 0;
        for(int i = 0; i < ranges.length; i++) {
            if (ranges[i] != 0) {
                taps[insertIndex][0] = i - ranges[i];
                taps[insertIndex][1] = i + ranges[i];
                insertIndex++;
            }
        }
        if (insertIndex == 0) {
            return new int[0][0];
        }
        Arrays.sort(taps, 0, insertIndex, (a,b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int[][] sortedTaps = new int[insertIndex][2];
        int sortedTapIndex = 1;
        sortedTaps[0] = taps[0];
        for (int i = 1; i < insertIndex; i++) {
            if (sortedTaps[sortedTapIndex - 1][0] != taps[i][0] && sortedTaps[sortedTapIndex - 1][1] < taps[i][1]) {
                sortedTaps[sortedTapIndex][0] = taps[i][0];
                sortedTaps[sortedTapIndex][1] = taps[i][1];
                sortedTapIndex++;
            }
        }
        return Arrays.copyOf(sortedTaps, sortedTapIndex);
    }
}
