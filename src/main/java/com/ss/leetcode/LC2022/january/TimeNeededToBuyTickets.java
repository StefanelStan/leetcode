package com.ss.leetcode.LC2022.january;

public class TimeNeededToBuyTickets {
    // https://leetcode.com/problems/time-needed-to-buy-tickets/
    /** Algorithm
     Intuition: Example of 7,2,5,1,3,2,4,5  k = 4. Focus on the left side; anything on left side will cause delay.
     The numbers lesser than k (3) will cause their sum as delay (1 and 2 = delay 3) but the numbers greater or equal to k (7 and 5)
     will cause a delay equal to how many numbers there are * value of k.
     So 7,2,5,1 will cause a delay of (1 + 2 - lesser than K) + (2 (how many numbers >= k) * 3 (val of t[k])). So 3 + 6 = 9.
     On the right side, the formula is the same, but instead of multiplying by t[k] you multiply by t[k] -1.
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        if (tickets[k] == 1) {
            return k + 1;
        }
        int sumOfLeftLesser =0, sumOfRightLesser = 0;
        int nrOfLeftGE = 0, nrOfRightGE = 0;
        for (int i = 0; i < k; i++) {
            if (tickets[i] < tickets[k]) {
                sumOfLeftLesser += tickets[i];
            } else {
                nrOfLeftGE++;
            }
        }
        for (int i = k + 1; i < tickets.length; i++) {
            if (tickets[i] < tickets[k]) {
                sumOfRightLesser += tickets[i];
            } else {
                nrOfRightGE++;
            }
        }
        return sumOfLeftLesser + tickets[k] * nrOfLeftGE +
            sumOfRightLesser + (tickets[k] -1) * nrOfRightGE + tickets[k];
    }
}
