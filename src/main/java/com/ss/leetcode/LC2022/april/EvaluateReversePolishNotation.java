package com.ss.leetcode.LC2022.april;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/
    public int evalRPN(String[] tokens) {
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
