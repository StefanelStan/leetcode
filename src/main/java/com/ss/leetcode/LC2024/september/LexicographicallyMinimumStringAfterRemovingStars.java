package com.ss.leetcode.LC2024.september;

import java.util.PriorityQueue;

public class LexicographicallyMinimumStringAfterRemovingStars {
    // https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars
    /** Algorithm
        1. Use a PriorityQueue of class CharPosition[char, position] to keep track of closest smallest char.
        2. Traverse string and if current char is NOT a star, add it and its position to queue, else poll last char from queue and mark
            its position with * in the char[] array
        3. Traverse chars and append them to a string builder IF current char is not a star. Return the value.
     */
    public String clearStars(String s) {
        char[] sChars = s.toCharArray();
        PriorityQueue<CharPosition> leftChars = new PriorityQueue<>((a,b) -> a.ch == b.ch ? Integer.compare(b.pos, a.pos) : Character.compare(a.ch, b.ch));
        for (int i = 0; i < s.length(); i++) {
            if (sChars[i] == '*') {
                sChars[leftChars.poll().pos] = '*';
            } else {
                leftChars.add(new CharPosition(sChars[i], i));
            }
        }
        return leftChars.isEmpty() ? "" : rebuildCharacters(sChars, leftChars.size());
    }

    private String rebuildCharacters(char[] remainingChars, int size) {
        StringBuilder stb = new StringBuilder(size);
        for (char ch : remainingChars) {
            if (ch != '*') {
                stb.append(ch);
            }
        }
        return stb.toString();
    }

    private record CharPosition(char ch, int pos) {}
}
