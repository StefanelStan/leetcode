package com.ss.leetcode.LC2023.april;

public class ChangeMinimumCharactersToSatisfyOneOfThreeConditions {
    // https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions
    /** Algorithm
        1. Count the letters of A and B into 2 ints[] countA[] and countB[].
            For better performance, also compute the prefixSum of the count and use countA[][] (row0 - count, row1- prefixSum)
        2. The solution is a min between 3 options: I) make both strings only one distinct letter, II) make a < b or III) b < a.
        3. Make both string only one distinch letter.
            Knowing the count of each letter,  aabbcdcdeedc = [2,2,3,3,2....] = total 12 & abcdde = [1,1,1,2,1] = total 6
            iterate over each letter and determine the cost of making all the other letters of string a and b match that letter
            EG: cost to make all letters of str1 to match a = 12 - 2 = 10;
            cost to make all letter of str2 to match a = 6 - 1 = 5.
            We can see the min is given by making all letters matching c: (12 - 3) + (6-2) = 13.
        4. Make a less than b (applicable to b less than a, you just swap the input prefixSum)
            Iterate from 24 to 0 (y to a) and determine the cost of eliminating all letters greater than [24] (y)
            from strA and all letters lesser or equal to [24] from strB.
            You can find this out by using prefix sum.
            Loop this for each letter Y - A and return the minimum.
     */
    public int minCharacters(String a, String b) {
        int[][] countAndPrefixA = getCountAndPrefix(a);
        int[][] countAndPrefixB = getCountAndPrefix(b);
        int min = makeOnlyOneDistinct(countAndPrefixA[0], countAndPrefixB[0], countAndPrefixA[1][25] + countAndPrefixB[1][25]);
        if (min > 0) {
            min = Math.min(min, makeLessThan(countAndPrefixA[1], countAndPrefixB[1]));
        }
        if (min > 0) {
            min = Math.min(min, makeLessThan(countAndPrefixB[1], countAndPrefixA[1]));
        }
        return min;
    }

    private int makeOnlyOneDistinct(int[] countA, int[] countB, int total) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < countA.length; i++) {
            min = Math.min(min, total - (countA[i] + countB[i]));
        }
        return min;
    }

    private int makeLessThan(int[] prefixA, int[] prefixB) {
        int min = Integer.MAX_VALUE;
        int removeFromA, removeFromB;
        for(int i = 24; i >= 0; i--) {
            removeFromA = prefixA[25] - prefixA[i];
            removeFromB = prefixB[i];
            min = Math.min(min, removeFromA + removeFromB);
        }
        return min;
    }

    private int[][] getCountAndPrefix(String str) {
        int[][] countAndPrefix = new int[2][26];
        for (int i = 0; i < str.length(); i++) {
            countAndPrefix[0][str.charAt(i) - 'a']++;
        }
        int prefix = 0;
        for (int i = 0; i < countAndPrefix[0].length; i++) {
            prefix += countAndPrefix[0][i];
            countAndPrefix[1][i] = prefix;
        }
        return countAndPrefix;
    }
}
