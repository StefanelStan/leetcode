package com.ss.leetcode.LC2022.march;

public class MinimumDominoRotationsForEqualRow {
    // https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
    /** Algorithm
         1. Declare an array [3][7] and count the appearances of each digit/number in top and bottoms.
         array[0] will hold count of 1,2..6 on top, array[1] will hold the count of 1.2..6 on bottom.
         2. In order to claim that a rotation is possible, there has to be tops.length appearences of that number in tops
         and bottoms.
             EG: [1,1,2]
                 [5,4,1]
             As we can see, we have a total of 3 1s, 2 on top and 1 on bottom.
             So this makes a possible rotation, with minRotation cost min(topCount, bottomCount).
         3. There is the possibility that one domino has the same number on tops and bottoms
             EG: [4,1,2]
                 [5,1,1]
             In this case, we do have 3 ones in total (1 top, 2 bottom), but a pair of ones is both on tops and bottom.
             Thus, when counting them, detect and count the doubles separately
         4. Putting these together, when counting, if there is no double-number domino, count the top, count the bottom
             If there is a double-number domino, then only increase the doubleDomino count for that.
             EG: [4,1,2]
                [5,1,1]       0,1,2,3,4,5,6
                 topCount    [0,0,1,0,1,0,0]
                 bottomCount [0,1,0,0,0,1,0]
                 doubles     [0,1,0,0,0,0,0]
             As we can see, for digit ,1 the number of top + bottoms + doubles is 2. 3 is needed
             EG2:[4,1,2]
                 [1,1,1]      0,1,2,3,4,5,6
                 topCount    [0,0,1,0,1,0,0]
                 bottomCount [0,2,0,0,0,1,0]
                 doubles     [0,1,0,0,0,0,0]
             In this case, looking at number 1, we see that topCount + bottomCount + doubles =  3.
             The min cost would be min(top, bottom) = 0.
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[][] counts = new int[3][7];
        int minRotations = tops.length;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == bottoms[i]) {
                counts[2][tops[i]]++;
            } else {
                counts[0][tops[i]]++;
                counts[1][bottoms[i]]++;
            }
        }
        for (int i = 1; i < counts[0].length; i++) {
            if (counts[0][i] + counts[1][i] + counts[2][i] == tops.length) {
                minRotations = Math.min(minRotations, Math.min(counts[0][i], counts[1][i]));
            }
        }
        return minRotations == tops.length ? -1 : minRotations;
    }
}
