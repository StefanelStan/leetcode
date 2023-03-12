package com.ss.leetcode.LC2023.march;

import com.ss.leetcode.shared.ListNode;

public class ReverseNodesInEvenLengthGroups {
    // https://leetcode.com/problems/reverse-nodes-in-even-length-groups
    /** Algorithm
        1. Traverse the list in target groups of 2,3 etc.
        2. For each group grade (2,3,4) determine if a reverse is needed (eg: length % 2 == 0).
            Traverse each group and if group length (number of nodes % 2 == 0) then reverse the list, else leave it as it is
        3. Use a method reverseIfNeeded that returns a ListNode[3]. This will be the newHead, newTail and nextFromTail of the segment.
            EG: Supposing you are at segment 2 in list 1,7,8,9.
             As inside this segment we have an even number of nodes, they will be reversed.
            The returned ListNode[] will contain [8,7,9].
            Link the head to ListNode[0],  and link ListNode[1] to ListNode[2].
            If the segment contains odd numbers of nodes, this operation is will have no effect, as the nodes are already linked.
     */
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode originalHead = head;
        int groupNumber = 2;
        ListNode[] endPoints = {null, null, head.next};
        while(endPoints[2] != null) {
            // This will return the originalSegment OR the reversedSegment, depending on count
            // [0] - newSegment head, [1] - newSegmentTail [2] - nextNode after tail.
            endPoints = reverseIfNeeded(head.next, groupNumber);
            head.next = endPoints[0];
            if(endPoints[1] != null) endPoints[1].next = endPoints[2];
            head = endPoints[1];
            groupNumber++;
        }
        return originalHead;
    }

    private ListNode[] reverseIfNeeded(ListNode from, int groupNumber) {
        if (from == null) {
            return new ListNode[3];
        }
        ListNode original = from;
        int count = 1;
        while(count < groupNumber && from != null) {
            from = from.next;
            if (from != null) count++;
        }
        ListNode[] answer = new ListNode[3];
        ListNode afterTail = from == null ? from : from.next;
        if (count % 2 == 0) {
            answer[0] = reverseList(original, count);
            answer[1] = original;
        } else {
            answer[0] = original;
            answer[1] = from;
        }
        answer[2] = afterTail;
        return answer;
    }

    private ListNode reverseList(ListNode node, int steps) {
        ListNode next, prev = null;
        while(node != null && steps-- > 0) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
