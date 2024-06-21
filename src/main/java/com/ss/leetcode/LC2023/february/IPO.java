package com.ss.leetcode.LC2023.february;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    // https://leetcode.com/problems/ipo
    /** Algorithm
        1. Sort the sortedByCapital [profits & capital] joined array by capital. So lowest required capital jobs first
        2. While sortedByCapital[capital] <= current capital, add these profits into a priority queue by reverse. (keep an index on sortedCapital)
        3. If able, poll the highest paying job from the pq and add it to current capital.
        4. At the end, if jobs still remain in pq, poll them until your k becomes 0
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int maxCapital = w;
        PriorityQueue<Integer> profitableJobs = new PriorityQueue<>(Comparator.reverseOrder());
        int[][] sortedByCapital = getSortedByCapital(profits, capital);
        int index = 0;
        while(index < profits.length && k > 0 && !(profitableJobs.isEmpty() && maxCapital < sortedByCapital[index][0])) {
            while(index < profits.length && maxCapital >= sortedByCapital[index][0]) {
                profitableJobs.add(sortedByCapital[index++][1]);
            }
            if (!profitableJobs.isEmpty()) {
                maxCapital += profitableJobs.poll();
                k--;
            }
        }
        while (k > 0 && !profitableJobs.isEmpty()) {
            maxCapital += profitableJobs.poll();
            k--;
        }
        return maxCapital;
    }

    private int[][] getSortedByCapital(int[] profits, int[] capital) {
        int[][] sortedByCapital = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            sortedByCapital[i] = new int[]{capital[i], profits[i]};
        }
        Arrays.sort(sortedByCapital, Comparator.comparingInt(a -> a[0]));
        return sortedByCapital;
    }


    /** Algorithm
        1. Given the current W, we can only start the projects that have the capital lesser or = to w.
            Add all the projects into a priority queue in increasing order by capital
        2. Out of these projects, we should select the one that gives the max profit.
            Put the projects from #1 in a second PriorityQueue in decreasing order by profit.
            This way we pick the project with best profit with the allowed capital.
        3. Once selected, increment the W and see what other projects can be pulled by repeating #1 and #2.
            If not able to pick new projects, pull more projects from the second queue.
     */
    public int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> capitalAndProfits = getCapitalAndProfits(capital, profits);
        if (capitalAndProfits.peek()[0] > w) {
            return 0;
        }
        PriorityQueue<Integer> profitableProjects = new PriorityQueue<>(Comparator.reverseOrder());
        while (k > 0 && !capitalAndProfits.isEmpty()) {
            while (!capitalAndProfits.isEmpty() && w >= capitalAndProfits.peek()[0]) {
                profitableProjects.add(capitalAndProfits.poll()[1]);
            }
            if (profitableProjects.isEmpty()){
                break;
            }
            w += profitableProjects.poll();
            k--;
        }
        while(k > 0 && !profitableProjects.isEmpty()) {
            k--;
            w += profitableProjects.poll();
        }
        return w;
    }

    private PriorityQueue<int[]> getCapitalAndProfits(int[] capital, int[] profits) {
        PriorityQueue<int[]> capitalAndProfits = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < capital.length; i++) {
            capitalAndProfits.add(new int[]{capital[i], profits[i]});
        }
        return capitalAndProfits;
    }
}
