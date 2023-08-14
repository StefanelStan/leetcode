package com.ss.leetcode.LC2023.august;

public class PlatesBetweenCandles {
    // https://leetcode.com/problems/plates-between-candles
    /** Algorithm
        1. Traverse the string and use an int[3][s.length] to mark the leftMost/rightMose and count of plates.
        2. For a given query [L,R] , find the closest candle at the right of L and the closest candle at the left of R. (x1, x2)/
        3. Thus, your x1,x2 is the interval that is cornered by 2 plates.
        4. Add few checks for x1,x2 EG: x1==x2 or x2<x1 or x1 == -1 or x2 == -1 (no left,right plate)
        5. Knowing the prefixSum of plates, determine the difference between prefixSum[x2] - prefixSum[x1-1].
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[][] posAndNumberOfCandles = getPosAndNumberOfCandles(s);
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = answerQuery(posAndNumberOfCandles, queries[i][0], queries[i][1]);
        }
        return answer;
    }

    private int answerQuery(int[][] posAndNumberOfCandles, int leftQuery, int rightQuery) {
        int firstCandleOnLeft = posAndNumberOfCandles[1][leftQuery];
        int lastCandleOnRight = posAndNumberOfCandles[0][rightQuery];
        if (firstCandleOnLeft == -1 || lastCandleOnRight == -1 || lastCandleOnRight <= firstCandleOnLeft
            || lastCandleOnRight > rightQuery || firstCandleOnLeft < leftQuery) {
            return 0;
        }
        int validInterval = (lastCandleOnRight - firstCandleOnLeft) + 1;
        int candleCount = posAndNumberOfCandles[2][lastCandleOnRight] - (firstCandleOnLeft == 0 ? 0 : posAndNumberOfCandles[2][firstCandleOnLeft - 1]);
        return validInterval - candleCount;
    }

    private int[][] getPosAndNumberOfCandles(String s) {
        int[][] posAndNumberOfCandles = new int[3][s.length()];
        char left, right;
        int i = 0, j = s.length() - 1;
        posAndNumberOfCandles[0][0] = -1;
        posAndNumberOfCandles[1][j] = -1;
        if (s.charAt(i) == '|') {
            posAndNumberOfCandles[0][0] = 0;
            posAndNumberOfCandles[2][0] = 1;
        }
        if (s.charAt(j) == '|') {
            posAndNumberOfCandles[1][j] = j;
            posAndNumberOfCandles[2][j] = 1;
        }
        while(++i < s.length()) {
            j--;
            left = s.charAt(i);
            right = s.charAt(j);
            posAndNumberOfCandles[0][i] = left == '|' ? i : posAndNumberOfCandles[0][i-1];
            posAndNumberOfCandles[1][j] = right == '|' ? j : posAndNumberOfCandles[1][j+1];
            posAndNumberOfCandles[2][i] = left == '|' ? posAndNumberOfCandles[2][i-1] + 1: posAndNumberOfCandles[2][i-1];
        }
        return posAndNumberOfCandles;
    }
}
