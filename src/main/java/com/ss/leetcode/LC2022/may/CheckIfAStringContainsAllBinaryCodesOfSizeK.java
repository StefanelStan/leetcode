package com.ss.leetcode.LC2022.may;

import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    // https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
    /** Algorithm
        1. Fail fast: if k > s.length() return false;
        2. Given a K, you expect to have 2 ^ k binary numbers; (0 .. 2 ^k -1) (2 ^ 20 = 1048576)
        3. Use a boolean[] codes to mark each present code.
        4. Get the int value of the first k digits and mark it on the codes
        5. Iterate over s starting with k and
            - increment the current value by 2, add the current digit and apply a MASK
            - the mask will "purge" the extra 1 bits, to regulate it into a number of k bits
            - the mask will have the value 2 ^ k -1 (all 11111 bits)
            - mark the found numbers
        6. Return foundNumbers == 2 ^ k;
     */
    public boolean hasAllCodes(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        int totalBinaryCodes = (int)Math.pow(2, k);
        boolean[] codes = new boolean[totalBinaryCodes + 1];
        int found = 1, mask = totalBinaryCodes - 1, binaryValue = Integer.parseInt(s.substring(0, k), 2);
        codes[binaryValue] = true;
        for (int i = k; i < s.length() && found < totalBinaryCodes; i++) {
            binaryValue = (binaryValue * 2 + (s.charAt(i) - '0')) & mask;
            if (!codes[binaryValue]) {
                found++;
            }
            codes[binaryValue] = true;
        }
        return found == totalBinaryCodes;
    }


    /** Algorithm
         1. The number of k combinations is 2 ^ k. K = 2 => 4, k = 20 - > 1mil+
         2. It is not feasable to generate ALL possible combinations and check each one at a time.
         3. Thus, we apply another strategy: how many substrings of size k does s contain?
            We can extract each one of them and put it into a hash set.
            Hashset will not store duplicated strings, but only unique.
         4. If the hashSet size is equal to 2 ^ k (so 2 ^ k unique subtrings of size k), then we have them all.
     */
    public boolean hasAllCodes2(String s, int k) {
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
