package com.ss.leetcode.LC2021.november;

public class SumOfAbsoluteDiffSortedArray {
    // https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
    /** Algorithm
        1. Compute the sum of all numbers. (totalSum)
        2. For a given number e in [a,b,c,d,e,f,g,h,i] the diff would look like
            (e-a) + (e-b) + (e-c) + (e-d) (LEFT SIDE OF E)
            (f-e) + (g-e) + (i-e) (RIGHT SIDE OF E)
        3. Translated into basic math:
            - LEFT SIDE: e * 4 - sum(a,d)
            - RIGHT SIE: sum(f,i) - e * 4.
        4. For each element in the array:
            - keep track of the cumulative sum so far (rolling sum)
            - Knowing the rollingSum up to your current element, you can find out the sum of
                the remaining right side elements by totalSum - rollingSum.
        5. Knowing how to find out the left, right sums, solve the ecuation from above, based on current index and how many
            elements you have on left/right side (i on left and nums.length i - 1) on right.
     */
    // PRO MODE -> after 2 years :)
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int numSum = 0;
        for (int num : nums) {
            numSum += num;
        }
        int [] absoluteDiff = new int[nums.length];
        int rollingSum = 0, diffOnLeft, diffOnRight;
        for (int i = 0; i < nums.length; i++) {
            diffOnLeft = i == 0 ? 0 : nums[i] * i - rollingSum;
            diffOnRight = (numSum - (rollingSum + nums[i])) - ((nums.length - i - 1) * nums[i]);
            absoluteDiff[i] = diffOnLeft + diffOnRight;
            rollingSum += nums[i];
        }
        return absoluteDiff;
    }


    public int[] getSumAbsoluteDifferences2(int[] nums) {
        int[] leftSum =  new int[nums.length];
        int[] rightSum = new int[nums.length];
        calculateSums(nums, leftSum, rightSum);
        return getDifferences(nums, leftSum, rightSum);
    }

    private void calculateSums(int[] nums, int[] leftSum, int[] rightSum) {
        leftSum[0] = nums[0];
        rightSum[nums.length -1] = nums[nums.length-1];
        for (int i = 1, j = nums.length-2; i < nums.length; i++, j--) {
            leftSum[i] = leftSum[i-1] + nums[i];
            rightSum[j] = rightSum[j+1] + nums[j];
        }
    }

    private int[] getDifferences(int[] nums, int[] leftSum, int[] rightSum) {
        int[] differences = new int[nums.length];
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            left = (i == 0 ? 0 : ( nums[i] * i - leftSum[i-1]));
            right = (i == nums.length -1 ? 0 : (rightSum[i+1] - nums[i] * (nums.length - i -1)));
            differences[i] = left + right;
        }
        return differences;
    }
}
