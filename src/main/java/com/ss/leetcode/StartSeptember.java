package com.ss.leetcode;

import com.ss.leetcode.september.ArrayNesting;
import com.ss.leetcode.september.PopulatingNextRightPointers;

public class StartSeptember {

    public static void main(String[] args) {
        StartSeptember start = new StartSeptember();
//        start.arrayNesting();
        start.populatingNextRightPointers();
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
}
