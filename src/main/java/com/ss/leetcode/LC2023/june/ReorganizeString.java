package com.ss.leetcode.LC2023.june;

import java.util.PriorityQueue;

public class ReorganizeString {
    /** Algorithm
        1. Count the letters and put them into a priorityQueue with reverse order: EG: [a, 10],[r,8],[t,6].
        2. Use a StringBuilder to build the string.
        3. While queue is not empty, poll the head.
        3a. If head != last char added to stb, add the char to stb, reduce the count of it, and,
            if count > 0, add it back to queue.
        3b. If head == lastChar in stb, poll the next head and append the char to stb.
            Update the nextHead count and add both of them back to queue.
        3c. Else (queue is empty and no other distinct char can be appended) return "" immediately.
        4. Return stb.toString(if 3c has not returned yet).
     */
    public String reorganizeString(String s) {
        PriorityQueue<CharNumber> chars = getCharNumbers(s);
        return reorganizeString(chars, s.length());
    }

    private String reorganizeString(PriorityQueue<CharNumber> chars, int length) {
        StringBuilder stb = new StringBuilder(length);
        char lastChar = 0;
        CharNumber topQueue;
        while(!chars.isEmpty()) {
            topQueue = chars.poll();
            if (lastChar != topQueue.ch) {
                lastChar = appendToString(stb, topQueue, chars);
            } else if (!chars.isEmpty()) {
                lastChar = appendToString(stb, chars.poll(), chars);
                chars.add(topQueue);
            } else {
                return "";
            }
        }
        return stb.toString();
    }

    private char appendToString(StringBuilder stb, CharNumber charNumber, PriorityQueue<CharNumber> chars) {
        stb.append(charNumber.ch);
        charNumber.count--;
        if (charNumber.count > 0) {
            chars.add(charNumber);
        }
        return charNumber.ch;
    }

    private PriorityQueue<CharNumber> getCharNumbers(String s) {
        PriorityQueue<CharNumber> chars = new PriorityQueue<>((a,b) -> Integer.compare(b.count, a.count));
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                chars.add(new CharNumber((char)(i + 'a'), count[i]));
            }
        }
        return chars;
    }

    private static class CharNumber {
        char ch;
        int count;
        public CharNumber(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
