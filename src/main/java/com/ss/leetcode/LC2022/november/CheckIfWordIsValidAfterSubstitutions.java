package com.ss.leetcode.LC2022.november;

public class CheckIfWordIsValidAfterSubstitutions {
    // https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
    /** Algorithm
         1. Use a stack to add chars from the string
         2. Loop over the chars from s and :
             -  If current char a or b, add it to queue
             -  Else (if it's 'c') check the last 2 from the stack are 'b' and 'a'.
                If yes (they would form a b c) remove them from stack. If no, add c to stack
         3. If the string is valid, then the stack is empty
         4. As optimisation, I am using a char[] and an index size / currentIndex to imitate the stack for faster access.
     */
    public boolean isValid(String s) {
        int size = 0;
        int insertIndex = 0;
        char[] chars = new char[s.length()];
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == 'c' && size > 1 && chars[size - 1] == 'b' && chars[size - 2] == 'a') {
                size -= 2;
                insertIndex -= 2;
            } else {
                chars[insertIndex++] = ch;
                size++;
            }
        }
        return size == 0;
    }
}
