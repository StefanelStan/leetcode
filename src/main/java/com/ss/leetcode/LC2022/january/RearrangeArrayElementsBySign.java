package com.ss.leetcode.LC2022.january;

public class RearrangeArrayElementsBySign {
    // https://leetcode.com/problems/rearrange-array-elements-by-sign/
    /** Algorithm
         1. Declare a new array of same size that will hold the result (rearranged[])
         2. In a while loop from i to n ()
         - Loop again to find the first/next positive number / index and first negative
         - If not reached the end, copy nums[positive], nums[negative] to rearranged[i,i+1]
         3. Return the answer
     */
    public int[] rearrangeArray(int[] nums) {
        int[] rearranged = new int[nums.length];
        int pIndex = 0, nIndex = 0, index = 0;
        while(index < nums.length) {
            while(pIndex < nums.length && nums[pIndex] < 0) {
                pIndex++;
            }
            while(nIndex < nums.length && nums[nIndex] > 0) {
                nIndex++;
            }
            if (pIndex < nums.length) {
                rearranged[index++] = nums[pIndex++];
            }
            if(nIndex < nums.length) {
                rearranged[index++] = nums[nIndex++];
            }
        }
        return rearranged;
    }
}
