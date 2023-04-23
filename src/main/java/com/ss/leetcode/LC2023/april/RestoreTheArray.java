package com.ss.leetcode.LC2023.april;

public class RestoreTheArray {
    // https://leetcode.com/problems/restore-the-array
    /** Algorithm
        1. The main idea is to start from the back of s (the number) and see how many possibilities of combinations
            each digit or group of digits can provide
        2. For memoization, store this result in an int[n+1]. (combinations[])
            Set combinations[n] = 1.
            combinations[0,0,0,0,1]
        3. Let's look at 1317 k = 2000
            i = 3.
                Digit/number 7 can make combinations of combinations[3+1] = 1.
                combinations = [0,0,0,1,1]
                As 7 is the end of s, we cannot go left anymore
            i = 2
            Digit 1 can make a combination of itself so comb[2] += comb[2+1] = 1
            As we didn't reach the end of number, add 7 to 1 => 17
            17 is lesser than 2000, so it's valid
            so comb[2] += comb[4] our number now spreads over index2 and index3
            number 17[i2,i3] can make [i4] combinations
            combinations = [0,0,2,1,1]
        i = 1
            digit/number 3: can make a solo combination of combinations[1+1] = 2
            - can be paired with 1 (31) and can give 1 extra combnation (comb[3] as 1 is at index 2)
            - can be paired with 7 (317) and can give extra 1 combinations
            so a total of 4 combinations
            combinations = [0,4,2,1,1]
        i = 0
            digit 1 can be taken solo and provide comb[0+1] extra combinations = 4
            1 and 3 (13) can provide comb[2] extra combinations 2
            131 (i [012]can provide comb[3] extra combinations  = 1
            1317 (i[0123]) can provide comb[4] extra combinations = 1
            Total 4 + 2 + 1 + 1 = 8.
        4. For each digit advancement (adding 3 to 1 resulting 13, adding 1 to 13 resulting 131), you must
            calculate the possible combinations only if number >= 1 and number <= k.
            If number is greater than k, you need to stop as you cannot advance further OR you cannot select that digit (eg: 0 or 00 or 000).
        5. Return comb[0].
     */
    public int numberOfArrays(String s, int k) {
        char[] chrs = s.toCharArray();
        int n = s.length();
        int[] combinations = new int[n + 1];
        combinations[n] = 1;
        for (int j = n-1; j>=0; j--) {
            combinations[j] = countCombinations(chrs, j, combinations, k);
        }
        return combinations[0];
    }

    private int countCombinations(char[] chrs, int index, int[] combinations, int k) {
        long windowNumber = 0L;
        long comb = 0L;
        while (index < chrs.length) {
            windowNumber = windowNumber * 10 + (chrs[index] - '0');
            if (1 <= windowNumber && windowNumber <= k) {
                comb += combinations[index + 1];
            } else {
                break;
            }
            index++;
        }
        return (int)(comb % 1_000_000_007);
    }
}
