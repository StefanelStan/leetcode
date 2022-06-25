package com.ss.leetcode.LC2022.june;

public class MinimumNumberOfOperationsToConvertTime {
    // https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
    /** Algorithm
         1. Use an int[2] to store hours and minutes; 12:24 will be [12, 24].
         2. Calculate minute steps: if current Min <= correctMin, return the difference,
         else return 60 - currentMins + correctMins (eg: currentMin: 50, correct: 10) -> 60 - 50 + 10
         3. If the current minute is greater then correct min (eg: 50, 10), you must also increment the hour by one.
         Pay attention as 23:xx becomes 0:xx
         4. Calculate the hours steps: correctHour - currentHour.
     */
    private static final int[] timeSteps = {1,5,15};
    public int convertTime(String current, String correct) {
        int[] currentTime = getTime(current);
        int[] correctTime = getTime(correct);
        int minOperations = getMinutesSteps(currentTime, correctTime);
        minOperations += getHoursSteps(currentTime, correctTime);
        return minOperations;
    }

    private int[] getTime(String timeString) {
        int[] time = new int[2];
        time[0] = (timeString.charAt(0) - '0') * 10 + (timeString.charAt(1) - '0');
        time[1] = (timeString.charAt(3) - '0') * 10 + (timeString.charAt(4) - '0');
        return time;
    }

    private int getMinutesSteps(int[] current, int[] correct) {
        int minutesNeeded = 0;
        if (current[1] <= correct[1]) {
            minutesNeeded = correct[1] - current[1];
        } else {
            minutesNeeded = 60 - current[1] + correct[1];
            current[0] = current[0] == 23 ? 0 : current[0] + 1;
        }
        int i = timeSteps.length -1;
        int steps = 0;
        // keep deducting 15,  5 or 1 from minutesNeeded until they become 0; eg: 14:40 -> 15:30.
        // 50 minutes needed. This loop will deduct 15 -> 35, then 15 again -> 20, again -> 5, then will deduct 5.
        while (i >= 0 && minutesNeeded > 0) {
            if (minutesNeeded >= timeSteps[i]) {
                minutesNeeded -= timeSteps[i];
                steps++;
            } else {
                i--;
            }
        }
        return steps;
    }

    private int getHoursSteps(int[] current, int[] correct) {
        return current[0] <= correct[0] ? correct[0] - current[0] : 24 - current[0] + correct[0];
    }

    public int convertTime2(String current, String correct) {
        Time currentTime = new Time(current);
        Time correctTime = new Time(correct);
        int minOperations = convertMinutes(currentTime, correctTime);
        minOperations += convertHours(currentTime, correctTime);
        return minOperations;
    }

    private int convertHours(Time currentTime, Time correctTime) {
        return currentTime.hours <= correctTime.hours
            ? correctTime.hours - currentTime.hours
            : 24 - correctTime.hours + correctTime.hours;
    }

    private int convertMinutes(Time currentTime, Time correctTime) {
        int minutesNeeded;
        if (currentTime.minutes <= correctTime.minutes) {
            minutesNeeded = correctTime.minutes - currentTime.minutes;
        } else {
            minutesNeeded = 60 - currentTime.minutes + correctTime.minutes;
            currentTime.hours = currentTime.hours == 23 ? 0 : currentTime.hours + 1;
        }
        int steps = 0;
        for (int i = timeSteps.length -1; i >= 0 && minutesNeeded > 0;) {
            if (minutesNeeded >= timeSteps[i]) {
                minutesNeeded -= timeSteps[i];
                steps++;
            } else {
                i--;
            }
        }
        return steps;
    }

    private static class Time {
        int hours;
        int minutes;

        public Time(String time) {
            String[] chunks = time.split(":");
            hours = Integer.parseInt(chunks[0]);
            minutes = Integer.parseInt(chunks[1]);
        }
    }
}
