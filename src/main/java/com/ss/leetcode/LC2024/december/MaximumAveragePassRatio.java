package com.ss.leetcode.LC2024.december;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    // https://leetcode.com/problems/maximum-average-pass-ratio
    /** Algorithm
        1. Use a priority queue to store the classes
        2. Each class can get a boost by extra students. Put each class in the priproty queue.
        3. The boost is given by the difference of newAverage (pass + 1) / (total + 1) and current average (pass / total)
        4. Sort the queue by the highest boost. Poll from it, adjust the average and put it back.
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double averageSum = 0;
        PriorityQueue<StudentClass> sortedClasses = new PriorityQueue<>(Comparator.comparingDouble(StudentClass::getAverageBoost).reversed());
        for (int[] aClass : classes) {
            averageSum += ((double)aClass[0] / aClass[1]);
            if (aClass[0] != aClass[1]) {
                sortedClasses.add(new StudentClass(aClass[0], aClass[1]));
            }
        }
        StudentClass polled;
        if (!sortedClasses.isEmpty()) {
            while (extraStudents > 0) {
                polled = sortedClasses.poll();
                averageSum -= polled.currentAverage;
                averageSum += polled.proposedAverage;
                sortedClasses.add(new StudentClass(++polled.pass, ++polled.total));
                extraStudents--;
            }
        }
        return averageSum / classes.length;
    }

    private static class StudentClass {
        int pass;
        int total;
        double currentAverage;
        double proposedAverage;

        public StudentClass(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.currentAverage = (double)pass / total;
            this.proposedAverage = (double)(pass + 1) / (total + 1);
        }

        public double getAverageBoost() {
            return this.proposedAverage - this.currentAverage;
        }
    }
}
