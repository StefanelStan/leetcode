package com.ss.leetcode.LC2024.january;

public class JumpGameVII {
    // https://leetcode.com/problems/jump-game-vii
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] chars = s.toCharArray();
        return hasValidWindows(chars, minJump, maxJump) && canJump(0, minJump, maxJump, chars, new Boolean[s.length()]);
    }

    private boolean hasValidWindows(char[] chars, int min, int max) {
        if (chars[chars.length - 1] == '1') {
            return false;
        }
        int oneCount = 0, left = 0, right = 0;
        while (right < max) {
            oneCount += (chars[right] - '0');
            right++;
        }
        int maxOneCount = oneCount;
        if (oneCount == max) {
            return false;
        }
        while (right < chars.length) {
            oneCount -= (chars[left++] - '0');
            oneCount += (chars[right++] - '0');
            maxOneCount = Math.max(maxOneCount, oneCount);
            if (oneCount == max) {
                return false;
            }
        }
        return true;
    }

    private boolean canJump(int index, int min, int max, char[] chars, Boolean[] canReach) {
        if (index == chars.length - 1 && chars[index] =='0') {
            return true;
        }
        if (chars[index] == '1') {
            return false;
        }
        if (canReach[index] == null) {
            boolean jumpResult = false;
            for (int i = Math.min(index + max, chars.length - 1); !jumpResult && i >= index + min; i--) {
                jumpResult = canJump(i, min, max, chars, canReach);
            }
            canReach[index] = jumpResult;
        }
        return canReach[index];
    }
}
