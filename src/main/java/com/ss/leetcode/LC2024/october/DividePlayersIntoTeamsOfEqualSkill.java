package com.ss.leetcode.LC2024.october;

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {
    // https://leetcode.com/problems/divide-players-into-teams-of-equal-skill
    /** Algorithm
        1. Sort the skills
        2. Having them sorted, you need to see if you can have equal pairs by connecting left and right number.
        3. With left = 0, right = n-1, if skill[left] + skill[right] = previous Pair, add their product (chemisty) to total chemistry
        4. Else, break and return -1;
     */
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long totalChemistry = (long)skill[0] * skill[skill.length -1];
        int targetSkill = skill[0] + skill[skill.length - 1];
        for (int left = 1, right = skill.length -2; left < right; left++, right--) {
            if (skill[left] + skill[right] != targetSkill) {
                return -1;
            }
            totalChemistry += (long)skill[left] * skill[right];
        }
        return totalChemistry;
    }
}
