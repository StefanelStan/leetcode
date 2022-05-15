package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.may.CombinationSumIII;
import com.ss.leetcode.LC2022.may.CountNodesEqualToAverageOfSubtree;
import com.ss.leetcode.LC2022.may.CountSortedVowelStrings;
import com.ss.leetcode.LC2022.may.DesignAuthenticationManager;
import com.ss.leetcode.LC2022.may.DesignLinkedList;
import com.ss.leetcode.LC2022.may.FindTheKBeautyOfANumber;
import com.ss.leetcode.LC2022.may.FlattenNestedListIterator;
import com.ss.leetcode.LC2022.may.FlattenNestedListIterator.MyNestedInteger;
import com.ss.leetcode.LC2022.may.ImplementStackUsingQueues;
import com.ss.leetcode.LC2022.may.Largest3SameDigitNumberInString;
import com.ss.leetcode.LC2022.may.LatestTimeByReplacingHiddenDigits;
import com.ss.leetcode.LC2022.may.LetterCombinationsOfAPhoneNumber;
import com.ss.leetcode.LC2022.may.MaxNumberOfKSumPairs;
import com.ss.leetcode.LC2022.may.MaximumWhiteTilesCoveredByACarpet;
import com.ss.leetcode.LC2022.may.MyCalendarI;
import com.ss.leetcode.LC2022.may.NumberOfWaysToSplitArray;
import com.ss.leetcode.LC2022.may.OneThreeTwo132Pattern;
import com.ss.leetcode.LC2022.may.PermutationsII;
import com.ss.leetcode.LC2022.may.SeatReservationManager;
import com.ss.leetcode.LC2022.may.ShortestUnsortedContinuousSubarray;
import com.ss.leetcode.shared.TreeNode;
import java.util.List;

public class StartMay {
    public static void main(String[] args) {
        StartMay start = new StartMay();

//        start.latestTimeByReplacingHiddenDigits();
//        start.seatReservationManager();
//        start.shortestUnsortedContinuousSubarray();
//        start.maxNumberOfKSumPairs();
//        start.implementStackUsingQueues();
//        start.myCalendarI();
//        start.oneThreeTwo132Pattern();
//        start.flattenNestedListIterator();
//        start.letterCombinationsOfAPhoneNumber();
//        start.combinationSumIII();
//        start.countSortedVowelStrings();
//        start.permutationsII();
//        start.countNodesEqualToAverageOfSubtree();
//        start.findTheKBeautyOfANumber();
//        start.numberOfWaysToSplitArray();
//        start.maximumWhiteTilesCoveredByACarpet();
//        start.designLinkedList();
//        start.designAuthenticationManager();
        start.largest3SameDigitNumberInString();
    }

    public void latestTimeByReplacingHiddenDigits() {
        LatestTimeByReplacingHiddenDigits ltbrhd = new LatestTimeByReplacingHiddenDigits();

        System.out.println("23:50 == " + ltbrhd.maximumTime("2?:?0"));
        System.out.println("09:39 == " + ltbrhd.maximumTime("0?:3?"));
        System.out.println("19:22 == " + ltbrhd.maximumTime("1?:22"));
    }

    public void seatReservationManager() {
        SeatReservationManager srm = new SeatReservationManager(5);

        System.out.println("1 == " + srm.reserve());
        System.out.println("2 == " + srm.reserve());
        srm.unreserve(2);
        System.out.println("2 == " + srm.reserve());
        System.out.println("3 == " + srm.reserve());
        System.out.println("4 == " + srm.reserve());
        System.out.println("5 == " + srm.reserve());
        srm.unreserve(5);
    }

