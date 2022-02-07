package com.ss.leetcode.LC2021.november;

public class FindTheDifference {
    // https://leetcode.com/problems/find-the-difference/

    /** Algorithm
     *  1. As t contains one extra char of s, we can say t = s + 1 char.
     *  2. So add the sum of s, sum of t and sumT - sumS is the extra char.
     *     s=a,b t=c,a,b => sSum=a+b (92+93), tSum=c+a+b(94+92+93). tSum - sSum = 94(c)
     */
    public char findTheDifference(String s, String t) {
        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();
        int sSum = 0, tSum = 0;
        for (int i = 0; i < sC.length; i++) {
            sSum += sC[i];
            tSum += tC[i];
        }
        return (char)(tSum + tC[tC.length -1] - sSum);
    }

    public char findTheDifference2(String s, String t) {
        int[] sCharCount = countChars(s);
        int[] tCharCount = new int[26];
        int pos;
        char extra = 'a';
        for (int i = 0; i < t.length(); i++) {
            pos = t.charAt(i) - 'a';
            tCharCount[pos]++;
            if (tCharCount[pos] > sCharCount[pos]) {
                extra = t.charAt(i);
                break;
            }
        }
        return extra;
    }

    private int[] countChars(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }
}
