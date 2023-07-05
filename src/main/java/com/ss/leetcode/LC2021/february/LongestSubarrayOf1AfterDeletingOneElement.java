package com.ss.leetcode.LC2021.february;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayOf1AfterDeletingOneElement {
    // https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
    public int longestSubarray(int[] nums) {
        boolean onChain = false;
        int longest = 0, firstHalf = 0, secondHalf = 0, prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (onChain) {
                    secondHalf++;
                } else {
                    firstHalf++;
                }
            } else {
                if (prev == 1 && i < nums.length - 1 && nums[i+1] == 1) {
                    if (onChain) {
                        firstHalf = secondHalf;
                        secondHalf = 0;
                    }
                    onChain = true;
                } else {
                    onChain = false;
                    firstHalf = 0;
                    secondHalf = 0;
                }
            }
            prev = nums[i];
            longest = Math.max(longest, firstHalf + secondHalf);
        }
        return longest == nums.length ? nums.length -1 : longest;
    }

    // Novice :)
    public int longestSubarray2(int[] nums) {
        final List<ZeroCount> zeroPositions = countZeroes(nums);
        if(zeroPositions.isEmpty()) {
            return nums.length -1;
        }

        int longestSubArray = getLongestSubArray(nums, zeroPositions);
        int continuousOnes = getContinuousOnes(zeroPositions, nums.length);
        return Math.max(longestSubArray, continuousOnes);
    }


    private int getLongestSubArray(int[] nums, List<ZeroCount> zeroPositions) {
        int longestSubArray = 0;
        int currentLongestSubArray;
        for (int i = 0; i < zeroPositions.size(); i++) {
            if (zeroPositions.get(i).length == 1) {
                currentLongestSubArray = getLengthOfOnes(i, zeroPositions, nums.length);
                if (currentLongestSubArray > longestSubArray) {
                    longestSubArray = currentLongestSubArray;
                }
            }
        }
        return longestSubArray;
    }


    private int getContinuousOnes(List<ZeroCount> zeroPositions, int numsLength) {
        int maxLength = 0;
        if(zeroPositions.get(0).position > 0) {
            maxLength = zeroPositions.get(0).position;
        }
        if(zeroPositions.get(zeroPositions.size() -1).getEndLength() < numsLength) {
            int endLength = numsLength - zeroPositions.get(zeroPositions.size() -1).getEndLength();
            if (endLength > maxLength) {
                maxLength = endLength;
            }
        }
        int currenthLength = 0;
        for (int i = 0; i < zeroPositions.size() -1; i++) {
            currenthLength = zeroPositions.get(i+1).position - zeroPositions.get(i).getEndLength();
            if (currenthLength > maxLength) {
                maxLength = currenthLength;
            }
        }
        return maxLength;
    }

    private List<ZeroCount> countZeroes(int[] nums) {
        List<ZeroCount> zeroPositions = new ArrayList<>(nums.length / 10);
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (zeroCount > 0) {
                zeroPositions.add(new ZeroCount(i - zeroCount, zeroCount));
                zeroCount = 0;
            }
        }
        if (zeroCount > 0) {
            zeroPositions.add(new ZeroCount(nums.length - zeroCount, zeroCount));
        }
        return zeroPositions;
    }

    private int getLengthOfOnes(int zp, List<ZeroCount> zeroPositions, int maxLength) {
        if (zeroPositions.get(zp).position == 0 || zeroPositions.get(zp).getEndLength() == maxLength) {
            return 0;
        }
        int leftSideLength = zp == 0 ? zeroPositions.get(zp).position  : zeroPositions.get(zp).position - (zeroPositions.get(zp - 1).getEndLength());// getLeftSide
        int rightSideLength = zp == zeroPositions.size() - 1 ? maxLength - zeroPositions.get(zp).getEndLength()
                                                             : zeroPositions.get(zp +1).position - zeroPositions.get(zp).getEndLength();
        return leftSideLength + rightSideLength;
    }

    private static class ZeroCount {
        private final int position;
        private final int length;

        public ZeroCount(int position, int length) {
            this.position = position;
            this.length = length;
        }

        public int getEndLength() {
            return position + length;
        }
    }
}
