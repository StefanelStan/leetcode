package com.ss.leetcode.august;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
    // https://leetcode.com/problems/maximum-profit-in-job-scheduling/
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        TreeMap<Integer, Integer> maxProfitBeforeTime = new TreeMap<>();
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        int maxRecordedUntilNow = -1;
        //sort by ending time;
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        for (int[] job : jobs) {
            int lastProfitUntilJob = getMaxBeforeTime(job[0], maxProfitBeforeTime);
            int profitForThisJob = lastProfitUntilJob + job[2];
            int existingJobProfit = maxProfitBeforeTime.getOrDefault(job[1], 0);
            // when saving the time, we need to put the highest time recorded until the selected time.
            // eg: job1 3-4 with profit 5 and job2 2-5 with profit 2. At time 6, which will be best choice? profit5 or profit2?
            // so we need to keep a track of all max val before.
            int toPut = Math.max(Math.max(existingJobProfit, profitForThisJob), maxRecordedUntilNow);
            maxRecordedUntilNow = toPut;
            maxProfitBeforeTime.put(job[1], toPut);
        }

        return maxProfitBeforeTime.lastEntry().getValue();
    }

    private int getMaxBeforeTime(int startTime, TreeMap<Integer, Integer> maxBeforeTime) {
        Map.Entry<Integer, Integer> entry = maxBeforeTime.floorEntry(startTime);
        if (entry == null) {
            return 0;
        } else  return entry.getValue();
    }
}
