package com.ss.leetcode.LC2021.august;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
    // https://leetcode.com/problems/maximum-profit-in-job-scheduling/
    /** Algorithm
        1. You need to have a sorted point of view of the jobs.
        2. Create a class Job (startTime, endTime, profit) and initialize an array Job[] jobs
        3. Sort it by startTime. This way, if you select job1 (3,6,10) then you know that you can only select another job that starts at 6
        4. With this sorting, you can use binary search to find the next possible best job by startingTime
        5. Use a cache Integer[] profitableJobs to determine the best/max combination of jobs
        6. You will use a logic of "select or skip this job"
            at index[0], you will choose between skipping this job (and maybe selecting next one -more profitable)
            and selecting this job and only being able to select one at endTime
        7. Use a recursive function findSchedule(int index, jobs[], cache[]). On each call you select the max between
            - skipping this job (findSchedule(index +1, jobs, cache)) or
            - selecting this job (jobs[index].profit) + finding next jobs after the endtime (findSchedule(binary_search_endtime), jobs)
        8. Return the cache[0] as this will build up the max profit.
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = getJobs(startTime, endTime, profit);
        return findSchedule(0, jobs, new Integer[jobs.length]);
    }

    private int findSchedule(int index, Job[] jobs, Integer[] profitableJobs) {
        if (index == jobs.length) {
            return 0;
        }
        if (profitableJobs[index] == null) {
            profitableJobs[index] = Math.max(findSchedule(index + 1, jobs, profitableJobs),
                jobs[index].profit + findSchedule(findNextJob(jobs, index + 1, jobs[index].endTime), jobs, profitableJobs));

        }
        return profitableJobs[index];
    }

    private int findNextJob(Job[] jobs, int low, int startTime) {
        int high = jobs.length - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (startTime <= jobs[pivot].startTime) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }

    private Job[] getJobs(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.startTime));
        return jobs;
    }

    private static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }


    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
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
