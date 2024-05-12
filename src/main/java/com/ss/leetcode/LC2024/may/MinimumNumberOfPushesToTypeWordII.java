package com.ss.leetcode.LC2024.may;

import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWordII {
    // https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii
    /** Algorithm
        1. Count and sort the letters by frequency.
        2. The most frequent letters need to be put first on the cheapest positions.(1 tap)
        3. Upon setting a letter to a key, move to next letter and next key.
        4. The first keyCost is 1. (1 tap). When finishing a full key cycle (keys 2-8 mapped to 0-7), the keyCost will become 2 (2 taps)
        5. Traverse all letterCount and multiply the count with cost. Increase the cost by 1 after each 7 letters.
     */
    public int minimumPushes(String word) {
        int[] sortedCount = getSortedCount(word);
        int pushCost = 0;
        for (int i = sortedCount.length - 1, keyCost = 1, key = 0; i >= 0 && sortedCount[i] > 0; i--) {
            pushCost += sortedCount[i] * keyCost;
            key = (key + 1) % 8;
            keyCost += (key == 0 ? 1 : 0);
        }
        return pushCost;
    }

    private int[] getSortedCount(String word) {
        int[] sortedCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            sortedCount[word.charAt(i) - 'a']++;
        }
        Arrays.sort(sortedCount);
        return sortedCount;
    }
}
