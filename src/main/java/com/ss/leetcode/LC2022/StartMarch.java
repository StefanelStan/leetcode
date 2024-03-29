package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.march.AddingSpacesToAString;
import com.ss.leetcode.LC2022.march.AllAncestorsOfANodeInADirectedAcyclicGraph;
import com.ss.leetcode.LC2022.march.BackspaceStringCompare;
import com.ss.leetcode.LC2022.march.BoatsToSavePeople;
import com.ss.leetcode.LC2022.march.BrokenCalculator;
import com.ss.leetcode.LC2022.march.CellsInARangeOnAnExcelSheet;
import com.ss.leetcode.LC2022.march.ChampagneTower;
import com.ss.leetcode.LC2022.march.ConvertIntegerToTheSumOfTwoNoZeroIntegers;
import com.ss.leetcode.LC2022.march.CopyListWithRandomPointer;
import com.ss.leetcode.LC2022.march.CountIntegersWithEvenDigitSum;
import com.ss.leetcode.LC2022.march.CountOperationsToObtainZero;
import com.ss.leetcode.LC2022.march.CountSpecialQuadruplets;
import com.ss.leetcode.LC2022.march.CountingWordsWithAGivenPrefix;
import com.ss.leetcode.LC2022.march.CreateBinaryTreeFromDescriptions;
import com.ss.leetcode.LC2022.march.DeleteAndEarn;
import com.ss.leetcode.LC2022.march.DivideArrayIntoEqualPairs;
import com.ss.leetcode.LC2022.march.FindAllKDistantIndicesInAnArray;
import com.ss.leetcode.LC2022.march.FindTheDuplicateNumber;
import com.ss.leetcode.LC2022.march.LowestCommonAncestorOfABinaryTree;
import com.ss.leetcode.LC2022.march.MagicSquaresInGrid;
import com.ss.leetcode.LC2022.march.MaximumFrequencyStack;
import com.ss.leetcode.LC2022.march.MinimumDominoRotationsForEqualRow;
import com.ss.leetcode.LC2022.march.MinimumRemoveToMakeValidParentheses;
import com.ss.leetcode.LC2022.march.MostFrequentNumberFollowingKeyInAnArray;
import com.ss.leetcode.LC2022.march.NextGreaterNodeInLinkedList;
import com.ss.leetcode.LC2022.march.OneBitAndTwoBitCharacters;
import com.ss.leetcode.LC2022.march.PartitionArrayIntoThreePartsWithEqualSum;
import com.ss.leetcode.LC2022.march.RandomPickIndex;
import com.ss.leetcode.LC2022.march.RotateList;
import com.ss.leetcode.LC2022.march.ScoreOfParentheses;
import com.ss.leetcode.LC2022.march.SearchInRotatedSortedArrayII;
import com.ss.leetcode.LC2022.march.SmallestStringWithAGivenNumericValue;
import com.ss.leetcode.LC2022.march.SmallestSubsequenceOfDistinctCharacters;
import com.ss.leetcode.LC2022.march.SortTheJumbledNumbers;
import com.ss.leetcode.LC2022.march.SplitArrayLargestSum;
import com.ss.leetcode.LC2022.march.TwoCityScheduling;
import com.ss.leetcode.LC2022.march.VerifyingAnAlienDictionary;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.NodeWithRandom;
import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;

