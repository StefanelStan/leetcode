package com.ss.leetcode.LC2022.august;

public class StringWithoutAAAOrBBB {
    /** Algorithm
         1. Looking at the numbers a and b, due to their difference, groups of (2, 1) might be needed
            EG: 4 1 -> (aabaa) :2a1b2a.
         2. First, try to balance the two numbers so they become equal.
             Add 2 chars of type largeNumber and 1 char or smallerNumber
             EG: 8 6 (a,b)
             add 2 of type a and 1 b. Repeat until the difference becomes zero between them.
             iteration 1: aab -> 6a, 5b remaining
             iteration 2: aabaab -> 4a and 4b remaining.
         3. As the two numbers are now equal, we can add equal chunks of each: chunks or 2 or 1 chars,
            depending on how many chars remain.
     */
    public String strWithout3a3b(int a, int b) {
        int largeNr = Math.max(a, b);
        int smallNr = largeNr == a ? b : a;
        char largeChar = largeNr == a ? 'a' : 'b';
        char smallChar = largeChar == 'a' ? 'b' : 'a';
        StringBuilder stb = new StringBuilder();
        while(largeNr - smallNr > 0 ) {
            largeNr -= appendTimes(stb, 2, largeNr, largeChar);
            smallNr -= appendTimes(stb, 1, smallNr, smallChar);
        }
        int chunkSizeToAdd;
        while(largeNr > 0 || smallNr > 0) {
            chunkSizeToAdd = largeNr > 2 ? 2 : 1;
            largeNr -= appendTimes(stb, chunkSizeToAdd, largeNr, largeChar);
            smallNr -= appendTimes(stb, chunkSizeToAdd, smallNr, smallChar);
        }
        return stb.toString();
    }

    private int appendTimes(StringBuilder stb, int maxToAdd, int remaining, char ch) {
        int toAdd = Math.min(remaining, maxToAdd);
        for (int i = 0; i < toAdd; i++) {
            stb.append(ch);
        }
        return toAdd;
    }
}
