package com.ss.leetcode;

import com.ss.leetcode.december.AddTwoNumbers;
import com.ss.leetcode.december.BestBreak;
import com.ss.leetcode.december.CountingBits;
import com.ss.leetcode.december.FilterRestaurants;
import com.ss.leetcode.december.HandOfStraights;
import com.ss.leetcode.december.LargestMultipleOfThree;
import com.ss.leetcode.december.LongestMountain;
import com.ss.leetcode.december.LongestSubstringWithoutRepeating;
import com.ss.leetcode.december.MergeSortList;
import com.ss.leetcode.december.MinimumDeletionCost;
import com.ss.leetcode.december.PowerfulIntegers;
import com.ss.leetcode.december.RemoveDuplicatesFromSortedArray;
import com.ss.leetcode.december.RemoveDuplicatesFromSortedArray2;
import com.ss.leetcode.december.RemoveElement;
import com.ss.leetcode.december.RiverRecords;
import com.ss.leetcode.december.ThreeSum;
import com.ss.leetcode.december.TwoSum;
import com.ss.leetcode.shared.ListNode;

import java.util.Arrays;
import java.util.List;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();
        start.twoSum();
//        start.threeSum();
//        start.remvoveElement();
//        start.removeDuplicates();
//        start.handOfStraights();
//        start.addTwoNumbers();
//        start.longestSubstringWithoutRepeating();
//        start.riverRecords();
//        start.mergeSortList();
//        start.filterRestaurants();
//        start.longestMountain();
//        start.powerfulIntegers();
//        start.removeDuplicates2();
//        start.largestMultipleOfThree();
//        start.minimumDeletionCost();

