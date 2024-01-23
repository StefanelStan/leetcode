package com.ss.leetcode.LC2024.january;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfOrdersInTheBacklog {
    // https://leetcode.com/problems/number-of-orders-in-the-backlog
    /** Algorithm
        1. Use 2 queues of type int[].
            - buyQueue, sorting in descending order of price
            - sellQueue, sorting in ascending order of price
        2. Process each order by type:
        3. BUY, you need to look in sellQueue,
            - loop while order's price >= head of queue price.
            - Keep track of what you take out from sellQueue.
            - Also, if the order ammount is still > 0, put it in the sellQueue
        4. SELL: you need to look in buyQueue;
            - loop while queue is not empty and order price <= head of queue price
            - Keep track of what you take out from buyQueue. If current head queue.amount == 0, remove from queue.
            - At the end, if order's amount > 0, put it in the sellQueue
        5. For each step, you will have a delta (diff between what goes out from lookInqueue what goes in putInQueue)
            - Add these deltas and return their modulo sum.
     */
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        long backlogStatus = 0L;
        for (int[] order : orders) {
            if (order[2] == 0) { //BUY
                backlogStatus += processItem(order, sellQueue, buyQueue, 0);
            } else { // SELL
                backlogStatus += processItem(order, buyQueue, sellQueue, 1);
            }
        }
        return (int)(backlogStatus % 1_000_000_007);
    }

    private int processItem(int[] order, PriorityQueue<int[]> lookInQueue, PriorityQueue<int[]> putInQueue, int op) {
        if (lookInQueue.isEmpty() || !(op == 0 ? order[0] >= lookInQueue.peek()[0] : order[0] <= lookInQueue.peek()[0])) {
            putInQueue.add(order);
            return order[1];
        }
        int backlogDelta = 0;
        while (!lookInQueue.isEmpty() && order[1] > 0 && (op == 0 ? order[0] >= lookInQueue.peek()[0] : order[0] <= lookInQueue.peek()[0])) {
            int amountToRemove = Math.min(lookInQueue.peek()[1], order[1]);
            backlogDelta += -amountToRemove;
            order[1] -= amountToRemove;
            lookInQueue.peek()[1] -= amountToRemove;
            if (lookInQueue.peek()[1] == 0) {
                lookInQueue.poll();
            }
        }
        if (order[1] > 0) {
            backlogDelta += order[1];
            putInQueue.add(order);
        }
        return backlogDelta;
    }
}
