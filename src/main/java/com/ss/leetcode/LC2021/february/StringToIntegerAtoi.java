package com.ss.leetcode.LC2021.february;

import java.math.BigInteger;

public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        char c = ' ';
        State state = new State();
        try {
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (c == ' ') {
                    if (!state.isPristine()) {
                        return state.getValue();
                    } else {
                        continue;
                    }

                } else if (c == '-' || c == '+') {
                    if (state.isPristine()) {
                        state.setSign(c);
                    } else {
                        return state.getValue();
                    }
                } else if (Character.isDigit(c)) {
                    state.appendDigit(c);
                } else {
                    if (!state.isPristine()) {
                        return state.getValue();
                    } else {
                        break;
                    }
                }
            }
        } catch (IllegalStateException e) {
            return 0;
        }
        return state.getValue();
    }

    private static final class State {
        private final StringBuilder stb;
        private boolean hasSign = false;
        boolean isPositive = true;

        public State() {
            this.stb = new StringBuilder();
        }

        private void setSign(char sign) {
            if (hasSign || stb.length() > 0) {
                throw new IllegalStateException("Cannot set sign");
            } else {
                hasSign = true;
                isPositive = sign == '+';
            }
        }

        private void appendDigit(char digit) {
            stb.append(digit);
        }

        private boolean isPristine() {
            return !hasSign &&  stb.length() == 0;
        }

        private int getValue() {
            if (stb.length() == 0) {
                return 0;
            }
            BigInteger value = new BigInteger(stb.toString());
            if (!isPositive) {
                value = value.negate();
            }
            if (value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                return Integer.MAX_VALUE;
            } else if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                return Integer.MIN_VALUE;
            } else {
                return value.intValue();
            }
        }
    }
}
