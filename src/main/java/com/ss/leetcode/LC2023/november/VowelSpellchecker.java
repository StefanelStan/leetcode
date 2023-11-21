package com.ss.leetcode.LC2023.november;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellchecker {
    // https://leetcode.com/problems/vowel-spellchecker
    /** Algorithm
        1. Use a Set<String> exactWords, Map<String, String> lowerCase and Map<String, String> replacedVowels to contain the words.
        2. For each word in wordList
            - add the word in exactWords set. This will be the first to be queried when looping over queries
            - add the lowercase version of word in lowerCase using putIfAbsent.
                PutIfAbsent guarantees that you will only get the first such match in the wordlist
            - for each letter of word, if it's a vowel, replace it with *, else putIfAbsent the lowercase version of
                character/word in replacedVowels map.
                PutIfAbsent guarantees that you will only get the first such match in the wordlist
        3. For each query
            - Check in exactWords String.
            - If not, make the query lowercase and check in lowerCase map.
            - If not, replace vowels with *, other chars with lowercase and check in replacedVowels map.
            - Return "" if not found in any.
     */
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> lowerCase = new HashMap<>();
        Map<String, String> replacedVowels = new HashMap<>();
        populateWords(wordlist, exactWords, lowerCase, replacedVowels);
        return answerQueries(queries, exactWords, lowerCase, replacedVowels);
    }

    private String[] answerQueries(String[] queries, Set<String> exactWords, Map<String, String> lowerCase, Map<String, String> replacedVowels) {
        String[] answers = new String[queries.length];
        StringBuilder lowerCaseStb = new StringBuilder();
        StringBuilder replacedVowelsStb = new StringBuilder();
        String answer;
        for (int i = 0; i < queries.length; i++) {
            lowerCaseStb.setLength(0);
            replacedVowelsStb.setLength(0);
            if (exactWords.contains(queries[i])) {
                answer = queries[i];
            } else {
                getSpecialWordForms(lowerCaseStb, replacedVowelsStb, queries[i]);
                answer = lowerCase.get(lowerCaseStb.toString());
                if (answer == null) {
                    answer = replacedVowels.getOrDefault(replacedVowelsStb.toString(), "");
                }
            }
            answers[i] = answer;
        }
        return answers;
    }

    private void populateWords(String[] words, Set<String> exactWords, Map<String, String> lowerCase, Map<String, String> replacedVowels) {
        StringBuilder lowerCaseStb = new StringBuilder();
        StringBuilder replacedVowelsStb = new StringBuilder();
        for (String word : words) {
            exactWords.add(word);
            lowerCaseStb.setLength(0);
            replacedVowelsStb.setLength(0);
            getSpecialWordForms(lowerCaseStb, replacedVowelsStb, word);
            lowerCase.putIfAbsent(lowerCaseStb.toString(), word);
            replacedVowels.putIfAbsent(replacedVowelsStb.toString(), word);
        }
    }

    private void getSpecialWordForms(StringBuilder lowerStb, StringBuilder vowelStb, String word) {
        char lowerCh;
        for (int i = 0; i < word.length(); i++) {
            lowerCh = Character.toLowerCase(word.charAt(i));
            lowerStb.append(lowerCh);
            vowelStb.append(isVowel(lowerCh) ? '*' : lowerCh);
        }
    }

    private boolean isVowel(char ch) {
        return switch(ch) {
            case 'a','e','i','o','u' -> true;
            default -> false;
        };
    }
}
