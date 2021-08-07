package com.ss.leetcode.august;

public class DetermineColorChessboardSquare {
    // https://leetcode.com/problems/determine-color-of-a-chessboard-square/
    public boolean squareIsWhite(String coordinates) {
        boolean isCharEven = coordinates.charAt(0) % 2 == 0;
        boolean isDigitEven = coordinates.charAt(1) % 2 == 0;

        if (isCharEven) {
            return !isDigitEven;
        } else {
            return isDigitEven;
        }
    }
}
