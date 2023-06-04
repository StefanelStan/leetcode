package com.ss.leetcode.LC2023.june;

public class MinimizeResultByAddingParenthesesToExpression {
    // https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression
    /** Algorithm
        1. As input is very small,9 digits, there are only max 20 possible combinations of left/right parentheses
        2. Split the expression into left and right number.
        3. Looping with i from 0 to left.length, apply the left parenthesis at i index.
            Looping with j from 0 ro right.length, apply the right parenthesis to j index.
        4. Based on i and j parentheses, determine the result.
        5. If the result is smaller that the best result known, set the i and j parenthesis index
        6. At the end, append the left and right paranthesis at i and j parentheses index.
     */
    public String minimizeResult(String expression) {
        String[] chunks = expression.split("\\+");
        int minResult = Integer.parseInt(chunks[0]) + Integer.parseInt(chunks[1]);
        int leftPos = 0, rightPos = expression.length();
        int leftSumToAdd, leftProductToAdd, currentResult;
        for (int i = 0; i < chunks[0].length(); i++) {
            leftSumToAdd = i == 0 ? 1 : Integer.parseInt(chunks[0].substring(0, i));
            leftProductToAdd = Integer.parseInt(chunks[0].substring(i));
            for (int j = 0; j < chunks[1].length(); j++) {
                currentResult = getParenthesesResult(leftSumToAdd, leftProductToAdd, chunks[1], j);
                if (currentResult < minResult) {
                    minResult = currentResult;
                    leftPos = i;
                    rightPos = chunks[0].length() + j+2;
                }
            }
        }
        return addParentheses(expression, leftPos, rightPos);
    }

    private String addParentheses(String expression, int leftP, int rightP) {
        StringBuilder stb = new StringBuilder(expression.length() + 2);
        for (int i = 0; i < expression.length(); i++) {
            if (i == leftP) {
                stb.append('(');
            } else if (i == rightP) {
                stb.append(')');
            }
            stb.append(expression.charAt(i));
        }
        if (rightP == expression.length()) {
            stb.append(')');
        }
        return stb.toString();
    }

    private int getParenthesesResult(int leftSumToAdd, int leftProductToAdd, String chunk, int j) {
        int rightProductToAdd = Integer.parseInt(chunk.substring(0, j+1));
        int rightSumToAdd = j == chunk.length() -1 ? 1 : Integer.parseInt(chunk.substring(j+1));
        return leftSumToAdd * (leftProductToAdd + rightProductToAdd) * rightSumToAdd;
    }
}
