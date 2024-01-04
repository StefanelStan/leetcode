package com.ss.leetcode.LC2024.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AdvantageShuffle {
    // https://leetcode.com/problems/advantage-shuffle
    /** Algorithm
        1. Use a int[nums1.length] target to hold the answer/target array. Initialize it with -1
        2. For a given value v2 from nums2 you need to find the lowest value amongst all the nums1 greater than v2
            - So you need to have nums1 and nums2 sorted to be able to use 2 pointers to traverse/advance
        3. Sort nums1
        4. Remap nums2 to an int[][] nums2Map [index, value] or a custom class
        5. Using 2 pointers i and j for nums1 and nums2Map
            - For a given i, if nums1[i] <= nums2Map[j][1], then move nums1[i] into an unusedList. Advance i
            - If nums1[i] > nums2Map[j][1], then you have for lowest value greater than current element in nums2
            - Copy that number from nums1 into target:  target[nums2Map[j][0]] = nums1[i] and advance i.
        6. If ususedList is NOT empty, you still have elements that have not been added to target array.
            - Traverse target and if current value is -1 (#step 1), pull the next available number from the unusedList.
    */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int[][] nums2Clone = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            nums2Clone[i][0] = i;
            nums2Clone[i][1] = nums2[i];
        }
        Arrays.sort(nums2Clone, Comparator.comparingInt(a -> a[1]));
        return swapNums(nums1, nums2Clone);
    }

    private int[] swapNums(int[] nums1, int[][] nums2Clone) {
        int[] target = new int[nums1.length];
        Arrays.fill(target, -1);
        ArrayList<Integer> unused = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2Clone.length; i++) {
            if (nums1[i] <= nums2Clone[j][1]) {
                unused.add(nums1[i]);
            } else {
                target[nums2Clone[j][0]] = nums1[i];
                j++;
            }
        }
        for (int i = 0, j = 0; i < nums1.length && j < unused.size(); i++) {
            if (target[i] == -1) {
                target[i] = unused.get(j++);
            }
        }
        return target;
    }
}
