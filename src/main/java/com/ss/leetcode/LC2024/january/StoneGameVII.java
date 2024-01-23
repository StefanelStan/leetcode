package com.ss.leetcode.LC2024.january;

public class StoneGameVII {
    // https://leetcode.com/problems/stone-game-vii
    // NOT WORKING
    public int stoneGameVII(int[] stones) {
        int[] prefixSum = getPrefixSum(stones);
        StoneRound[][] stoneGains = new StoneRound[stones.length][stones.length];
        StoneGain aliceStone = playStoneGame(0, stones.length - 1, true, stones, prefixSum, stoneGains);
        return aliceStone.maxGain - aliceStone.leftoverGain;
    }

    private StoneGain playStoneGame(int left, int right, boolean isAlice, int[] stones, int[] prefixSum, StoneRound[][] stoneGains) {
        if (stoneGains[left][right] == null) {
            if (left + 1 == right) {
                stoneGains[left][right] = new StoneRound();
                stoneGains[left][right].alice = stoneGains[left][right].bob = new StoneGain(Math.max(stones[left], stones[right]), 0);
            } else {
                StoneGain selectLeft = playStoneGame(left + 1, right, !isAlice, stones, prefixSum, stoneGains);
                StoneGain selectRight = playStoneGame(left, right - 1, !isAlice, stones, prefixSum, stoneGains);
                stoneGains[left][right] = new StoneRound();
                if (isAlice) {
                    stoneGains[left][right].alice = intervalSum(left + 1, right, prefixSum) + selectLeft.leftoverGain <= intervalSum(left, right - 1, prefixSum) + selectRight.leftoverGain
                        ?  new StoneGain(intervalSum(left, right - 1, prefixSum) + selectRight.leftoverGain, selectRight.maxGain)
                        :  new StoneGain(intervalSum(left + 1, right, prefixSum) + selectLeft.leftoverGain, selectLeft.maxGain);
                } else {
                    int leftDiff = intervalSum(left + 1, right, prefixSum) + selectLeft.leftoverGain - selectLeft.maxGain;
                    int rightDiff = intervalSum(left, right - 1, prefixSum) + selectRight.leftoverGain - selectRight.maxGain;
                    if (leftDiff >= rightDiff) {
                        stoneGains[left][right].bob = new StoneGain(intervalSum(left + 1, right, prefixSum) + selectLeft.leftoverGain, selectLeft.maxGain);
                    } else {
                        stoneGains[left][right].bob = new StoneGain(intervalSum(left, right - 1, prefixSum) + selectRight.leftoverGain, selectRight.maxGain);
                    }
                }
            }
        }
        return isAlice ? stoneGains[left][right].alice : stoneGains[left][right].bob;
    }

    private int intervalSum(int left, int right, int[] prefixSum) {
        return left == 0 ? prefixSum[right] : prefixSum[right] - prefixSum[left - 1];
    }

    private int[] getPrefixSum(int[] stones) {
        int sum = 0;
        int[] prefixSum = new int[stones.length];
        for(int i = 0; i < stones.length; i++) {
            sum += stones[i];
            prefixSum[i] = sum;
        }
        return prefixSum;
    }

    public static class StoneRound {
        public StoneGain alice;
        public StoneGain bob;
    }

    private static class StoneGain {
        int maxGain;
        int leftoverGain;

        public StoneGain(int maxGain, int leftoverGain) {
            this.maxGain = maxGain;
            this.leftoverGain = leftoverGain;
        }
    }
}
