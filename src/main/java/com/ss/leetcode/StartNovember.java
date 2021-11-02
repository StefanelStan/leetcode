package com.ss.leetcode;

import com.ss.leetcode.november.BinaryTreePaths;
import com.ss.leetcode.november.DeleteNodeInABST;
import com.ss.leetcode.november.SurroundedRegions;
import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

//        start.surroundedRegions();
//        start.binaryTreePaths();
        start.deleteNodeInABST();
    }

    public void surroundedRegions() {
        SurroundedRegions sr = new SurroundedRegions();

        char[][] board1 = {{'X','X','X','X'}, {'X','O','O','X'},{'X','X','O','X'}, {'X','X','X','X'}};
        char[][] board2 = {{'O','O','O','O','X','X'}, {'O','O','O','O','O','O'}, {'O','X','O','X','O','O'},
            {'O','X','O','O','X','O'}, {'O','X','O','X','O','O'}, {'O','X','O','O','O','O'}};
        char[][] board3 = {{'X','O','X','O','O','O','O'}, {'X','O','O','O','O','O','O'}, {'X','O','O','O','O','X','O'},
            {'O','O','O','O','X','O','X'}, {'X','O','O','O','O','O','O'}, {'O','O','O','O','O','O','O'}, {'O','X','O','O','O','O','O'}};

        sr.solve(board1);
        sr.solve(board2);
        sr.solve(board3);
        System.out.println("[[X,X,X,X],[X,X,X,X],[X,O,X,X]] == " + Arrays.deepToString(board1));
        System.out.println("[[O,O,O,O,X,X],[O,O,O,O,O,O],[O,X,O,X,O,O],[O,X,O,O,X,O],[O,X,O,X,O,O], [O,X,O,O,O,O]] == " + Arrays.deepToString(board2));
        System.out.println("[[X,O,X,O,O,O,O],[X,O,O,O,O,O,O],[X,O,O,O,O,X,O], [O,O,O,O,X,O,X],[O,X,O,O,O,O,O],[O,O,O,O,O,O,O],[O,X,O,O,O,O,O]] == " + Arrays.deepToString(board3));

    }

    public void binaryTreePaths() {
        BinaryTreePaths btp = new BinaryTreePaths();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        TreeNode root2 = new TreeNode(1);

        System.out.println("[1->2->5, 1->3] == " + btp.binaryTreePaths(root1));
        System.out.println("[1] == " + btp.binaryTreePaths(root2));
    }

    public void deleteNodeInABST() {
        DeleteNodeInABST dniabst = new DeleteNodeInABST();

        TreeNode root1 = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        TreeNode root2 = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(3, new TreeNode(2), new TreeNode(5, new TreeNode(4), new TreeNode(10, new TreeNode(8, new TreeNode(7), null), new TreeNode(15))));
        TreeNode root5 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));

//        System.out.println("[5,4,6,2,7] == " + TreeNode.extractValues(dniabst.deleteNode(root1, 3)));
//        System.out.println("[5,3,6,2,4,7] == " + TreeNode.extractValues(dniabst.deleteNode(root2, 0)));
//        System.out.println("[] == " + TreeNode.extractValues(dniabst.deleteNode(root3, 0)));
//        System.out.println("[6,3,7,2,4] == " + TreeNode.extractValues(dniabst.deleteNode(root1, 5)));
//        System.out.println("[3,2,7,4,10,8,15] == " + TreeNode.extractValues(dniabst.deleteNode(root4, 5)));
        System.out.println("[3,1,4] == " + TreeNode.extractValues(dniabst.deleteNode(root5, 2)));
    }
}

