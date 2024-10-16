package com.ss.leetcode.LC2023.september;

import java.util.PriorityQueue;

public class LongestHappyString {
    // https://leetcode.com/problems/longest-happy-string
    /** Algorithm
        1. Use a PriorityQueue (reverse order by count) to store the count of each letter and a StringBuilder to build the string
        2. If the last added letter is different than the head of the queue, poll() and add 1 or 2 letter.
        3. If last added letter is == head of queue, then add the next in line and then the head chars.
        4. Else, if queue is empty, break
        5. Adding to StringBuilder.
            - You can add 1 or 2 chars. If the difference between head and next >2, then take 2 chars, else 1.
            - This is to cover the edge cases of 10a4b -> aabaabaabaabaa.
     */
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharAndCount> letters = getLetters(a,b,c);
        StringBuilder stb = new StringBuilder();
        CharAndCount firstOnQueue;
        char prevAdded = 0;
        while(!letters.isEmpty()) {
            firstOnQueue = letters.poll();
            prevAdded = stb.isEmpty() ? 0 : stb.charAt(stb.length() - 1);
            if (firstOnQueue.ch != prevAdded || stb.length() == 1 || stb.charAt(stb.length() - 2) != prevAdded) {
                appendAndAddToQueue(firstOnQueue, letters, stb);
            } else if (letters.isEmpty()) {
                break;
            } else {
                appendAndAddToQueue(letters.poll(), letters, stb);
                appendAndAddToQueue(firstOnQueue, letters, stb);
            }
        }
        return stb.toString();
    }

    private PriorityQueue<CharAndCount> getLetters(int... cardinal) {
        PriorityQueue<CharAndCount> letters = new PriorityQueue<>((x,y) -> Integer.compare(y.count, x.count));
        for (int i = 0; i < cardinal.length; i++) {
            if (cardinal[i] > 0) {
                letters.add(new CharAndCount((char)('a' + i), cardinal[i]));
            }
        }
        return letters;
    }

    private void appendAndAddToQueue(CharAndCount charAndCount, PriorityQueue<CharAndCount> letters, StringBuilder stb) {
        stb.append(charAndCount.ch);
        if(--charAndCount.count > 0) {
            letters.add(charAndCount);
        }
    }

    private static class CharAndCount {
        char ch;
        int count;
        public CharAndCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
