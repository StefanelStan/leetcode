package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.july.AllPossibleFullBinaryTrees;
import com.ss.leetcode.LC2023.july.AsteroidCollision;
import com.ss.leetcode.LC2023.july.CountNumberOfTexts;
import com.ss.leetcode.LC2023.july.CountNumberOfWaysToPlaceHouses;
import com.ss.leetcode.LC2023.july.ExpressiveWords;
import com.ss.leetcode.LC2023.july.FindEventualSafeStates;
import com.ss.leetcode.LC2023.july.FindTheKthLargestIntegerInTheArray;
import com.ss.leetcode.LC2023.july.HIndexII;
import com.ss.leetcode.LC2023.july.KnightProbabilityInChessboard;
import com.ss.leetcode.LC2023.july.LinkedListComponents;
import com.ss.leetcode.LC2023.july.LongestCommonSubsequence;
import com.ss.leetcode.LC2023.july.LongestEvenOddSubarrayWithThreshold;
import com.ss.leetcode.LC2023.july.MaximizeTheConfusionOfAnExam;
import com.ss.leetcode.LC2023.july.MaximumNumberOfEatenApples;
import com.ss.leetcode.LC2023.july.MinimumASCIIDeleteSumForTwoStrings;
import com.ss.leetcode.LC2023.july.MinimumDepthOfBinaryTree;
import com.ss.leetcode.LC2023.july.MinimumOperationsToHalveArraySum;
import com.ss.leetcode.LC2023.july.MinimumSpeedToArriveOnTime;
import com.ss.leetcode.LC2023.july.MinimumTimeToRepairCars;
import com.ss.leetcode.LC2023.july.MostProfitAssigningWork;
import com.ss.leetcode.LC2023.july.NonOverlappingIntervals;
import com.ss.leetcode.LC2023.july.NumberOfLongestIncreasingSubsequence;
import com.ss.leetcode.LC2023.july.PredictTheWinner;
import com.ss.leetcode.LC2023.july.SmallestSufficientTeam;
import com.ss.leetcode.LC2023.july.StrangePrinter;
import com.ss.leetcode.LC2023.july.TotalDistanceTraveled;
import com.ss.leetcode.LC2023.july.UniqueSubstringsInWraparoundString;
import com.ss.leetcode.LC2023.july.WaysToSplitArrayIntoThreeSubarrays;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.TreeNode;
import java.util.Arrays;
import java.util.List;

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
//        start.countNumberOfTexts();
//        start.smallestSufficientTeam();
//        start.asteroidCollision();
//        start.nonOverlappingIntervals();
//        start.numberOfLongestIncreasingSubsequence();
//        start.knightProbabilityInChessboard();
//        start.allPossibleFullBinaryTrees();
//        start.linkedListComponents();
//        start.countNumberOfWaysToPlaceHouses();
//        start.hIndexII();
//        start.maximumNumberOfEatenApples();
//        start.waysToSplitArrayIntoThreeSubarrays();
//        start.minimumSpeedToArriveOnTime();
//        start.expressiveWords();
//        start.predictTheWinner();
//        start.minimumTimeToRepairCars();
//        start.strangePrinter();
//        start.longestCommonSubsequence();
        start.minimumASCIIDeleteSumForTwoStrings();
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

    public void smallestSufficientTeam() {
        SmallestSufficientTeam sst = new SmallestSufficientTeam();

        List<List<String>> people1 = List.of(List.of("java"), List.of("nodejs"), List.of("nodejs", "reactjs"));
        List<List<String>> people2 = List.of(List.of("algorithms", "math", "java"), List.of("algorithms", "math", "reactjs"),
            List.of("java", "csharp", "aws"), List.of("reactjs", "csharp"), List.of("csharp", "math"), List.of("aws", "java"));
        List<List<String>> people3 = List.of(
            List.of("peaqbonzgl","xtadkauiqwravo"),
            List.of("peaqbonzgl","pcfpppaxsxtpixd","zshbwqdhx"),
            List.of("x","a"), List.of("a"), List.of("jmhobexvmmlyyzk","fjubadocdwaygs","xtadkauiqwravo","zshbwqdhx"),
            List.of("fjubadocdwaygs","x","zshbwqdhx"), List.of("x","xtadkauiqwravo"), List.of("x","hyxnrujrqykzhizm"),
            List.of("peaqbonzgl","x","pcfpppaxsxtpixd","a"), List.of("peaqbonzgl","pcfpppaxsxtpixd"),
            List.of("a"), List.of("hyxnrujrqykzhizm"), List.of("jmhobexvmmlyyzk"), List.of("hfkbcrslcdjq","xtadkauiqwravo","a","zshbwqdhx"),
            List.of("peaqbonzgl","mf","a","rahimgtlopffbwdg","zshbwqdhx"), List.of("xtadkauiqwravo"),List.of("fjubadocdwaygs"),
            List.of("x","a","ulqocaijhezwfr","zshbwqdhx"), List.of("peaqbonzgl"), List.of("pcfpppaxsxtpixd","ulqocaijhezwfr","hyxnrujrqykzhizm"),
            List.of("a","ulqocaijhezwfr","hyxnrujrqykzhizm"), List.of("a","rahimgtlopffbwdg"), List.of("zshbwqdhx"),
            List.of("fjubadocdwaygs","peaqbonzgl","brgjopmm","x"), List.of("hyxnrujrqykzhizm"), List.of("jmhobexvmmlyyzk","a","ulqocaijhezwfr"),
            List.of("peaqbonzgl","x","a","ulqocaijhezwfr","zshbwqdhx"), List.of("mf","pcfpppaxsxtpixd"), List.of("fjubadocdwaygs","ulqocaijhezwfr"),
            List.of("fjubadocdwaygs","x","a"), List.of("zezdb","hyxnrujrqykzhizm"), List.of("ccwfthnjt","a"), List.of("fjubadocdwaygs","zezdb","a"),
            List.of(), List.of("peaqbonzgl","ccwfthnjt","hyxnrujrqykzhizm"), List.of("xtadkauiqwravo","hyxnrujrqykzhizm"),
            List.of("peaqbonzgl","a"), List.of("x","a","hyxnrujrqykzhizm"), List.of("zshbwqdhx"), List.of(),
            List.of("fjubadocdwaygs","mf","pcfpppaxsxtpixd","zshbwqdhx"), List.of("pcfpppaxsxtpixd","a","zshbwqdhx"),
            List.of("peaqbonzgl"), List.of("peaqbonzgl","x","ulqocaijhezwfr"), List.of("ulqocaijhezwfr"), List.of("x"),
            List.of("fjubadocdwaygs","peaqbonzgl"), List.of("fjubadocdwaygs","xtadkauiqwravo"), List.of("pcfpppaxsxtpixd","zshbwqdhx"),
            List.of("peaqbonzgl","brgjopmm","pcfpppaxsxtpixd","a"), List.of("fjubadocdwaygs","x","mf","ulqocaijhezwfr"),
            List.of("jmhobexvmmlyyzk","brgjopmm","rahimgtlopffbwdg","hyxnrujrqykzhizm"), List.of("x","ccwfthnjt","hyxnrujrqykzhizm"),
            List.of("hyxnrujrqykzhizm"),List.of("peaqbonzgl","x","xtadkauiqwravo","ulqocaijhezwfr","hyxnrujrqykzhizm"),
            List.of("brgjopmm","ulqocaijhezwfr","zshbwqdhx"), List.of("peaqbonzgl","pcfpppaxsxtpixd"), List.of("fjubadocdwaygs","x","a","zshbwqdhx"),
            List.of("fjubadocdwaygs","peaqbonzgl","x") ,List.of("ccwfthnjt"));
        List<List<String>> people4 = List.of(List.of("vaostwmycy"), List.of("mgdipkgt"), List.of("bjwxnfbbubpnd"), List.of(), List.of("uhppib"));

        System.out.println("[0, 2] == " + Arrays.toString(sst.smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"}, people1)));
        System.out.println("[1,2] == " + Arrays.toString(sst.smallestSufficientTeam(new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"}, people2)));
        System.out.println("[14, 13, 49, 25, 32, 52] == " + Arrays.toString(sst.smallestSufficientTeam(new String[]{
            "hfkbcrslcdjq","jmhobexvmmlyyzk","fjubadocdwaygs","peaqbonzgl","brgjopmm","x","mf","pcfpppaxsxtpixd","ccwfthnjt","xtadkauiqwravo","zezdb","a","rahimgtlopffbwdg","ulqocaijhezwfr","zshbwqdhx","hyxnrujrqykzhizm"},
            people3)));
        System.out.println("[0,1,2,4] == " + Arrays.toString(sst.smallestSufficientTeam(new String[]{"uhppib","mgdipkgt","vaostwmycy","bjwxnfbbubpnd"}, people4)));
    }

    public void asteroidCollision() {
        AsteroidCollision ac = new AsteroidCollision();

        System.out.println("[5,10] == " + Arrays.toString(ac.asteroidCollision(new int[]{5,10,-5})));
        System.out.println("[] == " + Arrays.toString(ac.asteroidCollision(new int[]{8,-8})));
        System.out.println("[10] == " + Arrays.toString(ac.asteroidCollision(new int[]{10,2,-5})));
    }

    public void nonOverlappingIntervals() {
        NonOverlappingIntervals noi = new NonOverlappingIntervals();

        System.out.println("1 == " + noi.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        System.out.println("2 == " + noi.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
        System.out.println("0 == " + noi.eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
        System.out.println("4 == " + noi.eraseOverlapIntervals(new int[][]{{1,7},{2,6},{1,2},{6,8},{8,10},{7,10},{3,9},{11,12},{8,12}}));
    }

    public void numberOfLongestIncreasingSubsequence() {
        NumberOfLongestIncreasingSubsequence nolis = new NumberOfLongestIncreasingSubsequence();

        System.out.println("2 == " + nolis.findNumberOfLIS(new int[]{1,3,5,4,7}));
        System.out.println("5 == " + nolis.findNumberOfLIS(new int[]{2,2,2,2,2}));
        System.out.println("1 == " + nolis.findNumberOfLIS(new int[]{1}));
        System.out.println("2 == " + nolis.findNumberOfLIS(new int[]{6,1,2,3,11,12,13,14,7,8,9,10}));
        System.out.println("1 == " + nolis.findNumberOfLIS(new int[]{6,1,2,3,11,12,13,14,7,8,9,11,4,5,6,7,8,9,78,6,5,4,3,2,43,54,6,7,8,76,5,3,2,10}));
        System.out.println("5 == " + nolis.findNumberOfLIS(new int[]{5,4,3,2,1}));
    }

    public void knightProbabilityInChessboard() {
        KnightProbabilityInChessboard kpic = new KnightProbabilityInChessboard();

        System.out.println("0.06250 == " + kpic.knightProbability(3,2,0,0));
        System.out.println("1.00000 == " + kpic.knightProbability(1,0,0,0));
        System.out.println("0.00634 == " + kpic.knightProbability(17,76,8,8));
        System.out.println("0.00122 == " + kpic.knightProbability(25,100,0,0));
        System.out.println("0.08580 == " + kpic.knightProbability(8,10,4,3));
    }

    public void allPossibleFullBinaryTrees() {
        AllPossibleFullBinaryTrees alfbt = new AllPossibleFullBinaryTrees();

        System.out.println("1 == " + alfbt.allPossibleFBT(1).size());
        System.out.println("1 == " + alfbt.allPossibleFBT(3).size());
        System.out.println("42 == " + alfbt.allPossibleFBT(11).size());
    }

    public void linkedListComponents() {
        LinkedListComponents llc = new LinkedListComponents();

        System.out.println("2 == " + llc.numComponents(ListNode.makeChain(new int[]{0,1,2,3}), new int[]{0,1,3}));
        System.out.println("2 == " + llc.numComponents(ListNode.makeChain(new int[]{0,1,2,3,4}), new int[]{0,3,1,4}));
        System.out.println("2 == " + llc.numComponents(ListNode.makeChain(new int[]{0,1,2,3,4}), new int[]{0,3,1,4}));
        System.out.println("5 == " + llc.numComponents(ListNode.makeChain(new int[]{0,1,2,3,9,4,8,7,6,5,11,13,12,10}), new int[]{9,8,6,13,0}));
        System.out.println("2 == " + llc.numComponents(ListNode.makeChain(new int[]{0,1,2,3,9,4,8,7,6,5,11,13,12,10}), new int[]{5,6,7,8,9,11,2,3,1}));
    }

    public void countNumberOfWaysToPlaceHouses() {
        CountNumberOfWaysToPlaceHouses cnowtph = new CountNumberOfWaysToPlaceHouses();

        System.out.println("4 == " + cnowtph.countHousePlacements(1));
        System.out.println("9 == " + cnowtph.countHousePlacements(2));
        System.out.println("25 == " + cnowtph.countHousePlacements(3));
        System.out.println("64 == " + cnowtph.countHousePlacements(4));
        System.out.println("169 == " + cnowtph.countHousePlacements(5));
        System.out.println("441 == " + cnowtph.countHousePlacements(6));
        System.out.println("1156 == " + cnowtph.countHousePlacements(7));
    }

    public void hIndexII() {
        HIndexII hiii = new HIndexII();

        System.out.println("3 == " + hiii.hIndex(new int[]{0,1,3,5,6}));
        System.out.println("2 == " + hiii.hIndex(new int[]{1,2,100}));
        System.out.println("2 == " + hiii.hIndex(new int[]{0,1,2,4,6}));
        System.out.println("5 == " + hiii.hIndex(new int[]{0,0,0,1,1,1,2,3,6,7,8,9,10}));
        System.out.println("5 == " + hiii.hIndex(new int[]{4,5,6,7,8,9}));
        System.out.println("2 == " + hiii.hIndex(new int[]{0,0,0,0,1,2,3}));
    }

    public void maximumNumberOfEatenApples() {
        MaximumNumberOfEatenApples mnoea = new MaximumNumberOfEatenApples();

        System.out.println("7 == " + mnoea.eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}));
        System.out.println("5 == " + mnoea.eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}));
        System.out.println("4 == " + mnoea.eatenApples(new int[]{2,1,10}, new int[]{2,10,1}));
    }

    public void waysToSplitArrayIntoThreeSubarrays() {
        WaysToSplitArrayIntoThreeSubarrays wtsits = new WaysToSplitArrayIntoThreeSubarrays();

        System.out.println("1 == " + wtsits.waysToSplit(new int[]{1,1,1}));
        System.out.println("3 == " + wtsits.waysToSplit(new int[]{1,2,2,2,5,0}));
        System.out.println("0 == " + wtsits.waysToSplit(new int[]{3,2,1}));
        System.out.println("0 == " + wtsits.waysToSplit(new int[]{3,100,4,4}));
        System.out.println("7 == " + wtsits.waysToSplit(new int[]{5,3,3,0,0,0,0,0,0,3,3}));
        System.out.println("1 == " + wtsits.waysToSplit(new int[]{0,0,0}));
        System.out.println("80 == " + wtsits.waysToSplit(new int[]{5,4,3,2,1,0,0,0,0,10,5,0,0,0,1,2,3,4,9,8,7,6}));
    }

    public void minimumSpeedToArriveOnTime() {
        MinimumSpeedToArriveOnTime mstaot = new MinimumSpeedToArriveOnTime();

        System.out.println("1 == " + mstaot.minSpeedOnTime(new int[]{1,3,2}, 6));
        System.out.println("3 == " + mstaot.minSpeedOnTime(new int[]{1,3,2}, 2.7));
        System.out.println("-1 == " + mstaot.minSpeedOnTime(new int[]{1,3,2}, 1.9));
        System.out.println("10000000 == " + mstaot.minSpeedOnTime(new int[]{1,1,100000}, 2.01));
    }

    public void expressiveWords() {
        ExpressiveWords ew = new ExpressiveWords();

        System.out.println("1 == " + ew.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println("3 == " + ew.expressiveWords("zzzzzyyyyy", new String[]{"zzyy","zy","zyy"}));
        System.out.println("2 == " + ew.expressiveWords("aaaaaa", new String[]{"aaaa","a","aaaaaaa","aaaaab"}));
        System.out.println("0 == " + ew.expressiveWords("aaaa", new String[]{"ab"}));
    }

    public void predictTheWinner() {
        PredictTheWinner ptw = new PredictTheWinner();

        System.out.println("false == " + ptw.predictTheWinner(new int[]{1,5,2}));
        System.out.println("true == " + ptw.predictTheWinner(new int[]{1,5,233,7}));
    }

    public void minimumTimeToRepairCars() {
        MinimumTimeToRepairCars mttrc = new MinimumTimeToRepairCars();

        System.out.println("16 == " + mttrc.repairCars(new int[]{4,2,3,1}, 10));
        System.out.println("16 == " + mttrc.repairCars(new int[]{5,1,8}, 6));
        System.out.println("100000000000000 == " + mttrc.repairCars(new int[]{100}, 1000000));
    }

    public void strangePrinter() {
        StrangePrinter sp = new StrangePrinter();

        System.out.println("2 == " + sp.strangePrinter("aaabbb"));
        System.out.println("2 == " + sp.strangePrinter("aba"));
        System.out.println("2 == " + sp.strangePrinter("aaaaabaaaaaaaaaaaaa"));
        System.out.println("7 == " + sp.strangePrinter("aaadfsdfsdf"));
        System.out.println("4 == " + sp.strangePrinter("abcd"));
        System.out.println("3 == " + sp.strangePrinter("abab"));
        System.out.println("9 == " + sp.strangePrinter("aaaaaaaabbbbbbbbbbbbbaaaaaaammmmmnnnnnnooooooiiiiiiyyyyyyaaaaaaabbbbbbbnnnnmmmm"));
    }

    public void longestCommonSubsequence() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        System.out.println("3 == " + lcs.longestCommonSubsequence("abcde", "ace"));
        System.out.println("3 == " + lcs.longestCommonSubsequence("abc", "abc"));
        System.out.println("0 == " + lcs.longestCommonSubsequence("abc", "def"));
    }

    public void minimumASCIIDeleteSumForTwoStrings() {
        MinimumASCIIDeleteSumForTwoStrings madsfts = new MinimumASCIIDeleteSumForTwoStrings();

        System.out.println("231 == " + madsfts.minimumDeleteSum("sea","eat"));
        System.out.println("403 == " + madsfts.minimumDeleteSum("delete","leet"));
    }
}
