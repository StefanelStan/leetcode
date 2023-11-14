package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.List;

public class UniqueLength3PalindromicSubsequences {
    // https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
    /** PRO MODE: O(n + 26*26 * log(k)) k - avg size of each groups of letters
        1. Looking at the constraint of a 3 length palindromes, we understand we need to have palindomes of form XYX
            where X if from a...z and y if from a..z.
        2. Our palindromes can/could look like "aaa", "aba", "aca", "ada".. "bab", "bbb", "bcb" etc.
        3. Understanding this, we can observe that the 1st/3rd letter go from a to z and the middle one from a to z
        4. We can loop this search
            - If first/last letter is A, do we have another A,B,C,D,E..Z between the first and last letter A?
        5. Use an array[] List<Integer>[] to map the indices of each letter. Traversing it would result in a sorted List<Integer>
            indices for each letter
            - EG: "abbaca"
            - [0](a) -> [0,3,5]
            - [1](b) -> [1,2]
            - [2](c) -> [4]
        6. Having access to this mapping of index, apply the logic
            - For each letter get the first and last position: eg: a -> 0, 5
            - Do we have a B that sits between index 1 and 4? Do we have a C? What about a D?
            - We need to know if we hava a B sitting at least at index 1
        7. For each pair first/last position, look for complementary letters that have a position first+1
        8. We already have the indices sorted, so why not BINARY SEARCH IT?
            - EG: a -> firstPos: 0, lastPos = 5. We need to find A,B,C..Z indices that sit between these
            - positions of a = [0,3,5]. So we have an index >= 1 in this list? Yes. we have 3. 3 > 1 and 3 < 5.
                So a can be bundled with a =>  "aaa"
            - positions of b = [1,2]. Do we have a B position >= 1? yes. So  "aba"
            - positions of c = [4]. => we can make aca
     */
    public int countPalindromicSubsequence(String s) {
        List<Integer>[] positions = getPositions(s);
        int count = 0;
        for (int i = 0; i < positions.length; i++) {
            count += countPalindromes(i, positions);
        }
        return count;
    }

    private int countPalindromes(int i, List<Integer>[] positions) {
        int total = 0;
        if (positions[i] == null || positions[i].size() < 2) {
            return total;
        }
        int firstPos = positions[i].get(0), lastPos = positions[i].get(positions[i].size() - 1), position;
        if (firstPos + 1 == lastPos) {
            return total;
        }
        for (int j = 0; j < 26; j++) {
            position = binarySearch(positions[j], firstPos + 1);
            total += (firstPos < position && position < lastPos ? 1 : 0);
        }
        return total;
    }

    private int binarySearch(List<Integer> positions, int target) {
        if(positions == null) {
            return -1;
        }
        int low = 0, high = positions.size() - 1, pivot, element;
        while(low <= high) {
            pivot = low + (high - low) / 2;
            element = positions.get(pivot);
            if (target == element) {
                return target;
            } else if (target > element) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        if (low == positions.size()) {
            low--;
        }
        return positions.get(low);
    }

    private List<Integer>[] getPositions(String s) {
        List<Integer>[] positions = new List[26];
        int codePoint;
        for (int i = 0; i < s.length(); i++) {
            codePoint = s.charAt(i) - 'a';
            if (positions[codePoint] == null) {
                positions[codePoint] = new ArrayList<>();
            }
            positions[codePoint].add(i);
        }
        return positions;
    }


    /** Algorithm O(n*n / 2) pax
         1. Get the last indices of each character in the string in an int[26] lastIndices;
            "ceabc" -> [2,3,4,0,1];
         2. Starting with i = 0 ..n-2 and j = i+1..n-1, we need to know if there is another character matching
            i that is AFTER index j. We know this from lastIndices.
             EX: i = 0;
             j = 1: c, e -> is there another c after index 1 ? yes: lastIndices[c] = 4. We have a palindrome cec
             j = 2: c, a -> any character c after index 2 ? yes, at index 4: we have a palindrome cac
             j = 3: c, b -> any character c after index 2? yes: we have another palindrime cbc
             i = 1  We should skip this point because we see lastIdnex[e] == i (1), so no palindrome can be formed (only 1 single char)
             i = 2  We should skip this point because we see lastIdnex[a] == i (2), so no palindrome can be formed (only 1 single char)
         3. While doing this, use a boolean[26][27] to mark any combinations done by characters:
            eg: "aaaaa": as we have done "aaa" we should mark [0][0] = true.
         4. For high optimization, the 27th column is used to mark if the letter has been checked.
             EX: "aeaeat"
             on i = 0 we check a as head of palindrome, so we should not check a again when we reach i = 2 onwards
             on i = 1 we check e as head of palindrome, so we should not check e again when we reach i = 3 onwards
         5. If letter a was checked for palindromes, then mark [0][27] true. There is no point in checking the same letter twice as
            head of palindrome.
     */
    public int countPalindromicSubsequence2(String s) {
        int count = 0;
        boolean[][] doneCombinations = new boolean[26][27];
        char[] chrs = s.toCharArray();
        int[] lastIndices = getLastIndices(chrs);
        for (int i = 0; i < chrs.length - 2; i++) {
            for (int j = i + 1; j < chrs.length - 1 && lastIndices[chrs[i] - 'a'] > i && !doneCombinations[chrs[i] -'a'][26]; j++) {
                if (!doneCombinations[chrs[i] -'a'][chrs[j] - 'a']) {
                    doneCombinations[chrs[i] -'a'][chrs[j] - 'a'] = true;
                    if (lastIndices[chrs[i] - 'a'] > j) {
                        count++;
                    }
                }
            }
            doneCombinations[chrs[i] -'a'][26] = true;
        }
        return count;
    }

    private int[] getLastIndices(char[] chrs) {
        int[] lastIndices = new int[26];
        for (int i = 0; i < chrs.length; i++) {
            lastIndices[chrs[i] - 'a'] = i;
        }
        return lastIndices;
    }
}
