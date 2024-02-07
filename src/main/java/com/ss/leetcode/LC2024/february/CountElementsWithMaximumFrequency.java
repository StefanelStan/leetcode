package com.ss.leetcode.LC2024.february;

import java.util.Arrays;

public class CountElementsWithMaximumFrequency {
    // https://leetcode.com/problems/count-elements-with-maximum-frequency
    /** Algorithm
        1. Use an int[101] to keep track of frequencies
        2. Iterate and for each element increment its frequency
            - if current element's frequency == maxFrequency, add it to total frequency
            - if current element's' frequency > maxFrequency, set new maxFrequenxy and set totalFreq = maxFrequency
        3. Return totalFreq
     */
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq =0, totalFreq = 0;
        for (int num : nums) {
            freq[num]++;
            totalFreq = freq[num] > maxFreq ? freq[num] : freq[num] == maxFreq ? totalFreq + freq[num] : totalFreq;
            maxFreq = Math.max(maxFreq, freq[num]);
        }
        return totalFreq;
    }

    public int maxFrequencyElements2(int[] nums) {
        Arrays.sort(nums);
        int freqSum = 1, currentFreq = 1, highestFreq = 1;
        for (int i = 1; i < nums.length; i++) {
            currentFreq = nums[i-1] == nums[i] ? currentFreq + 1 : 1;
            freqSum = currentFreq == highestFreq ? freqSum + currentFreq : currentFreq > highestFreq ? currentFreq : freqSum;
            highestFreq = Math.max(highestFreq, currentFreq);
        }
        return freqSum;
    }
}
