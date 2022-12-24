package com.ss.leetcode.LC2022.december;

public class RemoveLetterToEqualizeFrequency {
    // https://leetcode.com/problems/remove-letter-to-equalize-frequency
    /** Algorithm
     1. Count the letters: use an int[27] to count the letters [a-z 0 -25] and [26] to store the max
     2. Use an int[2][2] to store minCountValue, maxCountValue and how many there are: eg: 3 4 3 3 3 3 will be [3,4][5,1].
     3. While determining the minMax count, if any value is not max or not min, return false immediately (we only operate where count != 0)
     4. Return a mixed logic of potential cases of how many min and max counts you can have
     */
    public boolean equalFrequency(String word) {
        int[] countAndMax = getLetterCount(word);
        int max = countAndMax[26];
        int[][] minMax = new int[2][2];
        minMax[0][1] = max;
        for (int i = 0; i < 26; i++) {
            if (countAndMax[i] != 0) {
                if (countAndMax[i] == max) {
                    minMax[1][1]++;
                } else if (minMax[0][0] == 0 || countAndMax[i] == minMax[0][0]) {
                    minMax[0][0] = countAndMax[i];
                    minMax[1][0]++;
                } else {
                    return false;
                }
            }
        }
        return minMax[1][0] == 0
            // if you have no mo min count, then the max count must be 1 or have value 1 (eg: a, aa, aaa etc) : eg: only 1 single type of letter
            ? minMax[0][1] == 1 || minMax[1][1] == 1
            : minMax[0][0] == 1 && minMax[1][0] == 1 // edge case of abbccdd: removing the 1 single unique letter will let others be equal freq
                ? true
                // other cases: eg: abcdd or abcddd : we need this max count to be 1 AND the diff between min and max to be 1
                // in this case, we need to see if the max count is 1 and the diff between the groups is 1.
                // abcdefgg : [1,2][6,1]= 5 diff of 1 and 1 diff of 2. As we have one diff of two, we need to make sure that te group diff between 2 and 1 is 1
                // abcdefggg [1,3][6,1]. We only have 1 diff of 3, but 3 - 1 is not 1, so if we eliminate one g we end up with a freq of 2.
                : minMax[1][1] == 1 && minMax[0][1] - minMax[0][0] == 1;
    }

    private int[] getLetterCount(String word) {
        int[] count = new int[27];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
            count[26] = Math.max(count[26], count[c - 'a']);
        }
        return count;
    }
}
