package com.ss.leetcode.LC2023.may;

import com.ss.leetcode.shared.ListNode;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    // https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points
    /** Algorithm
        1. Traverse the list and keep track of previous node while head.next != null, as well last first, last Critical point index
        2. If you are on a critical point, store its position and determine the min/max between
            currentIndex and previousCritical point, currentIndex and firstCriticalPoint.
        3. If firstCriticalPoint == lastCriticalPoint, then you have less than 2 critical points, so return [-1,-1]
            Else return the answer array.
     */
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int prevVal = head.val;
        head = head.next;
        int[] answer = {Integer.MAX_VALUE, -1};
        int currentIndex = 2, firstCriticalPoint = -1, lastCriticalPoint = -1;
        while(head.next != null) {
            if ((prevVal < head.val && head.val > head.next.val) || (prevVal > head.val && head.val < head.next.val)) {
                if (firstCriticalPoint == -1) {
                    firstCriticalPoint = currentIndex;
                } else {
                    answer[0] = Math.min(answer[0], currentIndex - lastCriticalPoint);
                    answer[1] = Math.max(answer[1], currentIndex - firstCriticalPoint);
                }
                lastCriticalPoint = currentIndex;
            }
            currentIndex++;
            prevVal = head.val;
            head = head.next;
        }
        return firstCriticalPoint == lastCriticalPoint ? new int[]{-1,-1} : answer;
    }
}
