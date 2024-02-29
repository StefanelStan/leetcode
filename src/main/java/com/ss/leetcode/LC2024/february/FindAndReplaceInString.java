package com.ss.leetcode.LC2024.february;

import java.util.Arrays;

public class FindAndReplaceInString {
    // https://leetcode.com/problems/find-and-replace-in-string
    /** Algorithm
        1. We know there are no overlaps in the replacements
        2. Use an int[n] foundTargets to mark if the source[i] was found at indices[i].
        3. Traverse indices and check if sources[i] string is found at inside s at indices[i].
            If yes, then set foundTargets[indices[i]] = i; (mark that at index i we need to inject target[i])
        4. Use a stringBuilder and traverse s.
            - If foundMatches[i] != -1, then append the targets[foundMatches[i]] and move forward i with the sources[foundTargets[i]]
            - Else append the char i from s.
    */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int[] foundTargets = getFoundTargets(s, indices, sources, targets);
        StringBuilder stb = new StringBuilder(s.length());
        for (int i = 0; i < s.length();) {
            if (foundTargets[i] != -1) {
                stb.append(targets[foundTargets[i]]);
                i += sources[foundTargets[i]].length();
            } else {
                stb.append(s.charAt(i++));
            }
        }
        return stb.toString();
    }

    private int[] getFoundTargets(String s, int[] indices, String[] sources, String[] targets) {
        int[] foundTargets = new int[s.length()];
        Arrays.fill(foundTargets, -1);
        for (int i = 0; i < indices.length; i++) {
            if (s.startsWith(sources[i], indices[i])) {
                foundTargets[indices[i]] = i;
            }
        }
        return foundTargets;
    }
}
