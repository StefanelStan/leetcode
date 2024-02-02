package com.ss.leetcode.LC2021.february;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SequentialDigits {
    // https://leetcode.com/problems/sequential-digits
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = String.valueOf(low).length(); i <= String.valueOf(high).length(); i++) {
            appendNumbers(templateOf(i), i, low, high, numbers);
        }
        return numbers;
    }

    private void appendNumbers(int[] template, int length, int low, int high, List<Integer> numbers) {
        int next = valueOf(template);
        while (next <= high) {
            if (next >= low) {
                numbers.add(next);
            }
            if (template[length -1] < 9) {
                advanceTemplate(template);
                next = valueOf(template);
            } else {
                break;
            }
        }
    }

    private void advanceTemplate(int[] template) {
        for (int i = 1; i < template.length; i++) {
            template[i-1] = template[i];
        }
        template[template.length -1]++;
    }

    private int[] templateOf(int length) {
        int[] template = new int[length];
        for (int i = 1; i <= length; i++) {
            template[i-1] = i;
        }
        return template;
    }

    private int valueOf(int[] template) {
        if (template.length == 9 && template[0] == 2) {
            return 0;
        }
        int val = 0;
        for(int digit : template) {
            val = val * 10 + digit;
        }
        return val;
    }


    public List<Integer> sequentialDigits2(int low, int high) {
        List<Integer> sequences = new LinkedList<>();
        DigitNumber di = new DigitNumber(low);
        int nextSequence = di.getNextSequence();
        while (nextSequence <= high) {
            sequences.add(nextSequence);
            nextSequence = di.getNextSequence();
        }
        return sequences;
    }

    private static final class DigitNumber {
        private final int startValueInt;
        private int currentValueInt;
        private static final int[] DIGITS = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        public DigitNumber(int startValue) {
            this.startValueInt = startValue;
        }

        public int getNextSequence() {
            // initial call; have to build it
            if (currentValueInt == 0) {
                constructFirstValue();
            } else {
                generateNextValue();
            }
            return currentValueInt;
        }

        private void constructFirstValue() {
            String startValue = String.valueOf(startValueInt);
            currentValueInt = getNextSequenceOfDigits(startValue.charAt(0) - 48, startValue.length());
            if (startValueInt > currentValueInt) {
                currentValueInt = getNextSequenceOfDigits(DIGITS[Character.getNumericValue(String.valueOf(currentValueInt).charAt(1))], startValue.length());
            }
        }

        private int getNextSequenceOfDigits(int fDigit, int length) {
            if (length > 9) return Integer.MAX_VALUE;
            StringBuilder stb = new StringBuilder();
            if (fDigit + length > 10) {
                return getNextSequenceOfDigits(1, length + 1);
            } else {
                for (int i = fDigit; i < fDigit + length; i++) {
                    stb.append(DIGITS[i]);
                }
                return Integer.parseInt(stb.toString());
            }
        }

        private void generateNextValue() {
            String currentValue = String.valueOf(currentValueInt);
            currentValueInt = getNextSequenceOfDigits(currentValue.charAt(1) - 48, currentValue.length());
        }
    }
}
