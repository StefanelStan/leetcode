package com.ss.leetcode.LC2023.july;

public class MaximizeTheConfusionOfAnExam {
    // https://leetcode.com/problems/maximize-the-confusion-of-an-exam
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int maxConsecutive = -1;
        ConsecutiveAnswerWindow trueWindow = new ConsecutiveAnswerWindow('T', chars, k);
        ConsecutiveAnswerWindow falseWindow = new ConsecutiveAnswerWindow('F', chars, k);
        for(int i = 0; i < chars.length; i++) {
            trueWindow.advance();
            falseWindow.advance();
            maxConsecutive = Math.max(maxConsecutive, Math.max(trueWindow.size(), falseWindow.size()));
        }
        return maxConsecutive;
    }

    private static class ConsecutiveAnswerWindow {
        char sign;
        int left, right;
        int swaps, maxSwaps;
        char[] answers;

        public ConsecutiveAnswerWindow(char sign, char[] answers, int maxSwaps) {
            this.sign = sign;
            this.answers = answers;
            this.maxSwaps = maxSwaps;
        }

        public void advance() {
            if (answers[right] != sign) {
                swaps++;
            }
            right++;
            trimToSize();
        }

        private void trimToSize() {
            while (swaps > maxSwaps) {
                if(answers[left] != sign) {
                    swaps--;
                }
                left++;
            }
        }

        public int size() {
            return right - left;
        }
    }
}
