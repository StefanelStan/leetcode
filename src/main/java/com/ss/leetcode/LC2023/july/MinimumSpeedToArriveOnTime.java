package com.ss.leetcode.LC2023.july;

public class MinimumSpeedToArriveOnTime {
    // https://leetcode.com/problems/minimum-speed-to-arrive-on-time
    /** Algorithm
        1. Fail fast: if dist.length -1 >= hour return -1 immediately.
            Even in the best case scenario, you still must spend 1 hour between travels
            If 1st ride takes 0.001 hours, it gets aproximated to 1.
            If 1st ride takes 1.0 hours, it gets aproximated to 1.
            Thus, the min hours spend in trains == dist.length -1.
        2. Apply a binary search in [low, high] range 1 .. 1000000000 (10^9)
        3. If a ride can be done with X speed, lower X and try again. If not, increase X
        4. Determining if a trip can be made with speed X
            - loop with i[0,n-2] over dist and add Math.ceil(dist[i] / speed) to cumulativeTime
            - stop when i == n-1 OR cumulativeTime > hour
            - if cumulativeTime <= hour, compute the last time taken for last journey.
            - ! last journey does not need Math.ceil, as you don't need to wait for any train.
            - If last journey takes 0.5 hours and you're below the expected hour, that's excellent!
        5. Return low.
     */
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length - 1 >= hour) {
            return -1;
        }
        int low = 1, high = 1000000000, pivot;
        while(low <= high) {
            pivot = low + (high - low) / 2;
            if (canTravel(dist, hour, pivot)) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }

    private boolean canTravel(int[] dist, double hour, double speed) {
        double cumulatedTime = 0;
        int index = 0;
        while (index < dist.length -1 && cumulatedTime <= hour) {
            cumulatedTime += Math.ceil(dist[index++] / speed);
        }
        if (cumulatedTime <= hour) {
            cumulatedTime += dist[index++] / speed;
        }
        return index == dist.length && cumulatedTime <= hour;
    }
}
