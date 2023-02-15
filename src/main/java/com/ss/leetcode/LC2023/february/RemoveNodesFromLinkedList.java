package com.ss.leetcode.LC2023.february;

import com.ss.leetcode.shared.ListNode;
import java.util.LinkedList;

public class RemoveNodesFromLinkedList {
    // https://leetcode.com/problems/remove-nodes-from-linked-list/
    /** Algorithm: Next Greater Element
        1. Use a LinkedList (or Stack) LL to add elements which are >= than next element (they cannot be removed)
        2. Traverse the list and if current element is >= next, it means it cannot be removed at this stage, so
            add it to LinkedList (addLast()). (but it can be removed at a later stage, if a higher number is encountered).
            When adding, also set LL.peekLast().next = currentElement. Bind it right before adding it.
        3. If current element < nextElement, means current element cannot be added.
           Also, starting from lastElement in LL, check if nextElement is also > those elements, if yes,
           remove them from the tail one by one.
        4. Remember to add the last element to LL as well (as there is no greater element higher remaining)
        5. Return LL.peekFirst().
     */
    public ListNode removeNodes(ListNode head) {
        LinkedList<ListNode> greaterNodes = new LinkedList<>();
        while(head.next != null) {
            if (head.val < head.next.val) {
                while(!greaterNodes.isEmpty() && greaterNodes.peekLast().val < head.next.val) {
                    greaterNodes.removeLast();
                }
            } else {
                if (!greaterNodes.isEmpty()) {
                    greaterNodes.peekLast().next = head;
                }
                greaterNodes.addLast(head);
            }
            head = head.next;
        }
        if (!greaterNodes.isEmpty()) {
            greaterNodes.peekLast().next = head;
        }
        greaterNodes.addLast(head);
        return greaterNodes.peekFirst();
    }
}
