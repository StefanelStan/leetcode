package com.ss.leetcode.LC2022.may;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    /** Algorithm
         1. Some keys/digits can have 4 chars, other 3. So cache/map each digits to its possible letters
         2. In a recursive method that takes the current index as parameter, iterate over the list of possible letters of current index
             and append that letter to all of downstream possible combinations that start from next index
             234
                 a will be appended to all list of combinations that can be made with 34
                 recursively pass index + 1 to the method to generate the combinations from 34
             34 :
                 d will be appended to all list of combinations that can be made with 4 (d + g, d + h, d+ i);
                 e will be appended to all list of combinations that can be made with 4 (e + g, e + h, e +i);
                 f will be appended to all list of combinations that can be made with 4 (e + g, e + h, e +i);
                 a will be appended to this list of 6 strings:
                 b will be appended to all list of combinations that can be made with 32
         3. Return the made up list.
     */
    private static final List<List<String>> DIGIT_LETTERS = List.of(
        List.of("a","b","c"), List.of("d","e","f"), List.of("g","h","i"), List.of("j","k","l"),
        List.of("m","n","o"), List.of("p","q","r","s"), List.of("t","u","v"), List.of("w","x","y", "z"));
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        return generateCombinations(digits, 0);
    }

    private List<String> generateCombinations(String digits, int index) {
        List<String> combinations = new ArrayList<>();
        if (index == digits.length() -1) {
            return DIGIT_LETTERS.get(digits.charAt(index) - '2');
        }
        if (index < digits.length() -1) {
            for (String s : DIGIT_LETTERS.get(digits.charAt(index) - '2')) {
                for(String nextCombination : generateCombinations(digits, index+1)) {
                    combinations.add(s + nextCombination);
                }
            }
        }
        return combinations;
    }
}
