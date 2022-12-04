package com.ss.leetcode.LC2022.december;

public class ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters {
    // https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters

    /** Algorithm
        1. The idea is to traverse the string from index 1 to n and when you encounter a ?,
            iterate through all letters (a-z) and find one that is different from pos -1 and pos + 1;
        2. Edge case: if length is 1, if string is ?, then return a, else return the string itself (no ? existing)
        3. Edge case for pos 0 == ?: (because we loop from 1)
             - if pos[1] is ? then set pos[0] = a (default char) and let the algo run
             - if pos[1] is not ?, then set a or b, depending on if next char a or diff than a
        4. Apply step 1 for chars of pos 1 to n.
     */
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1 && chars[0] == '?') {
            chars[0] = 'a';
        } else if (chars.length > 1 && chars[0] == '?') {
            if (chars[1] == '?') {
                chars[0] = 'a';
            } else {
                chars[0] = chars[1] == 'a' ? 'b' : 'a';
            }
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '?') {
                chars[i] = getNextAvailableChar(chars, i);
            }
        }
        return new String(chars);
    }

    private char getNextAvailableChar(char[] chars, int pos) {
        char answer = 'a';
        if (pos == chars.length - 1) {
            // if at the end of string, determine the next valid letter from 0-25 (a = 0)
            answer = (char)(((int)(chars[pos -1] - 'a' + 1) % 26) + 'a');
        } else {
            // loop from 0 to 25 (a-z) and stop at first char that is diff from left and right
            for (int i = 0; i < 26; i++) {
                answer = (char)('a' + i);
                if (chars[pos - 1] != answer && answer != chars[pos + 1]) {
                    break;
                }
            }
        }
        return answer;
    }
}
