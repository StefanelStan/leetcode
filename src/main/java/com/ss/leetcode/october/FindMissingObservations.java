package com.ss.leetcode.october;

import java.util.stream.IntStream;

public class FindMissingObservations {
    // https://leetcode.com/contest/weekly-contest-261/problems/find-missing-observations/
    public int[] missingRolls(int[] rolls, int mean, int n) {
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
