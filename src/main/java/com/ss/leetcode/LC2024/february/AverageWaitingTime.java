package com.ss.leetcode.LC2024.february;

public class AverageWaitingTime {
    // https://leetcode.com/problems/average-waiting-time
    /** Algorithm
        1. When the first customer enters, the chef will take its order and will cook.
            - The chef will be available after client[0] + client[1] time. (chefAvailableTime)
        2. When second client comes, the chef might be busy (chefAvailableTime > client[0]) or might be available (chefAvailableTime <= customer[0]).
            - When the chef will cook, the waiting time for current customer will be
              Math.max(chevAvTime, customer[0]) (depending which one is bigger) + customer[1]
              (while cooking) - customer[0] (when client initially arrived at restaurant)
        3. With each order, the chefAvailableTime will be pushed to the right, adding to the global waiting time.
        4. Return the sum / number of clients.
     */
    public double averageWaitingTime(int[][] customers) {
        int chefAvailableTime = 0;
        long waitingTime = 0;
        for (int[] customer : customers) {
            chefAvailableTime = Math.max(chefAvailableTime, customer[0]) + customer[1];
            waitingTime += (chefAvailableTime - customer[0]);
        }
        return (double)waitingTime / customers.length;
    }
}
