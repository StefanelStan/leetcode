package com.ss.leetcode.LC2023.june;

import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    // https://leetcode.com/problems/total-cost-to-hire-k-workers
    /** Algorithm
        1. Add the candidates from left and right of the cost[] to two priority queues.
            - Also keep track of left and right pointers to track which leftIndex/rightIndex need to be inserted next
        2. While k > 0
            - if top of left queue <= top of right queue, poll from left, add to totalCost and add next cost from left (cost[leftIndex++])
            - else poll from right, add to totalCost and add next cost from right (cost[rightIndex++]).
            - pay attention to the two indices. If rightIndex < leftIndex, you cannot add more costs to
            the queues, and you have to use the elements that are already in the queue to pick the remaining k workers.
     */
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftCost = new PriorityQueue<>();
        PriorityQueue<Integer> rightCost = new PriorityQueue<>();
        addInitialCosts(costs, leftCost, rightCost, candidates);
        long totalCost = 0;
        int[] indices = {candidates, costs.length - candidates - 1};
        while(k > 0) {
            totalCost += getNextCost(costs, leftCost, rightCost, indices);
            k--;
        }
        return totalCost;
    }

    private void addInitialCosts(int[] costs, PriorityQueue<Integer> left, PriorityQueue<Integer> right, int c) {
        for (int i = 0, j = costs.length -1; i <= j && i < c; i++, j--) {
            left.add(costs[i]);
            if (i < j) {
                right.add(costs[costs.length -1 - i]);
            }
        }
    }

    private int getNextCost(int[] costs, PriorityQueue<Integer> left, PriorityQueue<Integer> right, int[] indices) {
        int leftCost = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
        int rightCost = right.isEmpty() ? Integer.MAX_VALUE : right.peek();
        int toReturn;
        if (leftCost <= rightCost) {
            toReturn = left.poll();
            if(indices[0] <= indices[1]) {
                left.add(costs[indices[0]]);
                indices[0]++;
            }
        } else {
            toReturn = right.poll();
            if (indices[0] <= indices[1]) {
                right.add(costs[indices[1]]);
                indices[1]--;
            }
        }
        return toReturn;
    }
}
