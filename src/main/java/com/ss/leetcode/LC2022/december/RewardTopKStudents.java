package com.ss.leetcode.LC2022.december;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class RewardTopKStudents {
    // https://leetcode.com/problems/reward-top-k-students
    /** Algorithm: Calculate the score for each student and place it in a priority queue. Retain and return the best k students
         1. Store the positive/negative feedback words in two sets for instance detection of each word in the report
         2. For each student, check if the words in the report are found in positive/negative sets. Add 3 or decrement 1 for each case
         3. Add each student in a priority queue that will compare based on score (low, high) but reverse on id (high id, low id).
            This way, when queue gets full (> size of 3), we eliminate the lowest student with the highest id
         4. Put the results of the qeeue in a linkedList, always addingFirst (so end of pqueue will be the head of list - the highest score)
         5. Return the list.
     */
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        LinkedList<Integer> topStudents = new LinkedList<>();
        Set<String> positiveWords = Arrays.stream(positive_feedback).collect(Collectors.toSet());
        Set<String> negativeWords = Arrays.stream(negative_feedback).collect(Collectors.toSet());
        PriorityQueue<StudentScore> studentHeap = new PriorityQueue<>((a,b) -> a.score == b.score ? b.id - a.id : a.score - b.score);
        for (int i = 0; i < report.length; i++) {
            studentHeap.add(getStudentScore(report[i], student_id[i], positiveWords, negativeWords));
            if (studentHeap.size() > k) {
                studentHeap.poll();
            }
        }
        while (!studentHeap.isEmpty()) {
            topStudents.addFirst(studentHeap.poll().id);
        }
        return topStudents;
    }


    private StudentScore getStudentScore(String report, int id, Set<String> positiveWords, Set<String> negativeWords) {
        int score = 0;
        String[] words = report.split(" ");
        for (String word : words) {
            if (positiveWords.contains(word)) {
                score += 3;
            } else if (negativeWords.contains(word)) {
                score--;
            }
        }
        return new StudentScore(id, score);

    }

    private static class StudentScore {
        int id;
        int score;

        public StudentScore(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
}
