package com.ss.leetcode.LC2021.september;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    // https://leetcode.com/problems/last-stone-weight/
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones) {
            pQueue.add(stone);
        }
        int highest, secondHighest;
        while(pQueue.size() > 2) {
            highest = pQueue.poll();
            secondHighest = pQueue.poll();
            if (highest != secondHighest) {
                pQueue.add(highest - secondHighest);
            }
        }
        return pQueue.size() == 2 ? (pQueue.poll() - pQueue.poll()) : pQueue.size() == 1 ? pQueue.poll() : 0;
    }


    public int lastStoneWeight2(int[] stones) {
        int[] stoneCount = new int[1001];
        int end = -1;
        for (int stone : stones) {
            stoneCount[stone]++;
            end = Math.max(stone, end);
        }
        boolean noneFound;
        while (end >= 1) {
            if (stoneCount[end] % 2 != 0) {
                noneFound = true;
                for (int nextEnd = end - 1; nextEnd >= 1; nextEnd--) {
                    if (stoneCount[nextEnd] > 0) {
                        stoneCount[end - nextEnd]++;
                        stoneCount[nextEnd]--;
                        end = Math.max(nextEnd, end - nextEnd);
                        noneFound = false;
                        break;
                    }
                }
                if (noneFound) {
                    return end;
                }
            } else {
                end--;
            }
        }
        return end;
    }
}
