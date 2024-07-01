package com.ss.leetcode.LC2021.september;

public class ThreeConsecutiveOdds {
    // https://leetcode.com/problems/three-consecutive-odds/
    /** Algorithm
        1.Traverse with i from 0 to n-2
        2. If arr[i] %2  == 1 && arr[i+1] % 2 ==1 && arr[i+2] % 2 == 1 return true
        3. Return false by default
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i+1] % 2 == 1 && arr[i+2] % 2== 1) {
                return true;
            }
        }
        return false;
    }
}
