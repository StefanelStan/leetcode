package com.ss.leetcode.LC2023.february;

public class CorporateFlightBookings {
    // https://leetcode.com/problems/corporate-flight-bookings
    /** Algorithm
         1. Intuition tells you, for each booking [a,b,x] you should traverse an int[] seats from a to b and increment the value by x.
            However, this would lead to n*n complexity, as you might have to travel the entire array bookings.length times.
            (if each booking is 0,n, value)
         2. So why not mark the beginning and ending of each booking
            eg: [1,4, 10], [2,3, 30]
                 before: int[] bookingMark = [0,0,0,0,0,0,0]
            #booking 1: mark [1] with 10 and [5] with -10 (to simulate you added 10 tickets and deducted 10 ticket)
                [10,0,0,0,-10]
            # booking 2 => [10,20,0,-20,-10]
         3. Now traverse this array and apply a prefix sum
            [10,30,30,10]
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] prefixSumLine = new int[n+2];
        for (int[] booking : bookings) {
            prefixSumLine[booking[0]] += booking[2];
            prefixSumLine[booking[1] +1] -= booking[2];
        }

        int[] seats = new int[n];
        int prefixSum = 0;
        for (int i = 0; i < seats.length; i++) {
            prefixSum += prefixSumLine[i+1];
            seats[i] = prefixSum;
        }
        return seats;
    }
}
