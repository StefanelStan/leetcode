package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.may.CombinationSumIII;
import com.ss.leetcode.LC2022.may.CountHillsAndValleysInAnArray;
import com.ss.leetcode.LC2022.may.CountNodesEqualToAverageOfSubtree;
import com.ss.leetcode.LC2022.may.CountSortedVowelStrings;
import com.ss.leetcode.LC2022.may.DesignAuthenticationManager;
import com.ss.leetcode.LC2022.may.DesignCircularQueue;
import com.ss.leetcode.LC2022.may.DesignLinkedList;
import com.ss.leetcode.LC2022.may.FindTheKBeautyOfANumber;
import com.ss.leetcode.LC2022.may.FlattenNestedListIterator;
import com.ss.leetcode.LC2022.may.FlattenNestedListIterator.MyNestedInteger;
import com.ss.leetcode.LC2022.may.ImplementStackUsingQueues;
import com.ss.leetcode.LC2022.may.IntersectionOfMultipleArrays;
import com.ss.leetcode.LC2022.may.Largest3SameDigitNumberInString;
import com.ss.leetcode.LC2022.may.LatestTimeByReplacingHiddenDigits;
import com.ss.leetcode.LC2022.may.LetterCombinationsOfAPhoneNumber;
import com.ss.leetcode.LC2022.may.LongestIncreasingPathInAMatrix;
import com.ss.leetcode.LC2022.may.LongestValidParentheses;
import com.ss.leetcode.LC2022.may.MaxNumberOfKSumPairs;
import com.ss.leetcode.LC2022.may.MaximizeSumOfArrayAfterKNegations;
import com.ss.leetcode.LC2022.may.MaximumWhiteTilesCoveredByACarpet;
import com.ss.leetcode.LC2022.may.MinCostClimbingStairs;
import com.ss.leetcode.LC2022.may.MyCalendarI;
import com.ss.leetcode.LC2022.may.NumberOfWaysToSplitArray;
import com.ss.leetcode.LC2022.may.OneThreeTwo132Pattern;
import com.ss.leetcode.LC2022.may.PermutationsII;
import com.ss.leetcode.LC2022.may.SeatReservationManager;
import com.ss.leetcode.LC2022.may.ShortestUnsortedContinuousSubarray;
import com.ss.leetcode.LC2022.may.UniquePathsII;
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
//        start.largest3SameDigitNumberInString();
//        start.longestIncreasingPathInAMatrix();
//        start.uniquePathsII();
//        start.intersectionOfMultipleArrays();
//        start.minCostClimbingStairs();
//        start.countHillsAndValleysInAnArray();
//        start.maximizeSumOfArrayAfterKNegations();
//        start.longestValidParentheses();
        start.designCircularQueue();
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

    public void longestIncreasingPathInAMatrix() {
        LongestIncreasingPathInAMatrix lipiam = new LongestIncreasingPathInAMatrix();

        System.out.println("4 == " + lipiam.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        System.out.println("4 == " + lipiam.longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
        System.out.println("1 == " + lipiam.longestIncreasingPath(new int[][]{{1}}));
        System.out.println("40 == " + lipiam.longestIncreasingPath(new int[][]{{0,1,2,3,4,5,6,7,8,9},
            {19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29}, {39,38,37,36,35,34,33,32,31,30},
            {40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},
            {79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},
            {100,101,102,103,104,105,106,107,108,109}, {119,118,117,116,115,114,113,112,111,110},
            {120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},
            {0,0,0,0,0,0,0,0,0,0}}));
    }

    public void uniquePathsII() {
        UniquePathsII upii = new UniquePathsII();

        System.out.println("2 == " + upii.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println("1 == " + upii.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
        System.out.println("0 == " + upii.uniquePathsWithObstacles(new int[][]{{1}}));
        System.out.println("0 == " + upii.uniquePathsWithObstacles(new int[][]{{1,0}}));
    }

    public void intersectionOfMultipleArrays() {
        IntersectionOfMultipleArrays ioma = new IntersectionOfMultipleArrays();

        System.out.println("[3,4] == " + ioma.intersection(new int[][]{{3,1,2,4,5},{1,2,3,4},{3,4,5,6}}));
        System.out.println("[] == " + ioma.intersection(new int[][]{{1,2,3},{4,5,6}}));
    }

    public void minCostClimbingStairs() {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();

        System.out.println("15 == " + mccs.minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println("6 == " + mccs.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    public void countHillsAndValleysInAnArray() {
        CountHillsAndValleysInAnArray chaviaa = new CountHillsAndValleysInAnArray();

        System.out.println("3 == " + chaviaa.countHillValley(new int[]{2,4,1,1,6,5}));
        System.out.println("0 == " + chaviaa.countHillValley(new int[]{6,6,5,5,4,1}));
        System.out.println("56 == " + chaviaa.countHillValley(new int[]{87,82,19,65,26,66,83,68,94,
            33,7,13,88,63,28,90,81,74,97,9,13,8,51,65,30,9,44,38,14,45,100,2,67,89,10,75,15,71,97,
            41,18,53,58,56,36,41,88,49,42,82,82,81,22,4,50,87,40,91,7,81,76,51,41,19,22,66,92,24,44,
            48,50,26,98,59,42,77,59,76,23,67,71,57,56,15,92,68,53,85,98,32,26,77,98,78,77}));
    }

    public void maximizeSumOfArrayAfterKNegations() {
        MaximizeSumOfArrayAfterKNegations msoaakn = new MaximizeSumOfArrayAfterKNegations();

        System.out.println("5 == " + msoaakn.largestSumAfterKNegations(new int[]{4,2,3}, 1));
        System.out.println("6 == " + msoaakn.largestSumAfterKNegations(new int[]{3,-1,0,2}, 3));
        System.out.println("13 == " + msoaakn.largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2));
        System.out.println("22 == " + msoaakn.largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2}, 6));
    }

    public void longestValidParentheses() {
        LongestValidParentheses lvp = new LongestValidParentheses();

        System.out.println("2 == " + lvp.longestValidParentheses("(()"));
        System.out.println("4 == " + lvp.longestValidParentheses(")()())"));
        System.out.println("4 == " + lvp.longestValidParentheses("()(()"));
        System.out.println("0 == " + lvp.longestValidParentheses(""));
    }

    public void designCircularQueue() {
        DesignCircularQueue dcq = new DesignCircularQueue(3);

        System.out.println("true == " + dcq.enQueue(1));
        System.out.println("true == " + dcq.enQueue(2));
        System.out.println("true == " + dcq.enQueue(3));
        System.out.println("false == " + dcq.enQueue(4));
        System.out.println("3 == " + dcq.rear());
        System.out.println("1 == " + dcq.front());
        System.out.println("true == " + dcq.isFull());
        System.out.println("true == " + dcq.deQueue());
        System.out.println("true == " + dcq.enQueue(4));
        System.out.println("4 == " + dcq.rear());
    }
}
