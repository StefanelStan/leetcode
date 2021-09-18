package com.ss.leetcode.september;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MaximumEarningsFromTaxi {
    // https://leetcode.com/contest/biweekly-contest-61/problems/maximum-earnings-from-taxi/
    public long maxTaxiEarnings(int n, int[][] rides) {
        TreeMap<Integer, Long> maxProfitBeforeTime = new TreeMap<>();
        long maxRecordedUntilNow = -1;
        //sort by ending time;
        Arrays.sort(rides, Comparator.comparingInt(a -> a[1]));
        for (int[] job : rides) {
            long lastProfitUntilJob = getMaxBeforeTime(job[0], maxProfitBeforeTime);
            long profitForThisJob = lastProfitUntilJob + (job[1] - job[0]) + job[2];
            long existingJobProfit = maxProfitBeforeTime.getOrDefault(job[1], 0L);
            // when saving the time, we need to put the highest time recorded until the selected time.
            // eg: job1 3-4 with profit 5 and job2 2-5 with profit 2. At time 6, which will be best choice? profit5 or profit2?
            // so we need to keep a track of all max val before.
            long toPut = Math.max(Math.max(existingJobProfit, profitForThisJob), maxRecordedUntilNow);
            maxRecordedUntilNow = toPut;
            maxProfitBeforeTime.put(job[1], toPut);
        }

        return maxProfitBeforeTime.lastEntry().getValue();
    }

    private Long getMaxBeforeTime(int startTime, TreeMap<Integer, Long> maxBeforeTime) {
        Map.Entry<Integer, Long> entry = maxBeforeTime.floorEntry(startTime);
        if (entry == null) {
            return 0L;
        } else  return entry.getValue();
    }
}
