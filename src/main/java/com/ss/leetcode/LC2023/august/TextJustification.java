package com.ss.leetcode.LC2023.august;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class TextJustification {
    // https://leetcode.com/problems/text-justification
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayDeque ad = new ArrayDeque();
        List<String> justified = new LinkedList<>();
        int windowTotalCharCount = 0, windowWordCharCount = 0;
        int leftIndex = 0, rightIndex = 0;
        while (rightIndex < words.length) {
            if (windowTotalCharCount + words[rightIndex].length() > maxWidth) {
                justified.add(formatLine(words, leftIndex, rightIndex - 1, windowWordCharCount, maxWidth));
                leftIndex = rightIndex;
                windowTotalCharCount = 0;
                windowWordCharCount = 0;
            } else {
                windowTotalCharCount += words[rightIndex].length() + 1;
                windowWordCharCount += words[rightIndex].length();
                rightIndex++;
            }
        }
        // process lastLine
        if (leftIndex < words.length) {// one lastWindow needs processing
            justified.add(formatLine(words, leftIndex, rightIndex - 1, windowWordCharCount, maxWidth));
        }
        return justified;
    }

    private String formatLine(String[] words, int start, int end, int windowWordCharCount, int maxWidth) {
        if (end - start == 0) {
            StringBuilder stb = new StringBuilder(maxWidth).append(words[start]);
            appendSpaces(stb, maxWidth - windowWordCharCount);
            return stb.toString();
        }
        if (end == words.length -1) {
            return processLastLine(words, start, end, maxWidth);
        } else {
            return processNormalLine(words, start, end, windowWordCharCount, maxWidth);
        }
    }

    private String processNormalLine(String[] words, int start, int end, int windowWordCharCount, int maxWidth) {
        int totalWords = (end - start) + 1;
        int spacesToPut = maxWidth - windowWordCharCount;
        int afterEachWord = spacesToPut / (totalWords - 1);
        int extraSpacePadding = spacesToPut % (totalWords - 1);
        StringBuilder stb = new StringBuilder(maxWidth);
        while (start < end) {
            stb.append(words[start]);
            appendSpaces(stb, afterEachWord);
            if (extraSpacePadding > 0) {
                appendSpaces(stb, 1);
                extraSpacePadding--;
            }
            start++;
        }
        return stb.append(words[end]).toString();
    }

    private String processLastLine(String[] words, int start, int end, int maxWidth) {
        StringBuilder stb = new StringBuilder(maxWidth);
        while(start <= end) {
            stb.append(words[start]);
            maxWidth -= words[start].length();
            if (maxWidth > 0) {
                stb.append(' ');
            }
            maxWidth--;
            start++;
        }
        appendSpaces(stb, maxWidth);
        return stb.toString();
    }

    private void appendSpaces(StringBuilder stb, int times) {
        while(times-- > 0) {
            stb.append(' ');
        }
    }
}
