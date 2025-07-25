package com.ss.leetcode.LC2025;

import com.ss.leetcode.LC2025.july.FindTheKthCharacterInStringGameI;
import com.ss.leetcode.LC2025.july.FindTheOriginalTypedStringI;
import com.ss.leetcode.LC2025.july.MaximumUniqueSubarraySumAfterDeletion;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.findTheOriginalTypedStringI();
//        start.findTheKthCharacterInStringGameI();
        start.maximumUniqueSubarraySumAfterDeletion();
    }

    public void findTheOriginalTypedStringI() {
        FindTheOriginalTypedStringI ftotsi = new FindTheOriginalTypedStringI();

        System.out.println("5 == " + ftotsi.possibleStringCount("abbcccc"));
        System.out.println("1 == " + ftotsi.possibleStringCount("abcd"));
        System.out.println("4 == " + ftotsi.possibleStringCount("aaaa"));
        System.out.println("6 == " + ftotsi.possibleStringCount("assdjhhjiashdhgashgdashgdshgashgdsahgashdgsaghdhgashsashghgshhhsshshshdgahsdasgd"));
        System.out.println("25 == " + ftotsi.possibleStringCount("sssssdddddddddddddddeeerreerreerer"));
        System.out.println("18 == " + ftotsi.possibleStringCount("aooaioioioiaaiiiiaaaiiiaiaiaiissisiisisissssss"));
    }

    public void findTheKthCharacterInStringGameI() {
        FindTheKthCharacterInStringGameI ftkcisgi = new FindTheKthCharacterInStringGameI();

        System.out.println("b == " + ftkcisgi.kthCharacter(5));
        System.out.println("c == " + ftkcisgi.kthCharacter(7));
        System.out.println("d == " + ftkcisgi.kthCharacter(12));
        System.out.println("e == " + ftkcisgi.kthCharacter(211));
    }

    public void maximumUniqueSubarraySumAfterDeletion() {
        MaximumUniqueSubarraySumAfterDeletion mussad = new MaximumUniqueSubarraySumAfterDeletion();

        System.out.println("15 == " + mussad.maxSum(new int[]{1,2,3,4,5}));
        System.out.println("1 == " + mussad.maxSum(new int[]{1,1,0,1,1}));
        System.out.println("-1 == " + mussad.maxSum(new int[]{-1,-2,-3,-4,-1,-2,-3,-4}));
        System.out.println("229 == " + mussad.maxSum(new int[]{5,4,6,7,8,7,6,5,4,2,-23,43,5,6,7,8,98,7,56,4,2}));
    }
}
