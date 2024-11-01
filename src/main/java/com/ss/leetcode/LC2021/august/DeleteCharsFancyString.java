package com.ss.leetcode.LC2021.august;

public class DeleteCharsFancyString {
    // https://leetcode.com/contest/biweekly-contest-58/problems/delete-characters-to-make-fancy-string/
    /** Algorithm
        1. Use a StringBuilder to append the good chars into it
        2. Use 2 variables: prev and prevPrev to retain the last 2 inserted chars
        3. If current char is != prev and currentChar != prevPrev , insert new char in stringbuilder. Also shift prev and prevPrev to new char.
        4. Return stb.toString().
     */
    public String makeFancyString(String s) {
        StringBuilder stb = new StringBuilder();
        char currentChar, prev = 0, prevPrev = 0;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (currentChar != prev || currentChar != prevPrev) {
                prevPrev = prev;
                prev = currentChar;
                stb.append(currentChar);
            }
        }
        return stb.toString();
    }


    public String makeFancyString2(String s) {
        char[] ch = new char[s.length()];
        int chIndex = 0;
        int endSeqIndex = 0;
        for (int i = 0; i < s.length(); ) {
            if (i < s.length() - 2) {
                if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 2)) {
                    endSeqIndex = getEndSeqIndex(s, s.charAt(i), i + 3);
                    ch[chIndex++] = s.charAt(i);
                    ch[chIndex++] = s.charAt(i);
                    i = endSeqIndex;
                    if (i == s.length() -1 && ch[chIndex -1] == s.charAt(s.length()-1)) break;
                } else {
                    ch[chIndex++] = s.charAt(i++);
                }
            } else {
                ch[chIndex++] = s.charAt(i++);
            }
        }

        return String.valueOf(ch, 0, chIndex);
    }

    private int getEndSeqIndex(String s, char toEqual, int i) {
        int end = 0;
        while (i < s.length()) {
            if (s.charAt(i) != toEqual) {
                return i;
            }
            i++;
        }
        return s.length() - 1;
    }
}
