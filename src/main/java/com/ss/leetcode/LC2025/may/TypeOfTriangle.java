package com.ss.leetcode.LC2025.may;

public class TypeOfTriangle {
    // https://leetcode.com/problems/type-of-triangle
    /** Algorithm
        1. In a triangle, the sum of any 2 edges is greater than the 3rd edge.
        2. Check if the sum of any 2 edges is lesser than the 3rd edge. If so, return none.
        3. Else check if all edges are equal or at least 2 of them.
        4. Return scalene by default.
     */
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || a == c || b == c) {
            return "isosceles";
        }
        return "scalene";
    }
}
