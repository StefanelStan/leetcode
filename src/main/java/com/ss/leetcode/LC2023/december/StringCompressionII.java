package com.ss.leetcode.LC2023.december;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StringCompressionII {
    // https://leetcode.com/problems/string-compression-ii
    // Needs fixing
    // maybe have a DP of threshold points a3b2a6c5 by 101. And you select a deletion point (from th3 to th2 or th2 to th1) and pass to it next;
    public int getLengthOfOptimalCompression(String s, int k) {
        PriorityQueue<CharThreshold> compensation = getCompensationPoints(s);
        CharThreshold ct;
        while (!compensation.isEmpty() && k >= compensation.peek().distance) {
            ct = compensation.poll();
            k -= ct.distance;
            ct.trimDistance();
            if (ct.length > 0){
                compensation.add(ct);
            }
        }
        return getSizeOf(compensation);
    }

    private int getSizeOf(PriorityQueue<CharThreshold> compensation) {
        int size = 0;
        for (CharThreshold ct : compensation) {
            size += 1 + (ct.length == 100 ? 3 : ct.length > 9 ? 2 : 1);
        }
        return size;
    }

    private PriorityQueue<CharThreshold> getCompensationPoints(String s) {
        PriorityQueue<CharThreshold> points = new PriorityQueue<>(Comparator.comparingInt(ct -> ct.distance));
        char prevChar = s.charAt(0), currentChar;
        int charCount = 1;
        for (int i = 1; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (prevChar != currentChar) {
                points.add(new CharThreshold(charCount));
                charCount = 0;
            }
            charCount++;
            prevChar = currentChar;
        }
        points.add(new CharThreshold(charCount));
        return points;
    }

    private static class CharThreshold {
        int length;
        int distance;

        public CharThreshold(int length) {
            this.length = length;
            this.distance = getDistance();
        }

        private int getDistance() {
            if (length == 100) {
                return 1;
            }
            return length > 9 ? length - 9 : length;
        }

        private void trimDistance() {
            length -= distance;
            distance = getDistance();
        }
    }
}
