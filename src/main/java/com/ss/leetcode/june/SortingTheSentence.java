package com.ss.leetcode.june;

public class SortingTheSentence {
    // https://leetcode.com/problems/sorting-the-sentence/
    public String sortSentence(String s) {
        String[] chunks = s.split(" ");
        String[] finals = new String[chunks.length];
        for (String chunk : chunks) {
            int index = chunk.charAt(chunk.length() -1) - 49;
            finals[index] = chunk.substring(0, chunk.length()-1);
        }
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < finals.length; i++) {
            stb.append(finals[i]);
            if (i != finals.length -1) {
                stb.append(' ');
            }
        }
        return stb.toString();
    }
}
