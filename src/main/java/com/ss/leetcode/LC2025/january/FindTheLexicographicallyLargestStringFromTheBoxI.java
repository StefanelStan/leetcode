package com.ss.leetcode.LC2025.january;

import java.util.ArrayList;
import java.util.List;

public class FindTheLexicographicallyLargestStringFromTheBoxI {
    // https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        char[] chars = word.toCharArray();
        int left = 0, right = 0;
        for (int i = left; i < chars.length; i++) {
            for (int j = chars.length - 1; j >= i; j--) {
                if (canBeSelected(chars.length, i, j, numFriends)) {
                    if (isLargerSubstring(chars, left, right, i, j)) {
                        left = i;
                        right = j;
                    }
                    break;
                }
            }
        }
        return word.substring(left, right + 1);
    }

    public String answerString2(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        char[] chars = word.toCharArray();
        List<Integer>[] positions = getPositions(chars);
        boolean found = false;
        int left = 0, right = 0;
        for (int i = positions.length - 1; i >= 0 && !found; i--) {
            if (positions[i] != null) {
                if (positions[i].size() == word.length()) {
                    return word.substring(0, 1 + word.length() - numFriends);
                }
                for (int j = positions[i].size() - 1; j >= 0; j--) {
                    for (int k = chars.length - 1; k >= positions[i].get(j); k--) {
                        if (canBeSelected(chars.length, positions[i].get(j), k, numFriends)) {
                            if (isLargerSubstring(chars, left, right, positions[i].get(j), k)) {
                                left = positions[i].get(j);
                                right = k;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return word.substring(left, right + 1);
    }

    private boolean isLargerSubstring(char[] chars, int left1, int right1, int left2, int right2) {
        while (left1 <= right1 && left2 <= right2) {
            if (chars[left2] > chars[left1]) {
                return true;
            } else if (chars[left1] > chars[left2]) {
                return false;
            }
            left1++;
            left2++;
        }
        return left2 <= right2;
    }

    private List<Integer>[] getPositions(char[] chars) {
        List<Integer>[] positions = new List[26];
        int codePoint;
        for (int i = 0; i < chars.length; i++) {
            codePoint = chars[i] - 'a';
            if (positions[codePoint] == null) {
                positions[codePoint] = new ArrayList<>();
            }
            positions[codePoint].add(i);
        }
        return positions;
    }

    private boolean canBeSelected(int length, int left, int right, int numFriends) {
        int copyFriends = numFriends;
        if(left > 0) {
            copyFriends--;
        }
        if (right < length - 1) {
            copyFriends--;
        }
        return copyFriends >= 0 && 1 + left + (length - (right + 1)) >= numFriends;
    }
}
