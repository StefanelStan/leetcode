package com.ss.leetcode.LC2023.january;

import java.util.TreeSet;

public class DataStreamAsDisjointIntervals {
    // https://leetcode.com/problems/data-stream-as-disjoint-intervals
    /** Algorithm
        1. Think of the intervals as a double linkedList. Each node is an interval:
            Node0(interval[0,2]) links to Node1(interval[3,5]) which links to Node2([7,9]) etc.
        2. For faster access, map each possible number [0, 10000] to it's correspondant node. Nodes[10001].
            For given example, Nodes[0,1,2] will link to Node0, Nodes[3,4,5] will link to Node1 and so on.
        3. Thus, with each insertion, we can instantly know if that given number is already in an interval and in  which one.
        4. If the number can link two intervals (Nodes[nr] == null, Nodes[nr-1] != null && Nodes[nr+1] != null),
            then bind the two intervals.
            Remember to traverse the nodes[a..b] and set the correct pointers ()
            For faster performance, determine which is the shortestSegment and override it with the longest one.
        5. Remember to also correlate the double linking of the nodes.
        6. Each time you add a new interval, increase the count of them. Each time you merge them, decrese by 1
     */
    private DisjointInterval[] intervals;
    private int minValue = Integer.MAX_VALUE;
    private int maxValue = -1;
    private TreeSet<Integer> nums;
    private int intervalCount = 0;
    public DataStreamAsDisjointIntervals() {
        intervals = new DisjointInterval[10_001];
        nums = new TreeSet<>();
    }

    public void addNum(int value) {
        // If the number has already been added to an interval, return immediately
        if(intervals[value] != null) {
            return;
        }
        // For faster access, add each number in a tree set. This will help determine which node is on the left (floor)
        // and which is on the right (ceiling). Knowling left, right, we can break the links and insert the
        // new middle node.
        nums.add(value);
        minValue = Math.min(minValue, value);
        maxValue = Math.max(maxValue, value);
        // if we need to merge two segments
        if (value > 0 && value < intervals.length - 1 && intervals[value -1] != null && intervals[value+1] != null) {
            mergeIntervals(value);
            intervalCount--;
            // edge cases to deal when value is 0 or 10_001 and we cannot peek on the left (0) or right (>10001)
        } else if (value < intervals.length - 1 && intervals[value + 1] != null){
            intervals[value + 1].increaseSegmentLimit(value);
            intervals[value] = intervals[value + 1];
        } else if (value > 0 &&  intervals[value -1] != null) {
            intervals[value - 1].increaseSegmentLimit(value);
            intervals[value] = intervals[value - 1];
            // else this is a new node that is not binding any intervals (eg: [3,5]  [9,12] and node is 7. It is standalone)
        } else {
            intervals[value] = new DisjointInterval(value);
            intervalCount++;
            linkIntervals(value);
        }
    }

    private void linkIntervals(int value) {
        if (value > minValue) {
            int closest = nums.floor(value - 1);
            intervals[closest].next = intervals[value];
            intervals[value].previous = intervals[closest];
        }
        if (value < maxValue) {
            int closest = nums.ceiling(value + 1);
            intervals[closest].previous = intervals[value];
            intervals[value].next = intervals[closest];
        }
    }

    private void mergeIntervals(int value) {
        DisjointInterval left = intervals[value - 1];
        DisjointInterval right = intervals[value + 1];
        DisjointInterval shortSegment = left.getLength() <= right.getLength() ? left : right;
        DisjointInterval longSegment = left.getLength() <= right.getLength() ? right : left;
        longSegment.increaseSegmentLimit(value);
        intervals[value] = longSegment;

        for (int i = shortSegment.interval[0]; i <= shortSegment.interval[1]; i++) {
            intervals[i] = longSegment;
        }
        longSegment.interval[0] = left.interval[0];
        longSegment.interval[1] = right.interval[1];
        left.next = null;
        right.previous = null;
        if (left.previous != null) {
            left.previous.next = longSegment;
            longSegment.previous = left.previous;
        }
        if (right.next != null) {
            right.next.previous = longSegment;
            longSegment.next = right.next;
        }
        shortSegment.next = null;
        shortSegment.previous = null;
    }

    public int[][] getIntervals() {
        int[][] answer = new int[intervalCount][2];
        DisjointInterval head = intervals[minValue];
        int index = 0;
        while(head != null) {
            System.arraycopy(head.interval, 0, answer[index], 0, 2);
            index++;
            head = head.next;
        }
        return answer;
    }

    private static class DisjointInterval {
        int[] interval;
        DisjointInterval previous;
        DisjointInterval next;

        public DisjointInterval(int value) {
            interval = new int[2];
            interval[0] = value;
            interval[1] = value;
        }

        public void increaseSegmentLimit(int value) {
            if (value > interval[1]) {
                interval[1] = value;
            } else {
                interval[0] = value;
            }
        }
        private int getLength() {
            return interval[1] - interval[0];
        }
    }
}
