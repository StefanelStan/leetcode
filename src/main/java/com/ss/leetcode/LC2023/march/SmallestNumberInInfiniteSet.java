package com.ss.leetcode.LC2023.march;

import java.util.TreeSet;

public class SmallestNumberInInfiniteSet {
    // https://leetcode.com/problems/smallest-number-in-infinite-set
    /** Algorithm
        1. Use an int variable minValue to keep track of the smallest "natural, in order" integer.
        2. At the same time, the calls might raise minValue to eg: 4 and do a addBack(2).
        In the scenario, the minValue is 4 but we have an addBack2.
        3. Use a TreeSet<Integer> to retain ALL the addBack values that are smaller than minValue
            (disconnected interval): eg: [2,5,8] and minValue = 12.
        4. popSmallest()
            - if the set is empty (no disconnected mins), increment and return minValue
            - else return the set.pollFirst()
        5. addBack(num)
            - if num == minValue -1, adjust the minValue (decrement it). Also, check if this value does not exist in set (last()).
                if it is, remove it. No duplications
                eg: 2,3 minValue = 4. addBack(3). In this case minValue becomes 3 and the set[2]
            - if num <= minValue -2, just add it to the set (the set contains disconnected integers)
                eg: 2,3,4 minValue = 6. Use minValue when possible.
         */
    private TreeSet<Integer> unconnectedMins;
    private int minValue =1;
    public SmallestNumberInInfiniteSet() {
        unconnectedMins = new TreeSet<>();
    }

    public int popSmallest() {
        if (unconnectedMins.isEmpty()) {
            minValue++;
            return minValue -1;
        } else {
            return unconnectedMins.pollFirst();
        }
    }

    public void addBack(int num) {
        if (num == minValue -1) {
            minValue--;
            if (!unconnectedMins.isEmpty() && unconnectedMins.last() == num) {
                unconnectedMins.pollLast();
            }
        } else if (num <= minValue - 2) {
            unconnectedMins.add(num);
        }
    }
}
