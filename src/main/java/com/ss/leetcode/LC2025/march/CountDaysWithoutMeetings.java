package com.ss.leetcode.LC2025.march;

import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings {
    //
    /** Algorithm
        1. Sort the meetings based on their start time.
        2. If 1st meeting starts before day1, add the diff to the available days
        3. From meeting[0], apply a merge interval algorithm: if current meeting starts after the prev one, add the diff days between current start and last ending
        4. Else, extent the interval of prev meeting to be the max betwwen current meeting end and prev meeting end.
        5. Also add the diff between last meeting end and given days. (eg: days = 10 and last meeting ends on day 6)
     */
    public int countDays(int days, int[][] meetings) {
        int availableDays = 0;
        Arrays.sort(meetings, Comparator.comparingInt(m -> m[0]));
        availableDays += meetings[0][0] - 1;
        int lastEndMeeting = meetings[0][1];
        for (int i = 1; i < meetings.length && meetings[i][1] <= days; i++) {
            if (meetings[i][0] > lastEndMeeting) {
                availableDays += ((meetings[i][0] - lastEndMeeting) - 1);
                lastEndMeeting = meetings[i][1];
            } else {
                lastEndMeeting = Math.max(lastEndMeeting, meetings[i][1]);
            }
        }
        availableDays += Math.max(0, days - lastEndMeeting);
        return availableDays;
    }
}
