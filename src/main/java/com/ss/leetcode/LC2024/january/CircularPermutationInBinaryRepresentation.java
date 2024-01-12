package com.ss.leetcode.LC2024.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CircularPermutationInBinaryRepresentation {
    // https://leetcode.com/problems/circular-permutation-in-binary-representation
    public List<Integer> circularPermutation(int n, int start) {
        int steps = (int) Math.pow(2, n) - 1;
        char[] startNumber = getPaddedStartNumber(n, Integer.toBinaryString(start).toCharArray());
        char[] tempNumber = Arrays.copyOf(startNumber, startNumber.length);
        boolean[] found = {false};
        Set<Integer> numberSet = new HashSet<>();
        List<char[]> numberList = new ArrayList<>(steps);
        numberSet.add(Arrays.hashCode(startNumber));
        numberList.add(startNumber);
        findPermutation(tempNumber, 2, numberSet, numberList, found, steps, startNumber);
        return numberList.stream().map(v -> Integer.parseInt(new String(v), 2))
            .collect(Collectors.toList());
    }

    private char[] getPaddedStartNumber(int n, char[] basicStart) {
        char[] paddedStart = new char[n];
        int j = n - 1;
        for (int i = basicStart.length - 1; i >= 0; j--, i--) {
            paddedStart[j] = basicStart[i];
        }
        while (j >= 0) {
            paddedStart[j--] = '0';
        }
        return paddedStart;
    }

    private void findPermutation(char[] tempNumber, int step, Set<Integer> numberSet,
        List<char[]> numberList, boolean[] found, int totalSteps, char[] startNumber) {
        if (step > totalSteps && areDifferentByOneChar(tempNumber, startNumber)) {
            found[0] = true;
            return;
        }
        char prev;
        boolean added;
        for (int i = 0; i < tempNumber.length && !found[0]; i++) {
            prev = tempNumber[i];
            tempNumber[i] = prev == '0' ? '1' : '0';
            added = numberSet.add(Arrays.hashCode(tempNumber));
            if (added) {
                numberList.add(Arrays.copyOf(tempNumber, tempNumber.length));
                findPermutation(tempNumber, step + 1, numberSet, numberList, found, totalSteps,
                    startNumber);
            }
            if (!found[0] && added) {
                numberSet.remove(Arrays.hashCode(tempNumber));
                numberList.remove(numberList.size() - 1);
            }
            tempNumber[i] = prev;
        }
    }

    private boolean areDifferentByOneChar(char[] ch1, char[] ch2) {
        int diff = 0;
        for (int i = 0; i < ch1.length && diff < 2; i++) {
            diff += ch1[i] == ch2[i] ? 0 : 1;
        }
        return diff == 1;
    }
}
