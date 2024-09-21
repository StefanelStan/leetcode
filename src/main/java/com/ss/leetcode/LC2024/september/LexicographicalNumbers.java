package com.ss.leetcode.LC2024.september;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    // https://leetcode.com/problems/lexicographical-numbers
    /** Algorithm
        1. For the range i= [1,9] try to generate and add all numbers to the list, up until n using a recursive function
        2. The recursive function:
            - if number is <= n, add number to list
            - loop from 0 to 9 and try to call the function again, passing number * i + i (basically concatenating the number with next digit)
        3. Return the list of numbers
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 1; i <= Math.min(9, n); i++) {
            addToNumbers(i, n, numbers);
        }
        return numbers;
    }

    private void addToNumbers(int number, int maxNumber, List<Integer> numbers) {
        if (number <= maxNumber) {
            numbers.add(number);
            for (int i = 0; i <= 9; i++) {
                addToNumbers(number * 10 + i, maxNumber, numbers);
            }
        }
    }
}
