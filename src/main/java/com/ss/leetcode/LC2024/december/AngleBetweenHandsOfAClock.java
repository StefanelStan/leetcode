package com.ss.leetcode.LC2024.december;

public class AngleBetweenHandsOfAClock {
    // https://leetcode.com/problems/angle-between-hands-of-a-clock
    /** Algorithm
        1. Each hour has 60 minutes (degrees). So 12 hours = 720 minutes / degrees.
        2. So for 3:15 the two hands would be:
            - hoursDegree: 60 * hour + minutes
            - minutesDegrees: 60 * (minutes / 5) + 12 * (minutes % 5);
        3. Calculate the min diff between the two degrees.
        4. If an angle of 90 degrees is 60  *3, then minDiffAngle is X. Calculate X. (divide by 2)
     */
    public double angleClock(int hour, int minutes) {
        int hoursDegrees = hour * 60 + minutes;
        int minutesDegrees = 60 * (minutes / 5) + 12 *(minutes % 5);
        int minTimer = Math.min(hoursDegrees, minutesDegrees);
        int maxTimer = Math.max(hoursDegrees, minutesDegrees);
        int bestAngleDegrees = Math.min(maxTimer - minTimer, minTimer + 720 - maxTimer);
        return bestAngleDegrees / 2.0;
    }
}
