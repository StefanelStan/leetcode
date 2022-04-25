package com.ss.leetcode.LC2021.january;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NextGreaterElementII {

    // https://leetcode.com/problems/next-greater-element-ii/
    public int[] nextGreaterElements(int[] nums) {
        int[] greaterElements = new int[nums.length];
        Deque<Integer> greaterPositions = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                greaterElements[i] = nums[i + 1];
                while (!greaterPositions.isEmpty() && nums[greaterPositions.peekLast()] < nums[i
                    + 1]) {
                    greaterElements[greaterPositions.removeLast()] = nums[i + 1];
                }
            } else {
                greaterPositions.addLast(i);
            }
        }
        greaterPositions.addLast(nums.length - 1);
        int maxIndex = greaterPositions.peekFirst();
        int last;
        while (!greaterPositions.isEmpty()) {
            last = greaterPositions.removeLast();
            if (nums[last] == nums[maxIndex]) {
                greaterElements[last] = -1;
            } else {
                for (int i = 0; i <= maxIndex; i++) {
                    if (nums[i] > nums[last]) {
                        greaterElements[last] = nums[i];
                        break;
                    }
                }
            }
        }
        return greaterElements;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int groupSize = getGroupSize(nums.length);
        int nrOfGroups = (int) Math.ceil((double) nums.length / groupSize);
        List<Group> groups = new ArrayList<>();
        int startGroup = 0;
        while (startGroup < nrOfGroups) {
            groups.add(getGroup(groupSize, startGroup, nums));
            startGroup++;
        }

        // got the groups now in one iteration;
        final int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = getNextGreaterElement(nums[i], i, groups, groupSize, nums);
        }

        return result;
    }

    private int getGroupSize(int length) {
        if (length < 10) {
            return 2;
        }
        if (length < 100) {
            return 10;
        }
        if (length < 500) {
            return 25;
        }
        if (length < 1000) {
            return 50;
        }
        if (length < 5000) {
            return 250;
        } else {
            return 500;
        }
    }


    private Group getGroup(int groupSize, int groupIndex, int[] nums) {
        int startIndex = groupIndex * groupSize;
        int endIndex = Math.min(startIndex + groupSize, nums.length) - 1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }
        return new Group(startIndex, endIndex, maxValue);
    }


    private int getNextGreaterElement(int num, int numIndex, List<Group> groups, int groupSize,
        int[] nums) {
        int currentGroupIndex = numIndex / groupSize;
        int nextGreaterElement = Integer.MIN_VALUE;
        if (groups.get(currentGroupIndex).getMaxValue() > num) {
            nextGreaterElement = getNextGreaterElementFromWithinGroup(groups.get(currentGroupIndex),
                num, numIndex % groupSize, nums);
        }
        if (nextGreaterElement == Integer.MIN_VALUE && currentGroupIndex + 1 <= groups.size() - 1) {
            // no max found here; look right
            nextGreaterElement = searchGroupsForGreaterElement(num, 0,
                Math.min(currentGroupIndex + 1, groups.size() - 1), groups.size() - 1, groups,
                nums);
        }
        if (nextGreaterElement == Integer.MIN_VALUE) {
            // no max found here; look left
            nextGreaterElement = searchGroupsForGreaterElement(num, 0, 0, currentGroupIndex, groups,
                nums);
        }
        return (nextGreaterElement == Integer.MIN_VALUE ? -1 : nextGreaterElement);
    }

    private int searchGroupsForGreaterElement(int num, int numIndex, int startGroupPosition,
        int endGroupPosition, List<Group> groups, int[] nums) {
        for (int i = startGroupPosition; i <= endGroupPosition; i++) {
            if (groups.get(i).getMaxValue() > num) {
                return getNextGreaterElementFromWithinGroup(groups.get(i), num, numIndex, nums);
            }
        }
        return Integer.MIN_VALUE;
    }

    private int getNextGreaterElementFromWithinGroup(Group group, int num, int numIndex,
        int[] nums) {
        for (int i = numIndex + group.startPosition; i <= group.endPosition; i++) {
            if (nums[i] > num) {
                return nums[i];
            }
        }
        return Integer.MIN_VALUE;
    }


    private static class Group {

        private final int startPosition;
        private final int endPosition;
        private final int maxValue;

        public Group(final int startPosition, final int endPosition, final int maxValue) {
            this.startPosition = startPosition;
            this.endPosition = endPosition;
            this.maxValue = maxValue;
        }

        public int getMaxValue() {
            return maxValue;
        }
    }
}
