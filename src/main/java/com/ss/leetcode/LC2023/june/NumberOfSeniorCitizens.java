package com.ss.leetcode.LC2023.june;

public class NumberOfSeniorCitizens {
    // https://leetcode.com/problems/number-of-senior-citizens
    /** Algorithm
        1. Determine the age of each passenger: digit value of charAt(11) * 10 + digitValue of charAt(12).
        2. If age > 60, increment number of seniors.
        3. Return seniors.
     */
    public int countSeniors(String[] details) {
        int seniors = 0;
        int age;
        for(String detail : details) {
            age = 10 * (detail.charAt(11) - '0') + (detail.charAt(12) - '0');
            if (age > 60) {
                seniors++;
            }
        }
        return seniors;
    }
}
