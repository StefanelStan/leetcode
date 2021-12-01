package com.ss.leetcode.LC2021;

import com.ss.leetcode.LC2021.february.ApplyDiscountEveryNOrders;
import com.ss.leetcode.LC2021.february.ArithmeticSubarrays;
import com.ss.leetcode.LC2021.february.BinaryNumberWithAlternatingBits;
import com.ss.leetcode.LC2021.february.CheckIfItIsAStraightLine;
import com.ss.leetcode.LC2021.february.ConcatenationOfConsecutiveBinaryNumbers;
import com.ss.leetcode.LC2021.february.ContiguousArray;
import com.ss.leetcode.LC2021.february.CountUnhappyFriends;
import com.ss.leetcode.LC2021.february.Dota2Senate;
import com.ss.leetcode.LC2021.february.FindNumbersWithEvenNumberOfDigits;
import com.ss.leetcode.LC2021.february.FindRightInterval;
import com.ss.leetcode.LC2021.february.FourDivisors;
import com.ss.leetcode.LC2021.february.LargestMergeOfTwoStrings;
import com.ss.leetcode.LC2021.february.LargestRectangleInHistogram;
import com.ss.leetcode.LC2021.february.LongestSubarrayOf1AfterDeletingOneElement;
import com.ss.leetcode.LC2021.february.MaximumOfAbsoluteValueExpression;
import com.ss.leetcode.LC2021.february.MergeSortedArray;
import com.ss.leetcode.LC2021.february.MinimumChangesToMakeAlternatingBinaryString;
import com.ss.leetcode.LC2021.february.PairsOfSongsWithTotalDurations;
import com.ss.leetcode.LC2021.february.ProductOfTheLastKNumbers;
import com.ss.leetcode.LC2021.february.RemoveAllAdjacentDuplicatesInStringII;
import com.ss.leetcode.LC2021.february.ReplaceTheSubstringForBalancedString;
import com.ss.leetcode.LC2021.february.RestoreTheArrayFromAdjacentPairs;
import com.ss.leetcode.LC2021.february.ReverseInteger;
import com.ss.leetcode.LC2021.february.SelfDividingNumbers;
import com.ss.leetcode.LC2021.february.SequentialDigits;
import com.ss.leetcode.LC2021.february.Shift2DGrid;
import com.ss.leetcode.LC2021.february.ShiftingLetters;
import com.ss.leetcode.LC2021.february.StringToIntegerAtoi;

import java.util.Arrays;

public class StartFebruary {
    private static void main(String[] args) {
        StartFebruary start = new StartFebruary();

//        start.fourDivisors();
//        start.mergeSortedArray();
//        start.selfDividingNumbers();
//        start.restoreTheArrayFromAdjacentPairs();
//        start.applyDiscountEveryNOrders();
//        start.contiguousArray();
//        start.shiftingLetters();
//        start.countUnhappyFriends();
//        start.minimumChangesToMakeAlternatingBinaryString();
//        start.longestSubarrayOf1AfterDeletingOneElement();
//        start.shift2DGrid();
//        start.largestMergeOfTwoStrings();
//        start.pairsOfSongsWithTotalDurationsDivisibleBy60();
//        start.maximumOfAbsoluteValueExpression();
//        start.dota2Senate();
//        start.largestRectangleInHistogram();
//        start.replaceTheSubstringForBalancedString();
//        start.productOfTheLastKNumbers();
//        start.sequentialDigits();
//        start.concatenationOfConsecutiveBinaryNumbers();
//        start.binaryNumberWithAlternatingBits();
//        start.numberOf1Bits();
//        start.checkIfItIsAStraightLine();
//        start.findRightInterval();
//        start.removeAllAdjacentDuplicatesInStringII();
//        start.reverseInteger();
//        start.stringToIntegerAtoi();
//        start.findNumbersWithEvenNumberOfDigits();
//        start.arithmeticSubarrays();

    }

