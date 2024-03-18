package com.ss.leetcode.LC2024.march;

import java.util.Arrays;

public class ApplyOperationsToMakeStringEmpty {
    // https://leetcode.com/problems/apply-operations-to-make-string-empty
    /** Algorithm
        1. Use an int[] count to count/track [occurances, LAST INDEX, codePoint].
            - It is important to keep track of lastIndex of each char, as this will dictate what letter has priority in your answer string
        2. Traverse and count each letter, keeping track of [count, last_Index, codePoint]
        3. Sort it by count (a[0]) and by lastIndex (a[1]).
        4. This way, the letters with max count will be at the end, sorted by their last index.
        5. Traverse the count and IF current count == MAX_COUNT, add that letter in the answer.
            - Because we have also sorted by the last_index, it is guaranteed they will be put in the order of last occurance.
     */
    public String lastNonEmptyString(String s) {
        int[][] countAndLastIndex = new int[26][3];
        int maxCount = 0, codePoint = 0;
        for (int i = 0; i < s.length(); i++) {
            codePoint = s.charAt(i) - 'a';
            countAndLastIndex[codePoint][0]++;
            countAndLastIndex[codePoint][1] = i;
            countAndLastIndex[codePoint][2] = codePoint;
            maxCount = Math.max(maxCount, countAndLastIndex[codePoint][0]);
        }
        Arrays.sort(countAndLastIndex, (a,b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        StringBuilder stb = new StringBuilder();
        for (int[] count : countAndLastIndex) {
            if (count[0] == maxCount) {
                stb.append((char)(count[2] + 'a'));
            }
        }
        return stb.toString();
    }
}
