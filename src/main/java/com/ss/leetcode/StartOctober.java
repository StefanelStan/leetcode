package com.ss.leetcode;

import com.ss.leetcode.august.StoneGame;
import com.ss.leetcode.october.AddDigits;
import com.ss.leetcode.october.BitwiseANDOfNumbersRange;
import com.ss.leetcode.october.Convert1DArrayInto2DArray;
import com.ss.leetcode.october.CousinsInBinaryTree;
import com.ss.leetcode.october.DiameterOfABinaryTree;
import com.ss.leetcode.october.FindMissingObservations;
import com.ss.leetcode.october.GuessNumberHigherOrLower;
import com.ss.leetcode.october.ImplementPrefixTrie;
import com.ss.leetcode.october.JumpGame;
import com.ss.leetcode.october.MaximumNumberOfWaysToPartitionAnArray;
import com.ss.leetcode.october.MinimumMovesToConvertString;
import com.ss.leetcode.october.NumberOfPairsConcatenationTarget;
import com.ss.leetcode.october.ReversePrefixOfWord;
import com.ss.leetcode.october.StoneGameIX;
import com.ss.leetcode.shared.TreeNode;
import com.sun.source.tree.Tree;
import com.sun.source.tree.YieldTree;
import jdk.jfr.TransitionTo;

import java.util.Arrays;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start =  new StartOctober();

