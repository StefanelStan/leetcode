package com.ss.leetcode.LC2023.october;

public class MakeStringASubsequenceUsingCyclicIncrements {
    // https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments
    /** Algorithm
        1. Fast fail: if str2 is longer than str1 return false
        2. Use 2 pointers i and j over str1 / str2
        3. Traverse with i and if str1[i] == str2[j] OR a + (str1[i] + 1) % 26 == str2[j] then also increment j
        4. Break when i reaches end of str1 or j reaches end of str2
        5. Return j == str2.length() (j has passed the end of str2)
     */
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return false;
        }
        int i = 0, j = 0;
        char str1Char, str2Char;
        while (i < str1.length() && j < str2.length()) {
            str1Char = str1.charAt(i);
            str2Char = str2.charAt(j);
            if ((str1Char == str2Char) || (char)('a' + (++str1Char -  'a') % 26) == str2Char) {
                j++;
            }
            i++;
        }
        return j == str2.length();
    }
}
