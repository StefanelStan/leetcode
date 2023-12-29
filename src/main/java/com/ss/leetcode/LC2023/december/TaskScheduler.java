package com.ss.leetcode.LC2023.december;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskScheduler {
    // https://leetcode.com/problems/task-scheduler
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        PriorityQueue<Integer> sortedTasks = getSortedTasks(tasks);
        ArrayList<Integer> polledTasks = new ArrayList<>(n);
        int polledRound, peek;
        int leastInterval = 0;
        while (!sortedTasks.isEmpty()) {
            polledRound = 0;
            polledTasks.clear();
            while (!sortedTasks.isEmpty() && polledRound <= n) {
                peek = sortedTasks.poll();
                polledRound++;
                if (--peek > 0) {
                    polledTasks.add(peek);
                }
            }
            sortedTasks.addAll(polledTasks);
            leastInterval += !sortedTasks.isEmpty() ? n + 1 : polledRound;
        }
        return leastInterval;
    }

    private PriorityQueue<Integer> getSortedTasks(char[] tasks) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        PriorityQueue<Integer> sortedTasks = new PriorityQueue<>(Comparator.reverseOrder());
        for (int j : count) {
            if (j > 0) {
                sortedTasks.add(j);
            }
        }
        return sortedTasks;
    }
}
