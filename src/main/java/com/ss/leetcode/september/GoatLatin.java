package com.ss.leetcode.september;

public class GoatLatin {
    // https://leetcode.com/problems/goat-latin/
    private static boolean[] vowels = null;

    public String toGoatLatin(String sentence) {
        if (vowels == null) {
            initializeVowels();
        }
        String[] words = sentence.split(" ");
        StringBuilder stb =  new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (vowels[words[i].charAt(0)]) {
                stb.append(words[i]);
                stb.append("ma");
                stb.append("a".repeat(i + 1));
                stb.append(" ");
            } else {
                stb.append(words[i].substring(1));
                stb.append(words[i].charAt(0));
                stb.append("ma");
                stb.append("a".repeat(i + 1));
                stb.append(" ");
            }
        }
        return stb.substring(0, stb.length() -1);
    }

    private void initializeVowels() {
        vowels = new boolean['z' + 1];
        vowels['a'] = true;
        vowels['e'] = true;
        vowels['i'] = true;
        vowels['o'] = true;
        vowels['u'] = true;
        vowels['A'] = true;
        vowels['E'] = true;
        vowels['I'] = true;
        vowels['O'] = true;
        vowels['U'] = true;
    }
}
