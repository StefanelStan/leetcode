package com.ss.leetcode.LC2021;

import com.ss.leetcode.LC2021.october.AddDigits;
import com.ss.leetcode.LC2021.october.BinarySearchTreeIterator;
import com.ss.leetcode.LC2021.october.BitwiseANDOfNumbersRange;
import com.ss.leetcode.LC2021.october.CheckNumbersAreAscendingSentence;
import com.ss.leetcode.LC2021.october.Convert1DArrayInto2DArray;
import com.ss.leetcode.LC2021.october.CountCompleteTreeNodes;
import com.ss.leetcode.LC2021.october.CousinsInBinaryTree;
import com.ss.leetcode.LC2021.october.DefuseTheBomb;
import com.ss.leetcode.LC2021.october.DiameterOfABinaryTree;
import com.ss.leetcode.LC2021.october.EmployeeImportance;
import com.ss.leetcode.LC2021.october.FindMissingObservations;
import com.ss.leetcode.LC2021.october.FlattenAMultilevelDoublyLL;
import com.ss.leetcode.LC2021.october.GuessNumberHigherOrLower;
import com.ss.leetcode.LC2021.october.ImplementPrefixTrie;
import com.ss.leetcode.LC2021.october.InsertDeleteGetRandomO1;
import com.ss.leetcode.LC2021.october.JumpGame;
import com.ss.leetcode.LC2021.october.MaximumNumberOfWaysToPartitionAnArray;
import com.ss.leetcode.LC2021.october.MinStack;
import com.ss.leetcode.LC2021.october.MinimumMovesToConvertString;
import com.ss.leetcode.LC2021.october.NumberOfPairsConcatenationTarget;
import com.ss.leetcode.LC2021.october.ReversePrefixOfWord;
import com.ss.leetcode.LC2021.october.ReverseWordsInAString;
import com.ss.leetcode.LC2021.october.StoneGameIX;
import com.ss.leetcode.LC2021.october.TransposeMatrix;
import com.ss.leetcode.LC2021.october.TwoOutOfThree;
import com.ss.leetcode.shared.TreeNode;
import com.ss.leetcode.LC2021.october.FlattenAMultilevelDoublyLL.Node;
import com.ss.leetcode.shared.Trie;

import java.util.Arrays;
import java.util.List;

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
        start.implementPrefixTrie();
