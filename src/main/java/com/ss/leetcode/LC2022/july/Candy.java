package com.ss.leetcode.LC2022.july;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Candy {
    // https://leetcode.com/problems/candy/
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int total = 0;
        PriorityQueue<int[]> candyOrder = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] assignedCandies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candyOrder.add(new int[]{i, ratings[i]});
        }
        total += assignToMinimumPriority(assignedCandies, candyOrder);
        while(!candyOrder.isEmpty()) {
            total += assignCandy(candyOrder.poll(), assignedCandies, ratings);
        }
        return total;
    }

    private int assignToMinimumPriority(int[] assignedCandies, PriorityQueue<int[]> candyOrder) {
        int total = 0;
        int min = candyOrder.peek()[1];
        int[] current;
        while(!candyOrder.isEmpty() && candyOrder.peek()[1] == min) {
            current = candyOrder.poll();
            assignedCandies[current[0]] = 1;
            total++;
        }
        return total;
    }

    private int assignCandy(int[] current, int[] assignedCandies, int[] ratings) {
        //treat edge cases
        // pos == 0
        int pos = current[0];
        int rating = current[1];
        if (pos == 0) {
            if (rating <= ratings[1]) {
                assignedCandies[0] = 1;
            } else {
                assignedCandies[0] = assignedCandies[1] + 1;
            }
        } else if (pos == assignedCandies.length -1) {
            if (rating <= ratings[ratings.length -2]) {
                assignedCandies[pos] = 1;
            } else {
                assignedCandies[pos] = assignedCandies[pos - 1] + 1;
            }
        } else { // somewhere in between
            if (rating == ratings[pos-1]) {
                if (rating == ratings[pos+1]) {
                    assignedCandies[pos] = 1;
                } else if (rating > ratings[pos +1]){
                    assignedCandies[pos] = assignedCandies[pos+1] + 1;
                } else {
                    assignedCandies[pos] = 1;
                }
            } else if (rating == ratings[pos + 1]){
                if (rating < ratings[pos-1]) {
                    assignedCandies[pos] = 1;
                } else {
                    assignedCandies[pos] = assignedCandies[pos-1] + 1;
                }
            } else if (rating > ratings[pos-1]) {
                if (rating < ratings[pos +1]) {
                    assignedCandies[pos] = assignedCandies[pos-1] + 1;
                } else {
                    assignedCandies[pos] = 1 + Math.max(assignedCandies[pos-1], assignedCandies[pos+1]);
                }
            } else assignedCandies[pos] = 1 + assignedCandies[pos + 1];
        }
        return assignedCandies[pos];
    }
}
