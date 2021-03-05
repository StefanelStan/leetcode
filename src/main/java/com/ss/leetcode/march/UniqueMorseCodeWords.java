package com.ss.leetcode.march;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    //    private static final Map<Character, String> MORSE_CODE = new HashMap<>();
//    static {
//        MORSE_CODE.put('a', ".-");
//        MORSE_CODE.put('b', "-...");
//        MORSE_CODE.put('c', "-.-.");
//        MORSE_CODE.put('d', "-..");
//        MORSE_CODE.put('e', ".");
//        MORSE_CODE.put('f', "..-.");
//        MORSE_CODE.put('g', "--.");
//        MORSE_CODE.put('h', "....");
//        MORSE_CODE.put('i', "..");
//        MORSE_CODE.put('j', ".---");
//        MORSE_CODE.put('k', "-.-");
//        MORSE_CODE.put('l', ".-..");
//        MORSE_CODE.put('m', "--");
//        MORSE_CODE.put('n', "-.");
//        MORSE_CODE.put('o', "---");
//        MORSE_CODE.put('p', ".--.");
//        MORSE_CODE.put('q', "--.-");
//        MORSE_CODE.put('r', ".-.");
//        MORSE_CODE.put('s', "...");
//        MORSE_CODE.put('t', "-");
//        MORSE_CODE.put('u', "..-");
//        MORSE_CODE.put('v', "...-");
//        MORSE_CODE.put('w', ".--");
//        MORSE_CODE.put('x', "-..-");
//        MORSE_CODE.put('y', "-.--");
//        MORSE_CODE.put('z', "--..");
//    }
//
//    public int uniqueMorseRepresentations(String[] words) {
//        Set<String> wordsSet = new HashSet<>();
//        StringBuilder stb = new StringBuilder();
//        for(String word: words) {
//
//            for (int i = 0; i < word.length();i++) {
//                stb.append(MORSE_CODE.get(word.charAt(i)));
//            }
//            wordsSet.add(stb.toString());
//            stb = new StringBuilder();
//        }
//        return wordsSet.size();
//    }
    String[] letters = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
            "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> wordsSet = new HashSet<>();
        StringBuilder stb = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                stb.append(letters[word.charAt(i) - 'a']);
            }
            wordsSet.add(stb.toString());
            stb = new StringBuilder();
        }
        return wordsSet.size();
    }
}
