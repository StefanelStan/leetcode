package com.ss.leetcode.LC2022.january;

public class CapitalizeTheTitle {
    // https://leetcode.com/problems/capitalize-the-title/
    /** Algorithm
     1. For a simple solution, split the title based on " " (space)
     2. Create a target tChars[] array that will hold the content of modified title
     3. For each chunk, if length > 2, copy first letter as upperCase and rest to lowerCcase, else all chunk as lowerCase
     4. Keep an index pointer to the current tChars, each time increasing it with the length of the current chunk + 1 (the space between words)
     */
    public String capitalizeTitle(String title) {
        char[] tChars = new char[title.length()];
        String[] chunks = title.split(" ");
        int index = 0;
        for (int i = 0; i < chunks.length; i++) {
            if (chunks[i].length() > 2) {
                tChars[index++] = Character.toUpperCase(chunks[i].charAt(0));
                copyToLower(tChars, index, chunks[i], 1);
                index += chunks[i].length() -1;
            } else {
                copyToLower(tChars, index, chunks[i], 0);
                index += chunks[i].length();
            }
            if(i < chunks.length -1) {
                tChars[index++] = ' ';
            }
        }
        return new String(tChars);
    }

    private void copyToLower(char[] tChars, int index, String chunk, int cStart) {
        while(cStart < chunk.length()) {
            tChars[index++] = Character.toLowerCase(chunk.charAt(cStart++));
        }
    }
}
