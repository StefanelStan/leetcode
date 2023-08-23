package com.ss.leetcode.LC2023.august;

public class MaximizeNumberOfSubsequencesInAString {
    // https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string
    /** Algorithm
        1. The only way to make the best choice is to put pattern[0] at the beginning of text OR pattern[1] at the end of text.
            - If pattern[0] is put at the beginning of the text, then it will form NEW substrings with ALL
                the pattern[1] chars present in the string.
            - If pattern[1] is put at the end of text, then ALL pattern[0] chars from text will form extra subtrings with the next char added at the end.
        2. Start traversing the string from the end and count the pattern0 / pattern1 chars.
        3. If you counter an pattern0 char, then that will make substrings with all pattern1Count chars encountered so far (so total += pattern1Count)
        4. If current char is pattern1, then increase pattern1Count by 1.
        5. Pay attention to the edge case when pattern is made out of two identical chars (eg:aa).
            - In this case, step #3 needs to be adjusted. EG: pattern1Count = pattern0Count - 1;
            - EG: text = abaca , pattern  = "aa"
            - i = 4: pattern0Count = 1, pattern1Count = pattern0Count -1 = 0;
                 total += 0;
            - i = 2: pattern0Count = 2, pattern1Count = pattern0Count - 1 = 1;
                total += 1;
            - i = 0: pattern0Count = 3, pattern1Count  = pattern0Count - 1 = 2;
                total += 2.
        6. So far, we have counted how many substrings exist, but we need to add pattern0/pattern1 char
        7. If both pattern0Count/pattern1Count are 0, then we cannot make any pattern
        8. If they are both > 0, then we need to add the char that will give the best extra number of substrings: max(pattern0Count, pattern1Count).
            EG: xaaab, pattern = "ab". We have 3 by default and 3 a, 1 b
            If we add b at the end (=> xaaabb), we get 3 extra substrings
            If we add a at the beginning(axaaab), we get 1 extra substring.
            Thus, the next answer is max(pattern0Count, pattern1Count)
        9. If one of them is 0, then we can only make max(pattern0Count, pattern1Count)
            EG: 'abcdee' pattern = pe
            0 p and 2e. If we make one p, then that p can make 2 patterns with e.
     */
    public long maximumSubsequenceCount(String text, String pattern) {
        long maxSubsequence = 0;
        char ch, firstPatternChar = pattern.charAt(0), secondPatternChar = pattern.charAt(1);
        int firstPatternCharCount = 0, secondPatternCharCount = 0;
        boolean samePatternChars = firstPatternChar == secondPatternChar;
        for (int i = text.length() - 1; i >=0; i--) {
            ch = text.charAt(i);
            if (ch == firstPatternChar) {
                firstPatternCharCount++;
                if (samePatternChars) {
                    secondPatternCharCount = firstPatternCharCount - 1;
                }
                maxSubsequence += secondPatternCharCount;
            } else if (ch == secondPatternChar) {
                secondPatternCharCount++;
            }
        }
        if (firstPatternCharCount > 0 && secondPatternCharCount > 0) {
            maxSubsequence += Math.max(firstPatternCharCount, secondPatternCharCount);
        } else if (firstPatternCharCount == 0 && secondPatternCharCount == 0){
            maxSubsequence = 0;
        } else {
            maxSubsequence = Math.max(firstPatternCharCount, secondPatternCharCount);
        }
        return maxSubsequence;
    }
}
