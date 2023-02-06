package com.ss.leetcode.LC2023.february;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {
    // https://leetcode.com/problems/take-gifts-from-the-richest-pile/
    /** Algorithm
        1. Use a Priority Queue with reverse comparator to put piles in decreasing order.
            Also get the sum/total of the piles while adding them.
        2. While k > 0, poll from the queue (highest), deduct val - Math.sqrt(val) from total/sum and put Math.sqrt(val) back in the queue.
        3. Return the remaining total.
     */
    public long pickGifts(int[] gifts, int k) {
        long total = 0;
        PriorityQueue<Integer> topPiles = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            topPiles.add(gift);
            total += gift;
        }
        int top, toPutBack;
        while (k > 0) {
            top = topPiles.poll();
            toPutBack = (int)Math.sqrt(top);
            total -= (top - toPutBack);
            topPiles.add(toPutBack);
            k--;
        }
        return total;
    }
}