//        start.bitwiseANDOfNumbersRange();
//        start.diameterOfABinaryTree();
//        start.guessNumberHigherOrLower();
//        start.cousinsInBinaryTree();
//        start.reverseWordsInAString();
//        start.insertDeleteGetRandomO1();
//        start.countCompleteTreeNodes();
//        start.minStack();
//        start.checkNumbersAreAscendingSentence();
//        start.twoOutOfThree();
//        start.binarySearchTreeIterator();
//        start.defuseTheBomb();
//        start.transposeMatrix();
//        start.employeeImportance();
//        start.flattenAMultilevelDoublyLL();
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
//        Trie ipt = new Trie();
        ipt.insert("apple");
        System.out.println("true == " + ipt.search("apple"));   // return True
        System.out.println("false == " + ipt.search("app"));     // return False
        System.out.println("true == " + ipt.startsWith("app")); // return True
        ipt.insert("app");
        System.out.println("true == " + ipt.search("app"));    // return True

        ImplementPrefixTrie ipt2 = new ImplementPrefixTrie();

        ipt2.insert("a");
        System.out.println("true == " + ipt2.search("a"));   // return True
        System.out.println("true == " + ipt2.startsWith("a")); // return True
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

    public void reverseWordsInAString() {
        ReverseWordsInAString rwias = new ReverseWordsInAString();

        System.out.println("blue is sky the == " + rwias.reverseWords("the sky is blue"));
        System.out.println("blue == " + rwias.reverseWords("blue"));
        System.out.println("world hello == " + rwias.reverseWords("  hello world  "));
        System.out.println("example good a == " + rwias.reverseWords("a good   example"));
        System.out.println("Alice Loves Bob == " + rwias.reverseWords("  Bob    Loves  Alice   "));
        System.out.println("bob like even not does Alice == " + rwias.reverseWords("Alice does not even like bob"));
    }

    public void insertDeleteGetRandomO1() {
        InsertDeleteGetRandomO1 idgro1 = new InsertDeleteGetRandomO1();

        System.out.println("true == " + idgro1.insert(1));
        System.out.println("false == " + idgro1.remove(2));
        System.out.println("true == " + idgro1.insert(2));
        System.out.println("1 or 2 == " + idgro1.getRandom());
        System.out.println("true == " + idgro1.remove(1));
        System.out.println("false == " + idgro1.insert(2));
        System.out.println("2 == " + idgro1.getRandom());
    }

    public void countCompleteTreeNodes() {
        CountCompleteTreeNodes cctn = new CountCompleteTreeNodes();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        TreeNode root2 = new TreeNode(1);

        System.out.println("6 == " + cctn.countNodes(root1));
        System.out.println("0 == " + cctn.countNodes(null));
        System.out.println("1 == " + cctn.countNodes(root2));
    }

    public void minStack() {
        MinStack ms = new MinStack();

        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println("3 == " + ms.getMin());
        ms.pop();
        System.out.println("0 == " + ms.top());
        System.out.println("-2 == " + ms.getMin());
    }

    public void checkNumbersAreAscendingSentence() {
        CheckNumbersAreAscendingSentence cnaas = new CheckNumbersAreAscendingSentence();

        System.out.println("true == " + cnaas.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println("false == " + cnaas.areNumbersAscending("hello world 5 x 5"));
        System.out.println("false == " + cnaas.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        System.out.println("true == " + cnaas.areNumbersAscending("4 5 11 26"));
    }

    public void twoOutOfThree() {
        TwoOutOfThree toof = new TwoOutOfThree();

        System.out.println("[3,2] == " + toof.twoOutOfThree(new int[]{1,1,3,2}, new int[]{2,3}, new int[]{3}));
        System.out.println("[2,3,1] == " + toof.twoOutOfThree(new int[]{3,1}, new int[]{2,3}, new int[]{1,2}));
        System.out.println("[] == " + toof.twoOutOfThree(new int[]{1,2,2}, new int[]{4,4,3}, new int[]{5}));
    }

    public void binarySearchTreeIterator() {
        TreeNode root1 = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BinarySearchTreeIterator bsti = new BinarySearchTreeIterator(root1);

        System.out.println("3 == " + bsti.next());
        System.out.println("7 == " + bsti.next());
        System.out.println("true == " + bsti.hasNext());
        System.out.println("9 == " + bsti.next());
        System.out.println("true == " + bsti.hasNext());
        System.out.println("15 == " + bsti.next());
        System.out.println("true == " + bsti.hasNext());
        System.out.println("20 == " + bsti.next());
        System.out.println("false == " + bsti.hasNext());
    }

    public void defuseTheBomb() {
        DefuseTheBomb dtb = new DefuseTheBomb();

        System.out.println("[12,10,16,13] == " + Arrays.toString(dtb.decrypt(new int[]{5,7,1,4}, 3)));
        System.out.println("[0,0,0,0] == " + Arrays.toString(dtb.decrypt(new int[]{1,2,3,4}, 0)));
        System.out.println("[12,5,6,13] == " + Arrays.toString(dtb.decrypt(new int[]{2,4,9,3}, -2)));
    }

    public void transposeMatrix() {
        TransposeMatrix tm = new TransposeMatrix();

        System.out.println("[[1,4,7],[2,5,8],[3,6,9]] == " + Arrays.deepToString(tm.transpose(new int[][]{{1,2,3}, {4,5,6},{7,8,9}})));
        System.out.println("[[1,4],[2,5],[3,6]] == " + Arrays.deepToString(tm.transpose(new int[][]{{1,2,3}, {4,5,6}})));
    }

    public void employeeImportance() {
        EmployeeImportance ei = new EmployeeImportance();

        List<EmployeeImportance.Employee> list1 = List.of(new EmployeeImportance.Employee(1, 5, List.of(2,3)),
            new EmployeeImportance.Employee(2,3), new EmployeeImportance.Employee(3,3));
        List<EmployeeImportance.Employee> list2 = List.of(new EmployeeImportance.Employee(1,2, List.of(5)), new EmployeeImportance.Employee(5, -3));

        System.out.println("11 == " + ei.getImportance(list1, 1));
        System.out.println("-3 == " + ei.getImportance(list2, 5));
    }

    public void flattenAMultilevelDoublyLL() {
        FlattenAMultilevelDoublyLL famldll = new FlattenAMultilevelDoublyLL();

        Node[] nodes = new Node[13];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i < 6; i++) Node.connect(nodes[i], nodes[i+1]);
        for (int i = 7; i < 10; i++) Node.connect(nodes[i], nodes[i+1]);
        for (int i = 11; i < 12; i++) Node.connect(nodes[i], nodes[i+1]);
        nodes[3].child = nodes[7];
        nodes[8].child = nodes[11];

        Node[] nodes2 = new Node[4];
        for (int i = 1; i < nodes2.length; i++) {
            nodes2[i] = new Node(i);
        }
        Node.connect(nodes2[1], nodes2[2]);
        nodes2[1].child = nodes2[3];

        Node[] nodes3 = new Node[4];
        for (int i = 1; i < nodes3.length; i++) {
            nodes3[i] = new Node(i);
        }
        nodes3[1].child = nodes3[2];
        nodes3[2].child = nodes3[3];

//        System.out.println("[1,2,3,7,8,11,12,9,10,4,5,6] == " + Node.toList(famldll.flatten(nodes[1])));
//        System.out.println("[1,3,2] == " + Node.toList(famldll.flatten(nodes2[1])));
//        System.out.println("[] == " + Node.toList(famldll.flatten(null)));
        System.out.println("[1,2,3] == " + Node.toList(famldll.flatten(nodes3[1])));
    }
}
