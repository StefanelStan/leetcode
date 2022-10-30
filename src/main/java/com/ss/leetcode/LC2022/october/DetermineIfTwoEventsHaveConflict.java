package com.ss.leetcode.LC2022.october;

public class DetermineIfTwoEventsHaveConflict {
    // https://leetcode.com/problems/determine-if-two-events-have-conflict/
    /** Algorithm
         1. Convert the time into minutes: event1 is [1AM,2AM], event2 is [1:20AM,3AM].
            This would converted to [60,120] and [80, 180].
         2. Having this conversion, try to see if the start of event 1 is between start,end of event2 OR
             start of event2 is between start-end of event1.
            (check if 60 is between 80 and 180 OR 80 is between 60 and 120).
     */
    public boolean haveConflict(String[] event1, String[] event2) {
        int[] event1Minutes = getMinutesOfEvent(event1);
        int[] event2Minutes = getMinutesOfEvent(event2);
        return (event1Minutes[0] >= event2Minutes[0] && event1Minutes[0] <= event2Minutes[1])
            || (event2Minutes[0] >= event1Minutes[0] && event2Minutes[0] <= event1Minutes[1]);
    }

    private int[] getMinutesOfEvent(String[] event) {
        int startMinutes = Integer.parseInt(event[0].substring(0,2)) * 60 + Integer.parseInt(event[0].substring(3));
        int endMinutes = Integer.parseInt(event[1].substring(0,2)) * 60 + Integer.parseInt(event[1].substring(3));
        return new int[]{startMinutes, endMinutes};
    }

    public boolean haveConflict2(String[] event1, String[] event2) {
        // compare the string directly and skip the int conversion
        return (event2[0].compareTo(event1[0]) >= 0 && event2[0].compareTo(event1[1]) <= 0) ||
            (event1[0].compareTo(event2[0]) >= 0 && event1[0].compareTo(event2[1]) <= 0);

    }
}