public class StartMarch {
    public static void main(String[] args) {
        StartMarch start = new StartMarch();

//        start.countOperationsToObtainZero();
//        start.countWordsWithAGivenPrefix();
//        start.champagneTower();
//        start.mostFrequentNumberFollowingKeyInAnArray();
//        start.sortTheJumbledNumbers();
//        start.allAncestorsOfANodeInADirectedAcyclicGraph();
//        start.deleteAndEarn();
//        start.countIntegersWithEvenDigitSum();
//        start.cellsInARangeOnAnExcelSheet();
//        start.countSpecialQuadruplets();
//        start.rotateList();
//        start.copyListWithRandomPointer();
//        start.randomPickIndex();
//        start.createBinaryTreeFromDescriptions();
//        start.minimumRemoveToMakeValidParentheses();
//        start.findAllKDistantIndicesInAnArray();
//        start.addingSpacesToAString();
//        start.nextGreaterNodeInLinkedList();
//        start.scoreOfParentheses();
//        start.backspaceStringCompare();
        start.smallestSubsequenceOfDistinctCharacters();
//        start.minimumDominoRotationsForEqualRow();
//        start.divideArrayIntoEqualPairs();
//        start.maximumFrequencyStack();
//        start.smallestStringWithAGivenNumericValue();
//        start.convertIntegerToTheSumOfTwoNoZeroIntegers();
//        start.brokenCalculator();
//        start.verifyingAnAlienDictionary();
//        start.boatsToSavePeople();
//        start.twoCityScheduling();
//        start.partitionArrayIntoThreePartsWithEqualSum();
//        start.oneBitAndTwoBitCharacters();
//        start.searchInRotatedSortedArrayII();
//        start.findTheDuplicateNumber();
//        start.lowestCommonAncestorOfABinaryTree();
//        start.magicSquaresInGrid();
//        start.splitArrayLargestSum();
    }

    public void countOperationsToObtainZero() {
        CountOperationsToObtainZero cotoz = new CountOperationsToObtainZero();

        System.out.println("3 == " + cotoz.countOperations(2, 3));
        System.out.println("1 == " + cotoz.countOperations(10, 10));
    }

    public void countWordsWithAGivenPrefix() {
        CountingWordsWithAGivenPrefix cwwagp = new CountingWordsWithAGivenPrefix();

        System.out.println("2 == " + cwwagp.prefixCount(new String[]{"pay","attention","practice","attend"}, "at"));
        System.out.println("0 == " + cwwagp.prefixCount(new String[]{"leetcode","win","loops","success"}, "code"));
    }

    public void champagneTower() {
        ChampagneTower ct = new ChampagneTower();

        System.out.println("0.0000 == " + ct.champagneTower(1, 1, 1));
        System.out.println("0.5000 == " + ct.champagneTower(2, 1, 1));
        System.out.println("1.0000 == " + ct.champagneTower(100000009, 33, 17));
        System.out.println("1.0000 == " + ct.champagneTower(50, 6, 5));
        System.out.println("1.0000 == " + ct.champagneTower(5352433, 86, 34));
    }

    public void mostFrequentNumberFollowingKeyInAnArray() {
        MostFrequentNumberFollowingKeyInAnArray mfnfkia = new MostFrequentNumberFollowingKeyInAnArray();

        System.out.println("100 == " + mfnfkia.mostFrequent(new int[]{1,100,200,1,100}, 1));
        System.out.println("2 == " + mfnfkia.mostFrequent(new int[]{2,2,2,2,3}, 2));
    }

    public void sortTheJumbledNumbers() {
        SortTheJumbledNumbers stjn = new SortTheJumbledNumbers();

        System.out.println("[338,38,991] == " + Arrays.toString(stjn.sortJumbled(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{991,338,38})));
        System.out.println("[123,456,789] == " + Arrays.toString(stjn.sortJumbled(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{789,456,123})));
    }

    public void allAncestorsOfANodeInADirectedAcyclicGraph() {
        AllAncestorsOfANodeInADirectedAcyclicGraph aaoaniadac = new AllAncestorsOfANodeInADirectedAcyclicGraph();

        System.out.println("[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]] == " +
            aaoaniadac.getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));

        System.out.println("[[],[0],[0,1],[0,1,2],[0,1,2,3]] == " +
            aaoaniadac.getAncestors(5, new int[][]{{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}}));

