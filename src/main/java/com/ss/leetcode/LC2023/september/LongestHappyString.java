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
        StringBuilder stb = new StringBuilder(a + b + c);
        PriorityQueue<CharCount> queue = appendToQueue(a,b,c);
        CharCount head;
        char lastAdded = 0;
        while(!queue.isEmpty()) {
            head = queue.poll();
            if (lastAdded != head.ch) {
                lastAdded = appendAndInsert(stb, queue, head, queue.peek());
            } else if (!queue.isEmpty()) {
                appendAndInsert(stb, queue, queue.poll(), head);
                lastAdded = appendAndInsert(stb, queue, head, queue.peek());
            } else {
                break;
            }
        }
        return stb.toString();
    }

    private char appendAndInsert(StringBuilder stb, PriorityQueue<CharCount> queue, CharCount element, CharCount maybeNext) {
        // add 1 or 2 ?
        boolean shouldAddTwo = true;
        if (maybeNext != null) {
            shouldAddTwo = element.count - maybeNext.count > 2;
        }
        if (element.count-- > 0) {
            stb.append(element.ch);
        }
        if (shouldAddTwo && element.count-- > 0) {
            stb.append(element.ch);
        }
        if (element.count > 0) {
            queue.add(element);
        }
        return element.ch;
    }

    private PriorityQueue<CharCount> appendToQueue(int a, int b, int c) {
        PriorityQueue<CharCount> queue = new PriorityQueue<>((e1,e2) -> Integer.compare(e2.count, e1.count));
        append(queue, 'a', a);
        append(queue, 'b', b);
        append(queue, 'c', c);
        return queue;
    }

    private void append(PriorityQueue<CharCount> queue, char ch, int count) {
        if (count > 0) {
            queue.add(new CharCount(ch, count));
        }
    }

    private static class CharCount {
        private final char ch;
        private int count;

        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
