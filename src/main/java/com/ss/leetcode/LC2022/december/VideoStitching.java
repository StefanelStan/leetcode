package com.ss.leetcode.LC2022.december;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {
    // https://leetcode.com/problems/video-stitching
    /** Algorithm: [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]
         1. Sort the clips based on their current startTime in increasing order.
            [0,2],[1,9],[1,5],[4,6],[5,9],[8,10]
         2. FailFast: if first video does not start from 0, return -1 immediately (video MUST start from 0)
            You cannot do this failfast on the last video if last video ending time before time (edge case: [0,2], [1,1] time = 2)
         3. Always try to get the video that has the biggest length past the given index
             eg: [1,9], [2,10], [7,11] and timeToStart = 5.
             All 3 movies start before 5 but 7,11 is the best match because it has the longest length past 5. We want to always get max windows size.
         4. Initially get the best fit video that has starting time 0. : [0,2].
         5. Now get the next best fit clip that has the startingtime <= 2.
            [1,9],[1,5] but 1,9 is best fit because 9-2 > 5-2. We have changes of covering multiple clips with such a long video
         6. Get next best fit that has a starting time <= 9:
             [4,6],[5,9],[8,10]. again, the best match is [8,10] because 10-9 = 1, gives us the max expanding clip window.
             ! Note: I did not include [1,9],[1,5] because we already search these options on previous step and we kept an index to where we stopped the search.
         7. As we observe, this last clip has endingTime == our searched time. Finish the loop
         8. If at any stage the bestFix index is not found, it means there is a gap so we cannot stitch them. Return -1.
     */
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, Comparator.comparingInt(a -> a[0]));
        if (clips[0][0] > 0) {
            return -1;
        }
        int[] searchIndex = {0};
        boolean foundLastSegment = false;
        int bestFit = -1;
        int segments = 0;
        while(!foundLastSegment) {
            bestFit = findBestMatch(clips, bestFit == -1 ? 0 : clips[bestFit][1], searchIndex);
            segments++;
            if (bestFit == -1) {
                return -1;
            }
            if (clips[bestFit][1] >= time) {
                foundLastSegment = true;
            }
        }
        return segments;
    }

    public int findBestMatch(int[][] clips, int timeToStart, int[] from) {
        int index = -1, bestDifference = -1;
        while(from[0] < clips.length && timeToStart >= clips[from[0]][0]) {
            // we can look for [1,9] in intervals of [4,6][8,10].
            // we always need to loop for the best/longest video that stretches the most past the timeToStart.
            if (clips[from[0]][1] >= timeToStart && clips[from[0]][1] - timeToStart > bestDifference) {
                bestDifference = clips[from[0]][1] - timeToStart;
                index = from[0];
            }
            from[0]++;
        }
        return index;
    }
}
