package com.ss.leetcode.LC2023.march;

public class RemovingMinimumNumberOfMagicBeans {
    // https://leetcode.com/problems/removing-minimum-number-of-magic-beans
    /** Algorithm
        1. [4,1,6,5] The idea is to see how much it would cost the remove all the beans from the bags in order to
            "flatten"/ make equal each bag.
        2. This process is much more visual when we order the bags: [4,1,6,5] -> [1,4,5,6]
        3. Iterating over each bag, we can ask "how much would it cost to make all the other bags equal to this"
            [1,4,5,6]
            i = 0: In order to make the bags on the right 1, we need to remove (4-1 + 5-1 + 6-1) beans.
                This formula can be simplified/cached and deducted as sumOfRightElements - current_element * number_of_right_elemens
                eg: 15 - (3*1) = 12. So we need to eliminate 12 beans.
                Total = 12
            i = 1. On left side we have 1 bean to eliminate, as we cannot make 1 bean be 4 beans.
                On right we have 11 - 2 * 4 = 3 beans.
                Total = 1+3;
            i = 2. Left : 1+4 = 5
                Right: 6-5 = 1;
                Total = 6;
            i = 3; Left : 1+4+5 = 9.
                Right = 0; Total 9.
                The min is 4.
        4. DO NOT APPLY step #3 just like that, but to all the consecutive numbers between min and max.
            eg: a,b,c,d  => The solution might be to lower all numbers to c-1 and eliminate a and b.
        5. So count/group the beans into an int[100_001]. Also retain the min and max.
        6. Iterate from i = min to max.
            Keep track of how many numbers you have parsed so far. This will help to know how many numbers you still have.
            The sum of numbers of the right is totalSum - sumSoFar.
            The numberOfBEans you need to eliminate from right side is sumOnRight - (numberOfRemainingBeans * currentBeanValue)
            The beans on the left will all be eliminated/made 0.
        7. Return the min of the operations.
     */
    public long minimumRemoval(int[] beans) {
        long minRemoval = Long.MAX_VALUE;
        long totalSum = 0;
        int[] count = new int[100_001];
        int min = 100_000, max = -1;
        int numsEncountered = 0;
        for(int bean : beans) {
            totalSum += bean;
            count[bean]++;
            min = Math.min(min, bean);
            max = Math.max(max, bean);
        }
        long currentSum = 0, sumOnRight, toRemoveFromRight;
        for (int i = min; i <= max; i++) {
            numsEncountered += count[i];
            sumOnRight = totalSum - (currentSum + (long)i * count[i]);
            toRemoveFromRight = sumOnRight - ((beans.length - numsEncountered) * (long)i);
            minRemoval = Math.min(minRemoval, currentSum + toRemoveFromRight);
            currentSum += ((long)count[i] * i);
        }
        return minRemoval;
    }
}
