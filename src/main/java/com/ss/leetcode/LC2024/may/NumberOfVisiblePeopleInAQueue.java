package com.ss.leetcode.LC2024.may;

import java.util.LinkedList;

public class NumberOfVisiblePeopleInAQueue {
    // https://leetcode.com/problems/number-of-visible-people-in-a-queue
    /** Algorithm
        1. Use a linkedList to add people to the queue to build next greater element/height
        2. Starting from the back of heights[], eliminate the people from the LL that are shorter or equal as height.
            - Each elimination means one person that gets viewed.
        3. If the queue is not empty, add +1 as you can see 1 more in the queue.
            - Only 1 because the next one will have a greater height and it's not visible.
            - EG: LinkedList = 1,2,4,5,6 current height = 3.
            - 3 will eliminate 1,2 => +2 viewed people
            - also, 3 can see 4, so add +1 viewed people
            - 3 cannot see 5 because 4 is between 3 and 5 and 4 is greater than 3. (everybody in between must be shorter than both of them)
     */
    public int[] canSeePersonsCount(int[] heights) {
        int[] visible = new int[heights.length];
        LinkedList<Integer> higherPeople = new LinkedList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!higherPeople.isEmpty() && higherPeople.peekFirst() <= heights[i]) {
                higherPeople.removeFirst();
                visible[i]++;
            }
            visible[i] += higherPeople.isEmpty() ? 0 : 1;
            higherPeople.addFirst(heights[i]);
        }
        return visible;
    }
}