//        start.reversePrefixOfWord();
//        start.addDigits();
//        start.convert1DArrayInto2DArray();
//        start.numberOfPairsConcatenationTarget();
//        start.maximumNumberOfWaysToPartitionAnArray();
//        start.minimumMovesToConvertString();
//        start.findMissingObservations();
//        start.stoneGameIX();
//        start.jumpGame();
//        start.implementPrefixTrie();
//        start.bitwiseANDOfNumbersRange();
//        start.diameterOfABinaryTree();
//        start.guessNumberHigherOrLower();
        start.cousinsInBinaryTree();
    }

    public void reversePrefixOfWord() {
        ReversePrefixOfWord rpow = new ReversePrefixOfWord();

        System.out.println("dcbaefd == " + rpow.reversePrefix("abcdefd", 'd'));
        System.out.println("zxyxxe == " + rpow.reversePrefix("xyxzxe", 'z'));
        System.out.println("abcd == " + rpow.reversePrefix("abcd", 'z'));
    }

    public void addDigits() {
        AddDigits ad = new AddDigits();

        System.out.println("2 == " + ad.addDigits(38));
        System.out.println("0 == " + ad.addDigits(0));
        System.out.println("3 == " + ad.addDigits(453));
    }

    public void convert1DArrayInto2DArray() {
        Convert1DArrayInto2DArray c1dai2da = new Convert1DArrayInto2DArray();

        System.out.println("[[1,2],[3,4]] == " + Arrays.deepToString(c1dai2da.construct2DArray(new int[]{1,2,3,4}, 2,2)));
        System.out.println("[[1,2,3]] == " + Arrays.deepToString(c1dai2da.construct2DArray(new int[]{1,2,3}, 1,3)));
        System.out.println("[[]] == " + Arrays.deepToString(c1dai2da.construct2DArray(new int[]{1,2}, 1,1)));
    }

    public void numberOfPairsConcatenationTarget() {
        NumberOfPairsConcatenationTarget nopct = new NumberOfPairsConcatenationTarget();

        System.out.println("4 == " + nopct.numOfPairs(new String[]{"777","7","77","77"}, "7777"));
        System.out.println("2 == " + nopct.numOfPairs(new String[]{"123","4","12","34"}, "1234"));
        System.out.println("6 == " + nopct.numOfPairs(new String[]{"1","1","1"}, "11"));
    }

    public void maximumNumberOfWaysToPartitionAnArray() {
        MaximumNumberOfWaysToPartitionAnArray mnowtpaa = new MaximumNumberOfWaysToPartitionAnArray();

        System.out.println("1 == " + mnowtpaa.waysToPartition(new int[]{2,-1,2}, 3));
        System.out.println("2 == " + mnowtpaa.waysToPartition(new int[]{0,0,0}, 1));
        System.out.println("4 == " + mnowtpaa.waysToPartition(new int[]{22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14}, -33));
        System.out.println("4 == " + mnowtpaa.waysToPartition(new int[]{22,4,-33,-20,-15,15,-16,7,19,-10,0,-13,-14}, -33));
    }
    // 5873. Maximize the Confusion of an Exam

    public void minimumMovesToConvertString() {
        MinimumMovesToConvertString mmtcs = new MinimumMovesToConvertString();

        System.out.println("1 == " + mmtcs.minimumMoves("XXX"));
        System.out.println("2 == " + mmtcs.minimumMoves("XX0X"));
        System.out.println("0 == " + mmtcs.minimumMoves("0000"));
        System.out.println("1 == " + mmtcs.minimumMoves("00X"));
        System.out.println("1 == " + mmtcs.minimumMoves("00XX"));
    }

    public void findMissingObservations() {
        FindMissingObservations fmo = new FindMissingObservations();

        System.out.println("[6,6] == " + Arrays.toString(fmo.missingRolls(new int[]{3,2,4,3}, 4, 2)));
        System.out.println("[2,3,2,2] == " + Arrays.toString(fmo.missingRolls(new int[]{1,5,6}, 3, 4)));
        System.out.println("[] == " + Arrays.toString(fmo.missingRolls(new int[]{1,2,3,4}, 6, 4)));
        System.out.println("[5] == " + Arrays.toString(fmo.missingRolls(new int[]{1}, 3, 1)));
        System.out.println("[6,6,5,2] == " + Arrays.toString(fmo.missingRolls(new int[]{3,5,1,6,4,2}, 4, 4)));
        System.out.println("[] == " + Arrays.toString(fmo.missingRolls(new int[]{6,3,4,3,5,3}, 1, 6)));
        System.out.println("[] == " + Arrays.toString(fmo.missingRolls(new int[]{4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3}, 2, 53)));
    }

    public void stoneGameIX() {
        StoneGameIX stix = new StoneGameIX();

//        System.out.println("true == " + stix.stoneGameIX(new int[]{2,1}));
//        System.out.println("false == " + stix.stoneGameIX(new int[]{2}));
//        System.out.println("false == " + stix.stoneGameIX(new int[]{5,1,2,4,3}));
        System.out.println("true == " + stix.stoneGameIX(new int[]{1,11,12,17,6}));
    }

    public void jumpGame() {
        JumpGame jg = new JumpGame();

        System.out.println("true == " + jg.canJump(new int[]{2,3,1,1,4}));
        System.out.println("false == " + jg.canJump(new int[]{3,2,1,0,4}));
        System.out.println("true == " + jg.canJump(new int[]{0}));
        System.out.println("true == " + jg.canJump(new int[]{2,0,0}));
    }

    public void implementPrefixTrie() {
        ImplementPrefixTrie ipt = new ImplementPrefixTrie();

        ipt.insert("apple");
        System.out.println("True == " + ipt.search("apple"));   // return True
        System.out.println("False == " + ipt.search("app"));     // return False
        System.out.println("True == " + ipt.startsWith("app")); // return True
        ipt.insert("app");
        System.out.println("True == " + ipt.search("app"));    // return True

        ImplementPrefixTrie ipt2 = new ImplementPrefixTrie();

        ipt2.insert("a");
        System.out.println("True == " + ipt2.search("a"));   // return True
        System.out.println("True == " + ipt2.startsWith("a")); // return True
    }

    public void bitwiseANDOfNumbersRange() {
        BitwiseANDOfNumbersRange baonr = new BitwiseANDOfNumbersRange();

        System.out.println("4 == " + baonr.rangeBitwiseAnd(5, 7));
        System.out.println("0 == " + baonr.rangeBitwiseAnd(0, 0));
        System.out.println("0 == " + baonr.rangeBitwiseAnd(1, 2147483647));
        System.out.println("2147483646 == " + baonr.rangeBitwiseAnd(2147483646, 2147483647));
    }

    public void diameterOfABinaryTree() {
        DiameterOfABinaryTree doabt = new DiameterOfABinaryTree();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode root3 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null);

        System.out.println("3 == " + doabt.diameterOfBinaryTree(root1));
        System.out.println("1 == " + doabt.diameterOfBinaryTree(root2));
        System.out.println("2 == " + doabt.diameterOfBinaryTree(root3));
    }

    public void guessNumberHigherOrLower() {
        GuessNumberHigherOrLower gnhol = new GuessNumberHigherOrLower();

        System.out.println("2 == " + gnhol.guessNumber(10));
    }

    public void cousinsInBinaryTree() {
        CousinsInBinaryTree cibt = new CousinsInBinaryTree();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5)));
        TreeNode root3 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));

        System.out.println("false == " + cibt.isCousins(root1, 4, 3));
        System.out.println("true == " + cibt.isCousins(root2, 5, 4));
        System.out.println("false == " + cibt.isCousins(root3, 2, 3));
    }
}
