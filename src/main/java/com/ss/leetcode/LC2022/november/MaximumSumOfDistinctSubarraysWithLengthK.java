package com.ss.leetcode.LC2022.november;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    // https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
    public long maximumSubarraySum(int[] nums, int k) {
        int max = 0;
        long maxSum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        SubarrayWindow window = new SubarrayWindow(max + 1, k);
        for (int i = 0; i < k; i++) {
            window.add(nums[i]);
        }
        if (window.isValid()) {
            maxSum = Math.max(maxSum, window.sum);
        }
        for (int left = 0, right = k; right < nums.length; left++, right++) {
            window.add(nums[right]);
            window.remove(nums[left]);
            if (window.isValid()) {
                maxSum = Math.max(maxSum, window.sum);
            }
        }
        return maxSum;
    }

    private static final class SubarrayWindow {
        int maxUnique;
        int unique;
        long sum;
        int[] count;

        public SubarrayWindow(int length, int maxUnique) {
            this.count = new int[length];
            this.maxUnique = maxUnique;
        }

        public void add(int num) {
            sum += num;
            count[num]++;
            if (count[num] == 1) {
                unique++;
            } else if (count[num] == 2) {
                unique--;
            }
        }

        public void remove(int num) {
            count[num]--;
            sum -= num;
            if (count[num] == 1) {
                unique++;
            } else if (count[num] == 0) {
                unique--;
            }
        }

        public boolean isValid() {
            return maxUnique == unique;
        }
    }





    /** Algorithm
         1. Use a int[100_0001] to store the count/presence of each number
         2. Start with a window of size k. Determine the sum of window, the present[] numbers AND an int[] duplication.
         3. The idea is that we want to store a duplication level/cardinal rather than loopling over i .. k and see if we have duplicates.
         4. Determining the initial duplication[] level/score
            - If ++present[i] > 1 (you also count them), then you have another duplicate, so increment duplicate[0].
         5. Sliding and determing the duplication level: unmark/remove i-1 and add/mark i+k.
             - When sliding, unmark the [i-1] element.
             - If --present[i-1] >= 1, it means this was a duplicated element. Decrease the duplication[0].
             - if ++present[i+k] > 1, means that elements exists already in window, so increase duplication level.
         6. If after each sliding operation the duplication[] level is 0, then all your window has
            unique elements, so the window sum can be checked against maxWindowSum known so far.
         7. Return max window sum
     */
    public long maximumSubarraySum2(int[] nums, int k) {
        int[] duplicates = {0};
        int[] present = new int[100_001];
        long sum = getWindowSum(nums, k, present, duplicates);
        long maxSum = 0;
        if (duplicates[0] == 0) {
            maxSum = Math.max(sum, maxSum);
        }
        int left = 1, right = k;
        while (right < nums.length) {
            sum = slideWindow(nums, left, right, sum, present, duplicates);
            if (duplicates[0] == 0) {
                maxSum = Math.max(sum, maxSum);
            }
            left++;
            right++;

        }
        return maxSum;
    }

    private long getWindowSum(int[] nums, int k, int[] present, int[] duplicates) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            if (++present[nums[i]] > 1) {
                duplicates[0]++;
            }
        }
        return sum;
    }

    private long slideWindow(int[] nums, int left, int right, long sum, int[] present, int[] duplicates) {
        sum -= nums[left -1];
        sum += nums[right];
        if (--present[nums[left - 1]] >= 1) {
            duplicates[0]--;
        }
        if(++present[nums[right]] > 1) {
            duplicates[0]++;
        }
        return sum;
    }
}
