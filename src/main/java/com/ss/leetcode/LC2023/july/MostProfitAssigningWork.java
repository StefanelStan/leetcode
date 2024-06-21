package com.ss.leetcode.LC2023.july;

import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssigningWork {
    // https://leetcode.com/problems/most-profit-assigning-work
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] jobsByDifficulty = getJobsByDifficulty(difficulty, profit);
        Arrays.sort(worker);
        int maxProfit = 0;
        int jobIndex = 0;
        for (int w : worker) {
            while (jobIndex < difficulty.length && w >= jobsByDifficulty[jobIndex][0]) {
                jobIndex++;
            }
            maxProfit += (jobIndex == 0 ? 0 : jobsByDifficulty[jobIndex - 1][1]);
        }
        return maxProfit;
    }

    private int[][] getJobsByDifficulty(int[] difficulty, int[] profit) {
        int[][] jobsByDifficulty = new int[difficulty.length][2];
        for (int i = 0; i < jobsByDifficulty.length; i++) {
            jobsByDifficulty[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(jobsByDifficulty, Comparator.comparingInt(j -> j[0]));
        for (int i = 1; i < difficulty.length; i++) {
            jobsByDifficulty[i][1] = Math.max(jobsByDifficulty[i-1][1], jobsByDifficulty[i][1]);
        }
        return jobsByDifficulty;
    }


    /** Algorithm
        1. Create an array[n][2] jobs [difficulty,profit] and sort it by difficulty
        2. Traverse this sorted array and set the max profit/ rolling profit from easiest job to hardest job. jobs[i][1]
        3. For each worker, find the most profitable job with a difficulty less or equal than worker. (binary search the job by difficulty).
            - Pay attention as same difficulty jobs might have different payment so binary search the last job only,
            as the last position will have the highest proffit guaranteed (step #2 does this)
        4. Return the sum.
     */
    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0, maxJobIndex;
        int[][] jobsByDifficulty = getJobsByDifficulty2(difficulty, profit);
        for (int w : worker) {
            maxJobIndex = findMaxJobIndex(jobsByDifficulty, w);
            maxProfit += maxJobIndex != -1 ? jobsByDifficulty[maxJobIndex][1] : 0;
        }
        return maxProfit;
    }

    private int[][] getJobsByDifficulty2(int[] difficulty, int[] profit) {
        int[][] jobsByDifficulty = new int[difficulty.length][2];
        for(int i = 0; i < difficulty.length; i++) {
            jobsByDifficulty[i][0] = difficulty[i];
            jobsByDifficulty[i][1] = profit[i];
        }
        Arrays.sort(jobsByDifficulty, Comparator.comparingInt(a -> a[0]));
        int maxJobProfit = 0;
        for (int[] job : jobsByDifficulty) {
            maxJobProfit = Math.max(maxJobProfit, job[1]);
            job[1] = maxJobProfit;
        }
        return jobsByDifficulty;
    }

    private int findMaxJobIndex(int[][] jobsByDifficulty, int target) {
        int low = 0, high = jobsByDifficulty.length - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (target >= jobsByDifficulty[pivot][0]) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low - 1;
    }
}
