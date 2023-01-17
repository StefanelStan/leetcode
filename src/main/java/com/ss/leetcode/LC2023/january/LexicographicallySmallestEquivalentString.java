package com.ss.leetcode.LC2023.january;

public class LexicographicallySmallestEquivalentString {
    // https://leetcode.com/problems/lexicographically-smallest-equivalent-string
    /** Algorithm
        1. The idea is to map a letter to a group of letters. For simplicity, also cache the minChar of the group.
            EG: e ~ g: e -> [e,g]  g -> [e,g].
                p ~ t: p -> [p,t]  t -> [p,t].
        2. If the two given letters belong to different groups, then move ALL the letters from the group with the
            largest min char to the group with the min minChar.
            EG: g ~ t : e ->[e,g,p,t]
                    g,p,t ->[e,g,p,t]
        3. While traversing the given pairs, if one letter belong to a group and one does not, add that letter to the group.
        4. When done, traverse the baseStr and return the minChar of the group mapped by each letter of baseStr or the letter itself,
            if no group exists.
     */
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        LetterGroup[] groups = new LetterGroup[26];
        StringBuilder stb = new StringBuilder(baseStr.length());
        for (int i = 0; i < s1.length(); i++) {
            setEquivalentChars(s1.charAt(i), s2.charAt(i), groups);
        }
        for (char c : baseStr.toCharArray()) {
            stb.append(groups[c - 'a'] == null ? c : groups[c - 'a'].minChar);
        }
        return stb.toString();
    }

    private void setEquivalentChars(char c1, char c2, LetterGroup[] groups) {
        if (groups[c1 - 'a'] == null && groups[c2 - 'a'] == null) {
            LetterGroup newGroup =  new LetterGroup(c1);
            newGroup.appendToGroup(c2);
            groups[c1 - 'a'] = newGroup;
            groups[c2 - 'a'] = newGroup;
        } else if (groups[c1 - 'a'] == null && groups[c2 - 'a'] != null) {
            groups[c2 - 'a'].appendToGroup(c1);
            groups[c1 - 'a'] = groups[c2 - 'a'];
        } else if(groups[c1 - 'a'] != null && groups[c2 - 'a'] == null) {
            groups[c1 - 'a'].appendToGroup(c2);
            groups[c2 - 'a'] = groups[c1 - 'a'];
        } else if (groups[c1 - 'a'] != groups[c2 - 'a']) {
            mergeGroups(groups[c1 - 'a'], groups[c2 - 'a'], groups);
        }
    }

    private void mergeGroups(LetterGroup g1, LetterGroup g2, LetterGroup[] groups) {
        LetterGroup minGroup = g1.minChar < g2.minChar ? g1 : g2;
        LetterGroup maxGroup = minGroup == g1 ? g2 : g1;
        for (int i = 0; i < 26; i++) {
            if (groups[i] == maxGroup) {
                minGroup.appendToGroup((char)(i + 'a'));
                groups[i] = minGroup;
            }
        }
    }

    private static class LetterGroup {
        private char minChar;

        public LetterGroup(char c) {
            this.minChar = c;
        }

        public void appendToGroup(char newChar) {
            if (newChar < minChar) {
                minChar = newChar;
            }
        }
    }
}
