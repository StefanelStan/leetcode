package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.july.CountNumberOfTexts;
import com.ss.leetcode.LC2023.july.FindEventualSafeStates;
import com.ss.leetcode.LC2023.july.FindTheKthLargestIntegerInTheArray;
import com.ss.leetcode.LC2023.july.LongestEvenOddSubarrayWithThreshold;
import com.ss.leetcode.LC2023.july.MaximizeTheConfusionOfAnExam;
import com.ss.leetcode.LC2023.july.MinimumDepthOfBinaryTree;
import com.ss.leetcode.LC2023.july.MinimumOperationsToHalveArraySum;
import com.ss.leetcode.LC2023.july.MostProfitAssigningWork;
import com.ss.leetcode.LC2023.july.TotalDistanceTraveled;
import com.ss.leetcode.LC2023.july.UniqueSubstringsInWraparoundString;
import com.ss.leetcode.shared.TreeNode;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.uniqueSubstringsInWraparoundString();
//        start.totalDistanceTraveled();
//        start.findTheKthLargestIntegerInTheArray();
//        start.maximizeTheConfusionOfAnExam();
//        start.longestEvenOddSubarrayWithThreshold();
//        start.mostProfitAssigningWork();
//        start.minimumDepthOfBinaryTree();
//        start.minimumOperationsToHalveArraySum();
//        start.findEventualSafeStates();
        start.countNumberOfTexts();
    }

    public void uniqueSubstringsInWraparoundString() {
        UniqueSubstringsInWraparoundString usiws = new UniqueSubstringsInWraparoundString();

        System.out.println("1 == " + usiws.findSubstringInWraproundString("a"));
        System.out.println("2 == " + usiws.findSubstringInWraproundString("cac"));
        System.out.println("6 == " + usiws.findSubstringInWraproundString("zab"));
    }

    public void totalDistanceTraveled() {
        TotalDistanceTraveled tdt = new TotalDistanceTraveled();
        String[]  strings = {"a", "b"};
        System.out.println("60 == " + tdt.distanceTraveled(5, 10));
        System.out.println("10 == " + tdt.distanceTraveled(1, 2));
        System.out.println("820 == " + tdt.distanceTraveled(70, 12));
    }

    public void findTheKthLargestIntegerInTheArray() {
        FindTheKthLargestIntegerInTheArray ftkliata = new FindTheKthLargestIntegerInTheArray();

        System.out.println("3 == " + ftkliata.kthLargestNumber(new String[]{"3","6","7","10"}, 4));
        System.out.println("2 == " + ftkliata.kthLargestNumber(new String[]{"2","21","12","1"}, 3));
        System.out.println("2 == " + ftkliata.kthLargestNumber(new String[]{"0","0"}, 2));
    }

    public void maximizeTheConfusionOfAnExam() {
        MaximizeTheConfusionOfAnExam mtcoaa = new MaximizeTheConfusionOfAnExam();

        System.out.println("4 == " + mtcoaa.maxConsecutiveAnswers("TTFF", 2));
        System.out.println("3 == " + mtcoaa.maxConsecutiveAnswers("TFFT", 1));
        System.out.println("5 == " + mtcoaa.maxConsecutiveAnswers("TTFTTFTT", 1));
    }

    public void longestEvenOddSubarrayWithThreshold() {
        LongestEvenOddSubarrayWithThreshold leoswt = new LongestEvenOddSubarrayWithThreshold();

        System.out.println("3 == " + leoswt.longestAlternatingSubarray(new int[]{3,2,5,4}, 5));
        System.out.println("1 == " + leoswt.longestAlternatingSubarray(new int[]{1,2}, 2));
        System.out.println("3 == " + leoswt.longestAlternatingSubarray(new int[]{2,3,4,5}, 4));
        System.out.println("1 == " + leoswt.longestAlternatingSubarray(new int[]{2,8}, 4));
    }

    public void mostProfitAssigningWork() {
        MostProfitAssigningWork mpaw = new MostProfitAssigningWork();

        System.out.println("100 == " + mpaw.maxProfitAssignment(new int[]{2,4,6,8,10}, new int[]{10,20,30,40,50}, new int[]{4,5,6,7}));
        System.out.println("0 == " + mpaw.maxProfitAssignment(new int[]{85,47,57}, new int[]{24,66,99}, new int[]{40,25,25}));
        System.out.println("553 == " + mpaw.maxProfitAssignment(new int[]{23,30,35,35,43,46,47,81,83,98}, new int[]{8,11,11,20,33,37,60,72,87,95}, new int[]{95,46,47,97,11,35,99,56,41,92}));
    }

    public void minimumDepthOfBinaryTree() {
        MinimumDepthOfBinaryTree mdobt = new MinimumDepthOfBinaryTree();

        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));

        System.out.println("2 == " + mdobt.minDepth(root1));
        System.out.println("5 == " + mdobt.minDepth(root2));
    }

    public void minimumOperationsToHalveArraySum() {
        MinimumOperationsToHalveArraySum mothas = new MinimumOperationsToHalveArraySum();

        System.out.println("3 == " + mothas.halveArray(new int[]{5,19,8,1}));
        System.out.println("3 == " + mothas.halveArray(new int[]{3,8,20}));
    }

    public void findEventualSafeStates() {
        FindEventualSafeStates fess = new FindEventualSafeStates();

        System.out.println("[2,4,5,6] == " + fess.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
        System.out.println("[4] == " + fess.eventualSafeNodes(new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}}));
    }

    public void countNumberOfTexts() {
        CountNumberOfTexts cnot = new CountNumberOfTexts();

        System.out.println("8 == " + cnot.countTexts("22233"));
        System.out.println("82876089 == " + cnot.countTexts("222222222222222222222222222222222222"));
        System.out.println("7 == " + cnot.countTexts("23333"));
    }
}