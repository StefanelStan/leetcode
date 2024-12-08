package com.ss.leetcode.LC2024.january;

import java.util.Arrays;
import java.util.Comparator;

public class TwoBestNonOverlappingEvents {
    // https://leetcode.com/problems/two-best-non-overlapping-events
    public int maxTwoEvents(int[][] events) {
        int maxValue = 0;
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int[] bestValue = getBestValue(events);
        for (int i = 0; i < events.length; i++) {
            maxValue = Math.max(maxValue, events[i][2] + findNextBestEvent(events, bestValue, events[i][1] + 1, i + 1));
        }
        return maxValue;
    }

    private int findNextBestEvent(int[][] events, int[] bestValue, int target, int low) {
        int high = events.length -1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (events[pivot][0] >= target) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low == events.length ? 0 : bestValue[low];
    }

    private int[] getBestValue(int[][] events) {
        int[] bestValue = new int[events.length];
        bestValue[bestValue.length - 1] = events[events.length -1][2];
        for (int i = bestValue.length - 2; i >= 0; i--) {
            bestValue[i] = Math.max(bestValue[i+1], events[i][2]);
        }
        return bestValue;
    }

    /** Algorithm
        1. Sort the events by start time
        2. Use an Integer[n][2] pickedEvents to cache the max value of picking state
            - state 0 pickedEvents[i][0]: you have not picked any event so you are free to pick 2 events
            - state 1: pickedEvents[i][1] you have made 1 selection and you need to find 1 more good selection
        3. Create a recursive function that will accept current index, number of picks (picks), events and pickedEvents
        4. If you index > n, return 0, as you cannot pick anything
        5. If pickedEvents[i][state/picks] == null, set it
            - skip current index and get next best value from (index+1, picks, events, pickedEvents)
            - pick current index; if picks == 0 (so you still have 1 more selection),
                also add the best value from (binarySearchNextIndex, 1, events, pickedEvents)
            - set pickedEvents[i][state/picks] as max of the two steps
        6. Your events are sorted by startTime so use binary search to find the most LEFT index of next event
            if last event is [1,3,2], then you need to find 4 in your events, as 4 is nest available start time.
        7. Return pickedEvents[i][state/picks]
     */
    public int maxTwoEvents2(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        Integer[][] pickedEvents = new Integer[events.length][2];
        return pickEvent(0, 0, events, pickedEvents);
    }

    private int pickEvent(int index, int picks, int[][] events, Integer[][] pickedEvents) {
        if (index >= events.length) {
            return 0;
        }
        if (pickedEvents[index][picks] == null) {
            // skip current and pass picks
            pickedEvents[index][picks] = pickEvent(index + 1, picks, events, pickedEvents);

            //pick current
            int select = events[index][2];
            if (picks == 0) {
                select += pickEvent(binarySearch(index + 1, events[index][1] + 1, events), 1, events, pickedEvents);
            }
            pickedEvents[index][picks] = Math.max(pickedEvents[index][picks], select);
        }
        return pickedEvents[index][picks];
    }

    private int binarySearch(int low, int target, int[][] events) {
        int high = events.length - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (events[pivot][0] >= target) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }
}
