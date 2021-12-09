package com.ss.leetcode.LC2021;

import com.ss.leetcode.LC2021.december.CheckIfAStringCanBreakAnotherString;
import com.ss.leetcode.LC2021.december.ConstructTheRectangle;
import com.ss.leetcode.LC2021.december.ContinuousSubarraySum;
import com.ss.leetcode.LC2021.december.DuplicateZeros;
import com.ss.leetcode.LC2021.december.Finding3DigitEvenNumbers;
import com.ss.leetcode.LC2021.december.FlattenBinaryTreeToLinkedList;
import com.ss.leetcode.LC2021.december.IntegerToRoman;
import com.ss.leetcode.LC2021.december.JumpGameIII;
import com.ss.leetcode.LC2021.december.MaximumAverageSubarrayI;
import com.ss.leetcode.LC2021.december.MaximumProductSubarray;
import com.ss.leetcode.LC2021.december.OddEvenLinkedList;
import com.ss.leetcode.LC2021.december.PerfectNumber;
import com.ss.leetcode.LC2021.december.RomanToInteger;
import com.ss.leetcode.LC2021.december.SetMismatch;
import com.ss.leetcode.LC2021.december.TeemoAttacking;
import com.ss.leetcode.LC2021.december.TwoFurthestHousesWithDifferentColors;
import com.ss.leetcode.LC2021.december.WateringPlants;
import com.ss.leetcode.LC2021.september.Permutations;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.wateringPlants();
//        start.oddEvenLinkedList();
//        start.constructTheRectangle();
//        start.teemoAttacking();
//        start.maximumProductSubarray();
//        start.twoFurthestHousesWithDifferentColors();
//        start.perfectNumber();
//        start.continuousSubarraySum();
//        start.setMismatch();
//        start.romanToInteger();
//        start.integerToRoman();
//        start.flattenBinaryTreeToLinkedList();
//        start.maximumAverageSubarrayI();
//        start.checkIfAStringCanBreakAnotherString();
//        start.jumpGameIII();
//        start.finding3DigitEvenNumbers();
        start.duplicateZeros();
    }

    public void wateringPlants() {
        WateringPlants wp = new WateringPlants();

        System.out.println("14 == " + wp.wateringPlants(new int[]{2,2,3,3}, 5));
        System.out.println("30 == " + wp.wateringPlants(new int[]{1,1,1,4,2,3}, 4));
        System.out.println("49 == " + wp.wateringPlants(new int[]{7,7,7,7,7,7,7}, 8));
    }

    public void oddEvenLinkedList() {
        OddEvenLinkedList oell = new OddEvenLinkedList();

        System.out.println("[1,3,5,2,4] == " + oell.oddEvenList(ListNode.makeChain(new int[]{1,2,3,4,5})).getAsList());
        System.out.println("[2,3,6,7,1,5,4] == " + oell.oddEvenList(ListNode.makeChain(new int[]{2,1,3,5,6,4,7})).getAsList());
    }

    public void constructTheRectangle() {
        ConstructTheRectangle ctr = new ConstructTheRectangle();

        System.out.println("[2,2] == " + Arrays.toString(ctr.constructRectangle(4)));
        System.out.println("[37,1] == " + Arrays.toString(ctr.constructRectangle(37)));
        System.out.println("[427,286] == " + Arrays.toString(ctr.constructRectangle(122122)));
    }

    public void teemoAttacking() {
        TeemoAttacking ta = new TeemoAttacking();

        System.out.println("4 == " + ta.findPoisonedDuration(new int[]{1,4}, 2));
        System.out.println("3 == " + ta.findPoisonedDuration(new int[]{1,2}, 2));
    }

    public void maximumProductSubarray() {
        MaximumProductSubarray mps = new MaximumProductSubarray();

//        System.out.println("6 == " + mps.maxProduct(new int[]{2,3,-2,4}));
//        System.out.println("0 == " + mps.maxProduct(new int[]{-2,0,-1}));
        System.out.println("0 == " + mps.maxProduct(new int[]{-2,0}));
    }

    public void twoFurthestHousesWithDifferentColors() {
        TwoFurthestHousesWithDifferentColors tfhwdc = new TwoFurthestHousesWithDifferentColors();

        System.out.println("3 == " + tfhwdc.maxDistance(new int[]{1,1,1,6,1,1,1}));
        System.out.println("4 == " + tfhwdc.maxDistance(new int[]{1,8,3,8,3}));
        System.out.println("1 == " + tfhwdc.maxDistance(new int[]{0,1}));
    }

    public void perfectNumber() {
        PerfectNumber pn = new PerfectNumber();

        System.out.println("true == " + pn.checkPerfectNumber(28));
        System.out.println("true == " + pn.checkPerfectNumber(6));
        System.out.println("true == " + pn.checkPerfectNumber(496));
        System.out.println("true == " + pn.checkPerfectNumber(8128));
        System.out.println("false == " + pn.checkPerfectNumber(2));
    }

    public void continuousSubarraySum() {
        ContinuousSubarraySum css = new ContinuousSubarraySum();

        System.out.println("false == " + css.checkSubarraySum(new int[]{0}, 1));
        System.out.println("true == " + css.checkSubarraySum(new int[]{4,5}, 3));
        System.out.println("true == " + css.checkSubarraySum(new int[]{23,2,4,6,7}, 6));
        System.out.println("true == " + css.checkSubarraySum(new int[]{23,2,6,4,7}, 6));
        System.out.println("false == " + css.checkSubarraySum(new int[]{23,2,6,4,7}, 13));
        System.out.println("true == " + css.checkSubarraySum(new int[]{0,1,2,3,4,5,6,7,8,9,10}, 19));
    }

    public void setMismatch() {
        SetMismatch sm = new SetMismatch();

        System.out.println("[2,3] == " + Arrays.toString(sm.findErrorNums(new int[]{4,1,2,2})));
        System.out.println("[1,2] == " + Arrays.toString(sm.findErrorNums(new int[]{1,1})));
    }

    public void romanToInteger() {
        RomanToInteger rti = new RomanToInteger();

//        System.out.println("3 == " + rti.romanToInt("III"));
//        System.out.println("4 == " + rti.romanToInt("IV"));
//        System.out.println("9 == " + rti.romanToInt("IX"));
//        System.out.println("58 == " + rti.romanToInt("LVIII"));
//        System.out.println("1994 == " + rti.romanToInt("MCMXCIV"));
        System.out.println("3899 == " + rti.romanToInt("MMMDCCCXCIX"));
    }

    public void integerToRoman() {
        IntegerToRoman itr = new IntegerToRoman();

        System.out.println("III == " + itr.intToRoman(3));
        System.out.println("IV == " + itr.intToRoman(4));
        System.out.println("IX == " + itr.intToRoman(9));
        System.out.println("MMMDCCCXCIX == " + itr.intToRoman(3899));
        System.out.println("IX == " + itr.intToRoman(9));
        System.out.println("LVIII == " + itr.intToRoman(58));
        System.out.println("LXXVII == " + itr.intToRoman(77));
        System.out.println("XCIX == " + itr.intToRoman(99));
        System.out.println("CXXI == " + itr.intToRoman(121));
        System.out.println("MI == " + itr.intToRoman(1001));
        System.out.println("MCMXCIV == " + itr.intToRoman(1994));
        System.out.println("CMXCIX == " + itr.intToRoman(999));
        System.out.println("MMMCMXCVII == " + itr.intToRoman(3997));
    }

    public void flattenBinaryTreeToLinkedList() {
        FlattenBinaryTreeToLinkedList fbttll = new FlattenBinaryTreeToLinkedList();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        TreeNode root2 = null;
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
            new TreeNode(6, null, new TreeNode(8, new TreeNode(7), new TreeNode(9))));
        TreeNode root5 = new TreeNode(5, new TreeNode(1), new TreeNode(7));
        TreeNode root6 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
            new TreeNode(6, null, new TreeNode(8, new TreeNode(7), null)));
        TreeNode root7 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        TreeNode root8 =  new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));

