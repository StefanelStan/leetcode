package com.ss.leetcode.LC2022.july;

public class DecodeTheMessage {
    // https://leetcode.com/problems/decode-the-message/
    /** Algorithm
         1. Build an array of mappings
             EASY: You can use a map and map each character to it's index, starting from a to z
             PRO:
             - Use an array char[] mapping and an index. Stop when index is 26.
             - For each char of key, if mapping[ch - 'a'] == 0, this needs mapping.
             Map it to index + 'a' (the next available letter, in order): t -> a. so mapping[19] = 'a'.
             Thus, as in #Example 1, the mapping becomes vigycnzbfphuqmkrdjsaetloxw (a -> v, b->i ...)
         2. Traverse the message and for each char replace it with its mapping.
     */
    public String decodeMessage(String key, String message) {
        char[] mapping = mapCharacters(key.toCharArray());
        return decodeMessage(mapping, message.toCharArray());
    }

    private char[] mapCharacters(char[] chrs) {
        char[] mapping = new char[26];
        int mappingIndex = 0;
        int codePoint;
        int space = ' ' - 'a';
        for (char ch : chrs) {
            codePoint = ch - 'a';
            if (codePoint != space && mapping[codePoint] == 0) {
                mapping[codePoint] = (char)(mappingIndex + 'a');
                if(++mappingIndex == mapping.length) {
                    break;
                }
            }
        }
        return mapping;
    }

    private String decodeMessage(char[] mapping, char[] message) {
        StringBuilder decoded =  new StringBuilder(message.length);
        for (char ch : message) {
            decoded.append(ch == ' ' ? ch : mapping[ch - 'a']);
        }
        return decoded.toString();
    }
}
