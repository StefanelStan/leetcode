package com.ss.leetcode.LC2024.october;

import java.util.Arrays;

public class MinimumDeletionsToMakeStringKSpecial {
    // https://leetcode.com/problems/minimum-deletions-to-make-string-k-special
    /** Algorithm
        1. Get the frequency of the characters: charFreq[].
        2. Sort and trim (do not include 0 freq) in the charFreq. Now charFreq is like [1,1,3,4,7,8,9]
        3. Looking at K (max diff), we see this is actually a window. (left, right): [1,1,3,4,7,8,9]
            - at freq of 1 (left) , you can have a max freq of 1 + k (right)
            - eg: k  = 5, at index[0] (1) you window can be opened to index [3] (4). At index [4] the window is not valid: 7-1 > 5
        4. Compute the cost of eliminating all elements at the left of left.
            - For right index, everything on the right needs to be removed until freq[right]
        5. ! However, is it efficient to lower all elements to index[3] = 4 ? Our window could expant until a freq of 6 (1 + 5).
            So, in fact, everything on the right of right needs to be lowered at freq[left] + k, and not at freq[right].
        6. Use this sliding window and find the min deletions.
     */
    public int minimumDeletions(String word, int k) {
        int minDeletions = Integer.MAX_VALUE;
        int[] charFreq = getCharFreq(word);
        int[] prefixSum = new int[charFreq.length];
        prefixSum[0] = charFreq[0];
        for (int i = 1; i <prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + charFreq[i];
        }
        for(int left = 0, right = 0; left < charFreq.length; left++) {
            while (right < charFreq.length && charFreq[left] + k > charFreq[right]) {
                right++;
            }
            minDeletions = Math.min(minDeletions, findMinDeletions(charFreq, left, Math.max(0, right - 1), prefixSum, k));
        }
        return minDeletions;
    }

    private int findMinDeletions(int[] charFreq, int left, int right, int[] prefixSum, int k) {
        int deletedOnLeft = left == 0 ? 0 : prefixSum[left - 1], deletedOnRight;
        if (right == charFreq.length - 1) {
            deletedOnRight = 0;
        } else {
            int rightTarget = Math.min(charFreq[left] + k, charFreq[right + 1]);
            deletedOnRight = (prefixSum[prefixSum.length - 1] - prefixSum[right]) - rightTarget * ((charFreq.length - 1) - right);
        }
        return deletedOnLeft + deletedOnRight;
    }

    private int[] getCharFreq(String word) {
        int[] charFreq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            charFreq[word.charAt(i) - 'a']++;
        }
        Arrays.sort(charFreq);
        int nonZeroIndex = 0;
        while(charFreq[nonZeroIndex] == 0) {
            nonZeroIndex++;
        }
        return Arrays.copyOfRange(charFreq, nonZeroIndex, charFreq.length);
    }
}
