package com.ss.leetcode.LC2022.january;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    // https://leetcode.com/problems/minimum-time-difference/
    /** Algorithm
         1. use a boolean[] array to map each minute of a day (60 * 24).
         2. parse each timePoint and set true each point in time on the boolean[] array
         - if at any point, the time is already [true] for the a given timePoint, return 0.
         3. Find first and last points and determine their difference. Only the last one and first one
         are in the situation of circular time difference: 00:05 and 23:55.
         The diff is the min between (23:55 - 00:05) and (24:00 - 23:55 + 00:05)
         4. After step #3, find the next marked minute point from firstPoint onwards and calculate
         its difference. Stop when nextPoint == lastPoint/last marked Position (calculated in step 3)
         5. Return min difference.
     */
    public int findMinDifference(List<String> timePoints) {
        int day = 60 * 24;
        boolean[] times = new boolean[day];
        for (String time : timePoints) {
            int minutes = getMinute(time);
            if (times[minutes]) {
                return 0;
            } else {
                times[minutes] = true;
            }
        }
        int firstPos = 0, lastPos = day-1;
        int minDiff = Integer.MAX_VALUE;
        while(!times[firstPos]) {
            firstPos++;
        }
        while(!times[lastPos]) {
            lastPos--;
        }
        minDiff = Math.min(minDiff, Math.min(lastPos-firstPos, day - lastPos + firstPos));
        int currentPos = firstPos, nextPos = -1;
        while(nextPos != lastPos) {
            nextPos = getNextPos(times, currentPos +1);
            minDiff = Math.min(minDiff, nextPos - currentPos);
            currentPos = nextPos;
        }
        return minDiff;
    }

    private int getNextPos(boolean[] times, int startPos) {
        while(!times[startPos]) {
            startPos++;
        }
        return startPos;
    }

    public int findMinDifference2(List<String> timePoints) {
        List<Integer> times = new ArrayList<>(timePoints.size());
        int day = 60 * 24;
        for (String time : timePoints) {
            int minutes = getMinute(time);
            times.add(minutes);
            times.add(minutes + day);
        }
        Collections.sort(times);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < times.size(); i++) {
            minDiff = Math.min(minDiff, times.get(i) - times.get(i-1));
        }
        return minDiff;
    }

    private int getMinute(String time) {
        return 60 * Integer.parseInt(time.substring(0, 2)) + Integer.parseInt(time.substring(3));
    }
}
