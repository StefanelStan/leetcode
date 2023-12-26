package com.ss.leetcode.LC2023.december;

public class NumberOfDiceRollsWithTargetSum {
    // https://leetcode.com/problems/number-of-dice-rolls-with-target-sum
    /** Algorithm
        1. Fail fast: if target < n (you cannot have a target of 6 if you have 7 dices. The min target is 7)
            OR target > n * k (target exceeds n * max_face_value) return 0 instantly
        2. You have n dices which are rolled by turn (all at once, but we imagine by turn)
        3. If you roll 1 with first dice, then the n-1 dices will need to roll target -1.
            - If you roll 2 with 1st dice, then you need to know & rolls with the other n-2 dices a target of target -2
        4. So, for each face of a dice, we select the current dice, deduct it from target and pass to next dice to roll
        5. EG: target = 15, n = 4, k = 4.
            - If you roll 3 with 1st dice, 4 with 2nd dice, then you have 2 more dices that need to sum up/target 8 (15-3-4)
            - If you roll 2 with 1st dice, 5 with 2nd dice, then you have 2 more dices that need to target 8 (15-2-5)
        6. As you can see, a cache is required to save the intermediary results.
        7. Use a cache[n][target + 1] to cache the precumputed results for 1st to nth dice.
        8. Loop for each dice (1..n). For each face o a dice, select it, deduct it from target and pass the remaining target to next dice.
            The sum of select_face_1...select_face_n will be the cache of cache[index][target]
     */
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) {
            return 0;
        }
        Integer[][] rolls = new Integer[n][target + 1];
        return rollDice(0, target, k, rolls);
    }

    private int rollDice(int diceIndex, int target, int faces, Integer[][] rolls) {
        if (target < rolls.length - diceIndex || target > (faces * (rolls.length - diceIndex))) {
            return 0;
        }
        if (diceIndex >= rolls.length) {
            return target == 0 ? 1 : 0;
        }
        if (rolls[diceIndex][target] == null) {
            rolls[diceIndex][target] = 0;
            for (int i = 1; i <= Math.min(faces, target); i++) {
                rolls[diceIndex][target] = (rolls[diceIndex][target] + rollDice(diceIndex + 1, target - i, faces, rolls)) % 1_000_000_007;
            }
        }
        return rolls[diceIndex][target];
    }
}
