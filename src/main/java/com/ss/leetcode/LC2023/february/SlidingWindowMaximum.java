package com.ss.leetcode.LC2023.february;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    // https://leetcode.com/problems/sliding-window-maximum
    /** Algorithm
        1. Use a priorityQueue<int[]> to store each element of the windows: [value, index].
        2. Set the priority queue to be a reverse comparator of the value (a,b) -> b[0] - a[0];
        3. Build your k size window and add PQ pook() to answer.
        4. From i = 1 to n-k add element i+k -1 to queue (new int[]{value, index}) AND remove any elements from the head that has index less than i.
            This way we simulate the elimination of any top elements that might be on the LEFT of the window.
        5. Add the peek() on the queue to answer
        6. Return the answer;
     */
    // Can be enhanced with a linkedList to keep max at the end and smallest in the front
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[1 + nums.length - k];
        PriorityQueue<Integer> highestNums = new PriorityQueue<>((a,b) -> Integer.compare(nums[b], nums[a]));
        for (int i = 0; i < k; i++) {
            if (!highestNums.isEmpty() && nums[highestNums.peek()] <= nums[i]) {
                highestNums.clear();
            }
            highestNums.add(i);
        }
        int insertIndex = 0;
        max[insertIndex++] = nums[highestNums.peek()];
        for (int j = k; j < nums.length; j++) {
            while (!highestNums.isEmpty() && insertIndex > highestNums.peek()) {
                highestNums.poll();
            }
            if (!highestNums.isEmpty() && nums[highestNums.peek()] <= nums[j]) {
                highestNums.clear();
            }
            highestNums.add(j);
            max[insertIndex++] = nums[highestNums.peek()];
        }
        return max;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] max = new int[1 + nums.length - k];
        PriorityQueue<Integer> highestNums = new PriorityQueue<>((a,b) -> Integer.compare(nums[b], nums[a]));
        for (int i = 0; i < k; i++) {
            highestNums.add(i);
        }
        int insertIndex = 0;
        max[insertIndex++] = nums[highestNums.peek()];
        for (int j = k; j < nums.length; j++) {
            highestNums.add(j);
            while (insertIndex > highestNums.peek()) {
                highestNums.poll();
            }
            max[insertIndex++] = nums[highestNums.peek()];
        }
        return max;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int slidingIndex = 0;
        int[] maxWindows = new int[nums.length - k + 1];
        PriorityQueue<int[]> window = getWindow(nums, k);
        maxWindows[slidingIndex++] = window.peek()[0];
        while (slidingIndex <= nums.length - k) {
            window.add(new int[]{nums[slidingIndex + k - 1], slidingIndex + k - 1});
            while(!window.isEmpty() && window.peek()[1] < slidingIndex) {
                window.poll();
            }
            maxWindows[slidingIndex++] = window.peek()[0];
        }
        return maxWindows;
    }

    private PriorityQueue<int[]> getWindow(int[] nums, int k) {
        PriorityQueue<int[]> window = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < k; i++) {
            window.add(new int[]{nums[i], i});
        }
        return window;
    }
}
