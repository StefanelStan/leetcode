package com.ss.leetcode.LC2022.september;

public class CheckDistancesBetweenSameLetters {
    // https://leetcode.com/problems/check-distances-between-same-letters/
    /** Algorithm
         1. Use an Integer[] foundDistances to store the positions. Checking null indicates if we have set already a value there
         2. Iterate over the string and set or determine the distance of current char/codePoint
         3. If foundDistances[codePoint] is null, set it to current index
         4. Else determine the distance: i - foundDistances[codePoint];
            - if foundDistances[codePoint] != distance[codePoint] return false;
         5. Return true by default.
     */
    public boolean checkDistances(String s, int[] distance) {
        Integer[] foundDistances =  new Integer[26];
        int codePoint;
        for (int i = 0; i < s.length(); i++) {
            codePoint = s.charAt(i) - 'a';
            if (foundDistances[codePoint] == null) {
                foundDistances[codePoint] = i;
            } else {
                foundDistances[codePoint] = i - 1 - foundDistances[codePoint];
                if (foundDistances[codePoint] != distance[codePoint]) {
                    return false;
                }
            }
        }
        return true;
    }
}
