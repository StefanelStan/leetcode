package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.september.DeleteNodesFromLinkedListPresentInArray;
import com.ss.leetcode.LC2024.september.FindTheStudentThatWillReplaceTheChalk;
import com.ss.leetcode.LC2024.september.LargestSumOfAverages;
import com.ss.leetcode.LC2024.september.LexicographicallyMinimumStringAfterRemovingStars;
import com.ss.leetcode.shared.ListNode;

public class StartSeptember {
    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.findTheStudentThatWillReplaceTheChalk();
//        start.largestSumOfAverages();
//        start.lexicographicallyMinimumStringAfterRemovingStars();
        start.deleteNodesFromLinkedListPresentInArray();
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
}
