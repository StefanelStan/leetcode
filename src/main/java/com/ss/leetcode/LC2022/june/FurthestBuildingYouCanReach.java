package com.ss.leetcode.LC2022.june;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    // https://leetcode.com/problems/furthest-building-you-can-reach/
    /** Algorithm
         1. The algorithm tries to use ALL ladders in the beginning, keeping track of them in a PriorityQueue.
         2. When out of ladders, check the ladder queue and see if next jump is bigger than the minimum from queue.
             If yes and if you have enough bricks, replace that minimum ladder jump with bricks and use a ladder instead.
             Remember to add this jump into the ladderJumps queue.
             EG: heights= [1,4,6,9,16] ladders = 3, bricks = 2.
             After 3 steps, all ladders are used and ladderQueue is 2,3,3 and the next jump is 7.
             As 7 > 2 (min of queue) and have 2 bricks, then use these 2 bricks to replace that ladder used in min jump
             Now, you will have 0 bricks and 1 ladder to use for this 7 step jump.
         3. If the current jump is a small one but have bricks, use bricks
             EH: heights [1,4,7,10,11] ladders = 3, bricks = 2.
             The ladder queue is [3,3,3] and next jump is 1. As we can see, the min jump from queue is 3 but next jump is 1.
             It does not worth spending 3 bricks to gain a ladder to be used for 1 jump.
             So use bricks instead, if sufficient bricks are available.
         4. If not possible any of the above, return i, the current step.
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderHeights = new PriorityQueue<>();
        int nextJump;
        for (int i = 0; i < heights.length -1; i++) {
            nextJump = heights[i + 1] - heights[i];
            if (nextJump <= 0) {
                continue;
            }
            if (ladders > 0) {
                // use all ladders in the first step
                ladderHeights.add(nextJump);
                ladders--;
            } else if (!ladderHeights.isEmpty() && nextJump > ladderHeights.peek() && bricks >= ladderHeights.peek()) {
                // if the ladder queue has a jump that is smaller than current use and have bricks, use bricks there and fetch that ladder
                bricks -= ladderHeights.poll();
                ladderHeights.add(nextJump);
            } else if (bricks >= nextJump) {
                bricks -= nextJump;
            } else {
                return i;
            }
        }
        return heights.length - 1;
    }
}
