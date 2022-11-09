package com.ss.leetcode.LC2022.november;

import java.util.LinkedList;

public class OnlineStockSpan {
    // https://leetcode.com/problems/online-stock-span
    /** Algorithm
     * 1. Keep a stack or LinkedList stockSpan of type int[] that will store price and dayIndex
     * 2. With each step, keep/increase a dayIndex. If stockSpan is empty, add a pair [price, dayIndex] to the tail. Return a default 1
     * 3. If not empty, starting from the back, remove the tail elements that have a price lower or equal to given price
     * 4. When you finish eliminating the lesser or equal elements, you have two options:
     *    - there are still elements in the list:  means the last element has a price higher so the span will be dayIndex - lastElement.dayIndex
     *    - if queue is empty, means you have eliminated all smaller elements, thus the current price is the highest. Return dayIndex.
     *    - add current price to the tail of queue
     */
    LinkedList<int[]> decreasingStocks;
    int round = 1;
    public OnlineStockSpan() {
        decreasingStocks =  new LinkedList<>();
    }

    public int next(int price) {
        int lastStock = 1;
        if (decreasingStocks.isEmpty()) {
            decreasingStocks.addLast(new int[]{price, round++});
        } else {
            while(!decreasingStocks.isEmpty() && decreasingStocks.peekLast()[0] <= price) {
                decreasingStocks.removeLast();
            }
            if(decreasingStocks.isEmpty()) {
                lastStock = round;
            } else {
                lastStock = round - decreasingStocks.peekLast()[1];
            }
            decreasingStocks.addLast(new int[]{price, round});
            round++;
        }
        return lastStock;
    }
}
