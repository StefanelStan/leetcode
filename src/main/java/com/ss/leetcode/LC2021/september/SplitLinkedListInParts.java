package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.ListNode;

public class SplitLinkedListInParts {
    // https://leetcode.com/problems/split-linked-list-in-parts/
    /** Algorithm
        1. Fail fast: if k == 1, return List[head];
        2. Get the size of the list. Each segment will have a length of average (size / k) + 1 (depending on size % k).
        3. For each expected segment, traverse in average + (1/0) steps and assign the head to parts[i].
        4. Remember to nullify the tail of each segment.
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (k == 1) {
            return new ListNode[]{head};
        }
        ListNode[] parts = new ListNode[k];
        ListNode[] currentHead = { head };
        int size = getSize(head);
        int averagePageSize = size / k, extraSegments = size % k;
        for (int i = 0; i < k; i++) {
            parts[i] = getSegment(currentHead, averagePageSize + (extraSegments > 0 ? 1 : 0));
            extraSegments--;
        }
        return parts;
    }

    private ListNode getSegment(ListNode[] head, int size) {
        ListNode headToReturn = head[0];
        while (head[0] != null && size > 1) {
            head[0] = head[0].next;
            size--;
        }
        if (head[0] != null) {
            ListNode next = head[0].next;
            head[0].next = null;
            head[0] = next;
        }
        return headToReturn;
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
