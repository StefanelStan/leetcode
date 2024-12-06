package com.ss.leetcode.LC2024.december;

public class CountCompleteSubarraysInAnArray {
    // https://leetcode.com/problems/count-complete-subarrays-in-an-array
    /** Algorithm
        1. Traverse nums and get the count of unique nums (boolean[2001]).
        2. Use 2 pointers LEFT and RIGHT that will be the edges of a sliding window.
            - If your window is valid, then you have n - RIGHT subarrays.
        3. Advance RIGHT until your window has enough unique numbers.
            - then the arrays [LEFT, RIGHT], [LEFT, RIGHT + 1].. [LEFT, N-1] are all valid
        4. Reduce LEFT by 1 and expand RIGHT until you have a new valid window.
     */
    public int countCompleteSubarrays(int[] nums) {
        int uniqueCount = getUniqueCount(nums);
        int complete = 0;
        SubarrayWindow window = new SubarrayWindow(uniqueCount);
        for (int left = 0, right = 0; left <= nums.length - uniqueCount; left++) {
            while(!window.isValid() && right < nums.length) {
                window.add(nums[right++]);
            }
            complete += window.isValid() ? 1 + nums.length - right : 0;
            window.remove(nums[left]);
        }
        return complete;
    }

    private static class SubarrayWindow {
        int[] count;
        int currentUnique;
        int targetUnique;
        public SubarrayWindow (int targetUnique) {
            this.count = new int[2001];
            this.targetUnique = targetUnique;
        }

        public void add(int num) {
            if (++count[num] == 1) {
                currentUnique++;
            }
        }

        public void remove(int num) {
            if (--count[num] == 0) {
                currentUnique--;
            }
        }

        public boolean isValid() {
            return currentUnique == targetUnique;
        }
    }

    private int getUniqueCount(int[] nums) {
        boolean[] present = new boolean[2001];
        int unique = 0;
        for (int num : nums) {
            unique += present[num] ? 0 : 1;
            present[num] = true;
        }
        return unique;
    }

    // BRUTE FORCE OPTIMISED
    public int countCompleteSubarrays2(int[] nums) {
        int uniqueCount = getUniqueCount(nums);
        int complete = 0;
        for (int i = 0; i <= nums.length - uniqueCount; i++) {
            boolean[] present = new boolean[2001];
            int subarrayCount = 0;
            for (int j = i; j < nums.length; j++) {
                subarrayCount += (present[nums[j]] ? 0 : 1);
                present[nums[j]] = true;
                if (subarrayCount == uniqueCount) {
                    complete += nums.length - j;
                    break;
                }
            }
        }
        return complete;
    }
}
