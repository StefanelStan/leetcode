package com.ss.leetcode.LC2022.november;

public class NumberOfValidClockTimes {
    // https://leetcode.com/problems/number-of-valid-clock-times/
    /** Algorithm
        1. Look at the string as a char[] : "23:16 -> [2,3,:1,6]
        2. Starting from last position, apply a multiplication ratio to a variable countTime =1 until the first position.
        3. if [4] is '?' then it can have 10 possibilities, so countTime *=10
        4. if [3] is '?' then it can have a multiplication ratio of 6 possibilities: countTime *=6
        5. Only if [0] == '?' or [1] == '?' proceed further (if none is ? then return the calculation so far)
        6. if [0] == [1] (so both are ?) apply a multiplication of 24 possibilities
        7. if [0] == '?' apply a ratio of 3 is [1] is <= 3 (03,12,23) or ratio of 2 if [1] is > 3 (04,14 or 05,15 etc)
        8. else if [1] == '?' apply a ratio of 10 if [0] is <= 1 (00..09 or 10..19) or a ratio of 4 if [0] is > 1 (20..23)
        9. Return the multiplication result;
     */
    public int countTime(String time) {
        int countTime = 1;
        char[] times = time.toCharArray();
        if (times[4] == '?')  {
            countTime *= 10;
        }
        if (times[3] == '?') {
            countTime *= 6;
        }
        if (times[0] == '?' || times[1] == '?') {
            if (times[0] == times[1]) {
                countTime *= 24;
            } else {
                if (times[0] == '?') {
                    countTime *= (times[1] <= '3' ? 3 : 2);
                } else {
                    countTime *= (times[0] <= '1' ? 10 : 4);
                }
            }
        }
        return countTime;
    }
}
