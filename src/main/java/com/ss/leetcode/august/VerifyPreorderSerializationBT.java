package com.ss.leetcode.august;

public class VerifyPreorderSerializationBT {
    // https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
    public boolean isValidSerialization(String preorder) {
        // Algorithm: each node introduced will spawn 2 more nodes: eith valid either null.
        // so if we have a root, we expect 2 more nodes to be in the string.
        // Each non null visited node will increase the expected nodes with 2 and decrease it by 1 as we have just visited it
        int expectedNodes = 1; // expect the root node
        String[] values = preorder.split(",");
        for(String value : values) {
            expectedNodes--;
            if (expectedNodes < 0) {
                return false;
            }
            if (!value.equals("#")) {
                expectedNodes += 2;
            }
        }
        return expectedNodes == 0;
    }
}