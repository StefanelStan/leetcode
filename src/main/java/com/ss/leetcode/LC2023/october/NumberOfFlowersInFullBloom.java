package com.ss.leetcode.LC2023.october;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfFlowersInFullBloom {
    // https://leetcode.com/problems/number-of-flowers-in-full-bloom
    /** Algorithm
        1. Sort the flowers by startDate ([1,5],[2,3],[2,8],[3,8] etc)
        2. Sort the people in ascending order. Also keep track of the original position of each person
            (copy people[] into a sortedPeople[i][original_position]). This way you know where each person was in the original people array
        3. Use a priorityQueue ("basket of flowers") which will be used to collect flowers, sorting them by endDate.
        4. In a loop, for each person in sortedPeople
            - Collect flowers in basket_of_flowers while flower's' startDate is <= sortedPeople[pIndex].
            (collect flowers that will bloom BEFORE OR EQUAL to current person)
            - Remove the "dried out flowers" (flowers whise endDate is < currentPerson) as they have dried before the arrival of current person
            - The flowers in the basket are viewed by current person. Set current person's number of flowers in full bloom (basket.size())
            - Advance to next person
     5. Return the answer.
     */
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] viewedBloomedFlowers = new int[people.length];
        Arrays.sort(flowers, Comparator.comparingInt(a -> a[0]));
        int[][] sortedPeople = getSortedPeople(people);
        PriorityQueue<Integer> basket = new PriorityQueue<>(Comparator.comparingInt(a -> flowers[a][1]));
        int fIndex = 0, pIndex = 0;
        while (pIndex < people.length) {
            while (fIndex < flowers.length && flowers[fIndex][0] <= sortedPeople[pIndex][0]) {
                basket.add(fIndex);
                fIndex++;
            }
            while (!basket.isEmpty() && flowers[basket.peek()][1] < sortedPeople[pIndex][0]) {
                basket.poll();
            }
            viewedBloomedFlowers[sortedPeople[pIndex][1]] = basket.size();
            pIndex++;
        }
        return viewedBloomedFlowers;
    }

    private int[][] getSortedPeople(int[] people) {
        int[][] sortedPeople = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            sortedPeople[i][0] = people[i];
            sortedPeople[i][1] = i;
        }
        Arrays.sort(sortedPeople, Comparator.comparingInt(a -> a[0]));
        return sortedPeople;
    }
}
