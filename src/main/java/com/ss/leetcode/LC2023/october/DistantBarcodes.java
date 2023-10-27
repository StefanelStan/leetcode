package com.ss.leetcode.LC2023.october;

import java.util.PriorityQueue;

public class DistantBarcodes {
    // https://leetcode.com/problems/distant-barcodes
    /** Algorithm
        1. Count the group size of each barcode: eg: 3 of 1s, 4 os 2s etc into an array[] count
        2. For each paid (index, count) add it into a PriorityQueue<> with reverse comparator based on count
            (most numerous elements on top)
        3. Poll the head of the queue. If the head != the last added element, add the value of the head, decrement count and put it back in queue (if count is still > 0)
        4. If the head matches the last element, poll next head, add next head's value to answer, add head's value to answer,
            decrement the counts and add them back to the queue (if counts > 0)
        5. Return then the queue is empty.
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] count = countBarcodes(barcodes);
        int prev = -1, insertIndex = 0;
        PriorityQueue<Barcode> queue = prioritizeBarcodes(count);
        Barcode top, next;
        while (insertIndex < barcodes.length) {
            top = queue.poll();
            if (top.value == prev) {
                next = queue.poll();
                barcodes[insertIndex++] = next.value;
                reinsertIfNeeded(queue, next);
            }
            prev = barcodes[insertIndex++] = top.value;
            reinsertIfNeeded(queue, top);
        }
        return barcodes;
    }

    private void reinsertIfNeeded(PriorityQueue<Barcode> queue, Barcode element) {
        if (--element.count > 0) {
            queue.add(element);
        }
    }

    private PriorityQueue<Barcode> prioritizeBarcodes(int[] count) {
        PriorityQueue<Barcode> queue = new PriorityQueue<>((a,b) -> Integer.compare(b.count, a.count));
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                queue.add(new Barcode(i, count[i]));
            }
        }
        return queue;
    }

    private int[] countBarcodes(int[] barcodes) {
        int[] count = new int[10001];
        for(int barcode : barcodes) {
            count[barcode]++;
        }
        return count;
    }

    private static class Barcode {
        int value;
        int count;

        public Barcode (int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
