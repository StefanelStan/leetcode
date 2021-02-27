package com.ss.leetcode.february;

import java.util.LinkedList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
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
