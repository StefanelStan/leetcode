package com.ss.leetcode.LC2022.june;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorderDataInLogFiles {
    // https://leetcode.com/problems/reorder-data-in-log-files/
    /** Algorithm
         1. Declare a class LetterLog that holds identifier, words and log itself, implementing Comparable
         based on the described rules.
         2. Declare a PriorityQueue<> of this type that will hold the letter type of logs.
         3. Traverse the array from the back,  with i = size -1 and also hold a special insertIndex = size- 1;
         4. Upon traversing the logs with i,
             - if log is a digit log, then move it at the end, at the insertIndex position and decrement insertIndex.
             - if the log is NOT a digit log, then add it to the priority queue.
         5. At the end, if priority queue is empty, return the logs, as no sorting is required.
         6. Else, while queue is not empty, extract one element at a time and add it in order, from 0, overriding logs[0...].
     */
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 1) {
            return logs;
        }
        int insertIndex = logs.length - 1;
        String[] answer =  new String[logs.length];
        PriorityQueue<LetterLog> letterLogs = new PriorityQueue<>();
        for (int i = logs.length -1; i >= 0; i--) {
            if (logs[i].charAt(logs[i].length() -1) >= 'a') {
                letterLogs.add(new LetterLog(logs[i]));
            } else {
                answer[insertIndex] = logs[i];
                insertIndex--;
            }
        }

        int i = 0;
        while(!letterLogs.isEmpty()) {
            answer[i] = letterLogs.poll().log;
            i++;
        }
        return answer;
    }

    private static class LetterLog implements Comparable<LetterLog>{
        String identifier;
        String content;
        String log;

        public LetterLog(String log) {
            int firstSpace = log.indexOf(' ');
            this.identifier = log.substring(0, firstSpace);
            this.content = log.substring(firstSpace + 1);
            this.log = log;
        }

        @Override
        public int compareTo(LetterLog o) {
            int c1 = content.compareTo(o.content);
            return c1 == 0 ? identifier.compareTo(o.identifier) : c1;
        }
    }

    public String[] reorderLogFiles2(String[] logs) {
        if (logs.length == 1) {
            return logs;
        }
        int letterLogIndex = 0, insertIndex = logs.length -1;
        String[][] letterLogs = new String[logs.length][3];
        for (int i = logs.length -1; i >=0; i--) {
            if (logs[i].charAt(logs[i].length() -1) >= 'a') {
                addToLetterLogs(letterLogs, letterLogIndex, logs[i]);
                letterLogIndex++;
            } else {
                logs[insertIndex] = logs[i];
                insertIndex--;
            }
        }
        if (letterLogIndex == 0) {
            return logs;
        }
        Arrays.sort(letterLogs, 0, letterLogIndex, Comparator.comparing((String[] a) -> a[1]).thenComparing(a -> a[0]));
        for (int i = 0; i < letterLogIndex; i++) {
            logs[i] = letterLogs[i][2];
        }
        return logs;
    }

    private void addToLetterLogs(String[][] letterLogs, int index, String letterLog) {
        int firstSpace = letterLog.indexOf(' ');
        letterLogs[index][0] = letterLog.substring(0, firstSpace);
        letterLogs[index][1] = letterLog.substring(firstSpace +1);
        letterLogs[index][2] = letterLog;
    }
}
