package com.ss.leetcode.LC2022.may;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class SeatReservationManager {
    // https://leetcode.com/problems/seat-reservation-manager/
    Queue<Integer> seats = new PriorityQueue<>();
    public SeatReservationManager(int n) {
        while(n > 0) {
            seats.add(n--);
        }
    }

    public int reserve() {
        return seats.poll();
    }

    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}
