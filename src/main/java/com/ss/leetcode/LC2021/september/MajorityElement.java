package com.ss.leetcode.LC2021.september;

import java.util.Arrays;

public class MajorityElement {
    // https://leetcode.com/problems/majority-element/
    /** Algorithm
        1. Being a major element (> 50%), its count will be greater than all the other added together
        2. Traverse array and if current == majorElement, increase count, else decrease count
        3. If count reaches 0, then current element is a candidate for majorElement. set count back to 1
        4. Due to majorityElement, no other elements will decreate its count below 1.
     */
    // Boyer–Moore algorithm
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            count = (nums[i] == majorityElement ? count + 1 : count - 1);
            if (count == 0) {
                majorityElement = nums[i];
                count = 1;
            }
        }
        return majorityElement;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
