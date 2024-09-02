package com.ss.leetcode.LC2024.september;

public class FindTheStudentThatWillReplaceTheChalk {
    // https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk
    /** Algorithm
        1. Imagine running a simulation, giving chalk[i] piles of chalk to each student.
        2. If K is large enough, this simulation could run many times.
        3. To trim this, we only need to know the k % sum_of_chalk
        4. Find this and loop over chalk, deducting chalk[i] from the modulo. Stop when you reach 0.
     */
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int item : chalk) {
            sum += item;
        }
        k = (int)((long)k % sum);
        int index = 0;
        while (k > 0) {
            k -= chalk[index++];
            if (k < 0) {
                return index - 1;
            }
        }
        return index;
    }
}
