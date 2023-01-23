package com.ss.leetcode.LC2023.january;

public class MinimumHoursOfTrainingToWinACompetition {
    // https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition
    /** Algorithm
         1. Traverse both arrays with an index and
            - calculate the totalEnergy by adding energy[i]
            - determine if this round you need Experience or not. neededRoundExp.Start with gainedExperience = initialExperience
            If current exp lvl >= gainedEnergy, you need the diff + 1. neededRoundExp = diff + 1, else you need  0.
            Add this neededRoundExp to a global var.(totalNeededExp)
            Also increment your gained experience with exp[i] + nededRoundExperience.
        2. Return the sum between totalNeededExp and (if neededEnergy >= initial, add the diff+1, else 0)
     */
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int neededRoundExperience = 0, neededTotalExperience = 0, gainedExperience = initialExperience;
        int neededEnergy = 0;
        for (int i = 0; i < energy.length; i++) {
            neededRoundExperience = experience[i] >= gainedExperience ? (experience[i]  - gainedExperience) + 1 : 0;
            gainedExperience += experience[i] + neededRoundExperience;
            neededTotalExperience += neededRoundExperience;
            neededEnergy += energy[i];
        }
        return neededTotalExperience + (neededEnergy >= initialEnergy ? ++neededEnergy - initialEnergy : 0);
    }
}
