package com.ss.leetcode.august;

public class RansomNote {
    // https://leetcode.com/problems/ransom-note/
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineLetters = new int[26];
        int[] ransomNoteLetters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magazineLetters[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteLetters[ransomNote.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNoteLetters.length; i++) {
            if (ransomNoteLetters[i] > magazineLetters[i]) {
                return false;
            }
        }
        return true;
    }
}
