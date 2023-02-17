package com.ss.leetcode.LC2023.february;

import java.util.Arrays;

public class SwapForLongestRepeatedCharacterSubstring {
    // https://leetcode.com/problems/swap-for-longest-repeated-character-substring
    public int maxRepOpt1(String text) {
        // Use an int[2][3] to store two baskets: type - quantity - lastStack.
        int[] longestWindows = new int['z' + 1];
        int[] letters = new int['z' + 1];
        int[][] baskets = new int[2][3];
        baskets[0][0] = -1;
        baskets[1][0] = -1;
        int idx = 0;
        for (char c : text.toCharArray()) {
            letters[c]++;
            if (baskets[0][0] == -1 || (c == baskets[0][0] && baskets[1][0] == -1)) {
                baskets[0][0] = c;
                baskets[0][1]++;
                baskets[0][2]++;
            } else if (c == baskets[0][0] && baskets[0][1] > 0) {
                // evict head basket
                baskets[1][0] = -1;
                baskets[1][1] = 0;
                baskets[1][2] = 0;
                baskets[0][1]++;
                baskets[0][2]++;
            } else if (c != baskets[0][0]) {
                if (c != baskets[1][0]) { // new type. evict first element and put tail on head
                    baskets[1][0] = baskets[0][0];
                    baskets[1][1] = baskets[0][2];
                    baskets[1][2] = 0;
                    baskets[0][0] = c;
                    baskets[0][1] = 1;
                    baskets[0][2] = 1;
                } else if (c == baskets[1][0]) {
                    // put tail basket on head basket and move headBasket to tail, resetting lastStack
                    if (baskets[0][1] == baskets[0][2]) {
                        swapBaskets(baskets);
                        baskets[0][1]++;
                        baskets[0][2]++;
                    } else {
                        swapBaskets(baskets);
                        baskets[1][0] = -1;
                        baskets[1][1] = baskets[0][2];
                        baskets[1][2] = 0;
                        baskets[0][0] = c;
                        baskets[0][1]++;
                        baskets[0][2] = 1;
                    }

                }
            }
            // evict first basket AND add this in new basket
            if (baskets[0][0] != -1) {
                longestWindows[baskets[0][0]] = Math.max(longestWindows[baskets[0][0]],
                    baskets[0][1]);
            }
            if (baskets[1][0] != -1) {
                longestWindows[baskets[1][0]] = Math.max(longestWindows[baskets[1][0]],
                    baskets[1][1]);
            }
            idx++;
        }
        return getLongestPossibleWindow(longestWindows, letters);
    }

    private void swapBaskets(int[][] baskets) {
        int[] temp = Arrays.copyOf(baskets[1], baskets[1].length);
        baskets[1][0] = baskets[0][0];
        baskets[1][1] = baskets[0][1];
        baskets[0][0] = temp[0];
        baskets[0][1] = temp[1];
        baskets[0][2] = 0;
    }

    private int getLongestPossibleWindow(int[] longestWindows, int[] letters) {
        int max = 1;
        for (int i = 0; i < longestWindows.length; i++) {
            max = Math.max(max,
                longestWindows[i] < letters[i] ? longestWindows[i] + 1 : longestWindows[i]);
        }
        return max;
    }
}


































































    /**
    public int maxRepOpt1(String text) {
        int[] longestWindows = new int[26];
        int[] letters = new int[26];
        char[] chrs = text.toCharArray();
        letters[chrs[0] - 'a']++;
        longestWindows[text.charAt(0) - 'a'] = 1;
        WindowSide left = null;
        WindowSide right = new WindowSide(chrs[0]);
        right.expand(0);
        boolean skipped = false;
        for (int i = 1; i < text.length(); i++) {
            // happy case, we can insert
            if (chrs[i] == right.mainChar) {
                if (left == null || left.size == 1) {
                    // can insert. case a,b
                    right.expand(i);
                    saveWindowSides(left, right, longestWindows);
                } else {
                    left.size = 1;
                    right.expand(i);
                    saveWindowSides(left, right, longestWindows);
                }
            } else {
                if (left == null || left.mainChar != chrs[i]) {
                    left = new WindowSide(right.mainChar);
                    left.size = right.size;
                    left.lastInput = right.lastInput;
                    right.mainChar = chrs[i];
                    right.size = 1;
                    right.lastInput = i;
                    saveWindowSides(left, right, longestWindows);
                } else {
                    if (right.size == 1) { // we can skip

                    }
                }
            }
        }


    }

    private void saveWindowSides(WindowSide s1, WindowSide s2, int[] longestWindows) {
        if (s1 != null && s2 != null) {
            if (s1.size == s2.size) {
                longestWindows[s1.mainChar - 'a'] = Math.max(longestWindows[s1.mainChar - 'a'], s1.size);
                longestWindows[s2.mainChar - 'a'] = Math.max(longestWindows[s2.mainChar - 'a'], s2.size);
            } else {
                WindowSide longest = s1.size < s2.size ? s2 : s1;
                longestWindows[longest.mainChar - 'a'] = Math.max(longestWindows[longest.mainChar - 'a'], longest.size);
            }
        } else {
            WindowSide longest = s1 == null ? s2 : s1;
            longestWindows[longest.mainChar - 'a'] = Math.max(longestWindows[longest.mainChar - 'a'], longest.size);
        }
    }

    private int getLongestPossibleWindow(int[] longestWindows, int[] letters) {
        int max = 1;
        for (int i = 0; i < longestWindows.length; i++) {
            max = Math.max(max, longestWindows[i] < letters[i] ? longestWindows[i] + 1 : longestWindows[i]);
        }
        return max;
    }

    private static class WindowSide {
        char mainChar;
        int size = 0;
        int lastInput;

        public WindowSide(char c) {
            this.mainChar = c;
        }

        public void expand(int i) {
            size++;
            lastInput = i;
        }
    }

*/
