package com.ss.leetcode.LC2021.october;

import java.util.stream.IntStream;

public class FindMissingObservations {
    // https://leetcode.com/contest/weekly-contest-261/problems/find-missing-observations/
    /** Algorithm
        1. Get the sum of rolls.
        2. Using the mean, get the expected sum of all n + m numbers: mean * (n + m).
        3. Sum of missing rolls if sumOfAllNumbers - sumOfRolls.
        4. If sumOfMissingRolls > 6 *n (you need numbers higher than 6) OR sumOfMissingRolls < n (you need numbers lower than 1) return int[0]
        5. Your "average" roll is sumOfMissingRolls / n.
        6. You might have a remainder eg: sumOfMissingRolls = 20. n = 6. 20 / 6 = 3; 3 *6 = 18. So you need to add the number 2 (1 + 1) on two more indices
        7. Insert average and an extra 1 (then an extra 0 when the remainider becomes 0).
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int sumOfMissingNumbers = mean * (rolls.length + n) - sum;
        if (sumOfMissingNumbers > 6 * n || sumOfMissingNumbers < n) {
            return new int[0];
        }
        int[] missing = new int[n];
        int newMean = sumOfMissingNumbers / n;
        int extra = sumOfMissingNumbers - newMean * n;
        for (int i = 0; i < n; i++) {
            missing[i] = newMean + (extra > 0 ? 1 : 0);
            extra--;
        }
        return missing;
    }


    public int[] missingRolls2(int[] rolls, int mean, int n) {
        int sum = IntStream.of(rolls).sum();
        double missingSum = mean * (rolls.length + n) - sum;
        double avgMissing = missingSum / n;

        if (avgMissing > 6 || avgMissing < 0) {
            return new int[0];
        }

        int[] missingRolls = new int[n];
        int toAdd =  (int)Math.ceil(avgMissing);
        missingRolls[0] = toAdd;
        missingSum -= toAdd;
        for (int i = 1; i < n; i++) {
            missingRolls[i] = (int) Math.max(1, missingSum / (n -i));
            missingSum -= missingRolls[i];
        }
        if (missingSum != 0) {
            return new int[0];
        }
        return missingRolls;
    }
}
