package com.ss.leetcode.LC2021.august;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInanArray {
    // https://leetcode.com/problems/find-all-duplicates-in-an-array/
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        int temp = 0, low = 0;
        while (low < nums.length) {
            if (nums[low] != nums[nums[low] -1]) {
                temp = nums[nums[low] -1];
                nums[nums[low] -1] = nums[low];
                nums[low] = temp;
            } else if (nums[low] != low + 1){
                duplicates.add(nums[low]);
                low++;
            } else low++;
        }
        return new ArrayList<>(duplicates);
    }
}
