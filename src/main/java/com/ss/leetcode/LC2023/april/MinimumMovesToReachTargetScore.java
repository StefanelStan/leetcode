package com.ss.leetcode.LC2023.april;

public class MinimumMovesToReachTargetScore {
    // https://leetcode.com/problems/minimum-moves-to-reach-target-score
    /** Algorithm
        1. Start from target and try to reach 1.
        2. If your target/current target is odd, you cannot obtain it by multiplication (eg: target == 19),
            but by adding 1 to previous even number (18 + 1) = 19.
        3. While maxDoubles > 0 and target > 1
            - if target is even, divide it by 2
            - if target is odd, deduct 1
        4. Stop #3 stops (maxDoubles reached 0 OR your target is 1), you can only use increment operations,
            this means from your current target you need target -1 steps to reach 1.
            EG: target 21 maxDoubles= 3
            move1: target = target -1 => target = 20 (21 is not even)
            move2: target = target / 2 =>target =10 and maxDoubles = 2
            move3: taget = target /2 => target = 5 and maxDoubles = 1
            move4: target = target -1 =>target = 4 and madDobules = 1
            move5: target = target / 2 =>target =2 and MaxDoubles = 0
            At this point we break the loop and we can't divide it anymore
            The answer is 5 (number of steps) + target -1 (2 - 1) = 6.
     */
    public int minMoves(int target, int maxDoubles) {
        int minMoves = 0;
        while(maxDoubles > 0 && target != 1) {
            if (target % 2 == 0) {
                target = target / 2;
                maxDoubles--;
            } else {
                target--;
            }
            minMoves++;
        }
        return minMoves + (target - 1);
    }
}