    private void fourDivisors() {
        int[] nums = { 21, 4, 7 };
        int[] nums2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        FourDivisors fd = new FourDivisors();
        System.out.println("32 == " + fd.sumFourDivisors(nums));
        System.out.println("45 == " + fd.sumFourDivisors(nums2));
    }

    private void mergeSortedArray() {
        MergeSortedArray msa = new MergeSortedArray();
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        int[] nums3 = { 1 };
        int[] nums4 = {};
        int[] nums5 = { 0 };
        int[] nums6 = { 1 };
        int[] nums7 = { 2, 0 };
        int[] nums8 = { 1 };

        msa.merge(nums1, 3, nums2, 3);
        msa.merge(nums3, 1, nums4, 0);
        msa.merge(nums5, 0, nums6, 1);
        msa.merge(nums7, 1, nums8, 1);
        System.out.println("{1,2,2,3,5,6} ==" + Arrays.toString(nums1));
        System.out.println("{1} ==" + Arrays.toString(nums3));
        System.out.println("{1} ==" + Arrays.toString(nums5));
        System.out.println("{1,2} ==" + Arrays.toString(nums7));

    }

    private void selfDividingNumbers() {
        SelfDividingNumbers sdn = new SelfDividingNumbers();
        System.out.println(sdn.selfDividingNumbers(1, 22));
    }

    private void restoreTheArrayFromAdjacentPairs() {
        RestoreTheArrayFromAdjacentPairs rtafap = new RestoreTheArrayFromAdjacentPairs();
        int[][] pairs1 = { { 2, 1 }, { 3, 4 }, { 3, 2 } };
        int[][] pairs2 = { { 4, -2 }, { 1, 4 }, { -3, 1 } };
        int[][] pairs3 = { { 100000, -100000 } };
        int[][] pairs4 = { { -3, -9 }, { -5, 3 }, { 2, -9 }, { 6, -3 }, { 6, 1 }, { 5, 3 }, { 8, 5 }, { -5, 1 }, { 7, 2 } };

        System.out.println(Arrays.toString(rtafap.restoreArray(pairs1)));
        System.out.println(Arrays.toString(rtafap.restoreArray(pairs2)));
        System.out.println(Arrays.toString(rtafap.restoreArray(pairs3)));
        System.out.println(Arrays.toString(rtafap.restoreArray(pairs4)));
    }

