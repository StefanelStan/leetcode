package com.ss.leetcode.LC2022.november;

public class DistanceBetweenBusStops {
    // https://leetcode.com/problems/distance-between-bus-stops
    /** Algorithm
         1. Determining the min cost implies calculating the distance between A -> B and B -> N -> 0 -> A.
         2. Thus, we observe A- > B -> N -> 0 -> A, which is, in fact, a full traversal of the path.
         3. Knowing the full cost of the traversal and the cost between A and B we can obtain the
            cost between B-N-0-A bu deducting the fist cost from the total cost
         4. For consistence purpose, we will travel from the left position to rightPosition.
            This way we also handle the case when start  > destination.
         5. Traverse from 0 to n and add each cost. Also, if you are between the start and destination,
            add it to a separate variable (segment cost)
         6. Determine the min between segmentCost, (totalCost-segmentCost).
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        int realStart = Math.min(start, destination);
        int realEnd = Math.max(start, destination);
        int intervalCost = 0, totalCost = 0;
        for (int i = 0; i < distance.length; i++) {
            totalCost += distance[i];
            if (i > realStart && i <= realEnd) {
                intervalCost += distance[i-1];
            }
        }
        return Math.min(intervalCost, totalCost - intervalCost);
    }
}
