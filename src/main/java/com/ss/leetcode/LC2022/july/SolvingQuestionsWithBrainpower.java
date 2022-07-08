package com.ss.leetcode.LC2022.july;

public class SolvingQuestionsWithBrainpower {
    // https://leetcode.com/problems/solving-questions-with-brainpower/
    /** Algorithm
         1. Look at the example EG: [[3,2],[4,1],[4,5],[2,5],[3,1]];
             - If we solve [3,2] then we must jump to position [3] and see what we can solve from there onwards
             So if we choose [3,2] out max Points will be 3 + the max that can be achieved from position [3] onwards, including
             - If we DO NOT pick or SKIP [3,2] then we can solve [4,1] and we can gain 4 points + the max that can be achieved from
             position [3] onwards.
             So we observe that our current decisions (to pick or not to pick 0 or 1) depend actually on the max onwards possible.
             Thus, we need to start from the back of array and check which is the maximum of these back positions.
         2. Declare an array long[] maxGain that will be used to store the maximum we can achieve from solving or skipping questions
         3. maxGain[n] = questions[n][0], as the max that can be gained from this last question is the question points itself
         4. Starting from n-1, decide what is best to do : choose this question and skip k OR skip this question in order to gain more
             from next question.
             EG: [[3,2],[4,1],[4,5],[2,5],[3,1]];
             maxGain[0,0,0,0,3].
             Look at position i = 3. questions[3] = [2,5]
             If we solve this question we get 2 points + the max that can be gained from questions[3 + 5 + 1] (out of array, so 0)
             But if we skip this question, we can gain 3 points, maxGain[i+1]. So it's best to skip it and gain 3.
         5.maxGain = [0,0,0,3,3].
             i =[2]. questions[2] = [4,5].
             If we solve this, we get 4 + maxGain[2 + 5 + 1] (out of array, so 0).
             If we skip this, we can get maxGain[3], which is 3.
             As we can see, it is better to solve this and get 4 points.
             maxGain[0,0,4,3,3].
         6.i = [1] questions[1] = [4,1].
             If we solve this, we get 4 + maxGain[1 + 1 + 1] = 4 + 7.
             If we skip this, we can get maxGain[2] = 4.
             It's better to solve it and gain 7
             maxGain[] = [0,7,4,3,3]
             i = 0. Solve it and gain 3 + maxGain[0 + 2+ 1] = 6.
             Skip it and gain 7.
             So max is 7.
         7. Return maxGain[0].
     */
    public long mostPoints(int[][] questions) {
        long[] maxGain =  new long[questions.length];
        long maxFromJump;
        maxGain[questions.length -1] = questions[questions.length -1][0];
        for (int i = questions.length - 2; i>= 0; i--) {
            maxFromJump = questions[i][0] + (i + questions[i][1] + 1 >= questions.length ? 0 : maxGain[i + questions[i][1] + 1]);
            maxGain[i] = Math.max(maxGain[i+1], maxFromJump);
        }
        return maxGain[0];

    }
}