    private void applyDiscountEveryNOrders() {
        int[] products = { 1, 2, 3, 4, 5, 6, 7 };
        int[] prices = { 100, 200, 300, 400, 300, 200, 100 };

        ApplyDiscountEveryNOrders adeno = new ApplyDiscountEveryNOrders(3, 50, products, prices);
        System.out.println("500.0 == " + adeno.getBill(new int[] { 1, 2 }, new int[] { 1, 2 }));
        System.out.println("4000.0 == " + adeno.getBill(new int[] { 3, 7 }, new int[] { 10, 10 }));
        System.out.println("800.0 == " + adeno.getBill(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 1, 1, 1, 1, 1, 1 }));
        System.out.println("4000.0 == " + adeno.getBill(new int[] { 4 }, new int[] { 10 }));
        System.out.println("4000.0 == " + adeno.getBill(new int[] { 7, 3 }, new int[] { 10, 10 }));
        System.out.println("7350.0 == " + adeno.getBill(new int[] { 7, 5, 3, 1, 6, 4, 2 }, new int[] { 10, 10, 10, 9, 9, 9, 7 }));
        System.out.println("2500.0 == " + adeno.getBill(new int[] { 2, 3, 5 }, new int[] { 5, 3, 2 }));
    }

    private void contiguousArray() {
        final ContiguousArray ca = new ContiguousArray();
        System.out.println("2 == " + ca.findMaxLength(new int[] { 0, 1 }));
        System.out.println("2 == " + ca.findMaxLength(new int[] { 0, 1, 0 }));
        System.out.println("6 == " + ca.findMaxLength(new int[] { 0, 0, 1, 0, 0, 0, 1, 1 }));
    }

    private void shiftingLetters() {
        ShiftingLetters sl = new ShiftingLetters();
        System.out.println("rpl ==" + sl.shiftingLetters("abc", new int[] { 3, 5, 9 }));
        System.out.println("wqqwlcjnkphhsyvrkdod ==" + sl.shiftingLetters("mkgfzkkuxownxvfvxasy", new int[] { 505870226, 437526072, 266740649,
                224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962,
                148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513 }));
    }

    private void countUnhappyFriends() {
        CountUnhappyFriends cuf = new CountUnhappyFriends();
        int[][] pref1 = { { 1, 2, 3 }, { 3, 2, 0 }, { 3, 1, 0 }, { 1, 2, 0 } };
        int[][] pairs1 = { { 0, 1 }, { 2, 3 } };

        int[][] pref2 = { { 1 }, { 0 } };
        int[][] pairs2 = { { 1, 0 } };

        int[][] pref3 = { { 1, 3, 2 }, { 2, 3, 0 }, { 1, 3, 0 }, { 0, 2, 1 } };
        int[][] pairs3 = { { 1, 3 }, { 0, 2 } };

        System.out.println("2 == " + cuf.unhappyFriends(4, pref1, pairs1));
        System.out.println("0 == " + cuf.unhappyFriends(2, pref2, pairs2));
        System.out.println("4 == " + cuf.unhappyFriends(4, pref3, pairs3));
    }

    private void minimumChangesToMakeAlternatingBinaryString() {
        MinimumChangesToMakeAlternatingBinaryString mctmabs = new MinimumChangesToMakeAlternatingBinaryString();
        System.out.println("1 == " + mctmabs.minOperations("0100"));
        System.out.println("0 == " + mctmabs.minOperations("01"));
        System.out.println("2 == " + mctmabs.minOperations("1111"));
    }

    private void longestSubarrayOf1AfterDeletingOneElement() {
        LongestSubarrayOf1AfterDeletingOneElement lsooadoe = new LongestSubarrayOf1AfterDeletingOneElement();
        System.out.println("3 == " + lsooadoe.longestSubarray(new int[] { 1, 1, 0, 1 }));
        System.out.println("5 == " + lsooadoe.longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }));
        System.out.println("2 == " + lsooadoe.longestSubarray(new int[] { 1, 1, 1 }));
        System.out.println("4 == " + lsooadoe.longestSubarray(new int[] { 1, 1, 0, 0, 1, 1, 1, 0, 1 }));
        System.out.println("0 == " + lsooadoe.longestSubarray(new int[] { 0, 0, 0 }));
        System.out.println("1 == " + lsooadoe.longestSubarray(new int[] { 1, 0, 0, 0, 0 }));

    }

    private void shift2DGrid() {
        Shift2DGrid s2dDRid = new Shift2DGrid();
        int[][] grid1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] grid2 = { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } };
        int[][] grid3 = { { 1 }, { 2 }, { 3 }, { 4 }, { 7 }, { 6 }, { 5 } };
