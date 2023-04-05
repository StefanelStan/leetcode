package com.ss.leetcode.LC2023.april;

public class MinimizeMaximumOfArray {
    // https://leetcode.com/problems/minimize-maximum-of-array
    /** Algorithm
        1. The best case of "normalizing" numbers is when you make them all/almost equal.
        2. This means you have to detect the average of the numbers as you traverse them
            EG: 1,3,5
            i = 0: sum = 1; avg = 1.
            i = 1: sum = 4; avh = 2.
            i = 2: sum = 9; avg = 3.
            3. As seen, the max avg we get is 3, which is also the minimum maximum integer.
        4. If avg is not an int, then increment the avg by 1, as one or more numbers will have to be higher than floor of avg.
            EG: 1,3,5,8
            i = 3: sum = 17. avg is 4.25. This means one numbers has to be 5 and others 4, thus minimum max is 5.
     */
    public int minimizeArrayValue(int[] nums) {
        long sum = 0L;
        int maxAvg = 0, currentAvg= 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            currentAvg = (int)(sum / (i+1));
            if (sum % (i+1) != 0) {
                currentAvg++;
            }
            maxAvg = Math.max(maxAvg, currentAvg);
        }
        return maxAvg;
    }
}
