package com.ss.leetcode.LC2021.june;

//import java.util.Set;

public class DetermineIfStringHalvesAreAlike {
    // https://leetcode.com/problems/determine-if-string-halves-are-alike/
    // Set solution is more elegant but pure int comparison is the fastest
//    Set<Integer> vowels = Set.of((int)'a', (int)'e', (int)'i', (int)'o', (int)'u', (int)'A', (int)'E', (int)'I', (int)'O', (int)'U');
    private static final char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
    public boolean halvesAreAlike(String s) {
        int firstHalfCount = countChars(s, 0, s.length() / 2 - 1);
        int secondHalfCount = countChars(s, s.length() / 2, s.length() -1);
        return firstHalfCount == secondHalfCount;
    }

    private int countChars(String s, int from, int to) {
        int[] count = new int['z' + 1];
        while(from <= to) {
            count[s.charAt(from)]++;
            from++;
        }
        int total = 0;
        for (char vowel : vowels) {
            total += count[vowel];
        }
        return total;
    }


    public boolean halvesAreAlike2(String s) {
        int firstHalfVowels = 0, secondHalfVowels = 0;
        for (int i = s.length() / 2 -1, j = i + 1; i >=0;  i--, j++) {
            if (isVowel(s.charAt(i))) {
                firstHalfVowels++;
            }
            if (isVowel(s.charAt(j))) {
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