    public void shortestUnsortedContinuousSubarray() {
        ShortestUnsortedContinuousSubarray sucs = new ShortestUnsortedContinuousSubarray();

        System.out.println("5 == " + sucs.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        System.out.println("0 == " + sucs.findUnsortedSubarray(new int[]{1,2,3,4}));
        System.out.println("0 == " + sucs.findUnsortedSubarray(new int[]{1}));
    }

    public void maxNumberOfKSumPairs() {
        MaxNumberOfKSumPairs mnokps = new MaxNumberOfKSumPairs();

        System.out.println("2 == " + mnokps.maxOperations(new int[]{1,2,3,4}, 5));
        System.out.println("1 == " + mnokps.maxOperations(new int[]{3,1,3,4,3}, 6));
    }

    public void implementStackUsingQueues() {
        ImplementStackUsingQueues isuq = new ImplementStackUsingQueues();

        isuq.push(1);
        isuq.push(2);
        System.out.println("2 == " + isuq.top());
        System.out.println("2 == " + isuq.pop());
        System.out.println("false == " + isuq.empty());
    }

    public void myCalendarI() {
        MyCalendarI mci = new MyCalendarI();
        System.out.println("true == " + mci.book(10, 20));
        System.out.println("false == " + mci.book(15, 25));
        System.out.println("true == " + mci.book(20, 30));

        mci = new MyCalendarI();
        System.out.println("true == " + mci.book(47, 50));
        System.out.println("true == " + mci.book(33,41));
        System.out.println("false == " + mci.book(39,45));
        System.out.println("false == " + mci.book(33,42));
        System.out.println("true == " + mci.book(25,32));
        System.out.println("false == " + mci.book(26,35));
        System.out.println("true == " + mci.book(19,25));
        System.out.println("true == " + mci.book(3,8));
        System.out.println("true == " + mci.book(8,13));
        System.out.println("false == " + mci.book(18,27));
    }

    public void oneThreeTwo132Pattern() {
        OneThreeTwo132Pattern ott132p = new OneThreeTwo132Pattern();

        System.out.println("false == " + ott132p.find132pattern(new int[]{1,2,3,4}));
        System.out.println("true == " + ott132p.find132pattern(new int[]{3,1,4,2}));
        System.out.println("true == " + ott132p.find132pattern(new int[]{-1,3,2,0}));
        System.out.println("true == " + ott132p.find132pattern(new int[]{1,3,2,4,5,6,7,8,9,10}));
        System.out.println("true == " + ott132p.find132pattern(new int[]{3,5,0,3,4}));
    }

    public void flattenNestedListIterator() {
        MyNestedInteger mn1 = new MyNestedInteger(List.of(new MyNestedInteger(1), new MyNestedInteger(1)));
        MyNestedInteger mn2 = new MyNestedInteger(2);
        MyNestedInteger mn3 = new MyNestedInteger(List.of(new MyNestedInteger(1), new MyNestedInteger(1)));
        FlattenNestedListIterator fnli = new FlattenNestedListIterator(List.of(mn1, mn2, mn3));
        System.out.println("[1,1,2,1,1] == " + List.of(fnli.next(), fnli.next(), fnli.next(), fnli.next(), fnli.next()));

        mn1 = new MyNestedInteger(6);
        mn2 = new MyNestedInteger(List.of(new MyNestedInteger(4), mn1));
        mn3 = new MyNestedInteger(List.of(new MyNestedInteger(1), mn2));
        fnli = new FlattenNestedListIterator(List.of(mn3, mn2, mn1));
        System.out.println("[1,4,6] == " + List.of(fnli.next(), fnli.next(), fnli.next()));
    }

    public void letterCombinationsOfAPhoneNumber() {
        LetterCombinationsOfAPhoneNumber lcoapn = new LetterCombinationsOfAPhoneNumber();

        System.out.println("[ad,ae,af,bd,be,bf,cd,ce,cf] == " + lcoapn.letterCombinations("23"));
        System.out.println("[] == " + lcoapn.letterCombinations(""));
        System.out.println("[a,b,c] == " + lcoapn.letterCombinations("2"));
    }

    public void combinationSumIII() {
        CombinationSumIII csiii = new CombinationSumIII();

        System.out.println("[[1,2,4]] == " + csiii.combinationSum3(3, 7));
        System.out.println("[[1,2,6],[1,3,5],[2,3,4]] == " + csiii.combinationSum3(3, 9));
        System.out.println("[] == " + csiii.combinationSum3(4, 1));
    }

    public void countSortedVowelStrings() {
        CountSortedVowelStrings csvs = new CountSortedVowelStrings();

        System.out.println("1 == " + csvs.countVowelStrings(1));
        System.out.println("15 == " + csvs.countVowelStrings(2));
    }

    public void permutationsII() {
        PermutationsII pii = new PermutationsII();

        System.out.println("[[1,1,2],[1,2,1],[2,1,1]] == " + pii.permuteUnique(new int[]{1,1,2}));
        System.out.println("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] == " + pii.permuteUnique(new int[]{1,2,3}));
    }

    public void countNodesEqualToAverageOfSubtree() {
        CountNodesEqualToAverageOfSubtree cnetaos = new CountNodesEqualToAverageOfSubtree();

        TreeNode root1 = new TreeNode(4, new TreeNode(8, new TreeNode(0), new TreeNode(1)), new TreeNode(5, null, new TreeNode(6)));
        TreeNode root2 = new TreeNode(1);

        System.out.println("5 == " + cnetaos.averageOfSubtree(root1));
        System.out.println("1 == " + cnetaos.averageOfSubtree(root2));
    }

    public void findTheKBeautyOfANumber() {
        FindTheKBeautyOfANumber ftkboan = new FindTheKBeautyOfANumber();

        System.out.println("2 == " + ftkboan.divisorSubstrings(240, 2));
        System.out.println("2 == " + ftkboan.divisorSubstrings(430043, 2));
    }

    public void numberOfWaysToSplitArray() {
        NumberOfWaysToSplitArray nowtsa = new NumberOfWaysToSplitArray();

        System.out.println("2 == " + nowtsa.waysToSplitArray(new int[]{10,4,-8,7}));
        System.out.println("2 == " + nowtsa.waysToSplitArray(new int[]{2,3,1,0}));
        System.out.println("1 == " + nowtsa.waysToSplitArray(new int[]{0,0}));
    }

    public void maximumWhiteTilesCoveredByACarpet() {
        MaximumWhiteTilesCoveredByACarpet mwtcbac = new MaximumWhiteTilesCoveredByACarpet();

        System.out.println("8 == " + mwtcbac.maximumWhiteTiles(new int[][]{{1,5},{10,11},{12,18},{20,25},{30,32}}, 8));
        System.out.println("9 == " + mwtcbac.maximumWhiteTiles(new int[][]{{1,5},{10,11},{12,18},{20,25},{30,32}}, 10));
        System.out.println("2 == " + mwtcbac.maximumWhiteTiles(new int[][]{{10,11},{1,1}}, 2));
    }

    public void designLinkedList() {
        DesignLinkedList dll = new DesignLinkedList();
        dll.addAtHead(1);
        dll.addAtTail(3);
        dll.addAtIndex(1,2);
        System.out.println("2 == " + dll.get(1));
        dll.deleteAtIndex(1);
        System.out.println("3 == " + dll.get(1));

        dll = new DesignLinkedList();
        dll.addAtTail(3);
        dll.addAtHead(1);
        dll.addAtIndex(1,2);
        System.out.println("2 == " + dll.get(1));
        dll.deleteAtIndex(1);
        System.out.println("3 == " + dll.get(1));
        dll.deleteAtIndex(0);
        System.out.println("3 == " + dll.get(0));

        dll = new DesignLinkedList();
        dll.addAtHead(1);
        dll.deleteAtIndex(0);
        dll.addAtHead(7);
        dll.addAtHead(2);
        dll.addAtHead(1);
        dll.addAtIndex(3,0);
        dll.deleteAtIndex(2);
        dll.addAtHead(6);
        dll.addAtTail(4);
        System.out.println("4 == " + dll.get(4));
        dll.addAtHead(4);
        dll.addAtIndex(5,0);
        dll.addAtHead(6);
    }

    public void designAuthenticationManager() {
        DesignAuthenticationManager dam = new DesignAuthenticationManager(5);
        dam.renew("aaa", 1);
        dam.generate("aaa", 2);
        System.out.println("1 == " + dam.countUnexpiredTokens(6));
        dam.generate("bbb", 7);
        dam.renew("aaa", 8);
        dam.renew("bbb", 10);
        System.out.println("0 == " + dam.countUnexpiredTokens(15));

        dam = new DesignAuthenticationManager(13);
        dam.renew("ajvy", 1);
        System.out.println("0 == " + dam.countUnexpiredTokens(3));
        System.out.println("0 == " + dam.countUnexpiredTokens(4));
        dam.generate("fuzxq", 5);
        dam.generate("izmry", 7);
        dam.renew("puv", 12);
        dam.generate("ybiqb", 13);
        dam.generate("gm", 14);
        System.out.println("4 == " + dam.countUnexpiredTokens(15));
        System.out.println("3 == " + dam.countUnexpiredTokens(18));
        System.out.println("3 == " + dam.countUnexpiredTokens(19));
        dam.renew("ybiqb", 21);
        System.out.println("2 == " + dam.countUnexpiredTokens(23));
        System.out.println("2 == " + dam.countUnexpiredTokens(25));
        System.out.println("2 == " + dam.countUnexpiredTokens(26));
        dam.generate("aqdm", 28);
        System.out.println("2 == " + dam.countUnexpiredTokens(29));
        dam.renew("puv", 30);
    }

    public void largest3SameDigitNumberInString() {
        Largest3SameDigitNumberInString l3sdnis = new Largest3SameDigitNumberInString();

        System.out.println("777 == " + l3sdnis.largestGoodInteger("6777133339"));
        System.out.println("000 == " + l3sdnis.largestGoodInteger("2300019"));
        System.out.println(" == " + l3sdnis.largestGoodInteger("42352338"));
    }
}