package com.ss.leetcode.LC2021.june;

public class DecryptStringFromAlphabet {
    // https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
    public String freqAlphabets(String s) {
        StringBuilder stb = new StringBuilder();
        char[] sChars = s.toCharArray();
        int minusThree = sChars.length -3;
        for (int i = 0; i < sChars.length; i++) {
            if (i <= minusThree && sChars[i + 2] == '#') {
                stb.append((char)('a' + getDiff(sChars[i], sChars[i+1])));
                i += 2;
            } else {
                stb.append((char)(48 + sChars[i]));
            }
        }
        return stb.toString();
    }

    private int getDiff(char a, char b) {
        return 10 * (a - '0') + (b - '1');
    }

    public String freqAlphabets2(String s) {
        StringBuilder stb = new StringBuilder();
        String[] chunks = s.split("#");
        for(int i = 0; i < chunks.length - 1; i++) {
            stb.append(extractLetters(chunks[i], chunks[i].length() - 3));
            stb.append(Character.valueOf((char) (96 + Integer.parseInt(chunks[i].substring(chunks[i].length()-2)))));
        }
        if (s.charAt(s.length() -1) == '#') {
            stb.append(extractLetters(chunks[chunks.length-1], chunks[chunks.length-1].length() - 3));
            stb.append(Character.valueOf((char) (96 +  Integer.parseInt(s.substring(s.length()-3, s.length()-1)))));
        } else {
            stb.append(extractLetters(chunks[chunks.length-1], chunks[chunks.length-1].length() - 1));
        }

        return stb.toString();
    }

    private char[] extractLetters(String chunk, int endPoint) {
        if (endPoint < 0) {
            return new char[0];
        }
        char[] chars = new char[endPoint+1];
        for (int i = 0; i<= endPoint; i++) {
            chars[i] = (char) (96 + Character.getNumericValue(chunk.charAt(i)));
        }
        return chars;
    }

}
