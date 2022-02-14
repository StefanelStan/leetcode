package com.ss.leetcode.LC2022.february;

public class NumberOfStudentsUnableToEatLunch {
    // https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/submissions/
    /** Algorithm
     1. Take the example of students = [1,1,1,0,0,1] and sw = [1,0,0,0,1,1].
     2. Counting students and sandwiches, we see that 2 students want '0' SW but there are 3 '0' SW.
     This extra sw cannot be picked up by anyone, blocking the others  behind it.
     3. So count the students and their sw preferences. Count the sandwiches.
     If '0' sw preferences == '0' sandwiches, means all will be fed.
     4. Find out which type of extra s/w exists and count them. Stop when the count of that type exceedes the its preference.
     students [1,1,1,0,0,1] sw = [1,0,0,0,1,1].
     Only 2 students want 0 but there are 3 0. This means the serving process will stop at index 3 because nobody will be albe to pick that '0' sandwich.
     */
    public int countStudents(int[] students, int[] sandwiches) {
        int sZ = 0, sO, sandZ = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                sZ++;
            }
            if(sandwiches[i] == 0) {
                sandZ++;
            }
        }
        if (sZ == sandZ) {
            return 0;
        }
        sO = students.length - sZ;
        int extraSandType = sandZ > sZ ? 0 : 1;
        int extraSandTypeCount = 0;
        int thresHold = (extraSandType == 0 ? sZ + 1 : sO + 1);
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == extraSandType) {
                extraSandTypeCount++;
                if (extraSandTypeCount == thresHold) {
                    return students.length - i;
                }
            }
        }
        return 0;
    }
}
