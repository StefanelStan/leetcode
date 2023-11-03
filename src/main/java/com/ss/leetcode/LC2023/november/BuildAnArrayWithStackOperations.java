package com.ss.leetcode.LC2023.november;

import java.util.LinkedList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    // https://leetcode.com/problems/build-an-array-with-stack-operations
    /** Algorithm
        1. Suppose you have 1 on your stack and your next target is 4 ([1,4])
            - You need to PUSH and POP 2
            - You need to PUSH and POP 3
            - PUSH 4
        2. We need PUSH & POP 2 times, to eliminate the numbers 2 & 3.
            - Thus, the "bad numbers" between the current and next target will require PU & PO, and 1 operation to PUSH the next target.
        3. Observe the formula (next - current - 1) x [PUSH & POP] + 1 PUSH (for next number)
     */
    private static final String PUSH = "Push";
    private static final String POP = "Pop";
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new LinkedList<>();
        int prev = 0;
        for (int element : target) {
            applyOperations ((element - prev) - 1, operations);
            prev = element;
        }
        return operations;
    }

    private void applyOperations(int gap, List<String> operations) {
        while (gap-- > 0) {
            operations.add(PUSH);
            operations.add(POP);
        }
        operations.add(PUSH);
    }
}