        System.out.println("[[],[0,6],[],[],[2],[0,2,3,7],[],[0],[]] == " +
            aaoaniadac.getAncestors(9, new int[][]{{7,5},{2,5},{0,7},{0,1},{6,1},{2,4},{3,5}}));
    }

    public void deleteAndEarn() {
        DeleteAndEarn dae = new DeleteAndEarn();

        System.out.println("6 == " + dae.deleteAndEarn(new int[]{3,4,2}));
        System.out.println("9 == " + dae.deleteAndEarn(new int[]{2,2,3,3,3,4}));
        System.out.println("10689 == " + dae.deleteAndEarn(new int[]{5,2,8,4,1,8,99,100,4,1,8,4,2,8,4,7,6,3,2,5,6,3,21,6,8,
            54,3,4,2,1,4,66,22,11,33,44,44,55,66,77,78,79,80,10000}));
    }

    public void countIntegersWithEvenDigitSum() {
        CountIntegersWithEvenDigitSum ciweds = new CountIntegersWithEvenDigitSum();

        System.out.println("2 == " + ciweds.countEven(4));
        System.out.println("14 == " + ciweds.countEven(30));
    }

    public void cellsInARangeOnAnExcelSheet() {
        CellsInARangeOnAnExcelSheet ciaroaes = new CellsInARangeOnAnExcelSheet();

        System.out.println("[K1, K2, L1, L2] == " + ciaroaes.cellsInRange("K1:L2"));
        System.out.println("[A1, B1, C1, D1, E1, F1] == " + ciaroaes.cellsInRange("A1:F1"));
    }

    public void countSpecialQuadruplets() {
        CountSpecialQuadruplets csq = new CountSpecialQuadruplets();

        System.out.println("1 == " + csq.countQuadruplets(new int[]{1,2,3,6}));
        System.out.println("0 == " + csq.countQuadruplets(new int[]{3,3,6,4,5}));
        System.out.println("4 == " + csq.countQuadruplets(new int[]{1,1,1,3,5}));
    }

    public void rotateList() {
        RotateList rl = new RotateList();

        ListNode head1 = ListNode.makeChain(new int[]{1,2,3,4,5});
        ListNode head2 = ListNode.makeChain(new int[]{0,1,2});
        ListNode head3 = ListNode.makeChain(new int[]{1,2,3,4,5,1,2,3,4,5,7,3,2,9,7,5,2,1,0});

        System.out.println("[4,5,1,2,3] == " + rl.rotateRight(head1, 2).getAsList());
        System.out.println("[2,0,1] == " + rl.rotateRight(head2, 4).getAsList());
        System.out.println("[5,1,2,3,4,5,7,3,2,9,7,5,2,1,0,1,2,3,4] == " + rl.rotateRight(head3, 1978265119).getAsList());
    }

    public void copyListWithRandomPointer() {
        CopyListWithRandomPointer clwrp = new CopyListWithRandomPointer();

        NodeWithRandom head1 = NodeWithRandom.makeChain(new Integer[][]{{7, null},{13,0},{11,4},{10,2},{1,0}});
        NodeWithRandom head2 = NodeWithRandom.makeChain(new Integer[][]{{1,1},{2,1}});
        NodeWithRandom head3 = NodeWithRandom.makeChain(new Integer[][]{{3, null},{3,0},{3,null}});

        System.out.println("[[7,null],[13,0],[11,4],[10,2],[1,0]] == " + clwrp.copyRandomList(head1).asList());
        System.out.println("[[1,1],[2,1]] == " + clwrp.copyRandomList(head2).asList());
        System.out.println("[[3,null],[3,0],[3,null]] == " + clwrp.copyRandomList(head3).asList());
    }

    public void randomPickIndex() {
        RandomPickIndex rpi = new RandomPickIndex(new int[]{1,2,3,3,3});

        System.out.println("2||3||4 == " + rpi.pick(3));
        System.out.println("0 == " + rpi.pick(1));
        System.out.println("2||3||4 == " + rpi.pick(3));
    }

    public void createBinaryTreeFromDescriptions() {
        CreateBinaryTreeFromDescriptions cbtfd = new CreateBinaryTreeFromDescriptions();

        System.out.println("[50,2015,17,80,19] == " + TreeNode.preOrder(cbtfd.createBinaryTree(new int[][]{{20,15,1},{20,17,0},{50,20,1},
            {50,80,0},{80,19,1}})));

        System.out.println("[1,2,3,4] == " + TreeNode.preOrder(cbtfd.createBinaryTree(new int[][]{{1,2,1},{2,3,0},{3,4,1}})));
    }

    public void minimumRemoveToMakeValidParentheses() {
        MinimumRemoveToMakeValidParentheses mrtmvp = new MinimumRemoveToMakeValidParentheses();

        System.out.println("lee(t(c)o)de == " + mrtmvp.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println("l()ee(t(c)o)de == " + mrtmvp.minRemoveToMakeValid("l())ee(t(c)o)de)"));
        System.out.println("ab(c)d == " + mrtmvp.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(" == " + mrtmvp.minRemoveToMakeValid("))(("));
        System.out.println("a == " + mrtmvp.minRemoveToMakeValid("a"));
        System.out.println("a == " + mrtmvp.minRemoveToMakeValid("a("));
    }

    public void findAllKDistantIndicesInAnArray() {
        FindAllKDistantIndicesInAnArray fakdiaaa = new FindAllKDistantIndicesInAnArray();

        System.out.println("[1,2,3,4,5,6] == " + fakdiaaa.findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1));
        System.out.println("[0,1,2,3,4] == " + fakdiaaa.findKDistantIndices(new int[]{2,2,2,2,2}, 2, 2));
    }

    public void addingSpacesToAString() {
        AddingSpacesToAString astas = new AddingSpacesToAString();

        System.out.println("Leetcode Helps Me Learn == " + astas.addSpaces("LeetcodeHelpsMeLearn", new int[]{8,13,15}));
        System.out.println("i code in py thon == " + astas.addSpaces("icodeinpython", new int[]{1,5,7,9}));
        System.out.println(" s p a c i n g == " + astas.addSpaces("spacing", new int[]{0,1,2,3,4,5,6}));
        System.out.println(" ab  == " + astas.addSpaces("ab", new int[]{0}));
    }

    public void nextGreaterNodeInLinkedList() {
        NextGreaterNodeInLinkedList ngnill = new NextGreaterNodeInLinkedList();

        System.out.println("[5,5,0] == " + Arrays.toString(ngnill.nextLargerNodes(ListNode.makeChain(new int[]{2,1,5}))));
        System.out.println("[7,0,5,5,0] == " + Arrays.toString(ngnill.nextLargerNodes(ListNode.makeChain(new int[]{2,7,4,3,5}))));
        System.out.println("[0] == " + Arrays.toString(ngnill.nextLargerNodes(ListNode.makeChain(new int[]{1}))));
        System.out.println("[2,3,0] == " + Arrays.toString(ngnill.nextLargerNodes(ListNode.makeChain(new int[]{1,2,3}))));
        System.out.println("[0,0,0] == " + Arrays.toString(ngnill.nextLargerNodes(ListNode.makeChain(new int[]{3,2,1}))));
    }

    public void scoreOfParentheses() {
        ScoreOfParentheses sop = new ScoreOfParentheses();

        System.out.println("1 == " + sop.scoreOfParentheses("()"));
        System.out.println("2 == " + sop.scoreOfParentheses("(())"));
        System.out.println("2 == " + sop.scoreOfParentheses("()()"));
        System.out.println("12 == " + sop.scoreOfParentheses("((()())()())"));
    }

    public void backspaceStringCompare() {
        BackspaceStringCompare bsc = new BackspaceStringCompare();

        System.out.println("true == " + bsc.backspaceCompare("ab#c", "ad#c"));
        System.out.println("true == " + bsc.backspaceCompare("ab##", "c#d#"));
        System.out.println("false == " + bsc.backspaceCompare("a#c", "b"));
    }

    public void smallestSubsequenceOfDistinctCharacters() {
        // NOT WORKING
        SmallestSubsequenceOfDistinctCharacters ssodc = new SmallestSubsequenceOfDistinctCharacters();

        System.out.println("abc == " + ssodc.smallestSubsequence("bcabc"));
        System.out.println("acdb == " + ssodc.smallestSubsequence("cbacdcbc"));
        System.out.println("abcdehofgiujlxmwtnrvks == " + ssodc.smallestSubsequence("cbacdcbchifdusghdfihiguehofimwscfn"
            + "idmghiuvhceujfsdilhgcxmiwhdtvlcnrhvdsclmisfldkghcjskj"));
    }

    public void minimumDominoRotationsForEqualRow() {
        MinimumDominoRotationsForEqualRow mdrfer = new MinimumDominoRotationsForEqualRow();

        System.out.println("2 == " + mdrfer.minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        System.out.println("-1 == " + mdrfer.minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
    }

    public void divideArrayIntoEqualPairs() {
        DivideArrayIntoEqualPairs daiep = new DivideArrayIntoEqualPairs();

        System.out.println("true == " + daiep.divideArray(new int[]{3,2,3,2,2,2}));
        System.out.println("false == " + daiep.divideArray(new int[]{1,2,2,2}));
    }

    public void maximumFrequencyStack() {
        MaximumFrequencyStack mfs = new MaximumFrequencyStack();

        mfs.push(5); // The stack is [5]
        mfs.push(7); // The stack is [5,7]
        mfs.push(5); // The stack is [5,7,5]
        mfs.push(7); // The stack is [5,7,5,7]
        mfs.push(4); // The stack is [5,7,5,7,4]
        mfs.push(5); // The stack is [5,7,5,7,4,5]
        System.out.println("5 == " + mfs.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        System.out.println("7 == " + mfs.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        System.out.println("5 == " + mfs.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        System.out.println("4 == " + mfs.pop());   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }

    public void smallestStringWithAGivenNumericValue() {
        SmallestStringWithAGivenNumericValue sswagnv = new SmallestStringWithAGivenNumericValue();

        System.out.println("aay == " + sswagnv.getSmallestString(3, 27));
        System.out.println("aaszz == " + sswagnv.getSmallestString(5, 73));
    }

    public void convertIntegerToTheSumOfTwoNoZeroIntegers() {
        ConvertIntegerToTheSumOfTwoNoZeroIntegers cittsotnzi = new ConvertIntegerToTheSumOfTwoNoZeroIntegers();

        System.out.println("[1,1] == " + Arrays.toString(cittsotnzi.getNoZeroIntegers(2)));
        System.out.println("[2,9] == " + Arrays.toString(cittsotnzi.getNoZeroIntegers(11)));
        System.out.println("[2,8999] == " + Arrays.toString(cittsotnzi.getNoZeroIntegers(9001)));
        System.out.println("[1,6] == " + Arrays.toString(cittsotnzi.getNoZeroIntegers(7)));
    }

    public void brokenCalculator() {
        BrokenCalculator bc = new BrokenCalculator();

        System.out.println("2 == " + bc.brokenCalc(2,3));
        System.out.println("2 == " + bc.brokenCalc(5,8));
        System.out.println("3 == " + bc.brokenCalc(3,10));
        System.out.println("5 == " + bc.brokenCalc(8,3));
    }

    public void verifyingAnAlienDictionary() {
        VerifyingAnAlienDictionary vaad = new VerifyingAnAlienDictionary();

        System.out.println("true == " + vaad.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println("false == " + vaad.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println("false == " + vaad.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
    }

    public void boatsToSavePeople() {
        BoatsToSavePeople btsp = new BoatsToSavePeople();

        System.out.println("1 == " + btsp.numRescueBoats(new int[]{1,2}, 3));
        System.out.println("3 == " + btsp.numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println("4 == " + btsp.numRescueBoats(new int[]{3,5,3,4}, 5));
        System.out.println("11 == " + btsp.numRescueBoats(new int[]{4,3,2,7,8,9,4,5,7,2,3,5,8,5,3,2,8,5,9,1,8}, 11));
    }

    public void twoCityScheduling() {
        TwoCityScheduling tcs = new TwoCityScheduling();

        System.out.println("110 == " + tcs.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,32}}));
        System.out.println("1859 == " + tcs.twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
        System.out.println("3086 == " + tcs.twoCitySchedCost(new int[][]{{515,563},{451,713},{537,709},{343,819},{855,779},
                                                            {457,60},{650,359},{631,42}}));
    }

    public void partitionArrayIntoThreePartsWithEqualSum() {
        PartitionArrayIntoThreePartsWithEqualSum paitpwes = new PartitionArrayIntoThreePartsWithEqualSum();

        System.out.println("true == " + paitpwes.canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        System.out.println("false == " + paitpwes.canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        System.out.println("true == " + paitpwes.canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
        System.out.println("true == " + paitpwes.canThreePartsEqualSum(new int[]{0,0,0,0}));
        System.out.println("false == " + paitpwes.canThreePartsEqualSum(new int[]{1,-1,1,-1}));
    }

    public void oneBitAndTwoBitCharacters() {
        OneBitAndTwoBitCharacters obatbc = new OneBitAndTwoBitCharacters();

        System.out.println("true == " + obatbc.isOneBitCharacter(new int[]{1,0,0}));
        System.out.println("false == " + obatbc.isOneBitCharacter(new int[]{1,1,1,0}));
    }

    public void searchInRotatedSortedArrayII() {
        SearchInRotatedSortedArrayII siarsaii = new SearchInRotatedSortedArrayII();

        System.out.println("true == " + siarsaii.search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println("false == " + siarsaii.search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println("true == " + siarsaii.search(new int[]{1,2,3,3,4,5,6,6,7,8,9,10,10,10,11,12,13,13,14,14,15,16}, 3));
        System.out.println("true == " + siarsaii.search(new int[]{8,9,10,10,10,11,12,13,13,14,14,15,16,1,2,3,3,4,5,6,6,7}, 3));
        System.out.println("true == " + siarsaii.search(new int[]{16,1,2,3,3,4,5,6,6,7,8,9,10,10,10,11,12,13,13,14,14,15}, 3));
        System.out.println("false == " + siarsaii.search(new int[]{16,1,2,3,3,4,5,6,6,7,8,9,10,10,10,11,12,13,13,14,14,15}, 33));
        System.out.println("true == " + siarsaii.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
            ,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1}, 2));
    }

    public void findTheDuplicateNumber() {
        FindTheDuplicateNumber ftdn = new FindTheDuplicateNumber();

        System.out.println("2 == " + ftdn.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println("3 == " + ftdn.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println("3 == " + ftdn.findDuplicate(new int[]{3,1,3,4,3,2}));
        System.out.println("1 == " + ftdn.findDuplicate(new int[]{1,1,3,4,5,2}));
        System.out.println("2 == " + ftdn.findDuplicate(new int[]{2,1,2}));
    }

    public void lowestCommonAncestorOfABinaryTree() {
        LowestCommonAncestorOfABinaryTree lcaoabt = new LowestCommonAncestorOfABinaryTree();

        TreeNode root1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                                      new TreeNode(1, new TreeNode(0), new TreeNode(8)));

        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));

        System.out.println("3 == " + lcaoabt.lowestCommonAncestor(root1, new TreeNode(5), new TreeNode(1)).val);
        System.out.println("5 == " + lcaoabt.lowestCommonAncestor(root1, new TreeNode(5), new TreeNode(4)).val);
        System.out.println("1 == " + lcaoabt.lowestCommonAncestor(root2, new TreeNode(1), new TreeNode(2)).val);
    }

    public void magicSquaresInGrid() {
        MagicSquaresInGrid msig = new MagicSquaresInGrid();

        System.out.println("1 == " + msig.numMagicSquaresInside(new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2}}));
        System.out.println("0 == " + msig.numMagicSquaresInside(new int[][]{{8}}));
        System.out.println("1 == " + msig.numMagicSquaresInside(new int[][]{{8,1,6},{3,5,7},{4,9,2}}));
        System.out.println("0 == " + msig.numMagicSquaresInside(new int[][]{{5,5,5},{5,5,5},{5,5,5}}));
        System.out.println("0 == " + msig.numMagicSquaresInside(new int[][]{{10,3,5},{1,6,11},{7,9,2}}));
        System.out.println("0 == " + msig.numMagicSquaresInside(new int[][]{{7,0,5},{2,4,6},{3,8,1}}));
    }

    public void splitArrayLargestSum() {
        SplitArrayLargestSum sals = new SplitArrayLargestSum();

        System.out.println("18 == " + sals.splitArray(new int[]{7,2,5,10,8}, 2));
        System.out.println("9 == " + sals.splitArray(new int[]{1,2,3,4,5}, 2));
        System.out.println("4 == " + sals.splitArray(new int[]{1,4,4}, 3));
    }
}
