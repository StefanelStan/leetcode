package com.ss.leetcode.LC2023.july;

public class CountNumberOfTexts {
    // https://leetcode.com/problems/count-number-of-texts
    /** Algorithm
        1. Use an  int[] values to store the values/count of texts that can be formed backwords. values[n -1] = 1;
        2. Look at each number:
            - key 4 can form 3 sequences: pressed once, twice, three times
            - key 9 can form 4 sequences: pressed once, twice, three, four times.
        3. Create a simple mapping for max number of presses for each number: 3 -> 2, 9 > 3
            means that digit 3 can take up at most 2 other chars at its right (current, next and next so an offset of 2)
        4. Let's look at the example 333 : values[0,0,1] (values[n-1] = 1 as last digit can form just 1 single number:itself)
            i = 1: 33: we can have one sequence of 1 press (d), thus the word is dd
                we can have one sequence of 2 presses: (e) thus the word is e
                so values is [0,2,1]
            i = 0: 333
                if we press 3 once, then we form the text/word count given by values[1] = 2
                if we press two times we form the text/word count given by values[2] = 1
                if we press it 3 times, we form the text f, thus just 1 word
            total = 2+1+1 = 4;
        5. Starting from index i = n-2 to 0
            - loop with j from current index and stop when j reaches the max number of allowed keys for that number OR > n
            - sum up the indices/values represented by values[i+j+1] for each loop of j,
            - set values[i] = that sum.
     */
    private static final int[] maxKeys = {0,0,2,2,2,2,2,3,2,3};
    public int countTexts(String pressedKeys) {
        char[] chars = pressedKeys.toCharArray();
        int[] values = new int[chars.length];
        values[chars.length - 1] = 1;
        int sum;
        int digit, j;
        for (int i = chars.length - 2; i >= 0; i--) {
            sum = 0;
            j = 0;
            digit = chars[i] - '0';
            for (; j <= maxKeys[digit] && i + j < chars.length && chars[i] == chars[i + j]; j++) {
                sum = (sum + (i + j + 1 > chars.length - 1 ? 1 : values[i + j + 1])) % 1_000_000_007;
            }
            values[i] = sum;
        }
        return values[0];
    }
}
