package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.april.AppendKIntegersWithMinimalSum;
import com.ss.leetcode.LC2023.april.ArrayWithElementsNotEqualToAverageOfNeighbors;
import com.ss.leetcode.LC2023.april.CalculateDelayedArrivalTime;
import com.ss.leetcode.LC2023.april.ChangeMinimumCharactersToSatisfyOneOfThreeConditions;
import com.ss.leetcode.LC2023.april.CheckIfThereIsAValidPathInAGrid;
import com.ss.leetcode.LC2023.april.ClosestNodesQueriesInABinarySearchTree;
import com.ss.leetcode.LC2023.april.ConvertAnArrayIntoA2DArrayWithConditions;
import com.ss.leetcode.LC2023.april.CourseSchedule;
import com.ss.leetcode.LC2023.april.CousinsInBinaryTreeII;
import com.ss.leetcode.LC2023.april.DestroyingAsteroids;
import com.ss.leetcode.LC2023.april.FindAllLonelyNumbersInTheArray;
import com.ss.leetcode.LC2023.april.FindTheLongestBalancedSubstringOfABinaryString;
import com.ss.leetcode.LC2023.april.FindTheSubstringWithMaximumCost;
import com.ss.leetcode.LC2023.april.FormSmallestNumberFromTwoDigitArrays;
import com.ss.leetcode.LC2023.april.MaximalNetworkRank;
import com.ss.leetcode.LC2023.april.MaximumDistanceBetweenAPairOfValues;
import com.ss.leetcode.LC2023.april.MaximumScoreFromRemovingStones;
import com.ss.leetcode.LC2023.april.MaximumSumObtainedOfAnyPermutation;
import com.ss.leetcode.LC2023.april.MinimizeMaximumOfArray;
import com.ss.leetcode.LC2023.april.MinimumMovesToReachTargetScore;
import com.ss.leetcode.LC2023.april.MinimumOperationsToMakeAUniValueGrid;
import com.ss.leetcode.LC2023.april.NumberOfEnclaves;
import com.ss.leetcode.LC2023.april.RearrangeSpacesBetweenWords;
import com.ss.leetcode.LC2023.april.RestoreTheArray;
import com.ss.leetcode.LC2023.april.SearchInRotatedSortedArray;
import com.ss.leetcode.LC2023.april.SellDiminishingValuedColoredBalls;
import com.ss.leetcode.LC2023.april.ShortestCycle;
import com.ss.leetcode.LC2023.april.SimplifyPath;
import com.ss.leetcode.shared.TreeNode;
import java.util.Arrays;
import java.util.List;

public class StartApril {
    public static void main(String[] args) {
        StartApril start = new StartApril();

//        start.formSmallestNumberFromTwoDigitArrays();
//        start.findTheSubstringWithMaximumCost();
//        start.shortestCycle();
//        start.sellDiminishingValuedColoredBalls();
//        start.maximumSumObtainedOfAnyPermutation();
//        start.minimizeMaximumOfArray();
//        start.rearrangeSpacesBetweenWords();
//        start.changeMinimumCharactersToSatisfyOneOfThreeConditions();
//        start.numberOfEnclaves();
//        start.maximumDistanceBetweenAPairOfValues();
//        start.destroyingAsteroids();
//        start.courseSchedule();
//        start.simplifyPath();
//        start.checkIfThereIsAValidPathInAGrid();
//        start.convertAnArrayIntoA2DArrayWithConditions();
//        start.maximumScoreFromRemovingStones();
//        start.arrayWithElementsNotEqualToAverageOfNeighbors();
//        start.findTheLongestBalancedSubstringOfABinaryString();
//        start.minimumMovesToReachTargetScore();
//        start.findAllLonelyNumbersInTheArray();
//        start.searchInRotatedSortedArray();
//        start.minimumOperationsToMakeAUniValueGrid();
//        start.restoreTheArray();
//        start.calculateDelayedArrivalTime();
//        start.cousinsInBinaryTreeII();
//        start.appendKIntegersWithMinimalSum();
//        start.maximalNetworkRank();
        start.closestNodesQueriesInABinarySearchTree();
    }

