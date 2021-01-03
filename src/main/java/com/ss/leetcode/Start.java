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
import com.ss.leetcode.january.AddToArrayForm;
import com.ss.leetcode.january.ConstructKPalindromeStrings;
import com.ss.leetcode.january.ExcelSheetColumnNumber;
import com.ss.leetcode.january.LargestNumber;
import com.ss.leetcode.january.LongestStringChain;
import com.ss.leetcode.january.ProductOfArrayExceptSelf;

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
//        start.longestMountain();
//        start.powerfulIntegers();
//        start.removeDuplicates2();
//        start.largestMultipleOfThree();
//        start.minimumDeletionCost();

//        start.countingBits();
//        start.bestBreak();
//        start.longestStringChain();
//        start.constructKPalindrome(); //unfinished
//        start.excelSheetColumnNumber();
//        start.largestNumber();
//        start.addToArrayForm();
        start.productOfArrayExceptSelf();

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
//        AddTwoNumbers atn = new AddTwoNumbers();
//        ListNode l11 = new ListNode(9);
//        ListNode l12 = new ListNode(9);
//        ListNode l13 = new ListNode(9);
//        ListNode l14 = new ListNode(9);
//        ListNode l15 = new ListNode(9);
//        ListNode l16 = new ListNode(9);
//        ListNode l17 = new ListNode(9);
//        ListNode l18 = new ListNode(9);
//        l11.next = l12;
//        l12.next = l13;
//        l13.next = l14;
//        l14.next = l15;
//        l15.next = l16;
//        l16.next = l17;
//        l17.next = l18;
//
//        ListNode l21 = new ListNode(9);
//        ListNode l22 = new ListNode(9);
//        ListNode l23 = new ListNode(9);
//        ListNode l24 = new ListNode(9);
//        l21.next = l22;
//        l22.next = l23;
//        l23.next = l24;
//        atn.addTwoNumbers(l11, l21);

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

    private void longestStringChain() {
        LongestStringChain lsc = new LongestStringChain();
        String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
        String[] words2 = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
        System.out.println("4 ==" + lsc.longestStrChain(words));
        System.out.println("5 ==" + lsc.longestStrChain(words2));

    }

    private void constructKPalindrome() {
        ConstructKPalindromeStrings ckps = new ConstructKPalindromeStrings();
        System.out.println("true ==" + ckps.canConstruct("annabelle", 2));
        System.out.println("false ==" + ckps.canConstruct("leetcode", 3));
        System.out.println("true ==" + ckps.canConstruct("true", 4));
        System.out.println("true ==" + ckps.canConstruct("yzyzyzyzyzyzyzy", 2));
        System.out.println("false ==" + ckps.canConstruct("cr", 7));
        //undone
    }

    private void excelSheetColumnNumber() {
        ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
        System.out.println("1 ==" + escn.titleToNumber("A"));
        System.out.println("28 ==" + escn.titleToNumber("AB"));
        System.out.println("701 ==" + escn.titleToNumber("ZY"));
    }

    private void largestNumber() {
        LargestNumber ln = new LargestNumber();
        int[] nums = { 10, 2 };
        int[] nums2 = { 3, 30, 34, 5, 9 };
        int[] nums3 = { 3, 30, 34, 5, 9,  9125, 90, 925};
        int[] nums4 = { 432, 43243};
        int[] nums5 = {8308,8308,830};
//        System.out.println("210 ==" + ln.largestNumber(nums));
//        System.out.println("9534330 ==" + ln.largestNumber(nums2));
//        System.out.println("9925912590 ==" + ln.largestNumber(nums3));
//        System.out.println("43243432 ==" + ln.largestNumber(nums4));
        System.out.println("83088308830 == " + ln.largestNumber(nums5));
    }

    private void addToArrayForm() {
        AddToArrayForm ataf = new AddToArrayForm();
        int[] digits1 = {1,2,0,0};
        int[] digits2 = {2,7,4};
        int[] digits3 = {9,9,9,9,9,9,9,9,9,9};
        System.out.println(ataf.addToArrayForm(digits1, 34));
        System.out.println(ataf.addToArrayForm(digits2, 181));
        System.out.println(ataf.addToArrayForm(digits3, 1));
    }

    private void productOfArrayExceptSelf() {
        ProductOfArrayExceptSelf poaes = new ProductOfArrayExceptSelf();
//        System.out.println(Arrays.toString(poaes.productExceptSelf(new int[]{1,0})));
        System.out.println(Arrays.toString(poaes.productExceptSelf(new int[]{1,2,3,4})));
    }

}

