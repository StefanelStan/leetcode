package com.ss.leetcode.LC2022.may;

import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    // https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
    /** Algorithm
         1. The number of k combinations is 2 ^ k. K = 2 => 4, k = 20 - > 1mil+
         2. It is not feasable to generate ALL possible combinations and check each one at a time.
         3. Thus, we apply another strategy: how many substrings of size k does s contain?
            We can extract each one of them and put it into a hash set.
            Hashset will not store duplicated strings, but only unique.
         4. If the hashSet size is equal to 2 ^ k (so 2 ^ k unique subtrings of size k), then we have them all.
     */
    public boolean hasAllCodes(String s, int k) {
        int numberOfCombinations = (int) Math.pow(2, k);
        // if number of k substrings is lesser than number of all needed combinations, return false immediately
        if (s.length() - k + 1 < numberOfCombinations) {
            return false;
        }
        Set<String> substrings = new HashSet<>();
        for(int i = 0; i <= s.length() - k; i++) {
            substrings.add(s.substring(i, i+k));
            if (substrings.size() == numberOfCombinations) {
                return true;
            }
        }
        return numberOfCombinations == substrings.size();
    }
}
