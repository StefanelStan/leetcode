package com.ss.leetcode.june;

//import java.util.Set;

public class DetermineIfStringHalvesAreAlike {
    // https://leetcode.com/problems/determine-if-string-halves-are-alike/
    // Set solution is more elegant but pure int comparison is the fastest
//    Set<Integer> vowels = Set.of((int)'a', (int)'e', (int)'i', (int)'o', (int)'u', (int)'A', (int)'E', (int)'I', (int)'O', (int)'U');
    public boolean halvesAreAlike(String s) {
        int firstHalfVowels = 0, secondHalfVowels = 0;
        for (int i = s.length() / 2 -1, j = i + 1; i >=0;  i--, j++) {
            if (isVowel((int)s.charAt(i))) {
                firstHalfVowels++;
            }
            if (isVowel((int)s.charAt(j))) {
                secondHalfVowels++;
            }
        }

        return firstHalfVowels == secondHalfVowels;
    }

    private boolean isVowel(int c) {
        return c == 65 || c == 69 || c == 73 || c == 79 || c == 85 || c == 97
                || c == 101 || c == 105 || c == 111 || c== 117;
    }
}
