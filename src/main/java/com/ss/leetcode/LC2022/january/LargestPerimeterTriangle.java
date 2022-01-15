package com.ss.leetcode.LC2022.january;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    // https://leetcode.com/problems/largest-perimeter-triangle/
    /** Algorithm
     1. In order for 3 edges to form a triangle, the sum of any 2 edges need to > 3rd edge.
     2. To get the max perimeter, look for the largest possible edges.
     3. Sort the array and ietrate from n to 2. If edge[n-2] + edge[n-1] > edge[n], return the sum of edges.
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int j = nums.length -1; j >= 2; j--) {
            if (nums[j-1] + nums[j-2] > nums[j]) {
                return nums[j-1] + nums[j-2] + nums[j];
            }
        }
        return 0;
    }
}
