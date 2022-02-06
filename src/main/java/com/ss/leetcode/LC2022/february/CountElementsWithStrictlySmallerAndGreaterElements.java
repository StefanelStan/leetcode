package com.ss.leetcode.LC2022.february;

public class CountElementsWithStrictlySmallerAndGreaterElements {
    /** Algorithm
         1. If nums.length is 0,1 or 2 then there can not be such "special" number. Return 0.
         2. In order for such "special" numbers to exist, they need to be greater than the smallest number
         and lesser than the greatest number.
         3. From #2, deduct that all it is required to do is to count/get the cardinal of smallest and greatest number.
         The number of "special" numbers is the difference between the total numbers and cardinal (smallest, greatest)
         Putting this into a different perspective:
         [4,2,4,7,5,6,2] -> (sorted) [2,2,4,4,5,6,7]
         What is required is to know how many numbers are between idx 2 and 5 (including)

         EG: [5,2,1,5,7,1,7,2,7]
         The min is 1 and there are 2 ones.
         The max is 7 and there are 3 sevens.
         The array has a length of 9.
         The total number of special numbers is 9 - (2+3). = 4;
     */
    public int countElements(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int minCount = 0, minValue = nums[0];
        int maxCount = 0, maxValue = nums[nums.length -1];
        for (int num : nums) {
            if (num < minValue) {
                minValue = num;
                minCount = 1;
            } else if (num == minValue) {
                minCount++;
            }
            if (num > maxValue) {
                maxValue =  num;
                maxCount = 1;
            } else if (num == maxValue) {
                maxCount++;
            }
        }
        return minValue == maxValue ? 0 : (nums.length - (minCount + maxCount));
    }
}
