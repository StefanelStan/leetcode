package com.ss.leetcode.LC2024.september;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheNumberOfTheSmallestUnoccupiedChair {
    // https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair
    /** Algorithm
        1. Get the arrivalTimeTargetFriend of the targetFriend. As this is unqiue, you can use it to break when you reach that arrival time.
        2. Sort the times by arrival time.
        3. Use a PriorityQueue<int[]> usedSeats to queue the usedSeats. int[]{seatNumber, leavingTime} (for used seats) and a PQ<Integer> freeSeats (for seats that have been cleared by short-staying friends)
        4. Each time a friend comes:
            - Traverse usedSeats queue and try to poll while the head of the queue leaving time <= newfriends arrival time.
            - Add the freed up seats in the freeSeats queue.
        5. Give the lowest free seat (freeSeats.poll()) to the new friend. If this is not free, then no seats can be freed up, so the new friend will
            get the next incremental seat (usedSeats.size()).
        6. Break after arrivanTime == arrivalTimeTargetFriend.
     */
    public int smallestChair(int[][] times, int targetFriend) {
        int friendTargetArrivingTime = times[targetFriend][0];
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> usedSeats = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> freeSeats = new PriorityQueue<>();
        int givenSeat = 0;
        for (int[] time : times) {
            while(!usedSeats.isEmpty() && usedSeats.peek()[1] <= time[0]) {
                freeSeats.add(usedSeats.poll()[0]);
            }
            givenSeat = freeSeats.isEmpty() ? usedSeats.size() : freeSeats.poll();
            usedSeats.add(new int[]{givenSeat, time[1]});
            if (friendTargetArrivingTime == time[0]) {
                break;
            }
        }
        return givenSeat;
    }
}
