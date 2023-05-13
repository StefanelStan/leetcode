package com.ss.leetcode.LC2023.may;

public class CountWaysToBuildGoodStrings {
    // https://leetcode.com/problems/count-ways-to-build-good-strings
    /** Algorithm
        Given the example low = 8, high = 11, zero = 3, one = 5.
        1. At index 0 you can form a string of lengh 3 and 1 string of lengh 5 (000, 11111)
            So having an count[11](high), mark position [2] and position[4] with 1.
            [0,0,1,0,1,0,0,0,0,0,0] => 1 string of size 3 and 1 string of size 5.
        2. i = 2. (000), We skip i=0 and i=1 as we cannot have strings of size 1 or 2
            - Add 000 and 11111 to the string 000 => 000+000 ([5]) and 000+11111 ([7]).
            - [0,0,1,0,1,1,0,1,0,0,0,0]. Currently we have [000,11111,000+000, 000+11111]
        3. i = 4 (We skip i = 3 as we have no strings of length 4)
            - (11111) => we can append 000 and 11111 => 11111+000 ([7]) and 11111+11111 ([9])
            - [0,0,1,0,1,1,0,2,0,1,0]
         4. i = 5 => (000+000) => we can add 000 and 11111 => 000+000+000 [8] & 000+000+11111 [10]
            - [0,0,1,0,1,1,0,2,1,1,1]
        5. i = 7: from this positoin we can add 000 and 11111.
            - So add 2 (at position 7 we have 2 strings: 000+11111 AND 11111+000) at indices 10 and 11
            - [0,0,1,0,1,1,0,2,1,1,3]
            - As 7+5 goes over high, do not add it
        6. i = 8-10 => we can't add anything as it goes over the limit
        7. As we can see, between indices [7] - [10] we have 2,1,1,3.
            - 2 strings of length 8, 1 of length 9, 1 of length 10 and 3 of length 11
            - Total = 7.
     */
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] count =  new int[high];
        int total = 0;
        int min = Math.min(zero, one);
        int max = Math.max(zero, one);
        count[min - 1] += 1;
        count[max - 1] += 1;
        for (int i = min - 1; i < high; i++) {
            if (count[i] != 0) {
                if (i + min < high) {
                    count[i + min] = (count[i + min] + count[i]) % 1_000_000_007;
                }
                if (i + max < high) {
                    count[i + max] = (count[i + max] + count[i]) % 1_000_000_007;
                }
                if (i >= low - 1) {
                    total = (total + count[i]) % 1_000_000_007;
                }
            }
        }
        return total;
    }
}
