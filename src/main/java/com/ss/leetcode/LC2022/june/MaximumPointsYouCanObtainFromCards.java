package com.ss.leetcode.LC2022.june;

public class MaximumPointsYouCanObtainFromCards {
    // https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
    /** Algorithm
         1. Start form index 0 and create a window of size k. Determine its sum.
         2. Reduce the window size from left and increase it on the right
         3. Start with i from k-1 to 0 (reduce left window) and j from n.length -1 to n-k (increase it from right),
            - Deduct cardPoints[i] from sum (reduce left window) and add carpPoints[j] to sum (increase right window)
         4. Always keep track of max score / max window sum
         5. Return max window sum.
     */
    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += cardPoints[i];
        }
        if (k == cardPoints.length) {
            return windowSum;
        }
        maxScore = windowSum;
        for (int i = k -1, j = cardPoints.length - 1; i >= 0; i--,j--) {
            windowSum = windowSum - cardPoints[i] + cardPoints[j];
            maxScore = Math.max(maxScore, windowSum);
        }
        return maxScore;
    }
}
