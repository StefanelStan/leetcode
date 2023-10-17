package com.ss.leetcode.LC2023.october;

import com.ss.leetcode.shared.ListNode;

public class DoubleANumberRepresentedAsALinkedList {
    // https://leetcode.com/problems/double-a-number-represented-as-a-linked-list
    /** Algorithm
        1. As we double each digit, there is a binary option:
            - any number [0,4] will carry 0 when we double it no matter what comes from the right side
            - any number [5,9] will carry 1 when we double it, no matter what comes from the right side
        2. Traverse the list and for each node
        3. Double the value and modulo 10. (4 => (4*2) % 10 = 8;  5 => (5*2) % 10 = 0)
        4. If the next node is NOT null and next node's value of greater than 4, then next node will carry an 1  so add 1 to current node value
            : EG: [2,4,5]
            i = 1; Current node's new value is 4*2 % 10 = 8. As next node is 5, we know that doubling it will cause one 1
            to carry to the right, to current node. So we add 1 to 8, setting it to 9.
        5. Move head to next node
        6. Apply this logic to the head in a separate initial call, as a new node might be created and put ahead of the head.
     */
    public ListNode doubleIt(ListNode head) {
        ListNode headNode = head.val > 4 ? new ListNode(1, head) : head;
        while (head != null) {
            head.val = (head.val * 2) % 10;
            if (head.next != null) {
                head.val += (head.next.val > 4 ? 1 : 0);
            }
            head = head.next;
        }
        return headNode;
    }
}