    public void formSmallestNumberFromTwoDigitArrays() {
        FormSmallestNumberFromTwoDigitArrays fsnftda = new FormSmallestNumberFromTwoDigitArrays();

        System.out.println("15 == " + fsnftda.minNumber(new int[]{4,1,3}, new int[]{5,7}));
        System.out.println("3 == " + fsnftda.minNumber(new int[]{3,5,2,6}, new int[]{3,1,7}));
    }

    public void findTheSubstringWithMaximumCost() {
        FindTheSubstringWithMaximumCost ftswmc = new FindTheSubstringWithMaximumCost();

        System.out.println("2 == " + ftswmc.maximumCostSubstring("adaa", "d", new int[]{-1000}));
        System.out.println("0 == " + ftswmc.maximumCostSubstring("abc", "abc", new int[]{-1,-1,-1}));
    }

    public void shortestCycle() {
        ShortestCycle ss = new ShortestCycle();

        System.out.println("3 == " + ss.findShortestCycle(7, new int[][]{{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}}));
        System.out.println("-1 == " + ss.findShortestCycle(4, new int[][]{{0,1},{0,2}}));
    }

    public void sellDiminishingValuedColoredBalls() {
        SellDiminishingValuedColoredBalls sdvcb = new SellDiminishingValuedColoredBalls();

        System.out.println("6 == " + sdvcb.maxProfit(new int[]{2,2}, 4));
        System.out.println("19 == " + sdvcb.maxProfit(new int[]{3,5}, 6));
        System.out.println("19 == " + sdvcb.maxProfit(new int[]{3,5}, 6));
        System.out.println("21 == " + sdvcb.maxProfit(new int[]{1000000000}, 1000000000));
        System.out.println("18 == " + sdvcb.maxProfit(new int[]{4,2,1,5,9,9,9,8,7,6,5,4}, 2));
        System.out.println("27 == " + sdvcb.maxProfit(new int[]{4,2,1,5,9,9,9,8,7,6,5,4}, 3));
        System.out.println("100 == " + sdvcb.maxProfit(new int[]{4,2,1,5,9,9,9,8,7,6,5,4}, 13));
        System.out.println("155 == " + sdvcb.maxProfit(new int[]{4,2,1,5,9,9,9,8,7,6,5,4}, 23));
    }

    public void maximumSumObtainedOfAnyPermutation() {
        MaximumSumObtainedOfAnyPermutation msooap = new MaximumSumObtainedOfAnyPermutation();

        System.out.println("19 == " + msooap.maxSumRangeQuery(new int[]{1,2,3,4,5}, new int[][]{{1,3}, {0,1}}));
        System.out.println("11 == " + msooap.maxSumRangeQuery(new int[]{1,2,3,4,5,6}, new int[][]{{0,1}}));
        System.out.println("47 == " + msooap.maxSumRangeQuery(new int[]{1,2,3,4,5,10}, new int[][]{{0,2},{1,3},{1,1}}));
    }

    public void minimizeMaximumOfArray() {
        MinimizeMaximumOfArray mmoa = new MinimizeMaximumOfArray();

        System.out.println("5 == " + mmoa.minimizeArrayValue(new int[]{3,7,1,6}));
        System.out.println("10 == " + mmoa.minimizeArrayValue(new int[]{10,1}));
    }

    public void rearrangeSpacesBetweenWords() {
        RearrangeSpacesBetweenWords rsbw = new RearrangeSpacesBetweenWords();

        System.out.println("this   is   a   sentence == " + rsbw.reorderSpaces("  this   is  a sentence "));
        System.out.println("practice   makes   perfect  == " + rsbw.reorderSpaces(" practice   makes   perfect"));
        System.out.println("john        == " + rsbw.reorderSpaces("   john     "));
        System.out.println("doe       == " + rsbw.reorderSpaces("doe      "));
        System.out.println("r        == " + rsbw.reorderSpaces("       r"));
    }

