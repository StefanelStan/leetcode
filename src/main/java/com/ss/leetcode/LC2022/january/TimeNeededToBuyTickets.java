package com.ss.leetcode.LC2022.january;

public class TimeNeededToBuyTickets {
    // https://leetcode.com/problems/time-needed-to-buy-tickets/
    /** Algorithm
        1. EG: 4,2,1,5,3,2,7 , k = 4
            - 1st round: [3,1,0,4,2,1,7]
            - 2nd round: [2,0,0,3,1,0,6...]
            - 3rd round  [1,0,0,2,0,0,5.]
        2. Items at the left of k (incl k) will need min(item[i], item[k]) steps
        3. Items at the right of k will need min(item[i], item[k] - 1) steps.
            item[k] - 1 because once you make item[k] 0, you stop, so you don't continue to the right.
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int timeNeeded = 0;
        for (int i = 0; i < tickets.length; i++) {
            timeNeeded += i <= k ? Math.min(tickets[k], tickets[i]) : Math.min(tickets[i], tickets[k] - 1);
        }
        return timeNeeded;
    }

    /** Algorithm
     Intuition: Example of 7,2,5,1,3,2,4,5  k = 4. Focus on the left side; anything on left side will cause delay.
     The numbers lesser than k (3) will cause their sum as delay (1 and 2 = delay 3) but the numbers greater or equal to k (7 and 5)
     will cause a delay equal to how many numbers there are * value of k.
     So 7,2,5,1 will cause a delay of (1 + 2 - lesser than K) + (2 (how many numbers >= k) * 3 (val of t[k])). So 3 + 6 = 9.
     On the right side, the formula is the same, but instead of multiplying by t[k] you multiply by t[k] -1.
     */
    public int timeRequiredToBuy2(int[] tickets, int k) {
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
