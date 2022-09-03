package com.ss.leetcode.LC2022.september;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    // https://leetcode.com/problems/numbers-with-same-consecutive-differences/
    /** Algorithm
         1. For each starting digit 1..9 call a function that will accept the digit, a building number, k and a grade
            (grade refers to the number of remaining digits to add. when grade is 1, it means the last digit of n was reached)
            This function will recursively build the number and when grade is 1, will add it to the list of answers
         2. The function will accept the given digit, a building number, the grade (postion/index/nr of digits remaining, k and a List answer)
         3. The function will try to recusively call the itself passing digit - k, digit + k, as variation of the digit
             - If the passed digit is <0 or >9 then return as this is not a valid digit
             - If the grade is 1, it means the last digit was reached and a number (buildingNumber) has been formed. Add it to answer.
             - Else, calculate the next digit based on the passed digit.
             - deduct k from the given digit. If next one is >= 0, then it's a valid digit and the newly number (nr * 10 + newDigit)
             can be passed to this recursive function
             - add k to the digit. If newlyDigit < 9 and k != 0 (if k is 0 this will cause duplications in answer) then pass
             the newly Digit and newly build number to this function.
     */
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> nrs = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            calculateSameConsecutiveDiff(i, i, n, k, nrs);
        }
        int[] answer = new int[nrs.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = nrs.get(i);
        }
        return answer;
    }
    private void calculateSameConsecutiveDiff(int digit, int buildingNumber, int grade, int k, List<Integer> nrs) {
        if (digit < 0 || digit > 9) {
            return;
        }
        if (grade == 1) {
            nrs.add(buildingNumber);
        } else {
            int lower = digit - k;
            if (lower >= 0) {
                calculateSameConsecutiveDiff(lower, buildingNumber * 10 + lower, grade -1, k, nrs);
            }
            if (k != 0) {
                int higher = digit + k;
                if (higher < 10) {
                    calculateSameConsecutiveDiff(higher, buildingNumber * 10 + higher, grade -1, k, nrs);
                }
            }
        }
    }
}
