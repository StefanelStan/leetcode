package com.ss.leetcode.LC2023.february;

public class CountDistinctNumbersOnBoard {
    // https://leetcode.com/problems/count-distinct-numbers-on-board/
    /** Algorithm
        1. We need all the numbers that n % i == 1. Logically, only one number satisfies this condition for any n > 1: n-1.
            n = 100. Only 100 % 99 = 1, all the others (98..1) will not satify this.
        2. Now we have 99 on board: Only 1 numbe satisfies this condition: 98. 99 % 98 = 1.
        3. As we observe, with each step we add n-1,n-2 on the board.
        4. In the end, the board will contain n, n-1..2, no n-1 numbers.
        5. We observe the answer is Math.max(1, n-1) (egde case n = 1. We still have to add 1 on board).
     */
    public int distinctIntegers(int n) {
        return Math.max(1, n-1);
    }
}
