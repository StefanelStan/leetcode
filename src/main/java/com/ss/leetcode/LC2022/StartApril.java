package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.april.*;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();

//        start.findUniqueBinaryString();
//        start.minimumBitFlipsToConvertNumber();
//        start.findTriangularSumOfAnArray();
//        start.sumOfScoresOfBuiltStrings();
//        start.countOddNumbersInAnIntervalRange();
//        start.nextPermutation();
//        start.swappingNodesInALinkedList();
//        start.containerWithMostWater();
//        start.threeSumWithMultiplicity();
//        start.kthLargestElementInAStream();
//        start.topKFrequentElements();
//        start.checkIfEveryRowAndColumnContainsAllNumbers();
//        start.addTwoIntegers();
//        start.rootEqualsSumOfChildren();
//        start.spiralMatrixII();
//        start.addOneRowToTree();
//        start.intersectionOfTwoLinkedLists();
//        start.findClosestNumberToZero();
//        start.numberOfWaysToBuyPensAndPencils();
//        start.designAnATMMachine();
//        start.evaluateReversePolishNotation();
//        start.numberOfDifferentIntegersInAString();
//        start.insertInterval();
//        start.determineWhetherMatrixObtainedByRotation();
//        start.rotateImage();
//        start.calculateDigitSumOfAString();
//        start.findTheDifferenceOfTwoArrays();
//        start.nextGreaterElementIII();
//        start.peekingIterator();
        start.minCostToConnectAllPoints();
