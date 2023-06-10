package com.ss.leetcode.LC2023.june;

public class MaximumValueAtAGivenIndexInABoundedArray {
    /** Algorithm
        1. As a general idea, you want to build the highest possible mountain in numbers
            eg: 1,1,1,1,1,2,3,4,5,6,7,6,5,4,3,2,1,1,1,1 , where max is 7m it goes to 1 and it flattens at 1
        2. Use binary search to determine if x (1..maxSum/2 + 1) can be the peak at given index
        3. This means that the number from left side will have to be 1..1,2,3.x-1
            And number at the right of index will be x-1,x-2...1...1
        4. To determine the sum of 1+2+...+x use formula x * (x+1) / 2
        5. Based on x and index, you can have a partial or complete sequence of numbers x,x-1..1
            EG: index = 5 and x = 3 => 1,1,1,1,2,3  => so the sum is 1+2+3 + (3 * 1)
            EG2: index = 5 and x = 100 => 95,96,97,98,99,100
            As observed, your segment has 6 elements. The sum of 95..100 is [sum of 1-100] - [sum of 1-94]
        6. Knowing your current x and the max length of "slope" on left and right, determine what sum can
            be achieved on left and right
        7. If this sum is greater than maxSum, lower right index in binary search, else increase left index.
     */
    public int maxValue(int n, int index, int maxSum) {
        if (n == 1) {
            return maxSum;
        }
        int left = 1, right = maxSum/2 + 1, pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (canConstructArray(n, index, pivot, maxSum)) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left - 1;
    }

    private boolean canConstructArray(int n, int index, int target, int maxSum) {
        long candidateSum = target
            + getSideSum(index, Math.max(1, target - 1))
            + getSideSum((n - (index + 1)),
            Math.max(1, target -1 ));
        return candidateSum <= maxSum;
    }

    private long getSideSum(int segmentLength, int value) {
        if (segmentLength < value) {
            // EG: because your value is > segmentLength, you can only build smth like 4,5,6,7 [0,1,2,3]
            return getIntervalSum(value, value - segmentLength);
        } else {
            // because your segment length >= value, you can build smth like [1,1,1,2,3,4,5]
            // where you have a 2 * 1 and a progression 1..5 so add the progression and the flat ones
            return ((long) value * (value + 1)) / 2 + (segmentLength - value);
        }
    }

    private long getIntervalSum(int n, int startIndex) {
        long totalSum = ((long)n * (n + 1)) / 2;
        long segmentSum = ((long)startIndex * (startIndex + 1)) / 2;
        return totalSum - segmentSum;
    }
}
