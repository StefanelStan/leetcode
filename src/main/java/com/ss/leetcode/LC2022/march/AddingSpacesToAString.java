package com.ss.leetcode.LC2022.march;

public class AddingSpacesToAString {
    // https://leetcode.com/problems/adding-spaces-to-a-string/submissions/
    /** Algorithm:
         1. Declare a target chrs[] that will hold the resulting array
         2. Iterate over s and spaces with i and j, setting the chrs[k] result
         3. If current i == spaces[j] (if you are at a space index), set chars[k] = ' ' and increase j
         If not a space, add the char i from s to chrs[k].
         4. Increase the k after each step.
         5. Return the string.
     */
    public String addSpaces(String s, int[] spaces) {
        if (spaces.length == 0) {
            return s;
        }
        char[] chrs = new char[s.length() + spaces.length];
        for (int i = 0, j = 0, k = 0; i < s.length();) {
            if (j < spaces.length && i == spaces[j]) {
                chrs[k++] = ' ';
                j++;
            } else {
                chrs[k++] = s.charAt(i++);
            }
        }
        return new String(chrs);
    }
}
