package com.ss.leetcode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> xPowers = getPowers(x, bound);
        Set<Integer> yPowers = getPowers(y, bound);
        List<Integer> powerfulIntegers = new LinkedList<>();
        for(int i = 2; i <= bound; i++) {
            if (isPowerfulInteger(i, xPowers, yPowers)) {
                powerfulIntegers.add(i);
            }
        }
        return powerfulIntegers;
    }

    private Set<Integer> getPowers(int term, int bound) {
        Set<Integer> powers = new LinkedHashSet<>();
        int power = 0;
        int i = 0;
        while(true) {
            power = (int)Math.pow(term, i);
            if (power <= bound) {
                if(!powers.add(power)) {
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return powers;
    }

    private boolean isPowerfulInteger(int sum, Set<Integer> xPowers, Set<Integer> yPowers) {
        for (int xPower: xPowers) {
            if (yPowers.contains( sum - xPower)) {
                return true;
            }
        }
        return false;
    }
}
