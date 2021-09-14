package com.ss.leetcode;

import com.ss.leetcode.september.ArithmeticSlicesIISubsequence;
import com.ss.leetcode.september.ArrayNesting;
import com.ss.leetcode.september.BestTimeBuySellStock;
import com.ss.leetcode.september.ClimbingStairs;
import com.ss.leetcode.september.Combinations;
import com.ss.leetcode.september.ComplementOfBase10Integer;
import com.ss.leetcode.september.ContainsDuplicate;
import com.ss.leetcode.september.CountSquareSumTriples;
import com.ss.leetcode.september.DeleteNodesAndReturnForest;
import com.ss.leetcode.september.DistributeCandies;
import com.ss.leetcode.september.ErectTheFence;
import com.ss.leetcode.september.FindAllGroupsOfFarmland;
import com.ss.leetcode.september.FindNearestPoint;
import com.ss.leetcode.september.FindTheDistanceBetweenTwoArrays;
import com.ss.leetcode.september.FindTheMiddleIndexInArray;
import com.ss.leetcode.september.FizzBuzz;
import com.ss.leetcode.september.GoatLatin;
import com.ss.leetcode.september.HouseRobber;
import com.ss.leetcode.september.IntersectionOfTwoArrays;
import com.ss.leetcode.september.KeyboardRow;
import com.ss.leetcode.september.KeysAndRooms;
import com.ss.leetcode.september.LargestPlusSign;
import com.ss.leetcode.september.LetterCasePermutation;
import com.ss.leetcode.september.LockingTree;
import com.ss.leetcode.september.LowestCommonAncestor;
import com.ss.leetcode.september.MaximumNumberOfBalloons;
import com.ss.leetcode.september.MaximumSubarray;
import com.ss.leetcode.september.MinimumCostToMoveChips;
import com.ss.leetcode.september.NumberComplement;
import com.ss.leetcode.september.NumberOfSubarraysSizeKAndAvg;
import com.ss.leetcode.september.PascalsTriangle;
import com.ss.leetcode.september.Permutations;
import com.ss.leetcode.september.PopulatingNextRightPointers;
import com.ss.leetcode.september.PowerOfTwo;
import com.ss.leetcode.september.PseudoPalindromicPathsBT;
import com.ss.leetcode.september.ReformatPhoneNumber;
import com.ss.leetcode.september.ReshapeTheMatrix;
import com.ss.leetcode.september.ReverseBits;
import com.ss.leetcode.september.ReverseOnlyLetters;
import com.ss.leetcode.september.SameTree;
import com.ss.leetcode.september.SearchA2DMatrix;
import com.ss.leetcode.september.SingleNumber;
import com.ss.leetcode.september.SlowestKey;
import com.ss.leetcode.september.SmallestRangeI;
import com.ss.leetcode.september.SortCharactersByFrequency;
import com.ss.leetcode.september.ToeplitzMatrix;
import com.ss.leetcode.september.UniqueBinarySearchTreesII;
import com.ss.leetcode.september.ValidAnagram;
import com.ss.leetcode.september.WordSearch;
import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class StartSeptember {

    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();

//        start.arrayNesting();
//        start.populatingNextRightPointers();
//        start.singleNumber();
//        start.reverseBits();
//        start.minimumCostToMoveChips();
//        start.uniqueBinarySearchTreesII();
//        start.deleteNodesAndReturnForest();
//        start.maximumSubarray();
//        start.letterCasePermutation();
//        start.lowestCommonAncestor();
//        start.wordSearch();
//        start.erectTheFence();
//        start.sameTree();
//        start.findNearestPoint();
//        start.findTheMiddleIndexInArray();
//        start.findAllGroupsOfFarmland();
//        start.operationsOnTree();
//        start.goatLatin();
//        start.slowestKey();
//        start.fizzBuzz();
//        start.intersectionOfTwoArrays();
//        start.keysAndRooms();
//        start.distributeCandies();
//        start.findTheDistanceBetweenTwoArrays();
//        start.combinations();
//        start.permutations();
//        start.keyboardRow();
//        start.largestPlusSign();
//        start.climbingStairs();
//        start.houseRobber();
//        start.sortCharactersByFrequency();
//        start.powerOfTwo();
//        start.smallestRangeI();
//        start.toeplitzMatrix();
//        start.arithmeticSlicesIISubsequence();
//        start.countSquareSumTriples();
//        start.leafSimilarTrees();
//        start.pseudoPalindromicPathsBT();
//        start.bestTimeBuySellStock();
//        start.containsDuplicate();
//        start.reshapeTheMatrix();
//        start.pascalsTriangle();
//        start.searchA2DMatrix();
//        start.validAnagram();
//        start.maximumNumberOfBalloons();
//        start.numberOfSubarraysSizeKAndAvg();
//        start.reverseOnlyLetters();
//        start.numberComplement();
//        start.complementOfBase10Integer();
        start.reformatPhoneNumber();
    }

    public void arrayNesting() {
        ArrayNesting an = new ArrayNesting();

        System.out.println("4 == " + an.arrayNesting(new int[]{5,4,0,3,1,6,2}));
//        System.out.println("1 == " + an.arrayNesting(new int[]{0,1,2}));
    }

    public void populatingNextRightPointers() {
        PopulatingNextRightPointers pnrp = new PopulatingNextRightPointers();

        PopulatingNextRightPointers.Node root1 = new PopulatingNextRightPointers.Node(1,
            new PopulatingNextRightPointers.Node(2, new PopulatingNextRightPointers.Node(4), new PopulatingNextRightPointers.Node(5)),
            new PopulatingNextRightPointers.Node(3, new PopulatingNextRightPointers.Node(6), new PopulatingNextRightPointers.Node(7)));

        PopulatingNextRightPointers.Node root2 = null;

        pnrp.connect(root1);
        pnrp.connect(root2);

        System.out.println("true == " + (root1.left.next == root1.right));
        System.out.println("null == " + root2);
    }

    public void singleNumber() {
        SingleNumber sn = new SingleNumber();

        System.out.println("1 == " + sn.singleNumber(new int[]{2,2,1}));
        System.out.println("4 == " + sn.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println("1 == " + sn.singleNumber(new int[]{1}));
    }

    public void reverseBits() {
        ReverseBits rb = new ReverseBits();

        System.out.println("964176192 == " + rb.reverseBits(Integer.parseUnsignedInt("00000010100101000001111010011100", 2)));
        System.out.println("-1073741825 == " + rb.reverseBits(Integer.parseUnsignedInt("11111111111111111111111111111101", 2)));

    }

    public void minimumCostToMoveChips() {
        MinimumCostToMoveChips mctmc = new MinimumCostToMoveChips();

        System.out.println("1 == " + mctmc.minCostToMoveChips(new int[]{1,2,3}));
        System.out.println("2 == " + mctmc.minCostToMoveChips(new int[]{2,2,2,3,3}));
        System.out.println("1 == " + mctmc.minCostToMoveChips(new int[]{1,1000000000}));
    }

    public void uniqueBinarySearchTreesII() {
        UniqueBinarySearchTreesII ubstii = new UniqueBinarySearchTreesII();

        System.out.println("5 == " + ubstii.generateTrees(3).size());
        System.out.println("1 == " + ubstii.generateTrees(1).size());
    }

    public void deleteNodesAndReturnForest() {
        DeleteNodesAndReturnForest dnarf = new DeleteNodesAndReturnForest();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(4));
        TreeNode root3 = new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)));

        StringBuilder stb = new StringBuilder();
        StringBuilder stb2 = new StringBuilder();
        StringBuilder stb3 = new StringBuilder();
        dnarf.delNodes(root1, new int[]{3,5}).forEach(head -> stb.append(TreeNode.extractValues(head)));
        dnarf.delNodes(root2, new int[]{3}).forEach(head -> stb2.append(TreeNode.extractValues(head)));
        dnarf.delNodes(root3, new int[]{2,1}).forEach(head -> stb3.append(TreeNode.extractValues(head)));

        System.out.println("[[1,2,4],[6],[7]] == " + stb);
        System.out.println("[[1,2,4]] == " + stb2);
        System.out.println("[[3,4]] == " + stb3);
    }

    public void maximumSubarray() {
        MaximumSubarray ms = new MaximumSubarray();

        System.out.println("6 == " + ms.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("1 == " + ms.maxSubArray(new int[]{1}));
        System.out.println("23 == " + ms.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println("-1 == " + ms.maxSubArray(new int[]{-2, -3, -1}));
    }

    public void letterCasePermutation() {
        LetterCasePermutation lcp = new LetterCasePermutation();

        System.out.println("[a1b2, a1B2 , A1b2, A1B2] == " + lcp.letterCasePermutation("a1b2"));
        System.out.println("[3z4, 3Z4] == " + lcp.letterCasePermutation("3z4"));
        System.out.println("[12345] == " + lcp.letterCasePermutation("12345"));
        System.out.println("[0] == " + lcp.letterCasePermutation("0"));
    }

    public void lowestCommonAncestor() {
        LowestCommonAncestor lca = new LowestCommonAncestor();

        TreeNode root1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                                      new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(0, new TreeNode(1, null, new TreeNode(2)),new TreeNode(3));

        System.out.println("[2,7,4] == " + TreeNode.extractValues(lca.lcaDeepestLeaves(root1)));
        System.out.println("[1] == " + TreeNode.extractValues(lca.lcaDeepestLeaves(root2)));
        System.out.println("[2] == " + TreeNode.extractValues(lca.lcaDeepestLeaves(root3)));

    }

    public void wordSearch() {
        WordSearch ws = new WordSearch();

        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};

        System.out.println("true == " + ws.exist(board, "ABCCED"));
        System.out.println("true == " + ws.exist(board, "SEE"));
        System.out.println("false == " + ws.exist(board, "ABCB"));
    }

    public void erectTheFence() {
        ErectTheFence etf = new ErectTheFence();

        System.out.println("[[1,1],[2,0],[3,3],[2,4],[4,2]] == " + Arrays.deepToString(etf.outerTrees(new int[][]{{1,1}, {2,2}, {2,0}, {2,4}, {3,3}, {4,2}})));
        System.out.println("[[4,2],[2,2],[1,2]] == " + Arrays.deepToString(etf.outerTrees(new int[][]{{1,2}, {2,2}, {4,2}})));
    }

    public void sameTree() {
        SameTree st = new SameTree();

        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root3 = new TreeNode(1, new TreeNode(2), null);
        TreeNode root4 = new TreeNode(1, null, new TreeNode(2));
        TreeNode root5 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root6 = new TreeNode(1, new TreeNode(1), new TreeNode(2));

        System.out.println("true == " + st.isSameTree(root1, root2));
        System.out.println("false == " + st.isSameTree(root3, root4));
        System.out.println("false == " + st.isSameTree(root5, root6));
    }

    public void findNearestPoint() {
        FindNearestPoint fnp = new FindNearestPoint();

        System.out.println("2 == " +  fnp.nearestValidPoint(3,4, new int[][]{{1,2}, {3,1}, {2,4}, {2,3}, {4,4}}));
        System.out.println("0 == " +  fnp.nearestValidPoint(3,4, new int[][]{{3,4}}));
        System.out.println("-1 == " +  fnp.nearestValidPoint(3,4, new int[][]{{2,3}}));
    }

    public void findTheMiddleIndexInArray() {
        FindTheMiddleIndexInArray ftmiia = new FindTheMiddleIndexInArray();

        System.out.println("3 == " + ftmiia.findMiddleIndex(new int[]{2,3,-1,8,4}));
        System.out.println("2 == " + ftmiia.findMiddleIndex(new int[]{1,-1,4}));
        System.out.println("2 == " + ftmiia.findMiddleIndex(new int[]{1,-1,4}));
        System.out.println("-1 == " + ftmiia.findMiddleIndex(new int[]{2,5}));
        System.out.println("0 == " + ftmiia.findMiddleIndex(new int[]{1}));
        System.out.println("0 == " + ftmiia.findMiddleIndex(new int[]{4,0}));
        System.out.println("1 == " + ftmiia.findMiddleIndex(new int[]{3,2,-1,-4,8}));
    }

    public void findAllGroupsOfFarmland() {
        FindAllGroupsOfFarmland fagof = new FindAllGroupsOfFarmland();

        int[][] land1 = {{1,0,0}, {0,1,1}, {0,1,1}};
        int[][] land2 = {{1,1}, {1,1}};
        int[][] land3 = {{0}};

        System.out.println("[[0,0,0,0],[1,1,2,2]] == " + Arrays.deepToString(fagof.findFarmland(land1)));
        System.out.println("[[0,0,1,1]] == " + Arrays.deepToString(fagof.findFarmland(land2)));
        System.out.println("[[]] == " + Arrays.deepToString(fagof.findFarmland(land3)));
    }

    public void operationsOnTree() {
        LockingTree lt = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});

        System.out.println("true == " + lt.lock(2,2));
        System.out.println("false == " + lt.unlock(2,3));
        System.out.println("true == " + lt.unlock(2,2));
        System.out.println("true == " + lt.lock(4,5));
        System.out.println("true == " + lt.upgrade(0,1));
        System.out.println("false == " + lt.lock(0,1));


        LockingTree lt2 = new LockingTree(new int[]{-1,0,3,1,0});
        System.out.println("false == " + lt2.upgrade(4,5));
        System.out.println("false == " + lt2.upgrade(3,8));
        System.out.println("false == " + lt2.unlock(0,7));
        System.out.println("true == " + lt2.lock(2,7));
        System.out.println("false == " + lt2.upgrade(4,6));
    }

    public void goatLatin() {
        GoatLatin gl = new GoatLatin();

        System.out.println("Imaa peaksmaa oatGmaaaa atinLmaaaaa == " + gl.toGoatLatin("I speak Goat Latin"));
        System.out.println("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa == "
                                            + gl.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public void slowestKey() {
        SlowestKey sl = new SlowestKey();

        System.out.println("c == " + sl.slowestKey(new int[]{9,29,49,50}, "cbcd"));
        System.out.println("a == " + sl.slowestKey(new int[]{12,23,36,46,62}, "spuda"));
    }

    public void fizzBuzz() {
        FizzBuzz fb = new FizzBuzz();

        System.out.println("[1,2,Fizz] == " + fb.fizzBuzz(3));
        System.out.println("[1,2,Fizz,4,Buzz] == " + fb.fizzBuzz(5));
        System.out.println("[1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz] == " + fb.fizzBuzz(15));
    }

    public void intersectionOfTwoArrays() {
        IntersectionOfTwoArrays iota = new IntersectionOfTwoArrays();

        System.out.println("[2] == " + Arrays.toString(iota.intersection(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println("[9,4] == " + Arrays.toString(iota.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public void keysAndRooms() {
        KeysAndRooms kar = new KeysAndRooms();

        System.out.println("true == " + kar.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), Collections.emptyList())));
        System.out.println("false == " + kar.canVisitAllRooms(List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(0))));
        System.out.println("true == " + kar.canVisitAllRooms(List.of(List.of(2), Collections.emptyList(), List.of(1))));
    }

    public void distributeCandies() {
        DistributeCandies dc = new DistributeCandies();

        System.out.println("3 == " + dc.distributeCandies(new int[]{1,1,2,2,3,3}));
        System.out.println("2 == " + dc.distributeCandies(new int[]{1,1,2,3}));
        System.out.println("1 == " + dc.distributeCandies(new int[]{6,6,6,6}));
    }

    public void findTheDistanceBetweenTwoArrays() {
        FindTheDistanceBetweenTwoArrays ftdbta = new FindTheDistanceBetweenTwoArrays();

        System.out.println("2 == " + ftdbta.findTheDistanceValue(new int[]{4,5,8}, new int[]{10,9,1,8}, 2));
        System.out.println("2 == " + ftdbta.findTheDistanceValue(new int[]{1,4,2,3}, new int[]{1-4,-3,6,10,20,30}, 3));
        System.out.println("1 == " + ftdbta.findTheDistanceValue(new int[]{2,1,100,3}, new int[]{-5,-2,10,-3,7}, 6));
        System.out.println("1 == " + ftdbta.findTheDistanceValue(new int[]{-3,-3,4,-1,-10}, new int[]{7,10}, 12));
        System.out.println("4 == " + ftdbta.findTheDistanceValue(
            new int[]{199,551,-487,704,399,-86,620,763,656,751,993,-656,116, -269,5,-140,752,-751,575,-573,168,800,-216,
                -581,-419,660,-779,851,653,-951,-759,165,530,-973,116,-393,976, 380,558,483,993,329,-721,-847},
            new int[]{24,-235,172,649,-363,-105,30,387,-270,553,82,-338,-999,-747,-95,470,-80,-283,-376,104,-183,-305,
                603,497,399,170,8,-769,326,879,-227,-217,-583,140,-993,-432,301,225,479,805,512,698,491,46,-593,890,-55,230,709},
            66));
    }

    public void combinations() {
        Combinations c = new Combinations();

        System.out.println("[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]] == " + c.combine(4, 2));
        System.out.println("[[1]] == " + c.combine(1, 1));
    }

    public void permutations() {
        Permutations p = new Permutations();

        System.out.println("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] == " + p.permute(new int[]{1,2,3}));
        System.out.println("[[1,0],[0,1]] == " + p.permute(new int[]{0,1}));
        System.out.println("[[1]] == " + p.permute(new int[]{1}));
    }

    public void keyboardRow() {
        KeyboardRow kr = new KeyboardRow();

        System.out.println("[Alaska, Dad] == " + Arrays.toString(kr.findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
        System.out.println("[] == " + Arrays.toString(kr.findWords(new String[]{"omk"})));
        System.out.println("[adsdf, sfd] == " + Arrays.toString(kr.findWords(new String[]{"adsdf","sfd"})));
    }

    public void largestPlusSign() {
        LargestPlusSign lps = new LargestPlusSign();

        System.out.println("2 == " + lps.orderOfLargestPlusSign(5, new int[][]{{4,2}}));
        System.out.println("1 == " + lps.orderOfLargestPlusSign(1, new int[][]{{0,0}}));
        System.out.println("2 == " + lps.orderOfLargestPlusSign(3, new int[][]{{0,0}}));
        System.out.println("1 == " + lps.orderOfLargestPlusSign(3, new int[][]{{0,0}, {0,1}, {1,0}}));
        System.out.println("4 == " + lps.orderOfLargestPlusSign(10, new int[][]{{1,2}, {1,8}, {2,4}, {4,7}, {5,0}, {5,6}, {6,4}, {6,9}}));
    }

    public void climbingStairs() {
        ClimbingStairs cs = new ClimbingStairs();

        System.out.println("2 == " + cs.climbStairs(2));
        System.out.println("3 == " + cs.climbStairs(3));
        System.out.println("5 == " + cs.climbStairs(4));
        System.out.println("8 == " + cs.climbStairs(5));
    }

    public void houseRobber() {
        HouseRobber hr = new HouseRobber();

        System.out.println("4 == " + hr.rob(new int[]{1,2,3,1}));
        System.out.println("12 == " + hr.rob(new int[]{2,7,9,3,1}));
        System.out.println("4 == " + hr.rob(new int[]{2,1,1,2}));
    }

    public void sortCharactersByFrequency() {
        SortCharactersByFrequency scbf = new SortCharactersByFrequency();

        System.out.println("eert == " + scbf.frequencySort("tree"));
        System.out.println("aaaccc == " + scbf.frequencySort("cccaaa"));
        System.out.println("bbAa == " + scbf.frequencySort("Aabb"));
    }

    public void powerOfTwo() {
        PowerOfTwo pot = new PowerOfTwo();

        System.out.println("true == " + pot.isPowerOfTwo(1));
        System.out.println("true == " + pot.isPowerOfTwo(16));
        System.out.println("false == " + pot.isPowerOfTwo(3));
        System.out.println("true == " + pot.isPowerOfTwo(4));
        System.out.println("false == " + pot.isPowerOfTwo(5));
    }

    public void smallestRangeI() {
        SmallestRangeI sri = new SmallestRangeI();

        System.out.println("0 == " + sri.smallestRangeI(new int[]{1}, 0));
        System.out.println("6 == " + sri.smallestRangeI(new int[]{0,10}, 2));
        System.out.println("0 == " + sri.smallestRangeI(new int[]{1,3,6}, 3));
    }

    public void toeplitzMatrix() {
        ToeplitzMatrix tm = new ToeplitzMatrix();

        System.out.println("true == " + tm.isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
        System.out.println("false == " + tm.isToeplitzMatrix(new int[][]{{1,2},{2,2}}));
    }

    public void arithmeticSlicesIISubsequence() {
        ArithmeticSlicesIISubsequence asiis = new ArithmeticSlicesIISubsequence();

        System.out.println("7 == " + asiis.numberOfArithmeticSlices(new int[]{2,4,6,8,10}));
        System.out.println("16 == " + asiis.numberOfArithmeticSlices(new int[]{7,7,7,7,7}));
        System.out.println("4 == " + asiis.numberOfArithmeticSlices(new int[]{0,1,2,2,2}));
        System.out.println("6 == " + asiis.numberOfArithmeticSlices(new int[]{0,1,2,2,3}));
        System.out.println("10 == " + asiis.numberOfArithmeticSlices(new int[]{0,1,2,2,3,3}));
        System.out.println("2096920 == " + asiis.numberOfArithmeticSlices(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
        System.out.println("989 == " + asiis.numberOfArithmeticSlices(new int[]{27,39,87,44,82,24,22,18,59,89,23,96,42,10,10,53,65,44,21,90,75,78,67,98,97,49,55,76,96,78,51,45,40,21,63,99,76,59,54,70,8,87,40,2,60,81,46,47,50,7,57,67,78,95,44,5,18,81,9,0,9,62,45,38,34,96,55,49,56,21,93,19,60,9,7,47,39,42,37,13,31,60,94,93,5,68,11,24,87,4,57,33,70,64,19,48,32,25,95,75}));
        System.out.println("921 == " + asiis.numberOfArithmeticSlices(new int[]{76,24,36,86,89,21,54,15,94,58,35,55,1,99,37,79,24,81,63,16,10,56,47,44,39,87,0,48,34,39,73,80,98,91,10,20,81,77,2,50,2,54,43,88,92,83,78,49,77,54,92,30,0,26,69,84,19,82,35,29,48,4,15,29,72,41,41,33,19,44,8,32,20,34,61,78,99,12,21,70,71,28,20,52,6,78,13,77,54,94,30,96,90,86,28,35,96,73,97,50}));
        System.out.println("1025 == " + asiis.numberOfArithmeticSlices(new int[]{95,73,69,50,69,44,68,62,60,56,97,31,88,61,30,66,24,56,28,25,73,99,99,24,45,92,21,31,31,65,84,39,82,48,86,97,14,12,41,59,22,61,6,71,4,44,83,47,35,47,29,93,68,84,71,61,93,53,55,9,79,26,36,47,12,29,87,71,45,39,97,92,34,7,28,66,21,38,98,37,45,86,12,52,46,95,39,14,43,59,51,20,16,68,45,59,49,94,93,98}));
        System.out.println("1086 == " + asiis.numberOfArithmeticSlices(new int[]{46,4,8,89,90,65,13,21,44,78,29,3,72,60,27,18,55,52,78,22,29,99,56,82,68,62,43,33,18,24,70,76,87,53,71,92,36,86,4,62,62,39,32,9,18,96,67,24,34,56,89,48,14,45,11,97,92,59,1,12,85,6,79,45,43,12,52,65,57,36,63,57,43,65,44,10,46,56,68,70,10,56,26,37,12,7,74,58,49,45,63,74,91,72,94,76,80,60,86,99}));
        System.out.println("897 == " + asiis.numberOfArithmeticSlices(new int[]{45,29,81,66,20,59,97,45,29,57,84,24,42,58,95,49,98,23,49,40,75,46,41,48,62,38,66,29,66,11,59,12,23,48,30,83,33,91,75,19,63,1,0,55,96,94,3,68,70,4,50,45,38,2,45,40,92,13,42,13,99,92,29,98,65,91,57,43,8,75,11,46,59,72,78,80,97,1,88,41,30,21,10,50,85,23,97,77,24,10,96,93,23,87,55,37,98,95,96,74}));
        System.out.println("895 == " + asiis.numberOfArithmeticSlices(new int[]{53,5,54,22,36,29,35,30,62,60,70,91,21,75,3,15,26,32,81,15,11,76,70,84,22,83,74,36,79,42,15,3,72,70,62,7,71,22,67,3,76,38,1,81,20,6,56,37,80,97,88,14,77,59,68,86,70,47,4,29,87,9,60,88,94,58,81,65,42,9,53,29,93,65,60,84,16,67,91,43,0,41,64,19,61,94,0,5,95,49,18,22,2,24,52,64,41,43,29,63}));
        System.out.println("1040 == " + asiis.numberOfArithmeticSlices(new int[]{26,75,77,3,92,97,42,3,17,12,16,28,32,79,41,28,92,70,60,26,45,60,67,1,40,56,8,38,77,89,6,92,98,72,99,84,70,51,61,75,74,71,23,30,31,82,43,19,39,8,43,3,64,4,74,18,81,44,20,14,98,73,4,54,84,34,23,67,93,76,36,67,58,1,42,56,32,49,78,92,92,36,83,67,38,36,53,91,66,1,61,55,52,9,49,3,40,40,30,87}));
        System.out.println("1045 == " + asiis.numberOfArithmeticSlices(new int[]{79,28,50,78,72,82,12,82,0,18,63,13,27,47,99,38,92,81,83,85,65,40,0,43,18,22,36,87,44,46,93,26,50,98,90,22,58,39,49,39,4,68,50,96,73,20,22,54,17,10,31,66,87,90,89,94,59,8,55,76,28,25,56,40,72,61,36,36,35,45,69,3,44,89,35,47,5,82,12,85,63,87,24,23,81,30,7,43,14,33,28,10,20,87,89,36,18,38,40,69}));
        System.out.println("1030 == " + asiis.numberOfArithmeticSlices(new int[]{79,20,64,28,67,81,60,58,97,85,92,96,82,89,46,50,15,2,36,44,54,2,90,37,7,79,26,40,34,67,64,28,60,89,46,31,9,95,43,19,47,64,48,95,80,31,47,19,72,99,28,46,13,9,64,4,68,74,50,28,69,94,93,3,80,78,23,80,43,49,77,18,68,28,13,61,34,44,80,70,55,85,0,37,93,40,47,47,45,23,26,74,45,67,34,20,33,71,48,96}));
        System.out.println("911 == " + asiis.numberOfArithmeticSlices(new int[]{88,31,44,91,68,40,3,6,34,50,26,45,95,9,42,98,5,27,42,31,63,90,76,0,21,44,81,65,84,18,47,55,85,2,74,19,47,29,75,36,78,25,0,24,27,97,52,65,74,0,92,39,27,37,75,44,61,42,48,72,16,26,84,81,82,22,86,56,35,58,73,49,36,33,87,38,81,68,84,64,68,69,26,29,95,36,82,11,54,35,94,65,12,56,98,21,34,16,28,91}));
    }

    public void countSquareSumTriples() {
        CountSquareSumTriples csst = new CountSquareSumTriples();

        System.out.println("2 == " + csst.countTriples(5));
        System.out.println("4 == " + csst.countTriples(10));
        System.out.println("16 == " + csst.countTriples(25));
        System.out.println("104 == " + csst.countTriples(100));
    }

    public void leafSimilarTrees() {
        LeafSimilarTrees lst = new LeafSimilarTrees();

        TreeNode root1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                                      new TreeNode(1, new TreeNode(9), new TreeNode(8)));
        TreeNode root2 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(7)),
                                      new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))));
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(2);
        TreeNode root6 = new TreeNode(1, new TreeNode(2), null);
        TreeNode root7 = new TreeNode(2, null, new TreeNode(2));
        TreeNode root8 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root9 = new TreeNode(1, new TreeNode(3), new TreeNode(2));

        System.out.println("true == " + lst.leafSimilar(root1, root2));
        System.out.println("true == " + lst.leafSimilar(root3, root4));
        System.out.println("false == " + lst.leafSimilar(root3, root5));
        System.out.println("true == " + lst.leafSimilar(root6, root7));
        System.out.println("false == " + lst.leafSimilar(root8, root9));
    }

    public void pseudoPalindromicPathsBT() {
        PseudoPalindromicPathsBT pppbt = new PseudoPalindromicPathsBT();

        TreeNode root1 = new TreeNode(2, new TreeNode(3, new TreeNode(3), new TreeNode(1)), new TreeNode(1, null, new TreeNode(1)));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, new TreeNode(1), new TreeNode(3, null, new TreeNode(1))), new TreeNode(1));
        TreeNode root3 = new TreeNode(9);

        System.out.println("2 == " + pppbt.pseudoPalindromicPaths(root1));
        System.out.println("1 == " + pppbt.pseudoPalindromicPaths(root2));
        System.out.println("1 == " + pppbt.pseudoPalindromicPaths(root3));
    }

    public void bestTimeBuySellStock() {
        BestTimeBuySellStock btbss = new BestTimeBuySellStock();

        System.out.println("5 == " + btbss.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("0 == " + btbss.maxProfit(new int[]{7,6,4,3,1}));
    }

    public void containsDuplicate() {
        ContainsDuplicate cd = new ContainsDuplicate();

        System.out.println("true == " + cd.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println("false == " + cd.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println("true == " + cd.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public void reshapeTheMatrix() {
        ReshapeTheMatrix rtm = new ReshapeTheMatrix();

        System.out.println("[[1,2,3,4]] == " + Arrays.deepToString(rtm.matrixReshape(new int[][]{{1,2},{3,4}}, 1, 4)));
        System.out.println("[[1,2],[3,4]] == " + Arrays.deepToString(rtm.matrixReshape(new int[][]{{1,2},{3,4}}, 2, 4)));
        System.out.println("[[1,2,3],[4,5,6],[7,8,9]] == " + Arrays.deepToString(rtm.matrixReshape(new int[][]{{1,2,3,4,5,6,7,8,9}}, 3, 3)));
    }

    public void pascalsTriangle() {
        PascalsTriangle pt = new PascalsTriangle();

        System.out.println("[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]] == " + pt.generate(5));
        System.out.println("[[1]] == " + pt.generate(1));
    }

    public void searchA2DMatrix() {
        SearchA2DMatrix sa2dm = new SearchA2DMatrix();

        System.out.println("true == " + sa2dm.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3));
        System.out.println("false == " + sa2dm.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 13));
        System.out.println("true == " + sa2dm.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}}, 20));
        System.out.println("false == " + sa2dm.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}}, 17));
        System.out.println("false == " + sa2dm.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}}, 24));
        System.out.println("true == " + sa2dm.searchMatrix(new int[][]{{1,3,5,7}}, 3));
        System.out.println("false == " + sa2dm.searchMatrix(new int[][]{{1,3,5,7}}, 12));
    }

    public void validAnagram() {
        ValidAnagram va = new ValidAnagram();

        System.out.println("true == " + va.isAnagram("anagram", "nagaram"));
        System.out.println("false == " + va.isAnagram("rat", "car"));
        System.out.println("false == " + va.isAnagram("ratc", "car"));
    }

    public void maximumNumberOfBalloons() {
        MaximumNumberOfBalloons mnob = new MaximumNumberOfBalloons();

        System.out.println("1 == " + mnob.maxNumberOfBalloons("nlaebolko"));
        System.out.println("2 == " + mnob.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println("0 == " + mnob.maxNumberOfBalloons("leetcode"));
    }

    public void numberOfSubarraysSizeKAndAvg() {
        NumberOfSubarraysSizeKAndAvg nosska = new NumberOfSubarraysSizeKAndAvg();

        System.out.println("3 == " + nosska.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4));
        System.out.println("5 == " + nosska.numOfSubarrays(new int[]{1,1,1,1,1}, 1, 0));
        System.out.println("6 == " + nosska.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3, 5));
        System.out.println("1 == " + nosska.numOfSubarrays(new int[]{7,7,7,7,7,7,7}, 7, 7));
        System.out.println("1 == " + nosska.numOfSubarrays(new int[]{4,4,4,4}, 4, 1));
    }

    public void reverseOnlyLetters() {
        ReverseOnlyLetters rol = new ReverseOnlyLetters();

        System.out.println("dc-ba == " + rol.reverseOnlyLetters("ab-cd"));
        System.out.println("j-Ih-gfE-dCba == " + rol.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println("Qedo1ct-eeLg=ntse-T! == " + rol.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public void numberComplement() {
        NumberComplement nc = new NumberComplement();

        System.out.println("2 == " + nc.findComplement(5));
        System.out.println("0 == " + nc.findComplement(1));
    }

    public void complementOfBase10Integer() {
        ComplementOfBase10Integer cob10i = new ComplementOfBase10Integer();

        System.out.println("2 == " + cob10i.bitwiseComplement(5));
        System.out.println("0 == " + cob10i.bitwiseComplement(7));
        System.out.println("5 == " + cob10i.bitwiseComplement(10));
    }

    public void reformatPhoneNumber() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        System.out.println("123-45-67 == " + rpn.reformatNumber("123 4-567"));
        System.out.println("123-456-78 == " + rpn.reformatNumber("123 4-5678"));
        System.out.println("12 == " + rpn.reformatNumber("12"));
        System.out.println("175-229-353-94-75 == " + rpn.reformatNumber("--17-5 229 35-39475 "));
    }
}
