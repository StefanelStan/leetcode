package com.ss.leetcode.LC2023.july;

public class PredictTheWinner {
    // https://leetcode.com/problems/predict-the-winner
    /** Algorithm
        1. Let's look at a segment[6,11].
            - If player1 selects 6,([0]), it gains 6 points and player2 can gain 11
            - If player1 selects 11([1]), it gains 11 points and player2 can gain 6.
            - As both play optimally, player1 will go for the max. (11)
        2. Looking at the example of #1, we see the segment[6,11] can have two attributes: maxScore and remaining
            Whoever gets to make a decision, it will gain the maxScore but the other player will gain the remaining
            Thus, we can see a class Score with 2 attributes: maxScore and remaining.
            [6,11] will have maxScore 11 and remaining 6.
        3. If a segment is of length 1 [5], then maxScore is 5 and remaining 0.
        4. Extending this example, let's look at the segment [6,11,7]
            - player1 can chose 6, then player2 will make the move and grab the best/max option: 11. and player1
             will be left with 7: so player1 gains 6+7 and player2 gains 11
            - player1 can choose 7, then player2 will make his move and select the max option(11), and player1 will be
            left with 6. So player1 gains 7+6 and player2 gains 11.
            - So segment[6,11,7] has a maxScore of 13 and remaining 11.(remaining is the [segment-1].maxScore)
        5. We observe the pattern of two choices when looking at a segment[a...z]
            - player1 selects left index [a], gains [a], player2 will select/gain the max of segment[a+1..z] and player1
                will be left with the remaining of segment[a+1..z].
            - player2 selects right index [z], gains [z], player2 will select/gian the max of segment[a..y] and player1
                will be left with the remaing of segment [a..y].
        6. We observe that, starting from a segment of length 1 we can build the maxScore/remaining of segments of length 2,3..n
        7. Use an Score[n][n] to save/cache these values.
        8. Loop with i from n-2; loop with j from i to n-1. Determine the Score of each segment [0,0], [0,1],[0,2].....[i,j]
        9. At the end, compare if maxScore of the whole segment [0,n-1] (Score[0][n-1]) is >= Score[0][n-1].remaining,
            As player1 will always get the maxScore but player2 the remaining.
     */
    public boolean predictTheWinner(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        StepScore[][] stepScore = new StepScore[nums.length][nums.length];
        StepScore playerScore = findScore(0, nums.length -1, nums, stepScore);
        return playerScore.maxGain >= playerScore.leftoverGain;
    }

    private StepScore findScore(int left, int right, int[] nums, StepScore[][] stepScore) {
        if (stepScore[left][right] == null) {
            if (left + 1 == right) {
                stepScore[left][right] = new StepScore(Math.max(nums[left], nums[right]), Math.min(nums[left], nums[right]));
            } else {
                StepScore selectLeft = findScore(left + 1, right, nums, stepScore);
                StepScore selectRight = findScore(left, right - 1, nums, stepScore);
                if (selectLeft.leftoverGain + nums[left] > selectRight.leftoverGain + nums[right]) {
                    stepScore[left][right] = new StepScore(selectLeft.leftoverGain + nums[left], selectLeft.maxGain);
                } else {
                    stepScore[left][right] = new StepScore(selectRight.leftoverGain + nums[right], selectRight.maxGain);
                }
            }
        }
        return stepScore[left][right];
    }

    private static class StepScore {
        int maxGain;
        int leftoverGain;
        public StepScore(int maxGain, int leftoverGain) {
            this.maxGain = maxGain;
            this.leftoverGain = leftoverGain;
        }
    }
}