//        fbttll.flatten(root1);
//        fbttll.flatten(root2);
//        fbttll.flatten(root3);
//        fbttll.flatten(root4);
//        fbttll.flatten(root5);
//        fbttll.flatten(root6);
//        fbttll.flatten(root7);
        fbttll.flatten(root8);

//        System.out.println("[1,2,3,4,5,6] == " + TreeNode.preOrder(root1));
//        System.out.println("[] == " + TreeNode.preOrder(root2));
//        System.out.println("[0] == " + TreeNode.preOrder(root3));
//        System.out.println("[5,3,2,1,4,6,8,7,9] == " + TreeNode.preOrder(root4));
//        System.out.println("[5,1,7] == " + TreeNode.preOrder(root5));
//        System.out.println("[1,2,3] == " + TreeNode.preOrder(root7));
        System.out.println("[2,1,4,3] == " + TreeNode.preOrder(root8));
    }

    public void maximumAverageSubarrayI() {
        MaximumAverageSubarrayI masi = new MaximumAverageSubarrayI();

        System.out.println("12.75 ==" + masi.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println("5.0 ==" + masi.findMaxAverage(new int[]{5}, 1));
        System.out.println("955.0 ==" + masi.findMaxAverage(new int[]{3,34,34,43,54,34,666,3000,49,67,76,75,43,342,123,213,3142}, 4));
    }

    public void checkIfAStringCanBreakAnotherString() {
        CheckIfAStringCanBreakAnotherString ciascbas = new CheckIfAStringCanBreakAnotherString();

        System.out.println("true == " + ciascbas.checkIfCanBreak("abc", "xya"));
        System.out.println("false == " + ciascbas.checkIfCanBreak("abe", "acd"));
        System.out.println("true == " + ciascbas.checkIfCanBreak("leetcode", "interview"));
    }

    public void jumpGameIII() {
        JumpGameIII jgiii = new JumpGameIII();

        System.out.println("true == " + jgiii.canReach(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println("true == " + jgiii.canReach(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println("false == " + jgiii.canReach(new int[]{3,0,2,1,2}, 2));
    }

    public void finding3DigitEvenNumbers() {
        Finding3DigitEvenNumbers f3dev = new Finding3DigitEvenNumbers();

        System.out.println("[102,120,130,132,210,230,302,310,312,320] == " + Arrays.toString(f3dev.findEvenNumbers(new int[]{2,1,3,0})));
        System.out.println("[222,228,282,288,822,828,882] == " + Arrays.toString(f3dev.findEvenNumbers(new int[]{2,2,8,8,2})));
        System.out.println("[] == " + Arrays.toString(f3dev.findEvenNumbers(new int[]{3,7,5})));
    }

    public void duplicateZeros() {
        DuplicateZeros dz = new DuplicateZeros();

        int[] array1 = {1,0,2,3,0,4,5,0};
        int[] array2 = {1,0,2,3,0,4,5,0};
        int[] array3 = {1,0,2,3,0,4,5,0};
        int[] array4 = {1,0,2,3,0,4,5,0};
        dz.duplicateZeros(array1);
        dz.duplicateZeros(array2);
        dz.duplicateZeros(array3);
        dz.duplicateZeros(array4);

        System.out.println("[1,0,0,2,3,0,0,4] == " + Arrays.toString(array1));
        System.out.println("[1,2,3] == " + Arrays.toString(array2));
        System.out.println("[1,0,0,2,3,0,0,4] == " + Arrays.toString(array3));
        System.out.println("[1,0,0,2,3,0,0] == " + Arrays.toString(array4));
    }
}
