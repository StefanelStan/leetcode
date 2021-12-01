package com.ss.leetcode.LC2021.july;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArray {
    // https://leetcode.com/problems/beautiful-array/
    public int[] beautifulArray(int n) {
        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        while(nums.size() < n) {
            List<Integer> tmp = new ArrayList<>(n/2);
            // odd: 2*El -1
            for(Integer nr : nums) {
                if(nr * 2 -1 <= n) {
                    tmp.add(nr * 2 -1);
                }
            }
            // even 2*El
            for(Integer nr : nums) {
                if(nr * 2 <= n) {
                    tmp.add(nr * 2);
                }
            }
            nums = tmp;
        }
        int[] result = new int[n];
        for(int i = 0; i < nums.size(); i++) {
            result[i] = nums.get(i);
        }
        return result;
    }
}
