package com.ss.leetcode.LC2022.february;

import java.util.LinkedList;

public class NumberOfStudentsUnableToEatLunch {
    // https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/submissions/
    /** Algorithm
        1. Traverse students and count their food preferences: foodPref[0,1]
        2. Traverse sandwiches and deduct 1 from the foodPref
        3. If, at any time, foodPref[0,1] goes negative, then that type of food does not exist and no student can pick it up.
            - EG: students, [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
            - foodPref[] = {2,4} (2 0s and 4 1s)
            - traverse sandwiches and deduct the sandwich type from food pref
            - i = 0 : [2,3]
            - i = 2 : [0,3]
            - i = 3 : [-1, 3] -> that 0 sandwich cannot be given to any student, so you can only feed 1 + s.length - index
        4. If you reach the end and foodIndex[] = {0,0} then ALL students have been fed!
     */
    public int countStudents(int[] students, int[] sandwiches) {
        int[] foodPref = {0,0};
        for (int student : students) {
            foodPref[student]++;
        }
        int index = 0;
        for (; index < sandwiches.length && foodPref[0] >= 0 && foodPref[1] >= 0; index++) {
            foodPref[sandwiches[index]]--;
        }
        int hungry = sandwiches.length - index;
        hungry += (foodPref[0] < 0 || foodPref[1] < 0 ) ? 1 : 0;
        return hungry;
    }

    public int countStudents2(int[] students, int[] sandwiches) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] count = {0, 0};
        for (int student : students) {
            count[student]++;
            queue.addLast(student);
        }
        int currentStudent;
        for (int i = 0; i < sandwiches.length && count[sandwiches[i]] > 0;) {
            if (queue.peekFirst() == sandwiches[i]) {
                count[sandwiches[i]]--;
                queue.removeFirst();
                i++;
            }  else {
                while (queue.peekFirst() != sandwiches[i]) {
                    queue.addLast(queue.removeFirst());
                }
            }
        }
        return queue.size();
    }















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
    public int countStudents3(int[] students, int[] sandwiches) {
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
