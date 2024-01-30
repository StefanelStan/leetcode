package com.ss.leetcode.LC2022.april;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/
    /** Algorithm
        1. Use a Stack (can or Dequeue) to stack the numbers
        2. If current token is an operand ( < '0'), then pop the last two nums, apply operation and add the result
        3. Return the result from the stack.
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> lastNums = new Stack<>();
        for (String token : tokens) {
            if (token.length() == 1 && token.charAt(0) < '0') {
                lastNums.push(operate(token.charAt(0), lastNums.pop(), lastNums.pop()));
            } else {
                lastNums.push(Integer.valueOf(token));
            }
        }
        return lastNums.pop();
    }

    private int operate(char op, int b, int a) {
        return switch(op) {
            case '-' -> a - b;
            case '+' -> a + b;
            case '/' -> a / b;
            default -> a * b;
        };
    }

    public int evalRPN2(String[] tokens) {
        Deque<Integer> numbers = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> numbers.push(numbers.pop() + numbers.pop());
                case "-" -> {
                    int second = numbers.pop();
                    int first = numbers.pop();
                    numbers.push(first - second);
                }
                case "*" -> numbers.push(numbers.pop() * numbers.pop());
                case "/" -> {
                    int second = numbers.pop();
                    int first = numbers.pop();
                    numbers.push(first / second);
                }
                default -> numbers.push(getNumber(token));
            }
        }
        return numbers.pop();
    }

    private int getNumber(String s) {
        boolean isNegative = s.charAt(0) == '-';
        int nr = 0;
        for (int i = isNegative ? 1 : 0; i < s.length(); i++) {
            nr = nr * 10 + (s.charAt(i) - '0');
        }
        return isNegative ? -nr : nr;
    }
}
