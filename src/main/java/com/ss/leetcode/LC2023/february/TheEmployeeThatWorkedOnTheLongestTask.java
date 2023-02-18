package com.ss.leetcode.LC2023.february;

public class TheEmployeeThatWorkedOnTheLongestTask {
    // https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task
    /** Algorithm
        1. Traverse the logs and keep track of hardestWorker and longestTask.
        2. If current task worked on is longer than longestTask, set it and set the worker
        3. If current task is as long as the longestTask known so far, set the harest worker to be min between these two workers.
        4. Return hardest worker.
     */
    public int hardestWorker(int n, int[][] logs) {
        int hardestWorker = logs[0][0];
        int longestTask = logs[0][1];
        int taskLength;
        for(int i = 1; i < logs.length; i++) {
            taskLength = logs[i][1] - logs[i-1][1];
            if (taskLength > longestTask) {
                longestTask = taskLength;
                hardestWorker = logs[i][0];
            } else if (taskLength == longestTask) {
                hardestWorker = Math.min(hardestWorker, logs[i][0]);
            }
        }
        return hardestWorker;
    }
}
