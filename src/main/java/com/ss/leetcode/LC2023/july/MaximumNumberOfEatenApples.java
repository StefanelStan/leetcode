package com.ss.leetcode.LC2023.july;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEatenApples {
    // https://leetcode.com/problems/maximum-number-of-eaten-apples
    /** Algorithm
        1. Use a priorityQueue<int[]> to collect apples in a basket: [count, expirationDate]. The priorityQueue will
            use a comparator.comparingInt(a -> a[1]), in order to put the smallest (shortest) expirationDate first
        2. Each day:
            - if apples > 0, add the apples to the queue
            - try to eat an apple from the queue. Eating will return 0 or 1, which will be increments to total number of eaten apples
        3. Eating apples:
            - Take an apple from the basket (queue.peek() -> [count, expiryDate])
            - if the apple is expired, remove the basket and try to pick next basket
            - if not expired, take one. If basket is empty (int[0]), remove the basket from queue
        4. When finished collecting apples into baskets, try to spend the remaining days eating the
            whatever apples you have in the priorityqueue. Each day will continue to be incremented and
            checked against the basket's expiry date.
     */
    public int eatenApples(int[] apples, int[] days) {
        int eatenApples = 0;
        PriorityQueue<int[]> pickedApples = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < days.length; i++) {
            if (apples[i] > 0) {
                // count and expiryDate
                pickedApples.add(new int[]{apples[i], (days[i] + i) - 1});
            }
            eatenApples += eatApple(pickedApples, i);
        }
        int currentDay = days.length;
        while(!pickedApples.isEmpty()) {
            eatenApples += eatApple(pickedApples, currentDay);
            currentDay++;
        }
        return eatenApples;
    }

    private int eatApple(PriorityQueue<int[]> pickedApples, int currentDay) {
        int eaten = 0;
        while(!pickedApples.isEmpty() && eaten == 0) {
            int[] current = pickedApples.peek();
            if (currentDay <= current[1]) {
                eaten++;
                if (--current[0] == 0) {
                    pickedApples.poll();
                }
            } else {
                pickedApples.poll();
            }
        }
        return eaten;
    }
}
