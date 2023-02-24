package com.ss.leetcode.LC2023.february;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    // https://leetcode.com/problems/ipo
    /** Algorithm
        1. Given the current W, we can only start the projects that have the capital lesser or = to w.
            Add all the projects into a priority queue in increasing order by capital
        2. Out of these projects, we should select the one that gives the max profit.
            Put the projects from #1 in a second PriorityQueue in decreasing order by profit.
            This way we pick the project with best profit with the allowed capital.
        3. Once selected, increment the W and see what other projects can be pulled by repeating #1 and #2.
            If not able to pick new projects, pull more projects from the second queue.
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
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
