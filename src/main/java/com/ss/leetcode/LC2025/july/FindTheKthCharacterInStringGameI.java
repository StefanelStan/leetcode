package com.ss.leetcode.LC2025.july;

public class FindTheKthCharacterInStringGameI {
    // https://leetcode.com/problems/find-the-k-th-character-in-string-game-i
    /** Algorithm
        1. Create a stringbuilder of size s * k
        2. While k > stringbuilder
        - loop from pos 0 to size - 1 and append the next char in the stringbuilder
        3. Return the char at pos k-1.
     */
    public char kthCharacter(int k) {
        StringBuilder stb = new StringBuilder(2 * k);
        stb.append('a');
        while (k > stb.length()) {
            for (int i = 0, j = stb.length(); i < j; i++) {
                stb.append((char)('a' + (1 + stb.charAt(i) % 97)));
            }
        }
        return stb.charAt(k - 1);
    }
}
