package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.september.DeleteNodesFromLinkedListPresentInArray;
import com.ss.leetcode.LC2024.september.FindTheStudentThatWillReplaceTheChalk;
import com.ss.leetcode.LC2024.september.LargestSumOfAverages;
import com.ss.leetcode.LC2024.september.LexicographicalNumbers;
import com.ss.leetcode.LC2024.september.LexicographicallyMinimumStringAfterRemovingStars;
import com.ss.leetcode.LC2024.september.LongestSubarrayWithMaximumBitwiseAND;
import com.ss.leetcode.LC2024.september.MaximumNumberOfAlloys;
import com.ss.leetcode.LC2024.september.XORQueriesOfASubarray;
import com.ss.leetcode.LC2024.september.HeightOfBinaryTreeAfterSubtreeRemovalQueries;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.TreeNode;
import java.util.Arrays;
import java.util.List;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.findTheStudentThatWillReplaceTheChalk();
//        start.largestSumOfAverages();
//        start.lexicographicallyMinimumStringAfterRemovingStars();
//        start.deleteNodesFromLinkedListPresentInArray();
//        start.xorQueriesOfASubarray();
//        start.longestSubarrayWithMaximumBitwiseAND();
//        start.maximumNumberOfAlloys();
//        start.lexicographicalNumbers();
        start.heightOfBinaryTreeAfterSubtreeRemovalQueries();
    }

    public void findTheStudentThatWillReplaceTheChalk() {
        FindTheStudentThatWillReplaceTheChalk ftstwrtc = new FindTheStudentThatWillReplaceTheChalk();

        System.out.println("0 == " + ftstwrtc.chalkReplacer(new int[]{5,1,5}, 22));
        System.out.println("1 == " + ftstwrtc.chalkReplacer(new int[]{3,4,1,2}, 25));
        System.out.println("13 == " + ftstwrtc.chalkReplacer(new int[]{3,1,2,3,4,5,6,5,45,3,2,1,2,43,5,78}, 123));
        System.out.println("4 == " + ftstwrtc.chalkReplacer(new int[]{3,1,2,3,4,5,6,5,45,3,2,1,2,43,5,78}, 12));
        System.out.println("3 == " + ftstwrtc.chalkReplacer(new int[]{3,1,2,3,4,5,6,5,45,3,2,1,2,43,5,78}, 812334231));
    }

    public void largestSumOfAverages() {
        LargestSumOfAverages lsoa = new LargestSumOfAverages();

        System.out.println("20.0 == " + lsoa.largestSumOfAverages(new int[]{9,1,2,3,9}, 3));
        System.out.println("20.5 == " + lsoa.largestSumOfAverages(new int[]{1,2,3,4,5,6,7}, 4));
    }

    public void lexicographicallyMinimumStringAfterRemovingStars() {
        LexicographicallyMinimumStringAfterRemovingStars lmsars = new LexicographicallyMinimumStringAfterRemovingStars();

        System.out.println("aab == " + lmsars.clearStars("aaba*"));
        System.out.println("abc == " + lmsars.clearStars("abc"));
    }

    public void deleteNodesFromLinkedListPresentInArray() {
        DeleteNodesFromLinkedListPresentInArray dnfllpia = new DeleteNodesFromLinkedListPresentInArray();

        System.out.println("[4,5] == " + dnfllpia.modifiedList(new int[]{1,2,3}, ListNode.makeChain(new int[]{1,2,3,4,5})).getAsList());
        System.out.println("[2,2,2] == " + dnfllpia.modifiedList(new int[]{1}, ListNode.makeChain(new int[]{1,2,1,2,1,2})).getAsList());
        System.out.println("[1,2,3,4] == " + dnfllpia.modifiedList(new int[]{5}, ListNode.makeChain(new int[]{1,2,3,4})).getAsList());
        System.out.println("[1] == " + dnfllpia.modifiedList(new int[]{4,5,6,7,34,3,2}, ListNode.makeChain(new int[]{3,4,5,6,7,1})).getAsList());
        System.out.println("[9] == " + dnfllpia.modifiedList(new int[]{1,2,3,4,5,6,7}, ListNode.makeChain(new int[]{1,1,1,1,1,1,1,1,1,1,9})).getAsList());
        System.out.println("[11] == " + dnfllpia.modifiedList(new int[]{1,2,3,4,5,6,7,8,9,10}, ListNode.makeChain(new int[]{1,2,3,4,5,6,7,8,9,10,11})).getAsList());
        System.out.println("[1] == " + dnfllpia.modifiedList(new int[]{2,3,4,5,6,7}, ListNode.makeChain(new int[]{1,2,3,4,5,6,7})).getAsList());
    }

    public void xorQueriesOfASubarray() {
        XORQueriesOfASubarray xorqoas = new XORQueriesOfASubarray();

        System.out.println("[2,7,14,8] == " + Arrays.toString(xorqoas.xorQueries(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}})));
        System.out.println("[8,0,4,4] == " + Arrays.toString(xorqoas.xorQueries(new int[]{4,8,2,10}, new int[][]{{2,3},{1,3},{0,0},{0,3}})));
        System.out.println("[7,5,1,4,3,1,4,4] == " + Arrays.toString(xorqoas.xorQueries(new int[]{1,2,3,4,5,5,4,3,1,1,2,3,5,6,76,43,1}, new int[][]{{2,3},{1,3},{0,0},{0,3},{0,1},{1,2},{0,3},{3,3}})));
    }

    public void longestSubarrayWithMaximumBitwiseAND() {
        LongestSubarrayWithMaximumBitwiseAND lswmband = new LongestSubarrayWithMaximumBitwiseAND();

        System.out.println("2 == " + lswmband.longestSubarray(new int[]{1,2,2,3,3,2,2}));
        System.out.println("1 == " + lswmband.longestSubarray(new int[]{1,2,3,4}));
    }

    public void maximumNumberOfAlloys() {
        MaximumNumberOfAlloys mnoa = new MaximumNumberOfAlloys();

        System.out.println("2 == " + mnoa.maxNumberOfAlloys(3,2,15, List.of(List.of(1,1,1), List.of(1,1,10)), List.of(0,0,0), List.of(1,2,3)));
        System.out.println("5 == " + mnoa.maxNumberOfAlloys(3,2,15, List.of(List.of(1,1,1), List.of(1,1,10)), List.of(0,0,100), List.of(1,2,3)));
        System.out.println("2 == " + mnoa.maxNumberOfAlloys(3,2,10, List.of(List.of(2,1), List.of(1,2), List.of(1,1)), List.of(1,1), List.of(5,5)));
    }

    public void lexicographicalNumbers() {
        LexicographicalNumbers ln = new LexicographicalNumbers();

        System.out.println("[1,10,11,12,13,2,3,4,5,6,7,8,9] == " + ln.lexicalOrder(13));
        System.out.println("[1,2] == " + ln.lexicalOrder(2));
    }

    public void heightOfBinaryTreeAfterSubtreeRemovalQueries() {
        HeightOfBinaryTreeAfterSubtreeRemovalQueries hobtastq = new HeightOfBinaryTreeAfterSubtreeRemovalQueries();

        System.out.println("[2] == " + Arrays.toString(hobtastq.treeQueries(
            new TreeNode(1, new TreeNode(3, new TreeNode(2), null), new TreeNode(4, new TreeNode(6), new TreeNode(5, null, new TreeNode(7)))),
            new int[]{4})));
        System.out.println("[3,2,3,2] == " + Arrays.toString(hobtastq.treeQueries(
            new TreeNode(5, new TreeNode(8, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(1)), new TreeNode(9, new TreeNode(3), new TreeNode(7))),
            new int[]{3,2,4,8})));
    }
}
