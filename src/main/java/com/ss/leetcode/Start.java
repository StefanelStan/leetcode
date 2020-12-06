package com.ss.leetcode;

import java.util.Arrays;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        Start start = new Start();
//        start.twoSum();
//        start.threeSum();
//        start.remvoveElement();
//        start.removeDuplicates();
//        start.handOfStraights();
//        start.addTwoNumbers();
//        start.longestSubstringWithoutRepeating();
//        start.riverRecords();
//        start.mergeSortList();
//        start.filterRestaurants();
        start.longestMountain();
    }


    public void twoSum() {
        TwoSum twoSum = new TwoSum();
        int[] nums = { 2, 7, 11, 15 };
        System.out.println("TwoSum of " + Arrays.toString(nums) + " = " + Arrays.toString(twoSum.twoSum(nums, 9)));
    }

    private void threeSum() {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println("ThreeSum of " + Arrays.toString(nums) + " = " + threeSum.threeSum(nums));
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
        int[] nums4 = new int[] { 0,0,1,1,2,3,4 };
        RemoveDuplicatesSortedArray rdsa = new RemoveDuplicatesSortedArray();
        System.out.println("RemoveElement  of " + Arrays.toString(nums) + " = " + rdsa.removeDuplicates(nums) + " =>" + Arrays.toString(nums));

        System.out.println("RemoveElement  of " + Arrays.toString(nums2) + " = " + rdsa.removeDuplicates(nums2)+ " =>" + Arrays.toString(nums2));

        System.out.println("RemoveElement  of " + Arrays.toString(nums3) + " = " + rdsa.removeDuplicates(nums3)+ " =>" + Arrays.toString(nums3));

        System.out.println("RemoveElement  of " + Arrays.toString(nums4) + " = " + rdsa.removeDuplicates(nums4)+ " =>" + Arrays.toString(nums4));
    }

    private void handOfStraights() {
        HandOfStraights hos = new HandOfStraights();
        int[] nums = new int[] {1,2,3,6,2,3,4,7,8};
        int[] nums2 = new int[] {1,2,3,4,5};
        int[] nums3 = new int[] {8,10,12};
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
        List<Integer> readings = Arrays.asList(5,3,6,7,4);
        List<Integer> readings2 = Arrays.asList(2, 3, 10, 2, 4, 8, 1);
        System.out.println(rr.maxTrailing(readings));
        System.out.println(rr.maxTrailing(readings2));
    }

    private void mergeSortList() {
        List<Integer> list1 =  Arrays.asList(2,4,5,9,9);
        List<Integer> list2 =  Arrays.asList(0,1,2,3,4);
        MergeSortList msl = new MergeSortList();
        System.out.println("Merging 2 lists = " + msl.mergeArrays(list1, list2));
    }

    private void filterRestaurants() {
        int[][] restaurants = {{1,4,1,40,10}, {2,8,0,50,5}, {3,8,1,30,4}, {4,10,0,10,3}, {5,1,1,15,1}};
        int[][] restaurants2 = {{1,4,1,40,10}, {2,8,0,50,5}, {3,8,1,30,4}, {4,10,0,10,3}, {5,1,1,15,1}};
        FilterRestaurants fr = new FilterRestaurants();
        System.out.println("Filtered restaurants :" + fr.filterRestaurants(restaurants, 1,50, 10));
    }

    private void longestMountain() {
        int[] numbers = {2,1,4,7,3,2,5};
        LongestMountain lm = new LongestMountain();
        System.out.println("Longest mountain =" + lm.longestMountain(numbers));
    }
}

