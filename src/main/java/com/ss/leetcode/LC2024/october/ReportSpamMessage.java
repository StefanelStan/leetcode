package com.ss.leetcode.LC2024.october;

import java.util.HashSet;
import java.util.Set;

public class ReportSpamMessage {
    // https://leetcode.com/problems/report-spam-message
    /** Algorithm
        1. Add all bannedWords into a set.
        2. For each word in message, increment a counter IF the set contains that word.
        3. Return counter >= 2;
     */
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> banned = new HashSet<>(bannedWords.length);
        for (String word : bannedWords) {
            banned.add(word);
        }
        int count = 0;
        for (int i = 0; i < message.length && count < 2; i++) {
            count += banned.contains(message[i]) ? 1 : 0;
        }
        return count >= 2;
    }
}
