package com.ss.leetcode.LC2021.july;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrappingRainWater {
    // https://leetcode.com/problems/trapping-rain-water/
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        List<HeightToIndex> heights = new ArrayList<>(height.length);
        for (int i = 0; i < height.length; i++) {
            heights.add(new HeightToIndex(i, height[i]));
        }
        int[] finalSum = new int[1];
        traverseHeightsAndTrapWater(height, heights, finalSum, 0, height.length -1);
        return finalSum[0];
    }

    private void traverseHeightsAndTrapWater(int[] height, List<HeightToIndex> heights, int[] finalSum, int from, int to) {
        if (from == to || from + 1 == to) {
            return;
        }
        List<Integer> maxHeightIndices = getMaxHeightIndices(heights, from, to);
        finalSum[0] += getWaterBetweenElevations(height, maxHeightIndices.get(0), maxHeightIndices.get(1));
        if ( maxHeightIndices.get(0) != from) {
            traverseHeightsAndTrapWater(height, heights, finalSum, 0, maxHeightIndices.get(0));
        }
        if (maxHeightIndices.get(1) != to) {
            traverseHeightsAndTrapWater(height, heights, finalSum, maxHeightIndices.get(1), to);
        }
    }

    /**
     * Calculate the indices that contain the max heights in the given interval.
     * Will also be called initially with [0, length - 1] so we can't say left or right are max;
     */
    private List<Integer> getMaxHeightIndices(List<HeightToIndex> height, int left, int right) {
        if (left + 1 == right) {
            return List.of(left, right);
        }
        List<HeightToIndex> orderedHeight = height.subList(left, right + 1).stream().sorted().collect(Collectors.toList());
        /*
         * edge cases:
         * 1. [0 0 0 X 0 0] => will return first0, last0 . their sum will be 0;  don't worry!
         * 2. [4 4 5] => left Most and rightMost.
         * 3. [4 5 5] => Will return the indices of left most5 and right most 5..
         * In second case, we want to return left most 5 and right most 5
         *
         */
        if (orderedHeight.get(orderedHeight.size() -1).height == orderedHeight.get(orderedHeight.size() -2).height) {
            HeightToIndex mostLeft = orderedHeight.stream().filter(hti -> hti.height == orderedHeight.get(orderedHeight.size() -1).height).findFirst().get();
            return List.of(mostLeft.index, orderedHeight.get(orderedHeight.size() -1).index);
        } else if (orderedHeight.get(orderedHeight.size() -1).height != orderedHeight.get(orderedHeight.size() -2).height) {
            var seconds = orderedHeight.stream().filter(hti -> hti.height == orderedHeight.get(orderedHeight.size() -2).height).collect(Collectors.toList());
            int mostLeft = Math.min(seconds.get(0).index, orderedHeight.get(orderedHeight.size() -1).index);
            int mostRight = Math.max(seconds.get(seconds.size() -1).index, orderedHeight.get(orderedHeight.size() -1).index);
            return List.of(mostLeft, mostRight);
        } else {
            return List.of(orderedHeight.get(orderedHeight.size() -2).index, orderedHeight.get(orderedHeight.size() -1).index);
        }
    }

    /**
     * Calculate the water trapped between <i>leftMargin</i> and <i>rightMargin</i> (inclusive)
     */
    private int getWaterBetweenElevations(int[] height, int leftMargin, int rightMargin) {
        int sum = 0;
        if (leftMargin + 1 == rightMargin) {
            return sum;
        }
        int heightLevel = Math.min(height[leftMargin], height[rightMargin]);
        if (heightLevel == 0) return 0;
        while (++leftMargin < rightMargin) {
            // can be 4 0 5 0 4; 4-5 will be -1 but we want 0 instead.
            sum += Math.max(heightLevel - height[leftMargin], 0);
        }
        return sum;
    }

    public class HeightToIndex implements Comparable<HeightToIndex>{
        private int index;
        private int height;

        public HeightToIndex(int index, int height) {
            this.index = index;
            this.height = height;
        }

        @Override
        public int compareTo(HeightToIndex o) {
            int initialCompare = Integer.compare(height, o.height);
            if (initialCompare == 0) {
                return Integer.compare(index, o.index);
            }
            return  initialCompare;
        }
    }

}
