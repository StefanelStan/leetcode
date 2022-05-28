package com.ss.leetcode.LC2022.may;

import java.util.HashMap;
import java.util.Map;

public class SenderWithLargestWordCount {
    // https://leetcode.com/problems/sender-with-largest-word-count/
    /** Algorithm
     *  1. Loop over each message, get the number of words and pap the sender to its number of words
     *  2. Loop over the map and if the number of words is grater than current number, set the new sender
     *     If the number of words is = to current max known, set the sender to be the largest between current
     *     heaviest sender and current index sender
     */
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> wordCount = new HashMap<>();

        for(int i = 0; i < messages.length; i++) {
            wordCount.merge(senders[i], getWordCount(messages[i]), Integer::sum);
        }
        final String[] largestName = {""};
        final int[] max = {0};
        wordCount.forEach((k, v) -> {
            if(v > max[0]) {
                max[0] = v;
                largestName[0] = k;
            } else if (v == max[0]) {
                largestName[0] = largestName[0].compareTo(k) > 0 ? largestName[0] : k;
            }
        });
        return largestName[0];
    }

    private int getWordCount(String s) {
        int spaceCount = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        return spaceCount + 1;
    }
}
