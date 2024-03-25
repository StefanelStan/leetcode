package com.ss.leetcode.LC2021.august;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInanArray {
    // https://leetcode.com/problems/find-all-duplicates-in-an-array/
    /** Algorithm
        1. Traverse and try to place nums[i] at the position nums[nums[i] - 1].
            EG: number 3 at the 3rd position in the array
        2. If nums[nums[i] - 1] is occupied by another number, swap it and put the current one
        3. If it's occupied by the same number as current, then current is duplicated, so add it
            to answer and set nums[i] to 0.
        4. If current number == nums[nums[i] - 1] OR 0, then continue traversing.
    */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int temp;
        for (int i = 0; i < nums.length;) {
            if (nums[i] - 1 == i || nums[i] == 0) {
                i++;
            } else {
                if (nums[i] == nums[nums[i] - 1]) {
                    duplicates.add(nums[i]);
                    nums[i] = 0;
                    i++;
                } else {
                    temp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[temp - 1] = temp;
                }
            }
        }
        return duplicates;
    }

    public List<Integer> findDuplicates2(int[] nums) {
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
