package com.ss.leetcode.LC2021.december;

public class ANumberAfterADoubleReversal {
    /** Algorithm:
     1. A number that ends with 0 will not have its double reverse equal to itself. EG: 120 -> 21 -> 12.
     (Except for number 0 itself)
     2. So if the num % 10 == 0 then it ends with zero so it will be different that its double reverse.
     */
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
    }
}
