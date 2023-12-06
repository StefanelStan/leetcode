package com.ss.leetcode.LC2023.december;

public class MinimumAdditionsToMakeValidString {
    // https://leetcode.com/problems/minimum-additions-to-make-valid-string
    /** Algorithm: eg: BAB
        1. Traverse the string backwards and insert letters that will match the given pattern in reverse order.
            (match c, match b, a)
        2. If your current letter in word does not match the pattern, an insertion is needed. So increment additions.
            - Current letter: b: (index 2) "bab", patternIndex = 2 (c).
            - An insertion is needed, so the string can virtually become "babc". Now last letter of the word matches last pattern letter
        3. Your current index is still 2, but your patternIndex is now 1 (above b in abc).
            As word[2] matches pattern[1], the wordIndex can shift left. Pattern also shifts left
        4. word[1] = a matches pattern[0] So no insertion. As patters reached 0, it will go back to 2
        5. word[0] = b does not match pattern[3] (c). An insertion is needed.
        6. word[0] = b matches pattern[1] (b). No insertion and both indices shift left
        7. As we finished the string, we see the pattern index is still @ index 1. Thus, is also needed to be added as addition.
     */
    public int addMinimum(String word) {
        int patternIndex = 3, codePoint, additions = 0;
        for (int i = word.length() - 1; i >= 0;) {
            patternIndex = patternIndex == 0 ? 2 : patternIndex - 1;
            codePoint = word.charAt(i) - 'a';
            if (codePoint == patternIndex) {
                i--;
            } else {
                additions++;
            }
        }
        return additions + patternIndex;
    }
}
