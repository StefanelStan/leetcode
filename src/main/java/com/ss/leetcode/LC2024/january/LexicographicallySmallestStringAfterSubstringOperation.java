package com.ss.leetcode.LC2024.january;

public class LexicographicallySmallestStringAfterSubstringOperation {
    // https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation
    /** Algorithm
        1. Create a char[] chrs = copy of S. You will make operations on this chrs.
        2. Traverse chrs and determine current char and its replacement;
        3. If replacement < ch, set a boolean flag replacement = true and replace current char with replacement
        4. If replacement > ch (eg: replacement of a is z) AND you are in process of replacing, then break immediately.
            You have reached the point where you should not replace anymore. Return new String(chrs)
        5. At the end, if you still have not returned, it means you did not make any replacement, because of edge case
            string "a..a". As you MUST make one replacement, replace the last char with z.
     */
    public String smallestString(String s) {
        char[] chrs = s.toCharArray();
        char ch, replacement = 0;
        boolean replacing = false;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            replacement = (ch == 'a' ? 'z' : (char)(ch - 1));
            if (replacement > ch && replacing) {
                return new String(chrs);
            } else if (replacement < ch) {
                replacing = true;
                chrs[i] = replacement;
            }
        }
        if (!replacing) {
            chrs[chrs.length -1] = 'z';
        }
        return new String(chrs);
    }
}
