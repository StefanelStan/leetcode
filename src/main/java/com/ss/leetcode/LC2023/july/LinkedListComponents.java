package com.ss.leetcode.LC2023.july;

import com.ss.leetcode.shared.ListNode;

public class LinkedListComponents {
    // https://leetcode.com/problems/linked-list-components
    /** Algorithm
        1. Use a boolean[10001] to map the present nums in nums
        2. Traverse list and use a boolean overAComponent to flag if you are over a component or not
            - First time you encounter a node from nums, increment the components by 1 and set the flag to true.
            - If the node is NOT present in nums, then mark overAComponent to false.
        3. Return number of components
     */
    public int numComponents(ListNode head, int[] nums) {
        boolean[] presentNums = getPresentNums(nums);
        int components = 0;
        boolean overAComponent = false;
        while(head != null) {
            if (presentNums[head.val]) {
                if (!overAComponent) {
                    overAComponent = true;
                    components++;
                }
            } else {
                overAComponent = false;
            }
            head = head.next;
        }
        return components;
    }


    private boolean[] getPresentNums(int[] nums) {
        boolean[] presentNums = new boolean[10001];
        for(int n : nums) {
            presentNums[n] = true;
        }
        return presentNums;
    }
}
