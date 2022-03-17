package com.ss.leetcode.LC2022.march;

import com.ss.leetcode.shared.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        Deque<int[]> greaterElements = new LinkedList<>();
        Stack<Integer> mys = new Stack<>();
        List<int[]> posAndValues = new ArrayList<>();
        int i = 0;
        while(head != null) {
            if (head.next != null) {
                // if current head is smaller than next, we have a next greater elements
                if (head.val < head.next.val) {
                    posAndValues.add(new int[]{i, head.next.val});
                    // check for the remaining queue
                    while(!greaterElements.isEmpty() && greaterElements.peekLast()[1] < head.next.val) {
                        posAndValues.add(new int[]{greaterElements.removeLast()[0], head.next.val});
                    }
                } else { // if next head is not greater then current head, add it to greater elements queue.
                    greaterElements.add(new int[]{i, head.val});
                }
            } else { // if reaching the last node, add it to posAndVal as last node will not have greater elements
                posAndValues.add(new int[]{i, 0});
            }
            head = head.next;
            i++;
        }
        while(!greaterElements.isEmpty()) {
            posAndValues.add(new int[]{greaterElements.removeLast()[0], 0});
        }
        return getNextLargetNodes(posAndValues);
    }

    private int[] getNextLargetNodes(List<int[]> posAndValues) {
        posAndValues.sort(Comparator.comparingInt(a -> a[0]));
        int[] nextLargerNodes = new int[posAndValues.size()];
        for(int i = 0; i < posAndValues.size(); i++) {
            nextLargerNodes[i] = posAndValues.get(i)[1];
        }
        return nextLargerNodes;
    }
}
