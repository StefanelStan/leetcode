package com.ss.leetcode.LC2023.september;

public class SentenceSimilarityIII {
    // https://leetcode.com/problems/sentence-similarity-iii
    /** Algorithm
        1. Split the two sentences into String[] words: sentence1, sentence2
        2. Decide which of the two is longer (eg: has more words): the logic is to find the short sentence inside the long one
        3. Use a leftPointer traverse short/long and break when the two words do not match.
            - If left pointer == short.length, then you have traversed the whole shortSentence.
                and it is contained 100% (eg: "aa aaa" / "aa aaa etc")
        4. Else, do the same but from the rightSide, with a rightPointer.
            - Start from the end of shortSentence/longSentence and traverse while the words match, stopping at the leftPointer -1.
            - if leftPointer -1 == rightPointer, then you have met the two in the middle, so the sentence can be made
            - EG: "ab cc dd ac", "ab  tt cc dd ac".
            - leftPointer will be 1.
            - rightPointer will be 0. 1 - 1 = 0, so the two pointers overlap.
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        return areSimilar(sentence1.split(" "), sentence2.split(" "));
    }

    private boolean areSimilar(String[] chunks1, String[] chunks2) {
        String[] shortSentence = chunks1.length <= chunks2.length ? chunks1 : chunks2;
        String[] longSentence = chunks1.length <= chunks2.length ? chunks2 : chunks1;
        int leftMismatchIndex = findMismatchIndex(0, shortSentence.length, 0, 1, shortSentence, longSentence);
        if (leftMismatchIndex == shortSentence.length) {
            return true;
        }
        int rightMismatch = findMismatchIndex(shortSentence.length -1, leftMismatchIndex - 1, longSentence.length -1, -1, shortSentence, longSentence);
        return leftMismatchIndex == 1 + rightMismatch;
    }

    private int findMismatchIndex(int shortFrom, int shortTo, int longFrom, int direction, String[] shortSentence, String[] longSentence) {
        while (shortFrom != shortTo && shortSentence[shortFrom].equals(longSentence[longFrom])) {
            shortFrom += direction;
            longFrom += direction;
        }
        return shortFrom;
    }
}
