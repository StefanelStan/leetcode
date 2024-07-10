package com.ss.leetcode.LC2024.july;

public class CrawlerLogFolder {
    // https://leetcode.com/problems/crawler-log-folder
    /** Algorithm
        1. Traverse each log and keep a minOperations variable
        2. If current log is "../" set minOperations to be max(0, minOps - 1) (go up a level)
        3. Else if log is NOT "./" then increase minOps by 1 as you go deeper into a folder.
     */
    public int minOperations(String[] logs) {
        int minOperations = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                minOperations = Math.max(0, minOperations - 1);
            } else {
                minOperations += (log.charAt(0) == '.' ? 0 : 1);
            }
        }
        return minOperations;
    }
}
