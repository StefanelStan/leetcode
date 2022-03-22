package com.ss.leetcode.LC2022.march;

public class SmallestStringWithAGivenNumericValue {
    // https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
    /** Algorithm
         1. The smallest lexicographically string is obtained when you have lighest letters first (aaa) and heaviest letters last (zzz):
         EG: n =2 and k =4.
         You can form it as 1,3 (a,c) or 2,2 (b,b) or 3,1 (c,1).
         But the smallest one will have the lightest letters first.
         2. Declare an char[] answer and loop i from the last index n to 1. (insertion will be done on i-1 index)
         3. If k == i, it means you need to put the smallest char : a
         4. If adding 25 to current index is still equal or less than k, it means you need to add z to continue with the remainder
         eg: n = 2, k = 29;
         i = 2 . 2 + 25 is still smaller than 29, so current i will be z and next one will be 29-26
         5. If not #3 or #4, then your char is between b and y. Determine it and set it.
         eg: n = 2, k = 24;
         i = 2. current char will be 24-1 so 23 (w) and 1 is carried over().
     */
    public String getSmallestString(int n, int k) {
        char[] smallestString = new char[n];
        for (int i = n; i >= 1; i--) {
            if (i == k) {
                smallestString[i-1] = 'a';
                k--;
            } else if (i + 25 <= k) { // will adding z to array cause a number greater than K? If not, then add Z, heaviest letter
                smallestString[i-1] = 'z';
                k -= 26;
            } else { // it means it is one between b and y.
                smallestString[i-1] = (char)((k - i) + 'a');
                k = i-1;
            }
        }
        return new String(smallestString);
    }
}
