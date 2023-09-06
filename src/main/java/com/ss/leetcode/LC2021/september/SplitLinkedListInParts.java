package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.ListNode;

public class SplitLinkedListInParts {
    // https://leetcode.com/problems/split-linked-list-in-parts/
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = getSize(head);
        ListNode[] parts = new ListNode[k];
        int modulo = size % k, partSize = size / k;
        for (int i = 0; i < k; i++) {
            head = splitInSize(head, parts, i, modulo, partSize);
            modulo--;
        }
        return parts;
    }

    private ListNode splitInSize(ListNode head, ListNode[] parts, int i, int modulo, int length) {
        if (head == null) {
            return null;
        }
        length += (modulo > 0 ? 1 : 0);
        parts[i] = head;
        while (head != null && length-- > 1) {
            head = head.next;
        }
        ListNode toReturn = head;
        if (head != null) {
            toReturn = head.next;
            head.next = null;
        }
        return toReturn;
    }

    public ListNode[] splitListToParts2(ListNode head, int k) {
        int listSize = getSize(head);
        // put the heads into a matrix position 0.next will point to the first node of each array
        ListNode[][] tempList = new ListNode[k][2];
        for (ListNode[] temp : tempList) {
            temp[0] = new ListNode(0);
        }
        parseList(head, tempList, listSize);
        return toArray(tempList);
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    /**
     * The plan is to group into groups of size s+1, s+1, s+1...s,s,s - having [listSize % K] groups of +1 length
     * eg: size of 8 and k is 5= > [2, 2, 2, 1, 1] (8%5 => 3 groups will have +1 grater size than the remaining 2 groups
     */
    private void parseList(ListNode head, ListNode[][] tempList, int listSize) {
        int kGroupIndex = 0, kGroupSize;
        // determine which group will be the last one with a size greater than the remaining ones.
        int mileStone = listSize % tempList.length;
        int lowerSize = listSize / tempList.length;
        while(head != null) {
            // if size % k == 0 => all groups will have the same size; if kGroupSize is less than the mileStone, will still have a bigger size, if not, the normal s / k size.
            kGroupSize = mileStone == 0 ? lowerSize : kGroupIndex < mileStone ? lowerSize + 1 : lowerSize;
            // fill one group at a time.
            for (int i = 0; i < kGroupSize; i++) {
                // traditional loop and link one node to next node.
                ListNode tmp = new ListNode(head.val);
                if (tempList[kGroupIndex][1] == null) {
                    tempList[kGroupIndex][1] = tmp;
                    tempList[kGroupIndex][0].next = tempList[kGroupIndex][1];
                } else {
                    tempList[kGroupIndex][1].next = tmp;
                    tempList[kGroupIndex][1] = tempList[kGroupIndex][1].next;
                }
                head = head.next;
            }
            kGroupIndex++;
        }
    }

    private ListNode[] toArray(ListNode[][] tempList) {
        ListNode[] nodes = new ListNode[tempList.length];
        for (int i = 0; i < tempList.length; i++) {
            nodes[i] = tempList[i][0].next;
        }
        return nodes;
    }
}