//        start.timeNeededToInformAllEmployees();
//        start.subarrayProductLessThanK();
//        start.rangeSumQuery2DImmutable();
//        start.countPrefixesOfAGivenString();
//        start.minimumAverageDifference();
//        start.countUnguardedCellsInTheGrid();
    }

    public void findUniqueBinaryString() {
        FindUniqueBinaryString fubs = new FindUniqueBinaryString();

        System.out.println("00 == " + fubs.findDifferentBinaryString(new String[]{"01","10"}));
        System.out.println("11 == " + fubs.findDifferentBinaryString(new String[]{"00","01"}));
        System.out.println("000 == " + fubs.findDifferentBinaryString(new String[]{"111","011","001"}));
    }

    public void minimumBitFlipsToConvertNumber() {
        MinimumBitFlipsToConvertNumber mbftcn = new MinimumBitFlipsToConvertNumber();

        System.out.println("3 == " + mbftcn.minBitFlips(10, 7));
        System.out.println("3 == " + mbftcn.minBitFlips(3, 4));
        System.out.println("3 == " + mbftcn.minBitFlips(3, 973299123));
        System.out.println("3 == " + mbftcn.minBitFlips(542122143, 7));
    }

    public void findTriangularSumOfAnArray() {
        FindTriangularSumOfAnArray ftsoaa = new FindTriangularSumOfAnArray();

        System.out.println("8 == " + ftsoaa.triangularSum(new int[]{1,2,3,4,5}));
        System.out.println("4 == " + ftsoaa.triangularSum(new int[]{1,2,3,4,5,4,2,7,5,3,2,8,5,3,2,7,4,3,8,1,5,7,9,3,2,0,1}));
        System.out.println("5 == " + ftsoaa.triangularSum(new int[]{5}));
    }

    public void sumOfScoresOfBuiltStrings() {
        SumOfScoresOfBuiltStrings sosobs = new SumOfScoresOfBuiltStrings();

        System.out.println("9 == " + sosobs.sumScores("babab"));
        System.out.println("14 == " + sosobs.sumScores("azbazbzaz"));
        System.out.println("235 == " + sosobs.sumScores("nskmiwknpiclnptttlihicvixtqyxzdyrkulgqpfeckxssnlekuxiwvmxhyfzspt"
            + "cjdqxvuavtakihlizitoozcnnubaafdsadfrvxnadgfshkpfqpcfrtcjsydkjbaupsflzgyumyggutzjcicbqmeghncnsgjkwqwksyahx"
            + "sykyjnqvofkmpxmeaqqhtddflkwvpbpqzkxzyzkdcrctmopmiipaewlw"));
        System.out.println("18 == " + sosobs.sumScores("hhzjhhzjsoiz"));
    }

    public void countOddNumbersInAnIntervalRange() {
        CountOddNumbersInAnIntervalRange coniair = new CountOddNumbersInAnIntervalRange();

        System.out.println("3 == " + coniair.countOdds(3,7));
        System.out.println("1 == " + coniair.countOdds(8,10));
    }

    public void nextPermutation() {
        NextPermutation np = new NextPermutation();

        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{3,2,1};
        int[] arr3 = new int[]{1,5,1};
        int[] arr4 = new int[]{1,5,2,7,4,2,8,5,1,7,3,2,8,9,1,3,2,1,1,1,1};

        np.nextPermutation(arr1);
        np.nextPermutation(arr2);
        np.nextPermutation(arr3);
        np.nextPermutation(arr4);

        System.out.println("[1,3,2] == " + Arrays.toString(arr1));
        System.out.println("[1,2,3] == " + Arrays.toString(arr2));
        System.out.println("[1,1,5] == " + Arrays.toString(arr3));
        System.out.println("[1,5,2,7,4,2,8,5,1,7,3,2,8,9,2,1,1,1,1,1,3] == " + Arrays.toString(arr4));
    }

    public void swappingNodesInALinkedList() {
        SwappingNodesInALinkedList sniall = new SwappingNodesInALinkedList();

        System.out.println("[1,4,3,2,5] == " + sniall.swapNodes(ListNode.makeChain(new int[]{1,2,3,4,5}), 2).getAsList());
        System.out.println("[1,3,2,4] == " + sniall.swapNodes(ListNode.makeChain(new int[]{1,2,3,4}), 2).getAsList());
        System.out.println("[7,9,6,6,8,7,3,0,9,5] == " + sniall.swapNodes(ListNode.makeChain(new int[]{7,9,6,6,7,8,3,0,9,5}), 5).getAsList());
        System.out.println("[2,1] == " + sniall.swapNodes(ListNode.makeChain(new int[]{1,2}), 2).getAsList());
        System.out.println("[3,2,1] == " + sniall.swapNodes(ListNode.makeChain(new int[]{1,2,3}), 1).getAsList());
        System.out.println("[2,1] == " + sniall.swapNodes(ListNode.makeChain(new int[]{1,2}), 1).getAsList());
    }

    public void containerWithMostWater() {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();

        System.out.println("49 == " + cwmw.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println("1 == " + cwmw.maxArea(new int[]{1,1}));
        System.out.println("264 == " + cwmw.maxArea(new int[]{5,2,8,5,3,89,2,1,6,8,5,2,1,5,8,6,3,22,8,1,7,4,2,3,4,5,6,7,8,9,7,6,5,4,3,2,1}));
    }

    public void threeSumWithMultiplicity() {
        ThreeSumWithMultiplicity tswm = new ThreeSumWithMultiplicity();

        System.out.println("20 == " + tswm.threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
        System.out.println("12 == " + tswm.threeSumMulti(new int[]{1,1,2,2,2,2}, 5));
    }

    public void kthLargestElementInAStream() {
        KthLargestElementInAStream kleias = new KthLargestElementInAStream(3, new int[]{4,5,8,2});

        System.out.println("4 == " + kleias.add(3));
        System.out.println("5 == " + kleias.add(5));
        System.out.println("5 == " + kleias.add(10));
        System.out.println("8 == " + kleias.add(9));
        System.out.println("8 == " + kleias.add(4));

        kleias = new KthLargestElementInAStream(1, new int[]{});

        System.out.println("-3 == " + kleias.add(-3));
        System.out.println("-2 == " + kleias.add(-2));
        System.out.println("-2 == " + kleias.add(-4));
        System.out.println("0 == " + kleias.add(0));
        System.out.println("4 == " + kleias.add(4));
    }

    public void topKFrequentElements() {
        TopKFrequentElements tkfe = new TopKFrequentElements();

        System.out.println("[1,2] == " + Arrays.toString(tkfe.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println("[1] == " + Arrays.toString(tkfe.topKFrequent(new int[]{1}, 1)));
        System.out.println("[1,2,3,4] == " + Arrays.toString(tkfe.topKFrequent(new int[]{1,1,1,2,2,2,3,3,3,4,4,5}, 4)));
        System.out.println("[5] == " + Arrays.toString(tkfe.topKFrequent(new int[]{1,2,3,4,5,5}, 1)));
    }

    public void checkIfEveryRowAndColumnContainsAllNumbers() {
        CheckIfEveryRowAndColumnContainsAllNumbers cieraccan = new CheckIfEveryRowAndColumnContainsAllNumbers();

        System.out.println("true == " + cieraccan.checkValid(new int[][]{{1,2,3},{3,2,1},{2,3,1}}));
        System.out.println("false == " + cieraccan.checkValid(new int[][]{{1,1,1},{1,2,3},{1,2,3}}));
    }

    public void addTwoIntegers() {
        AddTwoIntegers adi = new AddTwoIntegers();

        System.out.println("17 == " + adi.sum(12, 5));
        System.out.println("-6 == " + adi.sum(-10, 4));
    }

    public void rootEqualsSumOfChildren() {
        RootEqualsSumOfChildren resoc = new RootEqualsSumOfChildren();

        System.out.println("true == " + resoc.checkTree(new TreeNode(10, new TreeNode(4), new TreeNode(6))));
        System.out.println("false == " + resoc.checkTree(new TreeNode(5, new TreeNode(3), new TreeNode(1))));
    }

    public void spiralMatrixII() {
        SpiralMatrixII smii = new SpiralMatrixII();

        System.out.println("[[1,2,3],[8,9,4],[7,6,5]] == " + Arrays.deepToString(smii.generateMatrix(3)));
        System.out.println("[[1]] == " + Arrays.deepToString(smii.generateMatrix(1)));
    }

    public void addOneRowToTree() {
        AddOneRowToTree aortt = new AddOneRowToTree();

        TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, new TreeNode(5), null));
        TreeNode root2 = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), null);

        System.out.println("[4,1,2,3,1,1,6,5] == " + TreeNode.preOrder(aortt.addOneRow(root1, 1, 2)));
        System.out.println("[4,2,1,3,1,1] == " + TreeNode.preOrder(aortt.addOneRow(root2, 1, 3)));
    }

    public void intersectionOfTwoLinkedLists() {
        IntersectionOfTwoLinkedLists iotll = new IntersectionOfTwoLinkedLists();

        ListNode common1 = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode head1 = new ListNode(4, new ListNode(1, common1));
        ListNode head2 = new ListNode(5, new ListNode(6, new ListNode(1, common1)));

        ListNode common2 = new ListNode(2, new ListNode(4));
        ListNode head3 = new ListNode(1, new ListNode(9, new ListNode(1, common2)));
        ListNode head4 = new ListNode(3, common2);

        System.out.println("[8,4,5] == " + iotll.getIntersectionNode(head1, head2).getAsList());
        System.out.println("[2,4] == " + iotll.getIntersectionNode(head3, head4).getAsList());
    }

    public void findClosestNumberToZero() {
        FindClosestNumberToZero fcntz = new FindClosestNumberToZero();

        System.out.println("1 == " + fcntz.findClosestNumber(new int[]{-4,-2,1,4,8}));
        System.out.println("1 == " + fcntz.findClosestNumber(new int[]{2,-1,1}));
    }

    public void numberOfWaysToBuyPensAndPencils() {
        NumberOfWaysToBuyPensAndPencils nowtbpap = new NumberOfWaysToBuyPensAndPencils();

        System.out.println("9 == " + nowtbpap.waysToBuyPensPencils(20, 10, 5));
        System.out.println("1 == " + nowtbpap.waysToBuyPensPencils(5, 10, 10));
    }

    public void designAnATMMachine() {
        DesignAnATMMachine daatmm = new DesignAnATMMachine();

//        daatmm.deposit(new int[]{0,0,1,2,1});
//        System.out.println("[0,0,1,0,1] == " + Arrays.toString(daatmm.withdraw(600)));
//        daatmm.deposit(new int[]{0,1,0,1,1});
//        System.out.println("[-1] == " + Arrays.toString(daatmm.withdraw(600)));
//        System.out.println("[0,1,0,0,1] == " + Arrays.toString(daatmm.withdraw(550)));

//        for(int i = 0; i < 4000; i++) {
//            daatmm.deposit(new int[]{100000,100000,100000,100000,100000});
//        }
//        System.out.println("2000000 == " + Arrays.toString(daatmm.withdraw(1000000000)));

        daatmm.deposit(new int[]{226094735,393965432,637421322,948644288,831564545});
        daatmm.deposit(new int[]{46552724,433649668,171823159,857494741,710787090});
        daatmm.deposit(new int[]{935259214,495389631,745491587,619918730,53636060});
        daatmm.withdraw(892448980);
        daatmm.deposit(new int[]{897956273,638917478,895068048,700860525,472696905});
        daatmm.withdraw(748725445);
        daatmm.deposit(new int[]{855772627,899627874,370102367,328216522,563737450});
        daatmm.withdraw(230192275);
        daatmm.withdraw(901174015);
        daatmm.deposit(new int[]{630750355,525959450,96652997,399933566,191101825});
        daatmm.deposit(new int[]{757564362,403459275,788390370,187081434,77572739});
        daatmm.deposit(new int[]{123522257,48419930,489703077,151691306,938262923});
        daatmm.deposit(new int[]{195174028,591248143,835060612,836343810,298963554});
        System.out.println("[0,1,0,1,64274] == " + Arrays.toString(daatmm.withdraw(32137250)));
    }

    public void evaluateReversePolishNotation() {
        EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();

        System.out.println("9 == " + erpn.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println("6 == " + erpn.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println("22 == " + erpn.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        System.out.println("-1 == " + erpn.evalRPN(new String[]{"3","-4","+"}));
    }

    public void numberOfDifferentIntegersInAString() {
        NumberOfDifferentIntegersInAString nodiias = new NumberOfDifferentIntegersInAString();

        System.out.println("3 == " + nodiias.numDifferentIntegers("a123bc34d8ef34"));
        System.out.println("2 == " + nodiias.numDifferentIntegers("leet1234code234"));
        System.out.println("1 == " + nodiias.numDifferentIntegers("a1b01c001"));
        System.out.println("2 == " + nodiias.numDifferentIntegers("035985750011523523129774573439111590559325a1554234973"));
    }

    public void insertInterval() {
        InsertInterval ii = new InsertInterval();

        System.out.println("[[1,5],[6,9]] == " + Arrays.deepToString(ii.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})));
        System.out.println("[[1,2],[3,10],[12,16]] == " + Arrays.deepToString(ii.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
    }

    public void determineWhetherMatrixObtainedByRotation() {
        DetermineWhetherMatrixObtainedByRotation dwmobr = new DetermineWhetherMatrixObtainedByRotation();

        System.out.println("true == " + dwmobr.findRotation(new int[][]{{0,1},{1,0}}, new int[][]{{1,0},{0,1}}));
        System.out.println("false == " + dwmobr.findRotation(new int[][]{{0,1},{1,1}}, new int[][]{{1,0},{0,1}}));
        System.out.println("true == " + dwmobr.findRotation(new int[][]{{1,1},{0,0}}, new int[][]{{0,1},{0,1}}));
        System.out.println("true == " + dwmobr.findRotation(new int[][]{{0,0,0},{0,1,0},{1,1,1}}, new int[][]{{1,1,1},{0,1,0},{0,0,0}}));
    }

    public void rotateImage() {
        RotateImage ri = new RotateImage();

        int[][] matrix1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        ri.rotate(matrix1);
        ri.rotate(matrix2);

        System.out.println("[[7,4,1],[8,5,2],[9,6,3]] == " + Arrays.deepToString(matrix1));
        System.out.println("[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]] == " + Arrays.deepToString(matrix2));
    }

    public void calculateDigitSumOfAString() {
        CalculateDigitSumOfAString cdsoas = new CalculateDigitSumOfAString();

        System.out.println("135 == " + cdsoas.digitSum("11111222223", 3));
        System.out.println("000 == " + cdsoas.digitSum("00000000", 3));
    }

    public void findTheDifferenceOfTwoArrays() {
        FindTheDifferenceOfTwoArrays ftdota = new FindTheDifferenceOfTwoArrays();

        System.out.println("[[1,3],[4,6]] == " + ftdota.findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println("[[3],[]] == " + ftdota.findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }

    public void nextGreaterElementIII() {
        NextGreaterElementIII ngeiii = new NextGreaterElementIII();

        System.out.println("21 == " + ngeiii.nextGreaterElement(12));
        System.out.println("342423432 == " + ngeiii.nextGreaterElement(342423423));
        System.out.println("-1 == " + ngeiii.nextGreaterElement(1));
        System.out.println("230412 == " + ngeiii.nextGreaterElement(230241));
    }

    public void peekingIterator() {
        Iterator<Integer> iterator = List.of(1,2,3).iterator();
        PeekingIterator pi = new PeekingIterator(iterator);

        System.out.println("1 == " + pi.next());
        System.out.println("2 == " + pi.peek());
        System.out.println("2 == " + pi.next());
        System.out.println("3 == " + pi.next());
        System.out.println("false == " + pi.hasNext());
    }

    public void minCostToConnectAllPoints() {
        MinCostToConnectAllPoints mctcap = new MinCostToConnectAllPoints();

        System.out.println("20 == " + mctcap.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
//        System.out.println("18 == " + mctcap.minCostConnectPoints(new int[][]{{3,12},{-2,5},{-4,1}}));
//        System.out.println("0 == " + mctcap.minCostConnectPoints(new int[][]{{0,0}}));
//        System.out.println("53 == " + mctcap.minCostConnectPoints(new int[][]{{2,-3},{-17,-8},{13,8},{-17,-15}}));
    }

    public void timeNeededToInformAllEmployees() {
        TimeNeededToInformAllEmployees tntiae = new TimeNeededToInformAllEmployees();

        System.out.println("0 == " + tntiae.numOfMinutes(1, 0, new int[]{-1}, new int[]{0}));
        System.out.println("1 == " + tntiae.numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
    }

    public void subarrayProductLessThanK() {
        SubarrayProductLessThanK spltk = new SubarrayProductLessThanK();

        System.out.println("8 == " + spltk.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
        System.out.println("0 == " + spltk.numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
        System.out.println("0 == " + spltk.numSubarrayProductLessThanK(new int[]{2,3,4}, 1));
        System.out.println("55 == " + spltk.numSubarrayProductLessThanK(new int[]{3,4,3,2,7,5,6,2,3,1,4}, 9899));
    }

    public void rangeSumQuery2DImmutable() {
        RangeSumQuery2DImmutable rsq2di = new RangeSumQuery2DImmutable(new int[][]{{3,0,1,4,2},
            {5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});

        System.out.println("8 == " + rsq2di.sumRegion(2,1,4,3));
        System.out.println("11 == " + rsq2di.sumRegion(1,1,2,2));
        System.out.println("12 == " + rsq2di.sumRegion(1,2,2,4));
    }

    public void countPrefixesOfAGivenString() {
        CountPrefixesOfAGivenString cpoags = new CountPrefixesOfAGivenString();

        System.out.println("3 == " + cpoags.countPrefixes(new String[]{"a","b","c","ab","bc","abc"}, "abc"));
        System.out.println("2 == " + cpoags.countPrefixes(new String[]{"a", "a"}, "aa"));
    }

    public void minimumAverageDifference() {
        MinimumAverageDifference mad = new MinimumAverageDifference();

        System.out.println("3 == " + mad.minimumAverageDifference(new int[]{2,5,3,9,5,3}));
        System.out.println("0 == " + mad.minimumAverageDifference(new int[]{0}));
    }

    public void countUnguardedCellsInTheGrid() {
        CountUnguardedCellsInTheGrid cucitg = new CountUnguardedCellsInTheGrid();

        System.out.println("7 == " + cucitg.countUnguarded(4, 6, new int[][]{{0,0},{1,1},{2,3}}, new int[][]{{0,1},{2,2},{1,4}}));
        System.out.println("4 == " + cucitg.countUnguarded(3, 3, new int[][]{{1,1}}, new int[][]{{0,1},{1,0},{2,1},{1,2}}));
        System.out.println("1 == " + cucitg.countUnguarded(2, 7, new int[][]{{1,5},{1,1},{1,6},{0,2}}, new int[][]{{0,6},{0,3},{0,5}}));
    }
}
