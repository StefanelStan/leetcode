package com.ss.leetcode.LC2024.october;

import java.util.ArrayList;
import java.util.List;

public class CountSubstringsWithKFrequencyCharactersI {
    // https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i
    /** Algorithm
        1. If k == 1, you can obtain any subtrings of length 1..n. So return n * (n+1) / 2
        2. Else, use a List<Integer>[26] to store the positions of each char of string
        3. Also, for each list in array, use an index to remember last position you were for each index.
            - Each time you encounter a char, advance its index in list of positions.
        4. For a given position in s, find the next k positions for each char. The next k positions will give you the min windth window.
            - Past this window (eg: right index), you can obtain n - right substrings.
            - EG: s length = 20, i = 7.
            - for each char [a..z]- list of positions, find the next position that is k steps away from current index of list
            - as each list of an arrayList, you can do .get(last_index + k).
     */
    public int numberOfSubstrings(String s, int k) {
        if (k == 1) {
            return s.length() * (s.length() + 1) / 2;
        }
        CharPositionsAndIndex[] posAndIndex = getCharPositionsAndIndex(s);
        int count = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            count += countTotalFromPosition((int)(s.charAt(i) - 'a'), s.length(), posAndIndex, k);
        }
        return count;
    }

    private int countTotalFromPosition(int codePoint, int size, CharPositionsAndIndex[] posAndIndex, int k) {
        int closestLeft = size;
        for (CharPositionsAndIndex posIndex : posAndIndex) {
            if (posIndex != null && posIndex.index + k < posIndex.positions.size()) {
                closestLeft = Math.min(closestLeft, posIndex.positions.get(posIndex.index + k));
            }
        }
        posAndIndex[codePoint].index++;
        return size - (closestLeft);
    }

    private CharPositionsAndIndex[] getCharPositionsAndIndex(String s) {
        CharPositionsAndIndex[] posAndIndex = new CharPositionsAndIndex[26];
        int codePoint;
        for (int i = 0; i < s.length(); i++) {
            codePoint = (s.charAt(i) - 'a');
            if (posAndIndex[codePoint] == null) {
                posAndIndex[codePoint] = new CharPositionsAndIndex();
            }
            posAndIndex[codePoint].positions.add(i);
        }
        return posAndIndex;
    }

    private static class CharPositionsAndIndex {
        int index;
        List<Integer> positions;
        public CharPositionsAndIndex() {
            this.index = -1;
            this.positions = new ArrayList<>();
        }
    }
}
