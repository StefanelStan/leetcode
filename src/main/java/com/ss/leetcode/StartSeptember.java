package com.ss.leetcode;

import com.ss.leetcode.september.ArrayNesting;
import com.ss.leetcode.september.DeleteNodesAndReturnForest;
import com.ss.leetcode.september.DistributeCandies;
import com.ss.leetcode.september.ErectTheFence;
import com.ss.leetcode.september.FindAllGroupsOfFarmland;
import com.ss.leetcode.september.FindNearestPoint;
import com.ss.leetcode.september.FindTheDistanceBetweenTwoArrays;
import com.ss.leetcode.september.FindTheMiddleIndexInArray;
import com.ss.leetcode.september.FizzBuzz;
import com.ss.leetcode.september.GoatLatin;
import com.ss.leetcode.september.IntersectionOfTwoArrays;
import com.ss.leetcode.september.KeysAndRooms;
import com.ss.leetcode.september.LetterCasePermutation;
import com.ss.leetcode.september.LockingTree;
import com.ss.leetcode.september.LowestCommonAncestor;
import com.ss.leetcode.september.MaximumSubarray;
import com.ss.leetcode.september.MinimumCostToMoveChips;
import com.ss.leetcode.september.PopulatingNextRightPointers;
import com.ss.leetcode.september.ReverseBits;
import com.ss.leetcode.september.SameTree;
import com.ss.leetcode.september.SingleNumber;
import com.ss.leetcode.september.SlowestKey;
import com.ss.leetcode.september.UniqueBinarySearchTreesII;
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
        start.combinations();
    }

    public void arrayNesting() {
        ArrayNesting an = new ArrayNesting();

        System.out.println("4 == " + an.arrayNesting(new int[]{5,4,0,3,1,6,2}));
        System.out.println("1 == " + an.arrayNesting(new int[]{0,1,2}));
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

        System.out.println("[[2,4],[3,4],,[2,3],[1,2],[1,3],[1,4]] == " + Arrays.deepToString(c.combine(4, 2)));
    }
}
