package com.ss.leetcode.LC2022.december;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountPairsOfSimilarStrings {
    // https://leetcode.com/problems/count-pairs-of-similar-strings
    /** Algorithm
         1. For each word, try to determine its fingerprint: use a boolean[26] to mark the presence of various letters
            (char - 'a' will return a number from 0 to 25 (z -a = 25), thus mapping on an boolean[26])
            "accbae" -> [true, true, true, false, true,....]
            "ecba"   -> [true, true, true, false, true.....]
         2. Use a map of Map<Integer, Integer> to count the fingerprint the words.
            As key use Arrays.hashCode(boolean[] fingerprint) and value the count of that specific fingerprint
         3. Now that you have the count of each such fingerprint, use a combination of X by 2.
            EG: [true, true] -> 6. It means you have 6 words
            Combination of 6 by 2 is (5 * 6) / 2 (n! / (k! * ((n-k)!))).
            In order to avoid large numbers (eg: 14!) we apply basic math: 14! / 12! is 13 * 14.
         4. Calculate the factorial of each count/group where count is > 1.
         5. Return the value.
     */
    public int similarPairs(String[] words) {
        int similar = 0;
        Map<Integer, Integer> wordSignatures = getSignatures(words);
        for (int count : wordSignatures.values()) {
            if (count >= 2) {
                similar += (count *(count - 1) / 2);
            }
        }
        return similar;
    }

    private Map<Integer, Integer> getSignatures(String[] words) {
        Map<Integer, Integer> signatures = new HashMap<>();
        for (String word: words) {
            signatures.merge(Arrays.hashCode(getSignature(word)), 1, Integer::sum);
        }
        return signatures;
    }

    private boolean[] getSignature(String word) {
        boolean[] signature = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            signature[word.charAt(i) - 'a'] = true;
        }
        return signature;
    }
}
