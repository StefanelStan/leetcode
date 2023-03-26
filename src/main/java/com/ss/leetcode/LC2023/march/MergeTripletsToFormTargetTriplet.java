package com.ss.leetcode.LC2023.march;

public class MergeTripletsToFormTargetTriplet {
    // https://leetcode.com/problems/merge-triplets-to-form-target-triplet
    /** Algorithm
        1. Use 3 booleans to mark the merge/finding of first, second and third element of target
        2. Traverse the triplets and check if current triplet can match any of the 3 elements of target
        3. Matching.
          - If you are matching [0], then triplet[0] == target[0] and triplet[1,2] <= target[1,2].
          - Same when matching [1] and [2]: target element needs to be equal but the other two can be <= than target.
          - If they are larger than the target, you cannot chose that triplet.
        4. Return matchedFirst && second && third
     */
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean matchedFirst = false, matchedSecond = false, matchedThird = false;
        for (int i = 0; i < triplets.length && !(matchedFirst  && matchedSecond  && matchedThird); i++) {
            if (!matchedFirst) {
                matchedFirst = canMatchIndex(0, 1, 2, triplets[i], target);
            }
            if (!matchedSecond) {
                matchedSecond = canMatchIndex(1, 0, 2, triplets[i], target);
            }
            if (!matchedThird) {
                matchedThird = canMatchIndex(2, 0, 1, triplets[i], target);
            }
        }
        return matchedFirst && matchedSecond && matchedThird;
    }

    private boolean canMatchIndex(int eq, int i, int j, int[] triplet, int[] target) {
        return triplet[eq] == target[eq] && triplet[i] <= target[i] && triplet[j] <= target[j];
    }
}
