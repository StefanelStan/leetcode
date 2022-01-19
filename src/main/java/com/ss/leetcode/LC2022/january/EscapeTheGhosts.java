package com.ss.leetcode.LC2022.january;

public class EscapeTheGhosts {
    // https://leetcode.com/problems/escape-the-ghosts/
    /** Algorithm
     1. In order to escape ghosts, the player needs to be the closest object to the target.
     If one ghost is closer or equal distance, then the ghost can catch the player
     2. Determine the distance from 0,0 to target (make sure you use absolute values)
     3. Loop over the ghosts and calculate their distance to the target. If one ghost is closer or equal to the target, return false.
     4. Return true at the end of loop.
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int targetDistance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if (targetDistance >= (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]))) {
                return false;
            }
        }
        return true;
    }
}