    public void changeMinimumCharactersToSatisfyOneOfThreeConditions() {
        ChangeMinimumCharactersToSatisfyOneOfThreeConditions cmctsoftc = new ChangeMinimumCharactersToSatisfyOneOfThreeConditions();

        System.out.println("2 == " + cmctsoftc.minCharacters("aba", "caa"));
        System.out.println("3 == " + cmctsoftc.minCharacters("dabadd", "cda"));
        System.out.println("0 == " + cmctsoftc.minCharacters("zzzzzzzz", "cda"));
        System.out.println("0 == " + cmctsoftc.minCharacters("a", "a"));
        System.out.println("33 == " + cmctsoftc.minCharacters("dsfgsdfsdfdsfsdfsdfsdfsdfsdfdffdfsd", "yujgujthdfgsdfsdfgrtgfdgdjguohniufvhwsydfigywekjdfnwaoidfmsmsufignfiweuhdus"));
        System.out.println("52 == " + cmctsoftc.minCharacters("zzzzzzaaaaaazzzzzaaaaaabcdefghjijlopqrstuwxxxyyyyzzz", "zzzzzzaaaaaazzzzzaaaaaabcdefghjijlopqrstuwxxxyyyyzzz"));
    }

    public void numberOfEnclaves() {
        NumberOfEnclaves noe = new NumberOfEnclaves();

        System.out.println("3 == " + noe.numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
        System.out.println("0 == " + noe.numEnclaves(new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}));
        System.out.println("5 == " + noe.numEnclaves(new int[][]{{0,0,0,0,1},{1,0,1,0,0},{0,1,1,1,0},{0,1,0,0,1},{1,0,0,1,0}}));
        System.out.println("0 == " + noe.numEnclaves(new int[][]{{1}}));
        System.out.println("1 == " + noe.numEnclaves(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println("0 == " + noe.numEnclaves(new int[][]{{0}}));
    }

    public void maximumDistanceBetweenAPairOfValues() {
        MaximumDistanceBetweenAPairOfValues mdbapov = new MaximumDistanceBetweenAPairOfValues();

        System.out.println("2 == " + mdbapov.maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));
        System.out.println("1 == " + mdbapov.maxDistance(new int[]{2,2,2}, new int[]{10,10,1}));
        System.out.println("2 == " + mdbapov.maxDistance(new int[]{30,29,19,5}, new int[]{25,25,25,25,25}));
        System.out.println("0 == " + mdbapov.maxDistance(new int[]{121,111,101,99,88,77,66,55,30,5,4,2}, new int[]{131,100,20,10,10,5}));
        System.out.println("4 == " + mdbapov.maxDistance(new int[]{121,111,101,99,88,77,66,55,30,5,4,2}, new int[]{151,141,131,100,20,10,10,5,5,5,4,4,3,3,2,2,1,1}));
        System.out.println("0 == " + mdbapov.maxDistance(new int[]{1}, new int[]{2}));
        System.out.println("6 == " + mdbapov.maxDistance(new int[]{3,3,3,3,3,3,3,3}, new int[]{4,4,4,4,4,4,4,1}));
    }

    public void destroyingAsteroids() {
        DestroyingAsteroids da = new DestroyingAsteroids();

        System.out.println("true == " + da.asteroidsDestroyed(10, new int[]{3,9,19,5,21}));
        System.out.println("false == " + da.asteroidsDestroyed(5, new int[]{4,9,23,4}));
        System.out.println("true == " + da.asteroidsDestroyed(5, new int[]{4,9,18,4,23,23,23,23,23,23,23}));
        System.out.println("true == " + da.asteroidsDestroyed(5, new int[]{5}));
        System.out.println("false == " + da.asteroidsDestroyed(5, new int[]{6}));
    }

    public void courseSchedule() {
        CourseSchedule cs = new CourseSchedule();

        System.out.println("true == " + cs.canFinish(2, new int[][]{{1,0}}));
        System.out.println("false == " + cs.canFinish(2, new int[][]{{1,0},{0,1}}));
        System.out.println("true == " + cs.canFinish(4, new int[0][0]));
    }

    public void simplifyPath() {
        SimplifyPath sp = new SimplifyPath();

        System.out.println("/home == " + sp.simplifyPath("/home/"));
        System.out.println("/ == " + sp.simplifyPath("/../"));
        System.out.println("/home/foo == " + sp.simplifyPath("/home//foo/"));
    }

    public void checkIfThereIsAValidPathInAGrid() {
        CheckIfThereIsAValidPathInAGrid citiavpiag = new CheckIfThereIsAValidPathInAGrid();

        System.out.println("true == " + citiavpiag.hasValidPath(new int[][]{{2,4,3},{6,5,2}}));
        System.out.println("false == " + citiavpiag.hasValidPath(new int[][]{{1,2,1},{1,2,1}}));
        System.out.println("false == " + citiavpiag.hasValidPath(new int[][]{{1,1,2}}));
        System.out.println("false == " + citiavpiag.hasValidPath(new int[][]{{2,4,3,3,1},{2,2,6,5,2}}));
        System.out.println("false == " + citiavpiag.hasValidPath(new int[][]{{1,1,1,5},{2,2,6,5,2}}));
        System.out.println("true == " + citiavpiag.hasValidPath(new int[][]{{1}}));
        System.out.println("true == " + citiavpiag.hasValidPath(new int[][]{{1}}));
        System.out.println("true == " + citiavpiag.hasValidPath(new int[][]{{3},{2},{2},{2},{6}}));
    }

    public void convertAnArrayIntoA2DArrayWithConditions() {
        ConvertAnArrayIntoA2DArrayWithConditions caaia2dawc = new ConvertAnArrayIntoA2DArrayWithConditions();

        System.out.println("[[1,3,4,2],[1,3],[1]] == " + caaia2dawc.findMatrix(new int[]{1,3,4,1,2,3,1}));
        System.out.println("[[4,3,2,1]] == " + caaia2dawc.findMatrix(new int[]{1,2,3,4}));
    }

    public void maximumScoreFromRemovingStones() {
        MaximumScoreFromRemovingStones msfrs = new MaximumScoreFromRemovingStones();

        System.out.println("6 == " + msfrs.maximumScore(2,4,6));
        System.out.println("7 == " + msfrs.maximumScore(4,4,6));
        System.out.println("9 == " + msfrs.maximumScore(1,8,8));
    }

    public void arrayWithElementsNotEqualToAverageOfNeighbors() {
        ArrayWithElementsNotEqualToAverageOfNeighbors awenetaon = new ArrayWithElementsNotEqualToAverageOfNeighbors();

        System.out.println("[5,2,1,4,3] == " + Arrays.toString(awenetaon.rearrangeArray(new int[]{1,2,3,4,5})));
        System.out.println("[0,2,6,7,9] == " + Arrays.toString(awenetaon.rearrangeArray(new int[]{6,2,0,9,7})));
    }

    public void findTheLongestBalancedSubstringOfABinaryString() {
        FindTheLongestBalancedSubstringOfABinaryString ftlbsoabs = new FindTheLongestBalancedSubstringOfABinaryString();

        System.out.println("6 == " + ftlbsoabs.findTheLongestBalancedSubstring("01000111"));
        System.out.println("4 == " + ftlbsoabs.findTheLongestBalancedSubstring("00111"));
        System.out.println("0 == " + ftlbsoabs.findTheLongestBalancedSubstring("111"));
    }

    public void minimumMovesToReachTargetScore() {
        MinimumMovesToReachTargetScore mmtrts = new MinimumMovesToReachTargetScore();

        System.out.println("4 == " + mmtrts.minMoves(5, 0));
        System.out.println("7 == " + mmtrts.minMoves(19, 2));
        System.out.println("4 == " + mmtrts.minMoves(10, 4));
    }

    public void findAllLonelyNumbersInTheArray() {
        FindAllLonelyNumbersInTheArray falnita = new FindAllLonelyNumbersInTheArray();

        System.out.println("[8,10] == " + falnita.findLonely(new int[]{10,6,5,8}));
        System.out.println("[1,5] == " + falnita.findLonely(new int[]{1,3,5,3}));
    }

    public void searchInRotatedSortedArray() {
        SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();

        System.out.println("4 == " + sirsa.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println("-1 == " + sirsa.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println("-1 == " + sirsa.search(new int[]{1}, 0));
        System.out.println("4 == " + sirsa.search(new int[]{4,5,6,7,8,1,2,3}, 8));
        System.out.println("1 == " + sirsa.search(new int[]{5,1,2,3,4}, 1));
    }

    public void minimumOperationsToMakeAUniValueGrid() {
        MinimumOperationsToMakeAUniValueGrid motmauvg = new MinimumOperationsToMakeAUniValueGrid();

        System.out.println("4 == " + motmauvg.minOperations(new int[][]{{2,4},{6,8}}, 2));
        System.out.println("5 == " + motmauvg.minOperations(new int[][]{{1,5},{2,3}}, 1));
        System.out.println("-1 == " + motmauvg.minOperations(new int[][]{{1,2},{3,4}}, 2));
        System.out.println("-1 == " + motmauvg.minOperations(new int[][]{{1,2},{3,4}}, 2));
        System.out.println("19 == " + motmauvg.minOperations(new int[][]{{1,1,1,1,3,3,5,5,5,9,7,9,7,7,7,7}}, 2));
        System.out.println("12 == " + motmauvg.minOperations(new int[][]{{1,10,19,28}}, 3));
        System.out.println("41 == " + motmauvg.minOperations(new int[][]{{1,2,3,4,5,6,7},{2,4,6,8,10,12,13}}, 1));
    }

    public void restoreTheArray() {
        RestoreTheArray rta = new RestoreTheArray();

        System.out.println("1 == " + rta.numberOfArrays("1000", 10000));
        System.out.println("0 == " + rta.numberOfArrays("1000", 10));
        System.out.println("8 == " + rta.numberOfArrays("1318", 2000));
        System.out.println("8 == " + rta.numberOfArrays("1318", 2000));
        System.out.println("0 == " + rta.numberOfArrays("34534543344234232304320342034202310231032400000000000", 17219));
        System.out.println("250769347 == " + rta.numberOfArrays("345345433442342323043203420342023102310324000", 17219));
    }

    public void calculateDelayedArrivalTime() {
        CalculateDelayedArrivalTime cdat = new CalculateDelayedArrivalTime();

        System.out.println("20 == " + cdat.findDelayedArrivalTime(15, 5));
        System.out.println("0 == " + cdat.findDelayedArrivalTime(13, 11));
    }

    public void cousinsInBinaryTreeII() {
        CousinsInBinaryTreeII cibtii = new CousinsInBinaryTreeII();

        TreeNode root1 = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(10)), new TreeNode(9, null, new TreeNode(7)));
        TreeNode root2 = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        TreeNode root3 = new TreeNode(3);

        System.out.println("[0,0,7,7,0, 11] == " + TreeNode.preOrder(cibtii.replaceValueInTree(root1)));
        System.out.println("[0,0,0] == " + TreeNode.preOrder(cibtii.replaceValueInTree(root2)));
        System.out.println("[0] == " + TreeNode.preOrder(cibtii.replaceValueInTree(root3)));

    }

    public void appendKIntegersWithMinimalSum() {
        AppendKIntegersWithMinimalSum akiwms = new AppendKIntegersWithMinimalSum();
        System.out.println("5 == " + akiwms.minimalKSum(new int[]{1,4,25,10,25}, 2));
        System.out.println("25 == " + akiwms.minimalKSum(new int[]{5,6}, 6));
        System.out.println("794 == " + akiwms.minimalKSum(new int[]{96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84}, 35));
    }

    public void maximalNetworkRank() {
        MaximalNetworkRank mnr = new MaximalNetworkRank();

        System.out.println("4 == " + mnr.maximalNetworkRank(4, new int[][]{{0,1},{0,3},{1,2},{1,3}}));
        System.out.println("5 == " + mnr.maximalNetworkRank(5, new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}}));
        System.out.println("5 == " + mnr.maximalNetworkRank(8, new int[][]{{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}}));
        System.out.println("43 == " + mnr.maximalNetworkRank(32, new int[][]{{3,31},{13,22},{30,26},{26,6},{21,4},{26,14},{17,6},{11,2},{20,14},{22,5},{13,9},{9,21},{6,3},{25,28},{7,19},{25,15},{0,20},{18,19},{8,26},{18,0},{24,27},{20,5},{9,19},{14,16},{30,2},{2,0},{15,10},{5,11},{28,30},{17,27},{27,0},{12,20},{25,21},{12,26},{27,4},{11,13},{14,22},{12,11},{31,22},{19,1},{28,26},{9,27},{12,1},{27,8},{21,23},{10,4},{16,7},{22,28},{10,5},{25,1},{3,25},{28,16},{9,14},{13,12},{19,25},{30,4},{21,0},{31,16},{10,14},{13,14},{17,20},{12,2},{21,24},{3,19},{18,28},{7,14},{6,27},{21,11},{19,4},{22,26},{29,4},{12,22},{20,23},{30,0},{6,23},{22,11},{1,27},{9,23},{29,31},{27,13},{0,31},{7,2},{10,27},{10,22},{21,10},{24,25},{14,6},{22,0},{24,30},{0,9},{4,7},{12,17},{21,30},{29,6},{7,3},{16,23},{16,19},{0,6},{24,22},{19,13},{4,0},{12,25},{16,15},{22,3},{1,11},{18,17},{19,28},{2,13},{6,15},{12,23},{12,7},{7,10},{23,4},{2,23},{11,24},{16,21},{8,23},{3,18},{20,18},{20,11},{22,2},{17,5},{12,15},{20,26},{18,16},{18,26},{16,27},{2,18},{9,26},{0,29},{2,26},{30,13},{15,22},{25,14},{3,26},{10,23},{2,15},{12,16},{8,24},{14,17},{30,9},{20,28},{25,4},{29,20},{28,4},{25,13},{28,6},{14,8},{20,1},{26,23},{19,20},{29,13},{27,21},{19,17},{10,20},{3,17},{23,1},{14,2},{9,6},{9,16},{2,24},{4,20},{5,9},{28,11},{17,26},{20,15},{29,8},{7,23},{24,28},{22,23},{20,13},{12,10},{12,8},{2,1},{25,2},{9,15},{30,19},{11,27},{11,30},{4,26},{13,10},{31,6},{5,28},{23,24},{18,29},{29,19},{19,26},{11,16},{27,2},{31,21},{3,2},{31,12},{15,18},{30,5},{27,15},{30,23},{4,17},{23,18},{18,14},{21,22},{22,17},{27,28},{14,19},{16,17},{4,12},{31,2},{4,15},{29,7},{5,12},{3,21},{24,18},{17,30},{27,14},{31,19},{9,4},{11,23},{10,0},{27,30},{31,9},{20,8},{18,30},{6,19},{18,21},{10,19},{24,16},{13,5},{16,10},{4,6},{1,15},{24,1},{30,10},{19,11},{20,30},{27,31},{26,11},{4,3},{24,17},{30,3},{26,5},{29,24},{5,4},{24,7},{10,3},{4,31},{16,3},{7,17},{5,6},{25,9},{13,24},{14,4},{27,7},{0,28},{1,10},{26,7},{12,28},{16,6},{16,0},{2,9},{24,31},{3,20},{12,30},{25,29},{17,2},{4,16},{26,16},{6,30},{3,14},{21,28},{1,5},{22,7},{0,8}}));
    }

    public void closestNodesQueriesInABinarySearchTree() {
        ClosestNodesQueriesInABinarySearchTree cnqiabst = new ClosestNodesQueriesInABinarySearchTree();

        TreeNode root1 = new TreeNode(6, new TreeNode(2, new TreeNode(1), new TreeNode(4)), new TreeNode(13, new TreeNode(9), new TreeNode(15, new TreeNode(14), null)));

        System.out.println("[[2,2],[4,6],[15,-1]] == " + cnqiabst.closestNodes(root1, List.of(2,5,16)));
        System.out.println("[[1,1],[2,2],[2,4],[4,4],[4,6],[6,6],[6,9],[6,9],[9,9],[9,13],[9,13],[9,13],[13,13],[14,14],[15,15],[15,-1]] == "
            + cnqiabst.closestNodes(root1, List.of(3,4,5,6,7,8,9,10,11,12,13,14,15,16)));
    }
}