//        System.out.println("[[9,1,2],[3,4,5],[6,7,8]] == " + s2dDRid.printShiftedGrid(grid1, 1));
//        System.out.println("[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]] == " + s2dDRid.printShiftedGrid(grid2, 4));
//        System.out.println("[[1,2,3],[4,5,6],[7,8,9]] == " + s2dDRid.printShiftedGrid(grid1, 9));
        System.out.println("[[6],[5],[1],[2],[3],[4],[7]] == " + s2dDRid.printShiftedGrid(grid3, 23));

    }

    private void largestMergeOfTwoStrings() {
        LargestMergeOfTwoStrings lmots = new LargestMergeOfTwoStrings();
//        System.out.println("cbcabaaaaa == " + lmots.largestMerge("cabaa", "bcaaa"));
//        System.out.println("abdcabcabcaba == " + lmots.largestMerge("abcabc", "abdcaba"));
//        System.out.println("uuuurruuuruuuuuuuuruuuuurrrurrrrrrrruurrrurrrurrrrruu == "
//                            + lmots.largestMerge("uuurruuuruuuuuuuuruuuuu", "urrrurrrrrrrruurrrurrrurrrrruu"));
        System.out.println("nnnnnnnnnnnnnntnnngnnnbnttnngsnnntnbgnnnn == " + lmots.largestMerge("nngnnnbnttnngsnnntnbgnnnn", "nnnnnnnnnnnnnntn"));
    }

    private void pairsOfSongsWithTotalDurationsDivisibleBy60() {
        PairsOfSongsWithTotalDurations poswtd = new PairsOfSongsWithTotalDurations();
        int[] time1 = { 30, 20, 150, 100, 40 };
        int[] time2 = { 60, 60, 60 };
        int[] time3 = { 15, 63, 451, 213, 37, 209, 343, 319 };
        int[] time4 = { 95, 51, 462, 476, 245, 271, 481, 257, 130, 314, 244, 215, 397, 60, 21, 60, 168, 213, 107, 394,
                209, 223, 410, 220, 444, 337, 264, 417, 356, 409, 467, 23, 273, 236, 281, 478, 227, 69, 207, 255, 18, 133,
                362, 161, 329, 66, 233, 487, 23, 315, 296, 60, 424, 370, 331, 305, 333, 218, 145, 379, 212, 413, 486, 111,
                45, 239, 57, 395, 140, 405, 266, 212, 356, 28, 346, 358, 309, 263, 101, 46, 167, 352, 359, 381, 205, 308,
                213, 390, 211, 142, 287, 476, 189, 164, 9, 5, 58, 206, 39, 248, 409, 189, 139, 128, 107, 342, 466, 143,
                267, 372, 119, 172, 416, 5, 31, 77, 167, 133, 192, 182, 323, 238, 219, 140, 327, 275, 361, 435, 452, 489,
                185, 468, 252, 144, 233, 7, 243, 83, 72, 35, 446, 188, 259, 185, 499, 141, 457, 33, 267, 238, 224, 121,
                164, 436, 375, 259, 247, 136, 207, 391, 255, 182, 237, 451, 184, 407, 156, 386, 249, 351, 336, 110, 262,
                119, 375, 302, 95, 236, 279, 172, 199, 346, 14, 291, 338, 102, 101, 182, 28, 321, 446, 384, 191, 71, 259,
                410, 113, 160, 372, 260, 452, 246, 132, 416, 20, 113, 257, 113, 300, 222, 295, 10, 461, 449, 233, 73, 273,
                91, 464, 452, 362, 477, 2, 435, 373, 139, 165, 20, 455, 361, 62, 253, 412, 281, 362, 94, 246, 475, 224, 176,
                22, 388, 100, 255, 180, 340, 93, 245, 442, 420, 353, 25, 329, 232, 216, 2, 120, 450, 57, 133, 47, 309, 460,
                354, 93, 259, 485, 339, 490, 56, 488, 311, 250, 217, 247, 420, 376, 329, 491, 165, 488, 251, 430, 470, 122,
                111, 359, 343, 200, 480, 162, 353, 344, 349, 301, 145, 388, 456, 17, 455, 487, 324, 493, 248, 151, 53, 414,
                396, 194, 170, 290, 349, 287, 242, 53, 77, 219, 280, 267, 384, 118, 314, 12, 189, 118, 379, 254, 160, 179,
                29, 87, 274, 346, 228, 488, 481, 481, 56, 67, 3, 256, 463, 150, 399, 340, 464, 9, 28, 479, 250, 256, 21,
                209, 87, 59, 7, 433, 189, 433, 22, 76, 45, 217, 301, 34, 98, 248, 265, 496, 319, 157, 69, 216, 46, 299,
                233, 153, 310, 151, 299, 283, 206, 335, 220, 65, 195, 76, 213, 10, 150, 104, 488, 139, 360, 426, 14, 115,
                136, 409, 36, 165, 488, 440, 111, 462, 369, 341, 234, 372, 226, 369, 136, 424, 125, 418, 215, 178, 291,
                54, 183, 140, 82, 326, 92, 50, 82, 311, 12, 1, 9, 99, 106, 195, 153, 77, 108, 60, 211, 69, 194, 253, 246,
                353, 273, 483, 452, 488, 229, 412, 333, 441, 39, 255, 190, 480, 280, 419, 19, 337, 252, 312, 154, 247, 380,
                94, 70, 55, 320, 448, 328, 230, 18, 322, 309, 79, 477, 239, 314, 426, 19, 408, 151, 62, 495, 183, 401, 431,
                396, 93, 336, 205, 423, 113, 369, 376, 217, 158, 389, 250, 271, 465, 5, 108, 221, 309, 148, 57, 500, 209,
                259, 149, 479, 321, 368, 347, 358, 109, 23, 152, 114, 476, 428, 314, 78, 95, 16, 58, 317, 84, 108, 338,
                386, 495, 128, 172, 459, 29, 385, 181, 102, 3, 8, 198, 359, 115, 149, 82, 88, 340, 416, 450, 472, 353,
                495, 432, 404, 370, 74, 426, 121, 423, 406, 260, 84, 23, 459, 384, 156, 310, 66, 493, 108, 43, 248, 408,
                134, 323, 416, 202, 110, 20, 425, 38, 257, 19, 334, 300, 362, 319, 12, 82, 200, 95, 316, 447, 221, 372,
                285, 490, 245, 84, 386, 188, 109, 244, 411, 232, 473, 56, 351, 44, 278, 294, 145, 198, 65, 242, 340, 237,
                242, 308, 385, 204, 2, 344, 220, 63, 250, 174, 79, 186, 289, 288, 82, 159, 285, 495, 129, 8, 478, 202, 74,
                263, 474, 184, 212, 160, 476, 374, 345, 103, 106, 307, 436, 291, 435, 363, 332, 292, 425, 429, 184, 290,
                332, 189, 20, 316, 317, 458, 287, 202, 79, 301, 431, 387, 178, 88, 94, 335, 295, 52, 53, 170, 305, 155,
                268, 380, 395, 211, 379, 347, 284, 417, 32, 264, 318, 47, 318, 265, 191, 131, 331, 301, 399, 309, 476,
                484, 348, 277, 136, 204, 1, 447, 124, 226, 100, 109, 106, 177, 43, 328, 33, 418, 410, 127, 3, 171, 75,
                198, 307, 289, 73, 89, 95, 353, 483, 7, 412, 90, 254, 24, 253, 265, 162, 439, 283, 352, 169, 184, 272,
                200, 234, 38, 495, 83, 212, 314, 341, 175, 368, 143, 380, 329, 391, 4, 255, 399, 13, 182, 3, 198, 251,
                159, 417, 4, 410, 492, 149, 243, 22, 148, 229, 300, 112, 458, 228, 350, 36, 479, 83, 361, 276, 9, 11, 51,
                111, 45, 345, 342, 47, 50, 465, 467, 219, 368, 92, 268, 390, 487, 450, 107, 282, 189, 409, 310, 70, 227,
                212, 449, 380, 48, 148, 275, 452, 48, 274, 102, 415, 191, 391, 38, 324, 460, 31, 429, 171, 202, 383, 162,
                245, 42, 179, 341, 281, 283, 4, 225, 259, 461, 307, 294, 167, 67, 408, 271, 154, 393, 396, 366, 354, 230,
                60, 323, 9, 122, 28, 389, 26, 266, 417, 352, 459, 423, 495, 148, 28, 223, 231, 144, 179, 380, 2, 480, 26,
                151, 304, 469, 88, 94, 382, 131, 284, 458, 452, 241, 72, 438, 296, 225, 172, 150, 130, 40, 273, 402, 122,
                96, 374, 492, 377, 238, 262, 261, 179, 24, 251, 252, 190, 63, 169, 481, 114, 226, 93, 440, 320, 49, 7, 248,
                124, 283, 425, 448, 206, 133, 257, 257, 204, 209, 235, 474, 426, 284, 272, 123, 133, 140, 100, 263, 484,
                59, 397, 25, 362, 334, 86, 195, 43, 266, 117, 174, 62, 430, 281, 307, 122, 184, 133, 170, 121, 419, 103,
                490, 458, 48, 314, 46, 201, 2, 128, 254, 166, 416, 181, 399, 201, 191, 262, 251, 81, 225, 311, 174, 216,
                155, 285, 324, 325, 111, 272, 152, 246, 35, 167, 422, 398, 401, 55, 314, 84, 337, 300, 440, 494, 18, 124,
                86, 472, 57, 433, 128, 246, 392, 227, 499, 409, 421, 180, 362, 147, 152, 415, 39, 170, 136, 2, 132, 477,
                463, 195, 56, 491, 217, 398, 302, 54, 365, 254, 338, 465, 141, 252, 359, 319, 53, 187, 17, 426, 183, 50,
                240, 196, 70, 488, 240, 121, 223, 484, 204, 151, 134, 367, 131, 281, 243, 96, 357, 77, 322, 79, 67, 250,
                142, 405, 215, 82, 23, 58, 297, 346, 400, 352, 453, 133, 173, 145, 234, 152, 318, 469, 36, 292, 471, 314,
                91, 7, 446, 1, 298, 287, 76, 196, 109, 434, 136, 262, 288, 461, 114, 385, 317, 284, 333, 441, 406, 464,
                14, 442, 481, 78, 467, 138, 446, 265, 441, 175, 232, 419, 478, 78, 216, 61, 455, 243, 345, 106, 427, 435,
                274, 136, 431, 66, 71, 135, 436, 209, 457, 7, 392, 437, 65, 59, 157, 141, 269, 257, 384, 197, 235, 63, 203,
                426, 71, 29, 304, 402, 318, 384, 312, 490, 78, 121, 305, 139, 19, 340, 368, 24, 409, 218, 31, 356, 475, 59,
                476, 465, 245, 316, 340, 69, 195, 34, 346, 292, 464, 261, 38, 373, 484, 82, 2, 413, 159, 106, 320, 39, 387,
                281, 421, 251, 114, 99, 495, 330, 202, 362, 233, 71, 370, 319, 74, 289, 68, 420, 10, 467, 370, 328, 53, 110,
                299, 203, 273, 223, 205, 214, 300, 419, 213, 41, 59, 200, 20, 172, 381, 263, 98, 309, 154, 368, 333, 484,
                313, 240, 78, 106, 355, 244, 265, 475, 473, 411, 244, 268, 185, 468, 308, 9, 365, 129, 240, 464, 323, 249,
                212, 496, 364, 119, 119, 195, 153, 17, 377, 181, 81, 326, 334, 395, 145, 13, 461, 57, 26, 163, 314, 71,
                27, 248, 289, 148, 336, 339, 188, 202, 96, 310, 297, 200, 312, 235, 181, 61, 410, 169, 326, 445, 111, 464, 415, 199, 177 };
//        System.out.println("3 == " + poswtd.numPairsDivisibleBy60(time1));
//        System.out.println("3 == " + poswtd.numPairsDivisibleBy60(time2));
//        System.out.println("X == " + poswtd.numPairsDivisibleBy60(time3));
        System.out.println("14804 == " + poswtd.numPairsDivisibleBy60(time4));

    }

    private void maximumOfAbsoluteValueExpression() {
        MaximumOfAbsoluteValueExpression moave = new MaximumOfAbsoluteValueExpression();
        System.out.println("13 == " + moave.maxAbsValExpr(new int[]{1,2,3,4}, new int[]{-1,4,5,6}));
        System.out.println("20 == " + moave.maxAbsValExpr(new int[]{1,-2,-5,0,10}, new int[]{0,-2,-1,-7,-4}));
        // not working Time Limit Exceeded
    }

    private void dota2Senate() {
        Dota2Senate d2s = new Dota2Senate();
        System.out.println("Radiant == " + d2s.predictPartyVictory("RD"));
        System.out.println("Dire == " + d2s.predictPartyVictory("RDD"));
        System.out.println("Dire == " + d2s.predictPartyVictory("DDRRR"));
        System.out.println("Radiant == " + d2s.predictPartyVictory("RRDDD"));
        System.out.println("Radiant == " + d2s.predictPartyVictory("DRRDRDRDRDDRDRDR"));
        System.out.println("Dire == " + d2s.predictPartyVictory("DRRDDR"));
    }

    private void largestRectangleInHistogram() {
        // excededed time
        LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();
        System.out.println("10 == " + lrih.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println("4 == " + lrih.largestRectangleArea(new int[]{2,4}));
    }

    private void replaceTheSubstringForBalancedString() {
        // not done
        ReplaceTheSubstringForBalancedString rtsfbs = new ReplaceTheSubstringForBalancedString();
        System.out.println("0 == " + rtsfbs.balancedString("QWER"));
        System.out.println("1 == " + rtsfbs.balancedString("QQER"));
        System.out.println("2 == " + rtsfbs.balancedString("QQQR"));
        System.out.println("3 == " + rtsfbs.balancedString("QQQQ"));
    }

    private void productOfTheLastKNumbers() {
        ProductOfTheLastKNumbers potlkn = new ProductOfTheLastKNumbers();
        potlkn.add(3);
        potlkn.add(0);
        potlkn.add(2);
        potlkn.add(5);
        potlkn.add(4);
        System.out.println("20 == " + potlkn.getProduct(2));
        System.out.println("40 == " + potlkn.getProduct(3));
        System.out.println("0 == " + potlkn.getProduct(4));
        potlkn.add(8);
        System.out.println("32 == " + potlkn.getProduct(2));
        System.out.println("-----------------");

        ProductOfTheLastKNumbers potlkn2 = new ProductOfTheLastKNumbers();
        potlkn2.add(1);
        System.out.println("1 == " + potlkn2.getProduct(1));
        System.out.println("1 == " + potlkn2.getProduct(1));
        System.out.println("1 == " + potlkn2.getProduct(1));
        potlkn2.add(7);
        potlkn2.add(6);
        potlkn2.add(7);
        System.out.println("-----------------");

        ProductOfTheLastKNumbers potlkn3 = new ProductOfTheLastKNumbers();
        potlkn3.add(3);
        potlkn3.add(0);
        potlkn3.add(2);
        potlkn3.add(5);
        potlkn3.add(4);
        System.out.println("20 == " + potlkn3.getProduct(2));
        System.out.println("40 == " + potlkn3.getProduct(3));
        System.out.println("0 == " + potlkn3.getProduct(4));
        potlkn3.add(8);
        System.out.println("32 == " + potlkn3.getProduct(2));

    }

    private void sequentialDigits() {
        SequentialDigits sd = new SequentialDigits();

        System.out.println("[67,78,89,123] == " + sd.sequentialDigits(58, 166));
        System.out.println("[123,234] == " + sd.sequentialDigits(100, 300));
        System.out.println("[1234,2345,3456,4567,5678,6789,12345] == " + sd.sequentialDigits(1000, 13000));
        System.out.println("[] == " + sd.sequentialDigits(10, 1000000000));
    }

    private void concatenationOfConsecutiveBinaryNumbers() {
        ConcatenationOfConsecutiveBinaryNumbers cocbn = new ConcatenationOfConsecutiveBinaryNumbers();
//        System.out.println("1 == " + cocbn.concatenatedBinary(1));
//        System.out.println("27 == " + cocbn.concatenatedBinary(3));
//        System.out.println("505379714 == " + cocbn.concatenatedBinary(12));
//        System.out.println("35297621 == " + cocbn.concatenatedBinary(15));
//        System.out.println("385951001 == " + cocbn.concatenatedBinary(24));
        System.out.println("727837408 == " + cocbn.concatenatedBinary(42));
        System.out.println("727837408 == " + cocbn.concatenatedBinary(7167));
    }

    private void binaryNumberWithAlternatingBits() {
        BinaryNumberWithAlternatingBits bnwab = new BinaryNumberWithAlternatingBits();
        System.out.println("true == " + bnwab.hasAlternatingBits(5));
        System.out.println("false == " + bnwab.hasAlternatingBits(7));
        System.out.println("false == " + bnwab.hasAlternatingBits(11));
        System.out.println("true == " + bnwab.hasAlternatingBits(10));
        System.out.println("false == " + bnwab.hasAlternatingBits(3));
    }

    private void numberOf1Bits() {
        // workds OK
    }

    private void checkIfItIsAStraightLine() {
        CheckIfItIsAStraightLine ciiiasl = new CheckIfItIsAStraightLine();
        int[][] coords1 = {{1,2}, {2,3}, {3,4}, {4,5}, {5,6}, {6,7}};
        int[][] coords2 = {{1,1}, {2,2}, {3,4}, {4,5}, {5,6}, {7,7}};
        System.out.println("true == " + ciiiasl.checkStraightLine(coords1));
        System.out.println("false == " + ciiiasl.checkStraightLine(coords2));
    }

    private void findRightInterval() {
        FindRightInterval fri =  new FindRightInterval();
        int[][] int1 = {{1,2}};
        int[][] int2 = {{3,4}, {2,3}, {1,2}};
        int[][] int3 = {{1,4}, {2,3}, {3,4}};
        System.out.println("[-1] == " + Arrays.toString(fri.findRightInterval(int1)));
        System.out.println("[-1,0,1] == " + Arrays.toString(fri.findRightInterval(int2)));
        System.out.println("[-1,2,-1] == " + Arrays.toString(fri.findRightInterval(int3)));
    }

    private void removeAllAdjacentDuplicatesInStringII() {
        RemoveAllAdjacentDuplicatesInStringII rmadis2 = new RemoveAllAdjacentDuplicatesInStringII();
        System.out.println("abcd == " + rmadis2.removeDuplicates("abcd", 2));
        System.out.println("aa == " + rmadis2.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println("ps == " + rmadis2.removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println("ybth == " + rmadis2.removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
    }

    private void reverseInteger() {
        ReverseInteger ri =  new ReverseInteger();
        // put it into a Long and reverse it :D
        System.out.println("321 == " + ri.reverse(123));
        System.out.println("-321 == " + ri.reverse(-123));
        System.out.println("21 == " + ri.reverse(120));
        System.out.println("0 == " + ri.reverse(0));
    }

    private void stringToIntegerAtoi() {
        // not solved yet. Cat and mouse game
        StringToIntegerAtoi stia = new StringToIntegerAtoi();
        System.out.println("42 == " + stia.myAtoi("42"));
        System.out.println("-42 == " + stia.myAtoi("   -42"));
        System.out.println("4193 == " + stia.myAtoi("4193 with words"));
        System.out.println("0 == " + stia.myAtoi("words and 987"));
        System.out.println("-2147483648 == " + stia.myAtoi("-91283472332"));
        System.out.println("2147483648 == " + stia.myAtoi("20000000000000000000"));
    }

    private void findNumbersWithEvenNumberOfDigits() {
        FindNumbersWithEvenNumberOfDigits fnwenod = new FindNumbersWithEvenNumberOfDigits();
        int[] nums1 = {12,345,2,6,7896};
        int[] nums2 = {555,901,482,1771};
        System.out.println("2 == " + fnwenod.findNumbers(nums1));
        System.out.println("1 == " + fnwenod.findNumbers(nums2));
    }

    private void arithmeticSubarrays() {
        ArithmeticSubarrays as = new ArithmeticSubarrays();

        int[] nums1 = {4,6,5,9,3,7};
        int[] l1 = {0,0,2};
        int[] r1 = {2,3,5};

        int[] nums2 = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l2 = {0,1,6,4,8,7};
        int[] r2 = {4,4,9,7,9,10};

        System.out.println("[true,false,true] == " + as.checkArithmeticSubarrays(nums1, l1, r1));
        System.out.println("[false,true,false,false,true,true] == " + as.checkArithmeticSubarrays(nums2, l2, r2));

    }

}
