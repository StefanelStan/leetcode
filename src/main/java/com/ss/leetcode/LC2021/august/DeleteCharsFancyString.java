package com.ss.leetcode.LC2021.august;

public class DeleteCharsFancyString {
    // https://leetcode.com/contest/biweekly-contest-58/problems/delete-characters-to-make-fancy-string/
    public String makeFancyString(String s) {
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
