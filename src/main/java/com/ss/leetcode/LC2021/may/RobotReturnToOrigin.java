package com.ss.leetcode.LC2021.may;

public class RobotReturnToOrigin {
    // https://leetcode.com/problems/robot-return-to-origin/
    public boolean judgeCircle(String moves) {
        int verticalScore = 0, horizontalScore = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R' -> horizontalScore++;
                case 'L' -> horizontalScore--;
                case 'U' -> verticalScore++;
                case 'D' -> verticalScore--;
                default -> throw new IllegalArgumentException(moves.charAt(i) + " is not an accepted direction");
            }
        }
        return verticalScore == horizontalScore && horizontalScore == 0;
    }
}
