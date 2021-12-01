package com.ss.leetcode.LC2020.december;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LargestMultipleOfThree {
    // https://leetcode.com/problems/largest-multiple-of-three/

    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        int sum = 0;
        int index = digits.length -1;
        Set<Integer> presentNumbers = new HashSet<>();
        while(index >= 0){
            sum += digits[index];
            presentNumbers.add(digits[index]);
            index--;
        }
        if (sum % 3 == 0) {
            return getStringValueOf(digits, Math.max(index, 0), digits.length-1, -1, -1);
        }

        if(sum == 1 || sum == 2) {
            return "";
        }
        if(sum % 3 == 1) {
            return stripOneFromDigits(digits, presentNumbers, Math.max(index, 0));
        }
        if (sum % 3 == 2) {
            return stripTwoFromDigits(digits, presentNumbers, Math.max(index, 0));
        }

        return "";
    }

    private String stripOneFromDigits(int[] digits, Set<Integer> presentNumbers, int front) {
        int skippedIndex = -1;
        for (int i = front; i < digits.length; i++) {
            if (digits[i] == 1 || digits[i] == 4 || digits[i] == 7) {
                skippedIndex = i;
                break;
            }
        }
        if (skippedIndex < 0) { // 1 or 4 or 7 not found: need to make up the sum of the elements or 4,7,10, 13,16,
            // find indexes of sum of 4 (2 + 2)
                // get index of 2 and 2
                List<Integer> pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 2,2);
                if (pairOfIndexes.size() != 2) {
                    pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 2, 5);
                }
                if (pairOfIndexes.size() != 2) {
                    pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 2, 5);
                }
                if (pairOfIndexes.size() != 2) {
                    pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 5, 5);
                }
                if (pairOfIndexes.size() != 2) {
                    pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 5, 8);
                }
                if (pairOfIndexes.size() != 2) {
                    pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 8, 8);
                }
                if(pairOfIndexes.size() != 2) {
                    return "";
                }
                return getStringValueOf(digits, front, digits.length-1, pairOfIndexes.get(0), pairOfIndexes.get(1));
            // find sum of 7: 2 + 5
            // need to find the least extreme pair and remote it
        } else {
            return getStringValueOf(digits, front, digits.length-1, skippedIndex, -1);
        }
    }

    private List<Integer> getPairIndexOf(int[] digits, int front, int back, int digitOne, int digitTwo) {
        List<Integer> list = new LinkedList<>();
        boolean foundDigitOne = false;
        boolean foundDigitTwo = false;
        for (int i = front; i<= back && (!(foundDigitOne && foundDigitTwo)); i++) {
            if (digits[i] == digitOne && !foundDigitOne) {
                foundDigitOne = true;
                list.add(i);
            } else if (digits[i] == digitTwo && !foundDigitTwo) {
                foundDigitTwo = true;
                list.add(i);
            }
        }
        return list;
    }

    private String stripTwoFromDigits(int[] digits, Set<Integer> presentNumbers, int front) {
        int skippedIndex = -1;
        for (int i = front; i < digits.length; i++) {
            if (digits[i] == 2 || digits[i] == 5 || digits[i] == 8) {
                skippedIndex = i;
                break;
            }
        }
        if (skippedIndex < 0) { // 2 or 5 or 8 not found: need to make up the sum of the elements
            // find indexes of sum of 2 (1 + 1)
            if (presentNumbers.contains(1)) {
                // get index of 2 and 2
                List<Integer> pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 1,1);
                if (pairOfIndexes.size() != 2) {
                    pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 1, 4);
                }
                if (pairOfIndexes.size() != 2) {
                    pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 4, 4);
                }
                if (pairOfIndexes.size() != 2) {
                    pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 1, 7);
                }
                if (pairOfIndexes.size() != 2) {
                    pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 3, 7);
                }
                if (pairOfIndexes.size() != 2) {
                    pairOfIndexes = getPairIndexOf(digits, front, digits.length-1, 7, 7);
                }
                if(pairOfIndexes.size() != 2) {
                    return "";
                }
                return getStringValueOf(digits, front, digits.length-1, pairOfIndexes.get(0), pairOfIndexes.get(1));
            }
            // find sum of 7: 2 + 5
            // need to find the least extreme pair and remote it
        } else {
            return getStringValueOf(digits, front, digits.length-1, skippedIndex, -1);
        }
        return "0";
    }

    private String getStringValueOf(int[] digits, int front, int back, int skippedIndex1, int skippedIndex2 ) {
        StringBuilder stb = new StringBuilder();
        for (int i = back; i >= front; i--) {
            if (i != skippedIndex1 && i != skippedIndex2) {
                stb.append(digits[i]);
            }
        }
        String ret = stb.toString();
        if(containsOnlyZeroes(ret)) {
            return "0";
        }
        return ret.isEmpty() ? "" : ret;
    }

    private boolean containsOnlyZeroes(String ret) {
        if(ret.isEmpty()) return false;
        for(int i = 0; i < ret.length(); i++) {
            if(ret.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
