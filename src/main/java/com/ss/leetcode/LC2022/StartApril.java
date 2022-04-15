package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.april.*;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;

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
        start.intersectionOfTwoLinkedLists();
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
}