//        start.countingBits();
//        start.bestBreak();
        //        start.splitTwoStringsToMakePalindrome();
    }

    public void twoSum() {
        TwoSum ts = new TwoSum();
        System.out.println("[0,1] == " + Arrays.toString(ts.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println("[1,2] == " + Arrays.toString(ts.twoSum(new int[]{3,2,4}, 6)));
        System.out.println("[0,1] == " + Arrays.toString(ts.twoSum(new int[]{3,3}, 6)));
    }

    public void threeSum() {
        ThreeSum threeSum = new ThreeSum();
//        System.out.println("[[-1,-1,2],[-1,0,1]] = " + threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("[[-2,0,2],[-2,1,1]] = " + threeSum.threeSum(new int[]{-2,0,1,1,2}));
    }

    private void remvoveElement() {
        int[] nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        RemoveElement re = new RemoveElement();
        System.out.println("RemoveElement  of " + Arrays.toString(nums) + " = " + re.removeElement(nums, 2));
        System.out.print(" => " + Arrays.toString(nums));

        int[] nums2 = new int[] { 3, 3 };
        System.out.println("RemoveElement  of " + Arrays.toString(nums2) + " = " + re.removeElement(nums2, 5));
        System.out.print(" => " + Arrays.toString(nums2));
    }

    private void removeDuplicates() {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int[] nums2 = new int[] { 1, 1, 1 };
        int[] nums3 = new int[] { 1, 1, 2 };
        int[] nums4 = new int[] { 0, 0, 1, 1, 2, 3, 4 };
        RemoveDuplicatesFromSortedArray rdsa = new RemoveDuplicatesFromSortedArray();
        System.out.println("RemoveElement  of " + Arrays.toString(nums) + " = " + rdsa.removeDuplicates(nums) + " =>" + Arrays.toString(nums));

        System.out.println("RemoveElement  of " + Arrays.toString(nums2) + " = " + rdsa.removeDuplicates(nums2) + " =>" + Arrays.toString(nums2));

        System.out.println("RemoveElement  of " + Arrays.toString(nums3) + " = " + rdsa.removeDuplicates(nums3) + " =>" + Arrays.toString(nums3));

        System.out.println("RemoveElement  of " + Arrays.toString(nums4) + " = " + rdsa.removeDuplicates(nums4) + " =>" + Arrays.toString(nums4));
    }

    private void handOfStraights() {
        HandOfStraights hos = new HandOfStraights();
        int[] nums = new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int[] nums2 = new int[] { 1, 2, 3, 4, 5 };
        int[] nums3 = new int[] { 8, 10, 12 };
        System.out.println("HoS should be true on " + Arrays.toString(nums) + " : " + hos.isNStraightHand(nums, 3));
        System.out.println("HoS should be false on " + Arrays.toString(nums2) + " : " + hos.isNStraightHand(nums2, 4));
        System.out.println("HoS should be false on " + Arrays.toString(nums3) + " : " + hos.isNStraightHand(nums3, 3));
    }

    private void addTwoNumbers() {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        ListNode l16 = new ListNode(9);
        ListNode l17 = new ListNode(9);
        ListNode l18 = new ListNode(9);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;
        l17.next = l18;

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        atn.addTwoNumbers(l11, l21);

    }

    private void longestSubstringWithoutRepeating() {
        LongestSubstringWithoutRepeating lswr = new LongestSubstringWithoutRepeating();
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
//        System.out.println("Longest substring of " + s1 + " should be 3 :" + lswr.lengthOfLongestSubstring(s1));
//        System.out.println("Longest substring of " + s2 + " should be 1 :" + lswr.lengthOfLongestSubstring(s2));
//        System.out.println("Longest substring of " + s3 + " should be 3 :" + lswr.lengthOfLongestSubstring(s3));
    }

    private void riverRecords() {
        RiverRecords rr = new RiverRecords();
        List<Integer> readings = Arrays.asList(5, 3, 6, 7, 4);
        List<Integer> readings2 = Arrays.asList(2, 3, 10, 2, 4, 8, 1);
        System.out.println(rr.maxTrailing(readings));
        System.out.println(rr.maxTrailing(readings2));
    }

    private void mergeSortList() {
        List<Integer> list1 = Arrays.asList(2, 4, 5, 9, 9);
        List<Integer> list2 = Arrays.asList(0, 1, 2, 3, 4);
        MergeSortList msl = new MergeSortList();
        System.out.println("Merging 2 lists = " + msl.mergeArrays(list1, list2));
    }

    private void filterRestaurants() {
        int[][] restaurants = { { 1, 4, 1, 40, 10 }, { 2, 8, 0, 50, 5 }, { 3, 8, 1, 30, 4 }, { 4, 10, 0, 10, 3 }, { 5, 1, 1, 15, 1 } };
        int[][] restaurants2 = { { 1, 4, 1, 40, 10 }, { 2, 8, 0, 50, 5 }, { 3, 8, 1, 30, 4 }, { 4, 10, 0, 10, 3 }, { 5, 1, 1, 15, 1 } };
        FilterRestaurants fr = new FilterRestaurants();
        System.out.println("Filtered restaurants :" + fr.filterRestaurants(restaurants, 1, 50, 10));
    }

    private void longestMountain() {
        int[] numbers = { 2, 1, 4, 7, 3, 2, 5 };
        int[] numbers2 = { 2, 2, 2 };
        int[] numbers3 = { 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
        int[] numbers4 = { 2, 1, 4, 7, 3, 2, 5 };
        LongestMountain lm = new LongestMountain();
        System.out.println("Longest mountain 5 = " + lm.longestMountain(numbers));
        System.out.println("Longest mountain 0 = " + lm.longestMountain(numbers2));
        System.out.println("Longest mountain 11 = " + lm.longestMountain(numbers3));
        System.out.println("Longest mountain 5 = " + lm.longestMountain(numbers4));
    }

    private void powerfulIntegers() {
        PowerfulIntegers pi = new PowerfulIntegers();
        System.out.println(pi.powerfulIntegers(2, 3, 10));
        System.out.println(pi.powerfulIntegers(2, 3, 10));
        System.out.println(pi.powerfulIntegers(2, 1, 10));
    }

    private void removeDuplicates2() {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        int[] nums2 = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        int[] nums3 = new int[] { 1, 1, 1, 2, 2, 2, 3, 3 };
        RemoveDuplicatesFromSortedArray2 rdsa = new RemoveDuplicatesFromSortedArray2();
//        System.out.println("RemoveElement  of " + Arrays.toString(nums) + " = " + rdsa.removeDuplicates(nums) + " =>" + Arrays.toString(nums));

//        System.out.println("RemoveElement  of " + Arrays.toString(nums2) + " = " + rdsa.removeDuplicates(nums2)+ " =>" + Arrays.toString(nums2));
        System.out.println("RemoveElement  of " + Arrays.toString(nums3) + " = " + rdsa.removeDuplicates(nums3) + " =>" + Arrays.toString(nums3));
    }

    private void minimumDeletionCost() {
        MinimumDeletionCost mdc = new MinimumDeletionCost();
        System.out.println("Min cost deletion of[abaac] = " + mdc.minCost("abaac", new int[] { 1, 2, 3, 4, 5 }));
        System.out.println("Min cost deletion of[abc] = " + mdc.minCost("abc", new int[] { 1, 2, 3 }));
        System.out.println("Min cost deletion of[aabaa] = " + mdc.minCost("aabaa", new int[] { 1, 2, 3, 4, 1 }));
        System.out.println("Min cost deletion of[bbbaaa] = " + mdc.minCost("bbbaaa", new int[] { 4, 9, 3, 8, 8, 9 }));
    }

    private void largestMultipleOfThree() {
        int[] numbers = { 8, 1, 9 };
        int[] numbers2 = { 8, 6, 7, 1, 0 };
        int[] numbers3 = { 0, 0, 0, 0, 0, 0 };
        int[] numbers4 = { 9, 8, 6, 8, 6 };
        int[] numbers5 = { 0 };
        int[] numbers6 = { 1 };
        int[] numbers7 = { 7 };
        LargestMultipleOfThree lmot = new LargestMultipleOfThree();
//        System.out.println("Largest M3 from " + Arrays.toString(numbers) + " [981= " + lmot.largestMultipleOfThree(numbers));
//        System.out.println("Largest M3 from " + Arrays.toString(numbers2) + " [8760 = " + lmot.largestMultipleOfThree(numbers2));
//        System.out.println("Largest M3 from " + Arrays.toString(numbers3) + " [0 = " + lmot.largestMultipleOfThree(numbers3));
        System.out.println("Largest M3 from " + Arrays.toString(numbers4) + " [0 = " + lmot.largestMultipleOfThree(numbers4));
//        System.out.println("Largest M3 from " + Arrays.toString(numbers5) + " [0 = " + lmot.largestMultipleOfThree(numbers5));
//        System.out.println("Largest M3 from " + Arrays.toString(numbers6) + " [0 = " + lmot.largestMultipleOfThree(numbers6));
//        System.out.println("Largest M3 from " + Arrays.toString(numbers7) + " [0 = " + lmot.largestMultipleOfThree(numbers7));
    }

    private void countingBits() {
        CountingBits cb = new CountingBits();
        System.out.println(Arrays.toString(cb.countBits(2)));
        System.out.println(Arrays.toString(cb.countBits(5)));
    }

    private void bestBreak() {
        BestBreak bb = new BestBreak();
        System.out.println(bb.integerBreak(11));
        System.out.println(bb.integerBreak(8));
    }
}
